public class TransacaoCartao extends Transacao {

    public TransacaoCartao(Double valor) {
        super(valor);
    }

    @Override
    public void validarFraude() throws FraudeDetectadaExceptio {
        if (valor > 5000) {
            throw new FraudeDetectadaExceptio("Valor acima do limite permitido para cartão!");
        }
    }

    @Override
    public Double calcularTaxa() {
        return (valor * 0.02) + 1.50;
    }

}
