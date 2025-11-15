import java.util.*;

public class Recomendador {
    private BibliotecaFilmes biblioteca;

    public Recomendador(BibliotecaFilmes biblioteca) {
        this.biblioteca = biblioteca;
    }

    public List<Filme> sugerirFilmes(Usuario usuario, int limite) {
        Map<String, Integer> contagem = new HashMap<String, Integer>();
        List<Filme> assistidos = usuario.getAssistidos();
        for (int i = 0; i < assistidos.size(); i++) {
            Filme f = assistidos.get(i);
            String g = f.getGenero();
            if (contagem.containsKey(g)) {
                contagem.put(g, contagem.get(g) + 1);
            } else {
                contagem.put(g, 1);
            }
        }

        List<Filme> todos = biblioteca.getFilmes();
        Set<Filme> setAssistidos = new HashSet<Filme>(usuario.getAssistidos());
        Set<Filme> setReservados = new HashSet<Filme>(usuario.getReservados());

        List<Filme> recomendacoes = new ArrayList<Filme>();

        if (contagem.isEmpty()) {
            List<Filme> copia = new ArrayList<Filme>(todos);
            Collections.sort(copia, new Comparator<Filme>() {
                public int compare(Filme a, Filme b) {
                    return Double.compare(b.getAvaliacaoMedia(), a.getAvaliacaoMedia());
                }
            });
            for (int i = 0; i < copia.size() && recomendacoes.size() < limite; i++) {
                Filme f = copia.get(i);
                if (f.isDisponivel() && !setAssistidos.contains(f) && !setReservados.contains(f)) {
                    recomendacoes.add(f);
                }
            }
            return recomendacoes;
        }

        String favorito = null;
        int maior = -1;
        for (Iterator<String> it = contagem.keySet().iterator(); it.hasNext();) {
            String g = it.next();
            int c = contagem.get(g);
            if (c > maior) {
                maior = c;
                favorito = g;
            }
        }

        for (int i = 0; i < todos.size() && recomendacoes.size() < limite; i++) {
            Filme f = todos.get(i);
            if (f.getGenero().equalsIgnoreCase(favorito) && f.isDisponivel()
                    && !setAssistidos.contains(f) && !setReservados.contains(f)) {
                recomendacoes.add(f);
            }
        }

        if (recomendacoes.size() < limite) {
            List<Filme> copia = new ArrayList<Filme>(todos);
            Collections.sort(copia, new Comparator<Filme>() {
                public int compare(Filme a, Filme b) {
                    return Double.compare(b.getAvaliacaoMedia(), a.getAvaliacaoMedia());
                }
            });
            for (int i = 0; i < copia.size() && recomendacoes.size() < limite; i++) {
                Filme f = copia.get(i);
                if (!setAssistidos.contains(f) && !setReservados.contains(f) && f.isDisponivel()) {
                    if (!recomendacoes.contains(f)) {
                        recomendacoes.add(f);
                    }
                }
            }
        }

        return recomendacoes;
    }
}
