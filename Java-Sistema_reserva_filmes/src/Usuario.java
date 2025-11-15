import java.util.*;

public class Usuario {
    private String nome;
    private List<Filme> assistidos;
    private List<Filme> reservados;

    public Usuario(String nome) {
        this.nome = nome;
        this.assistidos = new ArrayList<Filme>();
        this.reservados = new ArrayList<Filme>();
    }

    public String getNome() {
        return nome;
    }

    public void assistirFilme(Filme f) {
        if (f.isDisponivel() || reservados.contains(f)) {
            System.out.println(nome + " está assistindo: " + f.getTitulo());
            assistidos.add(f);
            if (reservados.contains(f)) {
                reservados.remove(f);
                f.setDisponivel(true);
            }
        } else {
            System.out.println("Filme '" + f.getTitulo() + "' não disponível para assistir agora.");
        }
    }

    public void reservarFilme(Filme f) {
        if (!f.isDisponivel()) {
            System.out.println("Não foi possível reservar '" + f.getTitulo() + "' — já está indisponível.");
            return;
        }
        reservados.add(f);
        f.setDisponivel(false);
        System.out.println(nome + " reservou o filme: " + f.getTitulo());
    }

    public void exibirAssistidos() {
        System.out.println("Assistidos de " + nome + ":");
        if (assistidos.isEmpty()) {
            System.out.println("  (nenhum)");
            return;
        }
        for (int i = 0; i < assistidos.size(); i++) {
            Filme f = assistidos.get(i);
            System.out.println(" - " + f.getTitulo() + " (" + f.getGenero() + ")");
        }
    }

    public void exibirReservas() {
        System.out.println("Reservas de " + nome + ":");
        if (reservados.isEmpty()) {
            System.out.println("  (nenhuma)");
            return;
        }
        for (int i = 0; i < reservados.size(); i++) {
            Filme f = reservados.get(i);
            System.out.println(" - " + f.getTitulo() + " (" + f.getGenero() + ")");
        }
    }

    public List<Filme> getAssistidos() {
        return Collections.unmodifiableList(assistidos);
    }

    public List<Filme> getReservados() {
        return Collections.unmodifiableList(reservados);
    }

    public void avaliarFilme(Filme f, double nota) {
        f.avaliar(nota);
        System.out.printf("%s avaliou '%s' com %.1f%n", nome, f.getTitulo(), nota);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario)) return false;
        Usuario u = (Usuario) o;
        return this.nome.equalsIgnoreCase(u.nome);
    }

    @Override
    public int hashCode() {
        return nome.toLowerCase().hashCode();
    }
}
