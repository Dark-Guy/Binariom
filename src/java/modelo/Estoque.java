package modelo;

import java.util.ArrayList;

public class Estoque {

    private int id;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void inserir() throws Exception {
        EstoqueDAO eDAO = new EstoqueDAO();
        eDAO.inserir(this);
    }

    public void alterar() throws Exception {
        EstoqueDAO eDAO = new EstoqueDAO();
        eDAO.alterar(this);
    }

    public ArrayList<Estoque> listar() throws Exception {
        EstoqueDAO eDAO = new EstoqueDAO();
        return eDAO.listar();
    }
    
    public int contarComponentes (int id) throws Exception{
        EstoqueDAO eDAO = new EstoqueDAO();
        int qtd;
        qtd = eDAO.contarComponentes(id);
        return qtd;
    }
}
