package Model;

import java.util.Date;
import java.util.ArrayList;

public class Pedido {

    private int codigo;
    private Date data;
    private Status status;
    private FormaDePagamento formapgto;
    private ArrayList<Item> itens;

    public Pedido(int codigo, Date data, Status status, FormaDePagamento formapgto) {
        this.codigo = codigo;
        this.data = data;
        this.status = status;
        this.formapgto = formapgto;
        this.itens = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public FormaDePagamento getFormapgto() {
        return formapgto;
    }

    public void setFormapgto(FormaDePagamento formapgto) {
        this.formapgto = formapgto;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }

    public void AddItem(Item i) { //adicionar um item em pedido
        this.itens.add(i);
    }

    public double getPrecoTotal() { //somar todos os itens para ver o preço total do pedido
        double preco_t = 0;
        for (Item item : this.itens) {
            preco_t += item.PrecoTotalItem();
        }
        return preco_t;
    }
}
