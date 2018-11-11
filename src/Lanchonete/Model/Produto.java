package Lanchonete.Model;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double peso;

    public Produto(String codigo, String nome, String descricao, double preco, double peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco; //preço base do produto (1kg)
        this.peso = peso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double NovoPreco() {
        double aux;

        if (peso > 1.0) {
            aux = peso - 1.0;
            aux /= 0.1;
            preco += (aux * 0.15);
        }
        return preco;
    }
}
