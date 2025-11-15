import java.util.*;

public class BibliotecaFilmes {
    private List<Filme> filmes;

    public BibliotecaFilmes() {
        filmes = new ArrayList<Filme>();
    }

    public void adicionarFilme(Filme f) {
        filmes.add(f);
    }

    public void listarFilmes() {
        for (int i = 0; i < filmes.size(); i++) {
            filmes.get(i).exibirDetalhes();
        }
    }

    public List<Filme> buscarPorGenero(String genero) {
        List<Filme> resultado = new ArrayList<Filme>();
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if (f.getGenero().equalsIgnoreCase(genero)) {
                resultado.add(f);
            }
        }
        return resultado;
    }

    public List<Filme> rankingTopAvaliados(int n) {
        List<Filme> copia = new ArrayList<Filme>(filmes);
        Collections.sort(copia, new Comparator<Filme>() {
            public int compare(Filme a, Filme b) {
                return Double.compare(b.getAvaliacaoMedia(), a.getAvaliacaoMedia());
            }
        });
        List<Filme> top = new ArrayList<Filme>();
        for (int i = 0; i < n && i < copia.size(); i++) {
            top.add(copia.get(i));
        }
        return top;
    }

    public Filme buscarPorTitulo(String titulo) {
        for (int i = 0; i < filmes.size(); i++) {
            if (filmes.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return filmes.get(i);
            }
        }
        return null;
    }

    public List<Filme> getFilmes() {
        return Collections.unmodifiableList(filmes);
    }

}