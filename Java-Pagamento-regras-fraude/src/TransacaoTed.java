public class TransacaoTed extends Transacao{

    public TransacaoTed(Double valor) {
        super(valor);
    }

    @Override
    public void validarFraude() throws FraudeDetectadaExceptio {
        if (valor > 50000) {
            throw new FraudeDetectadaExceptio("Valor acima do limite permitido para TED!");
        }
    }

    @Override
    public Double calcularTaxa() {
        return (Double) 15.0;
    }

}
