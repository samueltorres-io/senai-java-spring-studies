import java.util.Scanner;

/*
Descrição: Escreva um programa que solicite a idade do usuário e classifique-o em uma das seguintes categorias:

    Menor de 12 anos: "Criança".
    Entre 12 e 17 anos: "Adolescente".
    Entre 18 e 59 anos: "Adulto".
    60 anos ou mais: "Idoso".

Dica: Utilize estruturas condicionais if, else if e else.
*/

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Insira sua idade: ");
        Integer idade = sc.nextInt();

        if (idade < 12) {
            System.out.println("Criança");
        } else if (idade < 18) {
            System.out.println("Adolescente");
        } else if (idade < 60) {
            System.out.println("Adulto");
        } else {
            System.out.println("Idoso");
        }

        sc.close();

    }
}
