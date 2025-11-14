package src.gerencia;

public class Curso {

    public String nome;
    public Double duracao;

    public Curso(String nome, Double duracao) {
        this.nome = nome;
        this.duracao = duracao;
    };

    public String getNome() {
        return nome;
    }

    public Double getDuracao() {
        return duracao;
    }

}
