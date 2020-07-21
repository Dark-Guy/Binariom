package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ClienteDAO extends ConexaoDAO {

    public void inserir(Cliente c) throws Exception {
        conectar();
        String sql = "INSERT INTO cliente (matricula, nome, cpf, setor,sala, telefone, senha, status)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getMatricula());
        pstm.setString(2, c.getNome());
        pstm.setString(3, c.getCpf());
        pstm.setString(4, c.getSetor());
        pstm.setInt(5, c.getSala());
        pstm.setString(6, c.getTelefone());
        pstm.setString(7, c.getSenha());
        pstm.setString(8, c.getStatus());

        pstm.execute();
        desconectar();
    }

    public void alterar(Cliente c) throws Exception {
        conectar();
        String sql = "UPDATE cliente SET nome=?, cpf=?, setor=?, sala=?, telefone=?, senha=?, status=? WHERE matricula=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getSetor());
        pstm.setInt(4, c.getSala());
        pstm.setString(5, c.getTelefone());
        pstm.setString(6, c.getSenha());
        pstm.setString(7, c.getStatus());
        pstm.setString(8, c.getMatricula());

        pstm.execute();
        desconectar();
    }

    public ArrayList<Cliente> listar() throws Exception {
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        conectar();
        String sql = "SELECT * FROM cliente";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            Cliente c = new Cliente();
            c.setMatricula(rs.getString("matricula"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setSala(rs.getInt("sala"));
            c.setSetor(rs.getString("setor"));
            c.setTelefone(rs.getString("telefone"));
            c.setStatus(rs.getString("status"));
            clientes.add(c);
        }
        desconectar();
        return clientes;
    }

    public Cliente carregarPorMatricula(String matricula) throws Exception {
        Cliente c = new Cliente();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE matricula=" + "'" + matricula + "'");

        if (rs.next()) {
            c.setMatricula(rs.getString("matricula"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setSetor(rs.getString("setor"));
            c.setSala(rs.getInt("sala"));
            c.setTelefone(rs.getString("telefone"));
            c.setSenha(rs.getString("senha"));
            c.setStatus(rs.getString("status"));
        }
        desconectar();
        return c;
    }

    public void excluir(Cliente c) throws Exception {
        conectar();
        String sql = "DELETE FROM cliente WHERE matricula=?";

        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getMatricula());

        pstm.execute();
        desconectar();
    }

    public Cliente logar(String matricula, String senha) throws Exception {
        Cliente c = new Cliente();
        conectar();
        String sql = "SELECT * FROM cliente WHERE matricula=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, matricula);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            if (rs.getString("senha").equals(senha)) {
                c.setMatricula(rs.getString("matricula"));
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setSetor(rs.getString("setor"));
                c.setSala(rs.getInt("sala"));
                c.setTelefone(rs.getString("telefone"));
                c.setSenha(rs.getString("senha"));
                c.setStatus(rs.getString("status"));
            }
        }
        desconectar();
        return c;
    }
}
