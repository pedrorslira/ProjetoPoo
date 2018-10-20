package Model;

public class Produto {

    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double peso;

    public Produto(int codigo, String nome, String descricao, double preco, double peso) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco; //preço base do produto (1kg)
        this.peso = peso;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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

    public double NovoPreco() { //cálculo do preço baseado no peso. A partir de 1.10 kg,aumentar 0.15 do preço a cada 0.10 kg
        double aux;
        if (peso > 1.0) {
            aux = peso - 1.0;
            aux /= 0.1;
            preco += (aux * 0.15);
        }
        return preco;
    }
}
