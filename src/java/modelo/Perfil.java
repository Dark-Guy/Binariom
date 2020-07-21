package modelo;

import java.util.ArrayList;

public class Perfil {

    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Menu> menus;

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
    
    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }    

    public void inserir() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.inserir(this);
    }

    public void alterar() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.alterar(this);
    }

    public ArrayList<Perfil> listar() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.listar();
    }

    public void carregarPorId(int id) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        this.id = pDAO.carregarPorId(id).getId();
        this.nome = pDAO.carregarPorId(id).getNome();
        this.descricao = pDAO.carregarPorId(id).getDescricao();
        this.menus = pDAO.carregarPorId(id).getMenus();
    }

    public void excluir() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.excluir(this);
    }

    public ArrayList<Menu> menusNaoPerfil(int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.carregaMenusNaoPerfil(id_perfil);
    }

    public ArrayList<Menu> menusPerfil(int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return pDAO.carregaMenusPerfil(id_perfil);

    }

    public void vincularMenu(int id_menu, int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.vincularMenu(id_menu, id_perfil);
    }

    public void desvincularMenu(int id_menu, int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.desvincularMenu(id_menu, id_perfil);
    }
}
