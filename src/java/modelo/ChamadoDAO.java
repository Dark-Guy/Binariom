package modelo;

import java.sql.*;
import java.util.ArrayList;

public class ChamadoDAO extends ConexaoDAO {

    public void abrir(Chamado c) throws Exception {
        conectar();
        String sql = "INSERT INTO chamado (descricao,equipamento_etiqueta,usuario_matricula,cliente_matricula,status) VALUES (?,?,?,?,?)";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getDescricao());
        pstm.setString(2, c.getEquipamento().getEtiqueta());
        pstm.setString(3, c.getUsuario().getMatricula());
        pstm.setString(4, c.getCliente().getMatricula());
        pstm.setString(5, c.getStatus());

        pstm.execute();
        desconectar();
    }

    public void realizar(Chamado c) throws Exception {
        conectar();
        String sql = "UPDATE chamado SET status=?, usuario_matricula=? WHERE bin=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getStatus());
        pstm.setString(2, c.getUsuario().getMatricula());
        pstm.setInt(3, c.getBin());

        pstm.execute();
        desconectar();
    }

    public void aprovar(Chamado c) throws Exception {
        conectar();
        String sql = "UPDATE chamado SET status=? WHERE bin=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getStatus());
        pstm.setInt(2, c.getBin());

        pstm.execute();
        desconectar();
    }

    public void finalizar(Chamado c) throws Exception {
        conectar();
        String sql = "UPDATE chamado SET atendimento=?, status=? WHERE bin=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getAtendimento());
        pstm.setString(2, c.getStatus());
        pstm.setInt(3, c.getBin());

        pstm.execute();
        desconectar();
    }

    public void cancelar(Chamado c) throws Exception {
        conectar();
        String sql = "UPDATE chamado SET atendimento=?, status=? WHERE bin=?";
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, c.getAtendimento());
        pstm.setString(2, c.getStatus());
        pstm.setInt(3, c.getBin());

        pstm.execute();
        desconectar();
    }

    public ArrayList<Chamado> listarAbertos() throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE status='ABERTO' OR status='Aberto'");

        while (rs.next()) {
            Chamado c = new Chamado();
            EquipamentoDAO eDAO = new EquipamentoDAO();
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO cDAO = new ClienteDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setEquipamento(eDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            c.setCliente(cDAO.carregarPorMatricula(rs.getString("cliente_matricula")));
            chamados.add(c);
        }
        return chamados;
    }

    public ArrayList<Chamado> listarRequisicoes() throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE status='Requisitado' OR status='Aprovado'");

        while (rs.next()) {
            Chamado c = new Chamado();
            UsuarioDAO uDAO = new UsuarioDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            chamados.add(c);
        }
        return chamados;
    }

    public ArrayList<Chamado> listarEmAndamento() throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE status='emAndamento' OR status='Em Andamento'");

        while (rs.next()) {
            Chamado c = new Chamado();
            EquipamentoDAO eDAO = new EquipamentoDAO();
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO cDAO = new ClienteDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setEquipamento(eDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            c.setCliente(cDAO.carregarPorMatricula(rs.getString("cliente_matricula")));
            chamados.add(c);
        }
        return chamados;
    }

    public ArrayList<Chamado> listarCancelados() throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE status='Cancelado'");

        while (rs.next()) {
            Chamado c = new Chamado();
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO cDAO = new ClienteDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setAtendimento(rs.getString("atendimento"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setDr(rs.getTimestamp("data_resolvido"));
            c.setCliente(cDAO.carregarPorMatricula(rs.getString("cliente_matricula")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            chamados.add(c);
        }
        return chamados;
    }

    public ArrayList<Chamado> listarResolvidos() throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE status='Resolvido'");

        while (rs.next()) {
            Chamado c = new Chamado();
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO cDAO = new ClienteDAO();
            EquipamentoDAO eDAO = new EquipamentoDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setAtendimento(rs.getString("atendimento"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setDr(rs.getTimestamp("data_resolvido"));
            c.setEquipamento(eDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            c.setCliente(cDAO.carregarPorMatricula(rs.getString("cliente_matricula")));
            chamados.add(c);
        }
        desconectar();
        return chamados;
    }

    public Chamado carregarPorBin(int bin) throws Exception {
        Chamado c = new Chamado();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE bin=" + bin);

        if (rs.next()) {
            EquipamentoDAO eDAO = new EquipamentoDAO();
            UsuarioDAO uDAO = new UsuarioDAO();
            ClienteDAO cDAO = new ClienteDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setEquipamento(eDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            c.setCliente(cDAO.carregarPorMatricula(rs.getString("cliente_matricula")));
        }
        desconectar();
        return c;
    }

    public ArrayList<Chamado> carregarChamadosPorMatricula(String matricula) throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE cliente_matricula=" + "'" + matricula + "'");

        while (rs.next()) {
            Chamado c = new Chamado();
            EquipamentoDAO eDAO = new EquipamentoDAO();
            UsuarioDAO uDAO = new UsuarioDAO();
            c.setBin(rs.getInt("bin"));
            c.setDescricao(rs.getString("descricao"));
            c.setAtendimento(rs.getString("atendimento"));
            c.setStatus(rs.getString("status"));
            c.setDa(rs.getTimestamp("data_abertura"));
            c.setEquipamento(eDAO.carregarPorEtiqueta(rs.getString("equipamento_etiqueta")));
            c.setUsuario(uDAO.listarPorMatricula(rs.getString("usuario_matricula")));
            chamados.add(c);
        }
        desconectar();
        return chamados;
    }

    //Acões especificas: abertos, em andamento, cancelados e concluídos
    public int abertos() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(status) FROM chamado WHERE status='ABERTO' or status='Aberto'");

        while (rs.next()) {
            num = rs.getInt("count(status)");
        }
        return num;
    }

    public int emAndamento() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(status) FROM chamado WHERE status='emAndamento' OR status='Em Andamento'");

        while (rs.next()) {
            num = rs.getInt("count(status)");
        }
        return num;
    }

    public int cancelados() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(status) FROM chamado WHERE status='Cancelado'");

        while (rs.next()) {
            num = rs.getInt("count(status)");
        }
        return num;
    }

    public int resolvidos() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(status) FROM chamado WHERE status='Resolvido'");

        while (rs.next()) {
            num = rs.getInt("count(status)");
        }
        return num;
    }

    public int requisicoes() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(status) FROM chamado WHERE status='Requisitado'");

        while (rs.next()) {
            num = rs.getInt("count(status)");
        }
        return num;
    }

    public int totalChamados() throws Exception {
        int num = 0;
        conectar();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT count(bin) FROM chamado");

        while (rs.next()) {
            num = rs.getInt("count(bin)");
        }
        return num;
    }

    public ArrayList<Chamado> listaDeChamadosCliente(String matricula) throws Exception {
        ArrayList<Chamado> chamados = new ArrayList<Chamado>();
        conectar();
        Statement stm = con.createStatement();

        ResultSet rs = stm.executeQuery("SELECT * FROM chamado WHERE cliente_matricula=" + "'" + matricula + "'");

        return chamados;
    }

}
