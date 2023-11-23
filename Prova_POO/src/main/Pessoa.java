package main;

public class Pessoa {
    private String nome;
    private int idade;
    private String sexo;
    private boolean embriaguez;

    public Pessoa(String nome, int idade, String sexo, boolean embriaguez) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.embriaguez = embriaguez;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public boolean isEmbriaguez() {
        return embriaguez;
    }

    public void setEmbriaguez(boolean embriaguez) {
        this.embriaguez = embriaguez;
    }
}
