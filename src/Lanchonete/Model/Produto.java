package Lanchonete.Model;

import Lanchonete.Model.Strategy.Strategy.Categoria;
import Lanchonete.Model.Strategy.*;

public class Produto {

    private String codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double peso;
    private double preco_embalagem;
    private Categoria categoria;

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

    public double getPreco_embalagem() {
        return preco_embalagem;
    }

    public void setPreco_embalagem(double preco_embalagem) {
        this.preco_embalagem = preco_embalagem;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public void NovoPreco() {
        Strategy calculo;        
        if (peso >= 1) {
            calculo = new CalculoPrecoLeve();
            calculo.aplicar(this);
        } else if (peso > 3) {
            calculo = new CalculoPrecoMedio();
            calculo.aplicar(this);
        } else if (peso > 5) {
            calculo =  new CalculoPrecoPesado();
            calculo.aplicar(this);
        }
    }
}
