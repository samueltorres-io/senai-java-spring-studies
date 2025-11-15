import java.time.LocalDateTime;

public abstract class Transacao {

    protected Double valor;
    protected LocalDateTime dataHora;
    protected String status;

    public Transacao(Double valor) {
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.status = "PENDENTE";
    };

    public abstract void validarFraude() throws FraudeDetectadaExceptio;
    public abstract Double calcularTaxa();

    public void processar() {
        try {
            validarFraude();
            double taxa = calcularTaxa();
            System.out.println("Taxa: R$ " + taxa);

            status = "APROVADA";
            System.out.println("Transacao aprovada!");
        } catch (FraudeDetectadaExceptio e) {
            status = "REJEITADA";
            System.out.println("Transacao rejeitada: " + e.getMessage());
        }
    }

    public String getStatus() {
        return (String) status;
    }

}
