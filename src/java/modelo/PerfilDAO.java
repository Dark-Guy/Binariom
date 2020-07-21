package modelo;

import java.sql.*;
import java.util.ArrayList;

public class PerfilDAO extends ConexaoDAO {

    public void inserir(Perfil p) throws Exception {
        conectar();
        String sql = "INSERT INTO perfil (nome, descricao) VALUE (?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getDescricao());

        pstm.execute();
        desconectar();

    }

    public ArrayList<Perfil> listar() throws Exception {

        ArrayList<Perfil> perfis = new ArrayList<Perfil>();

        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM perfil");

        while (rs.next()) {
            Perfil p = new Perfil();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            perfis.add(p);
        }
        desconectar();
        return perfis;
    }

    public Perfil carregarPorId(int id) throws Exception {
        Perfil p = new Perfil();

        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM perfil WHERE id=" + id);

        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setDescricao(rs.getString("descricao"));
            p.setMenus(this.carregaMenusPerfil(id));
        }
        desconectar();
        return p;
    }

    public void alterar(Perfil p) throws Exception {

        conectar();
        String sql = "UPDATE perfil SET nome=?, descricao=? WHERE id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getDescricao());
        pstm.setInt(3, p.getId());

        pstm.execute();
        desconectar();
    }

    public void excluir(Perfil p) throws Exception {
        conectar();
        String sql = "DELETE FROM perfil WHERE id=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, p.getId());

        pstm.execute();
        desconectar();
    }

    public ArrayList<Menu> carregaMenusPerfil(int id_perfil) throws Exception {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu as m, menu_perfil as mp WHERE m.id=mp.id_menu AND mp.id_perfil=" + id_perfil;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
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

    public ArrayList<Menu> carregaMenusNaoPerfil(int id_perfil) throws Exception {
        ArrayList<Menu> menus = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu WHERE id NOT IN(SELECT id_menu FROM menu_perfil WHERE id_perfil=" + id_perfil + ")";
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
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

    public void vincularMenu(int id_menu, int id_perfil) throws Exception {
        String sql = "INSERT INTO menu_perfil (id_menu,id_perfil) VALUES(?,?)";

        conectar();

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id_menu);
        pstm.setInt(2, id_perfil);
        pstm.execute();

        desconectar();
    }

    public void desvincularMenu(int id_menu, int id_perfil) throws Exception {
        String sql = "DELETE FROM menu_perfil WHERE id_menu=? AND id_perfil=?";

        conectar();

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id_menu);
        pstm.setInt(2, id_perfil);

        pstm.execute();

        desconectar();
    }
}
