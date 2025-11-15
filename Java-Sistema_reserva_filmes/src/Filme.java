public class Filme {

    private String titulo;
    private String genero;
    private int duracaoMinutos;
    private boolean disponivel;
    private double somaAvaliacoes;
    private int contadorAvaliacoes;

    public Filme(String titulo, String genero, int duracaoMinutos, boolean disponivel) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoMinutos = duracaoMinutos;
        this.disponivel = disponivel;
        this.somaAvaliacoes = 0.0;
        this.contadorAvaliacoes = 0;
    }

    public void exibirDetalhes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Duracao: " + duracaoMinutos + " min");
        System.out.println("Disponivel: " + (disponivel ? "Sim" : "Não"));
        if (contadorAvaliacoes == 0) {
            System.out.println("Avaliação média: Sem avaliações");
        } else {
            System.out.printf("Avaliação média: %.2f (%d avaliações)%n", getAvaliacaoMedia(), contadorAvaliacoes);
        }
        System.out.println("-------------------------------");
    }

    public void exibirDetalhesCurtos() {
        System.out.printf("%s (%s) - %.2f/5 - %s%n",
        titulo, genero, getAvaliacaoMedia(), (disponivel ? "Disonivel" : "Reservado/Indisponivel"));
    }

    public void avaliar(double nota) {
        if (nota < 0.0 || nota > 5.0) {
            System.out.println("Nota inválida. Use valores entre 0.0 e 5.0");
            return;
        }
        somaAvaliacoes += nota;
        contadorAvaliacoes++;
    }

    public double getAvaliacaoMedia() {
        if (contadorAvaliacoes == 0) return 0.0;
        return somaAvaliacoes / contadorAvaliacoes;
    }

    public String getTitulo() { return titulo; }
    public String getGenero() { return genero; }
    public int getDuracaoMinutos() { return duracaoMinutos; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

}
