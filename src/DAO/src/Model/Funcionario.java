package Model;

public class Funcionario extends Pessoa {

    private int numero;
    private String endereco;
    private double salario;

    public Funcionario(int numero, String endereco, double salario, String nome, String cpf) {
        super(nome, cpf);
        this.numero = numero;
        this.endereco = endereco;
        this.salario = salario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
}
