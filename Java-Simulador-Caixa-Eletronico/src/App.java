import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        Usuario usuario = new Usuario("Lucas", 1000.00);

        byte opcao;
        Double valor;
        
        do {
            System.out.println("Escolha uma operação: \n [1] Saque \n [2] Depósito \n [3] Consultar Saldo \n [4] Sair");
            opcao = sc.nextByte();

            switch (opcao) {
                case 1:
                    System.out.print("Seu saldo é: " + usuario.getSaldo());
                    System.out.print("\nDigite o valor do saque: ");
                    valor = sc.nextDouble();
                    System.out.println("Seu saldo atual é: " + usuario.saque(valor));
                    continue;
                case 2:
                    System.out.print("Digite o valor de depósito: ");
                    valor = sc.nextDouble();
                    System.out.println("Seu saldo atual é: " + usuario.deposito(valor));
                case 3:
                    System.out.println("Seu saldo atual é de: " + usuario.getSaldo());
                default:
                    continue;
            }

        } while (opcao != 4);

        sc.close();

    }
}
