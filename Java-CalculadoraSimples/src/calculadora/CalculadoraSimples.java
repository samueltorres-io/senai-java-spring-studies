package src.calculadora;

import java.util.Scanner;

public class CalculadoraSimples {

    static public Double soma(Double n1, Double n2) {
        return n1 + n2;
    }

    static public Double subtracao(Double n1, Double n2) {
        return n1 - n2;
    }

    static public Double multiplicacao(Double n1, Double n2) {
        return n1 * n2;
    }

    static public Double divisao(Double n1, Double n2) {
        return n1 / n2;
    }

    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Double[] n = new Double[2];

        for (int i = 0; i < 2; i++) {
            System.out.printf("Insira o %d numero: ", i + 1);
            n[i] = sc.nextDouble();
        }

        System.out.println("Soma: " + soma(n[0], n[1]));
        System.out.println("Subtracao: " + subtracao(n[0], n[1]));
        System.out.println("Multiplicacao: " + multiplicacao(n[0], n[1]));
        System.out.println("Divisao: " + divisao(n[0], n[1]));

        sc.close();

    }

}
