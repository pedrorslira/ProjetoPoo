package Lanchonete.Model;

import java.util.Date;
import java.util.ArrayList;

public class Pedido {

    private String codigo;
    private Date data;
    private Status status;
    private FormaDePagamento formapgto;
    private ArrayList<Item> itens;

    public Pedido(Date data, FormaDePagamento formapgto) {
        this.data = data;
        this.formapgto = formapgto;
        this.itens = new ArrayList<>();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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

    public String NovoCodigo() {
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "z"};
        String cod = "";

        for (int x = 0; x < 6; x++) {
            int j = (int) (Math.random() * carct.length);
            cod += carct[j];
        }
        return cod;
    }
}
