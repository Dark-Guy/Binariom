package modelo;

import java.util.ArrayList;

public class Equipamento {

    private String etiqueta;
    private String tipo;
   
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //Metodos da DAO
    public void inserir() throws Exception {
        EquipamentoDAO eDAO = new EquipamentoDAO();
        eDAO.inserir(this);
    }

    public void alterar() throws Exception {
        EquipamentoDAO eDAO = new EquipamentoDAO();
        eDAO.alterar(this);
    }

    public void carregaPorEtiqueta(String etiqueta) throws Exception {
        EquipamentoDAO eDAO = new EquipamentoDAO();
        this.setEtiqueta(eDAO.carregarPorEtiqueta(etiqueta).getEtiqueta());
        this.setTipo(eDAO.carregarPorEtiqueta(etiqueta).getTipo());
    }

    public ArrayList<Equipamento> listar() throws Exception{
        EquipamentoDAO eDAO = new EquipamentoDAO();
        return eDAO.listar();
    }

    public void excluir() throws Exception {
        EquipamentoDAO eDAO = new EquipamentoDAO();
        eDAO.excluir(this);
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

}
