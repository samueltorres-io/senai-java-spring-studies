import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cpf;
        boolean isValid = false;

        do {
            System.out.print("Digite seu CPF (formato XXX.XXX.XXX-XX): ");
            cpf = sc.nextLine();

            isValid = ValidaCPF.isCPF(cpf);

            if (isValid) {
                System.out.println("CPF válido!");
            } else {
                System.out.println("CPF inválido! Tente novamente.");
            }

        } while (!isValid);

        sc.close();
    }
}
