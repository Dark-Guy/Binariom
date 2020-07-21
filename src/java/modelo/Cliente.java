package modelo;

import java.util.ArrayList;

public class Cliente {

    private String matricula;
    private String nome;
    private String senha;
    private String cpf;
    private String setor;
    private int sala;
    private String telefone;
    private String status;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void inserir() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.inserir(this);
    }

    public void alterar() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.alterar(this);
    }

    public ArrayList<Cliente> listar() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.listar();
    }

    public void carregarPorMatricula(String matricula) throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        this.setMatricula(cDAO.carregarPorMatricula(matricula).getMatricula());
        this.setNome(cDAO.carregarPorMatricula(matricula).getNome());
        this.setCpf(cDAO.carregarPorMatricula(matricula).getCpf());
        this.setSetor(cDAO.carregarPorMatricula(matricula).getSetor());
        this.setTelefone(cDAO.carregarPorMatricula(matricula).getTelefone());
        this.setSenha(cDAO.carregarPorMatricula(matricula).getSenha());
        this.setSala(cDAO.carregarPorMatricula(matricula).getSala());
        this.setStatus(cDAO.carregarPorMatricula(matricula).getStatus());
    }

    public void excluir() throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        cDAO.excluir(this);
    }

    public Cliente logar(String matricula, String senha) throws Exception {
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.logar(matricula, senha);
    }
}
