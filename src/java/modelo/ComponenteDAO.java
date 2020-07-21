package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ComponenteDAO extends ConexaoDAO {

    public void inserir(Componente c) throws Exception {
        conectar();

        String sql = "INSERT INTO componente (id, modelo, tipo, marca, descricao, id_estoque, equipamento_etiqueta) "
                + "VALUES (?,?,?,?,?,?,?)";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getId());
        pstm.setString(2, c.getModelo());
        pstm.setString(3, c.getTipo());
        pstm.setString(4, c.getMarca());
        pstm.setString(5, c.getDescricao());
        pstm.setInt(6, c.getEstoque().getId());
        pstm.setString(7, c.getEquipamento().getEtiqueta());

        pstm.execute();

        desconectar();
    }

    //Altera os dados do componente e também vincula um componente a um equipamento
    public void alterar(Componente c) throws Exception {
        conectar();

        String sql = "UPDATE componente "
                + "SET modelo=?, tipo=?, marca=?, descricao=?, id_estoque=?, equipamento_etiqueta=? WHERE id=?";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getModelo());
        pstm.setString(2, c.getTipo());
        pstm.setString(3, c.getMarca());
        pstm.setString(4, c.getDescricao());
        pstm.setInt(5, c.getEstoque().getId());
        pstm.setString(6, c.getEquipamento().getEtiqueta());
        pstm.setString(7, c.getId());

        pstm.execute();

        desconectar();
    }

    //Não está sendo utilizado
    public ArrayList<Componente> listarTodos() throws Exception {
        ArrayList<Componente> componentes = new ArrayList<Componente>();

        conectar();
        String sql = "SELECT * FROM componente";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Componente c = new Componente();
            EquipamentoDAO eqDAO = new EquipamentoDAO();
            EstoqueDAO eDAO = new EstoqueDAO();
            c.setId(rs.getString("id"));
            c.setModelo(rs.getString("modelo"));
            c.setTipo(rs.getString("tipo"));
            c.setMarca(rs.getString("marca"));
            c.setStatus(rs.getString("status"));
            c.setDescricao(rs.getString("descricao"));
            c.setEstoque(eDAO.carregarPorId(rs.getInt("id_estoque")));
            c.setEquipamento(eqDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
        }

        return componentes;
    }

    public Componente carregarPorId(String id) throws Exception {
        Componente c = new Componente();
        conectar();
        String sql = "SELECT * FROM componente WHERE id=" + "'" + id + "'";
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            EquipamentoDAO eqDAO = new EquipamentoDAO();
            EstoqueDAO eDAO = new EstoqueDAO();
            c.setId(rs.getString("id"));
            c.setModelo(rs.getString("modelo"));
            c.setTipo(rs.getString("tipo"));
            c.setMarca(rs.getString("marca"));
            c.setStatus(rs.getString("status"));
            c.setDescricao(rs.getString("descricao"));
            c.setEstoque(eDAO.carregarPorId(rs.getInt("id_estoque")));
            c.setEquipamento(eqDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
        }
        desconectar();
        return c;
    }

    public ArrayList<Componente> carregarComponentesDoEquipamento(String etiqueta) throws Exception {
        ArrayList<Componente> componentes = new ArrayList<Componente>();
        conectar();
        String sql = "SELECT * FROM componente WHERE equipamento_etiqueta=" + "'" + etiqueta + "'";
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Componente c = new Componente();
            EquipamentoDAO eqDAO = new EquipamentoDAO();
            c.setId(rs.getString("id"));
            c.setModelo(rs.getString("modelo"));
            c.setTipo(rs.getString("tipo"));
            c.setMarca(rs.getString("marca"));
            c.setDescricao(rs.getString("descricao"));
            c.setEquipamento(eqDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            componentes.add(c);
        }
        desconectar();
        return componentes;
    }

    public void remover(Componente c) throws Exception {
        conectar();
        String sql = "DELETE FROM componente WHERE id=?";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getId());

        pstm.execute();
        desconectar();
    }
}
