package modelo;

import java.util.ArrayList;
import java.util.Date;

public class Chamado {

    private int bin;
    private String descricao;
    private String atendimento;
    private String status;
    private Date da;
    private Date dr;
    private Usuario usuario;
    private Equipamento equipamento;
    private Cliente cliente;

    public int getBin() {
        return bin;
    }

    public void setBin(int bin) {
        this.bin = bin;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public String getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(String atendimento) {
        this.atendimento = atendimento;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDa() {
        return da;
    }

    public void setDa(Date da) {
        this.da = da;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Date getDr() {
        return dr;
    }

    public void setDr(Date dr) {
        this.dr = dr;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void abrir() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        cDAO.abrir(this);
    }
    
    public void realizar() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        cDAO.realizar(this);
    }
    public void aprovar() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        cDAO.aprovar(this);
    }
    public void cancelar() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        cDAO.cancelar(this);
    }

    public void finalizar() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        cDAO.finalizar(this);
    }

    public ArrayList<Chamado> listarAbertos() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.listarAbertos();
    }
    
    public ArrayList<Chamado> listarRequisicoes() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.listarRequisicoes();
    }
    
    public ArrayList<Chamado> listarEmAndamento() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.listarEmAndamento();
    }

    public ArrayList<Chamado> listarCancelados() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.listarCancelados();
    }

    public ArrayList<Chamado> listarResolvidos() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.listarResolvidos();
    }

    public int totalChamados() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.totalChamados();
    }

    public int abertos() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.abertos();
    }

    public int cancelados() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.cancelados();
    }

    public int emAndamento() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.emAndamento();
    }

    public int resolvidos() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.resolvidos();
    }
    
    public int requisicoes() throws Exception {
        ChamadoDAO cDAO = new ChamadoDAO();
        return cDAO.requisicoes();
    }
}