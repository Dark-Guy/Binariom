package modelo;

public class Componente {

    private String id;
    private String modelo;
    private String tipo;
    private String marca;
    private String descricao;
    private String status;
    private Estoque estoque;
    private Equipamento equipamento;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void inserir() throws Exception {
        ComponenteDAO cDAO = new ComponenteDAO();
        cDAO.inserir(this);
    }

    public void alterar() throws Exception {
        ComponenteDAO cDAO = new ComponenteDAO();
        cDAO.alterar(this);
    }
    
    public void remover() throws Exception {
        ComponenteDAO cDAO = new ComponenteDAO();
        cDAO.remover(this);
    }
}
