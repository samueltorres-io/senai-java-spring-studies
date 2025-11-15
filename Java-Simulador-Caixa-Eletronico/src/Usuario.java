public class Usuario {

    public String nome;
    private Double saldo;

    public Usuario(String nome, Double saldo) {
        this.nome = nome;
        setSaldo(saldo);
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        if (saldo < 0) {
            System.out.println("O saldo deve ser um valor maior ou igual a zero!");
        } else {
            this.saldo = saldo;
        }
    }

    public Double saque(Double valor) {
        if (valor <= 0) {
            System.out.println("O valor não pode ser nulo!");
            return null;
        } else if (valor > saldo) {
            System.out.println("O valor de saque é maior que o saldo!");
            return null;
        } else {
            this.saldo = saldo - valor;
            return saldo;
        }
    }

    public Double deposito(Double valor) {
        if (valor <= 0) {
            System.out.println("O valor não pode ser nulo!");
            return null;
        }
        this.saldo = valor + saldo;
        return saldo;
    }

}
