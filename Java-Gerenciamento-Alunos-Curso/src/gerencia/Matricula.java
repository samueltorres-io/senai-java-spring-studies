package src.gerencia;

public class Matricula {

    public Aluno aluno;
    public Curso curso;

    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
    };

    @Override
    public String toString() {
        return aluno.toString() + "\n" + curso.toString();
    }

}
