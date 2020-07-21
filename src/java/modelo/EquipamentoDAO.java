package modelo;

import java.sql.*;
import java.util.ArrayList;

public class EquipamentoDAO extends ConexaoDAO {

    public void inserir(Equipamento e) throws Exception {
        conectar();
        String sql = "INSERT INTO equipamento (etiqueta,tipo) VALUES (?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, e.getEtiqueta());
        pstm.setString(2, e.getTipo());

        pstm.execute();
        desconectar();
    }

    public void alterar(Equipamento e) throws Exception {
        conectar();
        String sql = "UPDATE equipamento SET etiqueta=?, tipo=? WHERE etiqueta=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1,e.getEtiqueta());
        pstm.setString(2,e.getTipo());
        pstm.setString(3,e.getEtiqueta());

        pstm.execute();
        desconectar();

    }

    public ArrayList<Equipamento> listar() throws Exception {
        ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();
        String sql = "SELECT * FROM equipamento";
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Equipamento e = new Equipamento();
            e.setEtiqueta(rs.getString("etiqueta"));
            e.setTipo(rs.getString("tipo"));
            equipamentos.add(e);
        }

        desconectar();
        return equipamentos;
    }

    public Equipamento carregarPorEtiqueta(String etiqueta) throws Exception {
        Equipamento e = new Equipamento();
        String sql = "SELECT * FROM equipamento WHERE etiqueta=" + "'" + etiqueta + "'";
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery(sql);

        if (rs.next()) {
            e.setEtiqueta(rs.getString("etiqueta"));
            e.setTipo(rs.getString("tipo"));
        }
        desconectar();
        return e;
    }

    public void excluir(Equipamento e) throws Exception {
        conectar();
        String sql = "DELETE FROM equipamento WHERE etiqueta=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, e.getEtiqueta());

        pstm.execute();
        desconectar();
    }
}
