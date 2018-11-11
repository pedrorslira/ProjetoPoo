package Lanchonete.Model;

public class Administrador extends Pessoa {

    private String usuario;
    private String senha;

    public Administrador() {
        super("Big Boss", "96342158746");
        this.usuario = "admin";
        this.senha = "admin123";
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
