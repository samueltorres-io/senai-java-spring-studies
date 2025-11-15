public class TransacaoPix extends Transacao {

    public TransacaoPix(Double valor) {
        super(valor);
    }

    @Override
    public void validarFraude() throws FraudeDetectadaExceptio {
        if (valor > 10000) {
            throw new FraudeDetectadaExceptio("Valor acima do limite permitido para pix!");
        }
    }

    @Override
    public Double calcularTaxa() {
        return (Double) 0.50;
    }

}
