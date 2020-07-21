package modelo;

import java.sql.*;
import java.util.ArrayList;

public class EstoqueDAO extends ConexaoDAO {

    public void inserir(Estoque e) throws Exception {
        conectar();

        String sql = "INSERT INTO estoque (id, nome, descricao) VALUES (?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, e.getId());
        pstm.setString(2, e.getNome());
        pstm.setString(3, e.getDescricao());

        pstm.execute();

        desconectar();
    }

    public void alterar(Estoque e) throws Exception {
        conectar();

        String sql = "UPDATE estoque SET nome=?, descricao=? WHERE id=?";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, e.getNome());
        pstm.setString(2, e.getDescricao());
        pstm.setInt(3, e.getId());

        pstm.execute();

        desconectar();
    }

    public Estoque carregarPorId(int id) throws Exception {
        Estoque e = new Estoque();
        conectar();
        String sql = "SELECT * FROM estoque WHERE id=" + id;
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            e.setDescricao(rs.getString("descricao"));
        }
        desconectar();
        return e;
    }

    public ArrayList<Estoque> listar() throws Exception {
        conectar();
        ArrayList<Estoque> listaEstoque = new ArrayList<>();
        String sql = "SELECT * FROM estoque";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Estoque e = new Estoque();
            e.setId(rs.getInt("id"));
            e.setNome(rs.getString("nome"));
            listaEstoque.add(e);
        }
        desconectar();
        return listaEstoque;
    }

    public ArrayList<Componente> checarEstoque(int id) throws Exception {
        ArrayList<Componente> componentes = new ArrayList<Componente>();
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM componente WHERE id_estoque=" + id + " AND status='DISPONIVEL' OR status='COM DEFEITO'");

        while (rs.next()) {
            Componente c = new Componente();
            c.setId(rs.getString("id"));
            c.setMarca(rs.getString("marca"));
            c.setStatus(rs.getString("status"));
            c.setEstoque(carregarPorId(rs.getInt("id_estoque")));
            componentes.add(c);
        }
        return componentes;
    }

    /*Fazer select count dos estoques*/
    public int contarComponentes(int id) throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(id_estoque)FROM componente WHERE id_estoque=" + id);

        while (rs.next()) {
            num = rs.getInt("count(id_estoque)");
        }
        return num;
    }
}
