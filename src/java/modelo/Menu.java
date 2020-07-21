package modelo;

import java.util.ArrayList;

public class Menu {

    private int id;
    private String nome;
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void inserir() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.inserir(this);
    }

    public void alterar() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.alterar(this);
    }

    public ArrayList<Menu> listar() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        return mDAO.listar();
    }

    public void excluir() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.excluir(this);
    }
}
