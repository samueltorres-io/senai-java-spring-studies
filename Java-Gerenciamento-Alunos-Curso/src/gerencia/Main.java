package src.gerencia;

public class Main {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Joao Silva", 20);
        Curso curso1 = new Curso("Java Basico", 40.0);
        Matricula matricula1 = new Matricula(aluno1, curso1);
        System.out.println(matricula1);

        Aluno aluno2 = new Aluno("Maria Oliveira", 25);
        Curso curso2 = new Curso("Python Avançado", 60.0);
        Matricula matricula2 = new Matricula(aluno2, curso2);
        System.out.println(matricula2);
    }

}
