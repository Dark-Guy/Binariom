package modelo;

import java.util.ArrayList;

public class Usuario {

    private String matricula;
    private String nome;
    private String senha;
    private String cpf;
    private String setor;
    private String telefone;
    private String status;
    private Perfil perfil;

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

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void inserir() throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        uDAO.inserir(this);
    }

    public void alterar() throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        uDAO.alterar(this);
    }

    public ArrayList<Usuario> listar() throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.listar();
    }

    public void excluir() throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        uDAO.excluir(this);
    }
    
    public Usuario logar(String matricula, String senha) throws Exception{
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.logar(matricula,senha);
    }
	
    public ArrayList<Usuario> listarTecnicos() throws Exception {
        UsuarioDAO uDAO = new UsuarioDAO();
        return uDAO.listarTecnicos();
    }
	
}
