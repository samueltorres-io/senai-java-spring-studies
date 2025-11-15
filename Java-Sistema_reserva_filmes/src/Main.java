import java.util.*;

public class Main {
    public static void main(String[] args) {
        BibliotecaFilmes biblioteca = new BibliotecaFilmes();

        Filme f1 = new Filme("O Viajante", "Aventura", 120, true);
        Filme f2 = new Filme("Amor em Código", "Romance", 95, true);
        Filme f3 = new Filme("Mistério da Noite", "Suspense", 110, true);
        Filme f4 = new Filme("Risos e Bugs", "Comédia", 100, true);
        Filme f5 = new Filme("A Estratégia", "Aventura", 130, true);
        Filme f6 = new Filme("Coração de Silício", "Romance", 105, true);

        biblioteca.adicionarFilme(f1);
        biblioteca.adicionarFilme(f2);
        biblioteca.adicionarFilme(f3);
        biblioteca.adicionarFilme(f4);
        biblioteca.adicionarFilme(f5);
        biblioteca.adicionarFilme(f6);

        Usuario alice = new Usuario("Alice");
        Usuario bob = new Usuario("Bob");

        // Simulações
        System.out.println("=== Catálogo completo ===");
        biblioteca.listarFilmes();

        System.out.println("\n=== Alice reserva e assiste filmes ===");
        alice.reservarFilme(f1);
        alice.assistirFilme(f1);
        alice.avaliarFilme(f1, 4.5);

        alice.assistirFilme(f2);
        alice.avaliarFilme(f2, 5.0);

        System.out.println("\n=== Bob assiste e avalia ===");
        bob.assistirFilme(f4);
        bob.avaliarFilme(f4, 3.5);

        bob.assistirFilme(f3);
        bob.avaliarFilme(f3, 4.0);

        alice.assistirFilme(f5);
        alice.avaliarFilme(f5, 4.0);

        System.out.println("\n=== Lista de assistidos e reservas ===");
        alice.exibirAssistidos();
        alice.exibirReservas();
        bob.exibirAssistidos();
        bob.exibirReservas();

        System.out.println("\n=== Recomendador sugere para Alice ===");
        Recomendador rec = new Recomendador(biblioteca);
        List<Filme> recomendadosParaAlice = rec.sugerirFilmes(alice, 5);
        if (recomendadosParaAlice.isEmpty()) {
            System.out.println("Nenhuma recomendação disponível no momento.");
        } else {
            System.out.println("Recomendações para " + alice.getNome() + ":");
            for (int i = 0; i < recomendadosParaAlice.size(); i++) {
                recomendadosParaAlice.get(i).exibirDetalhesCurtos();
            }
        }

        System.out.println("\n=== Ranking dos filmes mais bem avaliados ===");
        List<Filme> top3 = biblioteca.rankingTopAvaliados(3);
        for (int i = 0; i < top3.size(); i++) {
            System.out.printf("%d) ", i + 1);
            top3.get(i).exibirDetalhesCurtos();
        }

        System.out.println("\n=== Filmes do gênero 'Aventura' ===");
        List<Filme> aventuras = biblioteca.buscarPorGenero("Aventura");
        for (int i = 0; i < aventuras.size(); i++) {
            aventuras.get(i).exibirDetalhesCurtos();
        }
    }
}
