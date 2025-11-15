import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.print("Digite o seu e-mail: ");
        String email = sc.nextLine();

        try {

            FileWriter w = new FileWriter("dados.txt", true);

            Date data = new Date();

            w.write("Nome: " + nome + "\n");
            w.write("Idade: " + idade + "\n");
            w.write("Email: " + email + "\n");
            w.write("Data: " + data + "\n" );
            w.write("-----------------------");
            w.close();

            System.out.println("Dados salvos!");

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        sc.close();

    }
}
