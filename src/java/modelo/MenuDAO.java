package modelo;

import java.sql.*;
import java.util.ArrayList;

public class MenuDAO extends ConexaoDAO {

    public void inserir(Menu m) throws Exception {
        String sql = "INSERT INTO menu (nome,link) VALUES (?,?)";
        conectar();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, m.getNome());
        pstm.setString(2, m.getLink());

        pstm.execute();
        desconectar();
    }

    public ArrayList<Menu> listar() throws Exception {

        ArrayList<Menu> menus = new ArrayList<Menu>();

        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM menu");

        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            m.setLink(rs.getString("link"));
            menus.add(m);
        }
        desconectar();
        return menus;
    }

    public Menu carregarPorId(int id) throws Exception {
        Menu m = new Menu();
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM menu WHERE id=" + id);

        if (rs.next()) {
            m.setId(rs.getInt("id"));
            m.setNome(rs.getString("nome"));
            m.setLink(rs.getString("link"));
        }
        desconectar();
        return m;
    }

    public void alterar(Menu m) throws Exception {
        conectar();
        String sql = "UPDATE menu SET nome=?, link=? WHERE id = ?"; 
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, m.getNome());
        pstm.setString(2, m.getLink());
        pstm.setInt(3, m.getId());

        pstm.execute();
        desconectar();
    }

    public void excluir(Menu m) throws Exception {
        conectar();
        String sql = "DELETE FROM menu WHERE id=?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, m.getId());
        pstm.execute();
        desconectar();
    }

}
