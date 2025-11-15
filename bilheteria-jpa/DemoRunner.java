import com.example.bilheteriajpa.model.*;
import com.example.bilheteriajpa.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class DemoRunner implements CommandLineRunner {

    // Injeção de todos os repositórios
    private final AtorRepository atorRepository;
    private final ClienteRepository clienteRepository;
    private final FilmeRepository filmeRepository;
    private final GeneroRepository generoRepository;
    private final IngressoRepository ingressoRepository;
    private final SalaRepository salaRepository;
    private final SessaoRepository sessaoRepository;

    public DemoRunner(AtorRepository atorRepository, ClienteRepository clienteRepository, 
                      FilmeRepository filmeRepository, GeneroRepository generoRepository, 
                      IngressoRepository ingressoRepository, SalaRepository salaRepository, 
                      SessaoRepository sessaoRepository) {
        this.atorRepository = atorRepository;
        this.clienteRepository = clienteRepository;
        this.filmeRepository = filmeRepository;
        this.generoRepository = generoRepository;
        this.ingressoRepository = ingressoRepository;
        this.salaRepository = salaRepository;
        this.sessaoRepository = sessaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Genero acao = new Genero();
        acao.setNome("Ação");
        Genero sciFi = new Genero();
        sciFi.setNome("Ficção Científica");
        generoRepository.saveAll(List.of(acao, sciFi));

        Ator ator1 = new Ator();
        ator1.setNome("Keanu Reeves");
        Ator ator2 = new Ator();
        ator2.setNome("Scarlett Johansson");
        atorRepository.saveAll(List.of(ator1, ator2));

        Filme filme1 = new Filme();
        filme1.setTituloFilme("Matrix");
        filme1.setDuracao(136);
        filme1.getGeneros().add(acao);
        filme1.getGeneros().add(sciFi);
        filme1.getAtores().add(ator1);
        filmeRepository.save(filme1);

        Sala sala1 = new Sala();
        sala1.setNumeroSala(1);
        sala1.setCapacidade(100);

        Assento a1 = new Assento();
        a1.setFileira("A");
        a1.setNumero(1);
        sala1.addAssento(a1);
        
        Assento a2 = new Assento();
        a2.setFileira("A");
        a2.setNumero(2);
        sala1.addAssento(a2);

        salaRepository.save(sala1);

        Sessao sessao1 = new Sessao();
        sessao1.setDataHoraInicio(LocalDateTime.now().plusHours(2));
        sessao1.setFilme(filme1);
        sessao1.setSala(sala1);
        sessaoRepository.save(sessao1);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Ana Silva");
        cliente1.setEmail("ana@email.com");
        clienteRepository.save(cliente1);

        Ingresso ingresso1 = new Ingresso();
        ingresso1.setTipo("Inteira");
        ingresso1.setPreco(50.00);
        ingresso1.setSessao(sessao1);
        ingressoRepository.save(ingresso1);

        cliente1.getIngressos().add(ingresso1);
        clienteRepository.save(cliente1);

        List<Sessao> sessoesMatrix = sessaoRepository.findByFilme_TituloFilme("Matrix");
        sessoesMatrix.forEach(s -> {
            System.out.println("Sessão ID: " + s.getId() + " - Início: " + s.getDataHoraInicio());
        });
    }
}