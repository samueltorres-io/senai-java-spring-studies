package src.gerencia;

public class Aluno {

    public String nome;
    private Integer idade;

    public Aluno(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    };

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public Integer idade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + ", Idade: " + idade;
    }

}
