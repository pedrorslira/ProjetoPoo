package Lanchonete.Model;

public class Funcionario extends Pessoa {

    private String codigo;
    private String endereco;
    private double salario;
    private int qtdvendas;

    public Funcionario(String endereco, double salario, String nome, String cpf) {
        super(nome, cpf);
        this.endereco = endereco;
        this.salario = salario;
        this.qtdvendas = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getQtdVendas() {
        return qtdvendas;
    }

    public void setQtdVendas(int qtd) {
        this.qtdvendas = qtd;
    }

    public String NovoCodigo() {
        String[] carct = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String cod = "";
        for (int x = 0; x < 3; x++) {
            int j = (int) (Math.random() * carct.length);
            cod += carct[j];
        }
        return cod;
    }

    public void BonusSalario(double precoTotalPedido) {
        double bonus = precoTotalPedido * 0.02; //bônus de 2% de cada venda no salário do funcionário
        this.setSalario(this.getSalario() + bonus);
    }

}
