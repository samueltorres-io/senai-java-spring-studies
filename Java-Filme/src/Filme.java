public class Filme {

    private String titulo;
    private String genero;
    private int duracao;
    private int anoLancamento;
    private String classificacao;
    private boolean disponivel;
    private double notaMedia;
    private int totalAvaliacoes;
    private int totalDeViews;

    public Filme(String titulo, String genero, int duracao, int anoLancamento, String classificacao) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.classificacao = classificacao;
        this.disponivel = true;
        this.notaMedia = 0.0;
        this.totalAvaliacoes = 0;
        this.totalDeViews = 0;
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Gênero: " + genero);
        System.out.println("Duração: " + duracao + " min");
        System.out.println("Ano: " + anoLancamento);
        System.out.println("Classificação: " + classificacao);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("Nota média: " + notaMedia);
        System.out.println("Total de views: " + totalDeViews);
    }

    public void reproduzir() {
        if (disponivel) {
            System.out.println("Reproduzindo: " + titulo + "...");
            totalDeViews++;
        } else {
            System.out.println("O filme " + titulo + " não está disponível no momento.");
        }
    }

    public void avaliar(int nota) {
        totalAvaliacoes++;
        notaMedia = ((notaMedia * (totalAvaliacoes - 1)) + nota) / totalAvaliacoes;
        System.out.println("Obrigado por avaliar! Nova média: " + notaMedia);
    }

    public void marcarComoIndisponivel() {
        disponivel = false;
    }

    public void marcarComoDisponivel() {
        disponivel = true;
    }
}
