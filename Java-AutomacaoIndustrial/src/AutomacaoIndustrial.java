public class AutomacaoIndustrial {

    /*
        Automação Industrial com Sobrecarga
        Uma empresa deseja automatizar o cálculo da eficiência das máquinas com base em diferentes critérios. Para isso, você precisa implementar métodos sobrecarregados que lidem com diferentes tipos de dados.

        Tarefa:
        Crie dois métodos chamados calcularEficiência utilizando sobrecarga:

        Um método que receba dois parâmetros:

            A quantidade de produtos fabricados (um número inteiro).
            A quantidade de horas trabalhadas (um número inteiro).
            O método deve retornar a eficiência como produtos por hora.

        Outro método que receba três parâmetros:

            A quantidade de produtos fabricados (um número inteiro).
            A quantidade de horas trabalhadas (um número inteiro).
            A quantidade de operadores trabalhando na máquina (um número inteiro).
            O método deve retornar a eficiência como produtos por hora por operador.

        Utilize os métodos criados para calcular a eficiência e exiba os resultados no console.

        Objetivo dos Exercícios

            Aplicar conceitos fundamentais de métodos com retorno, sem retorno e sobrecarga.
            Contextualizar o uso de Java em cenários reais da indústria, como automação, controle e manutenção.
            Desenvolver habilidades práticas para resolver problemas industriais utilizando programação orientada a objetos.
    */

    public static double calcularEficiencia(int produtos, int horas) {
        if (horas <= 0) {
            System.out.println("Horas deve ser maior que 0.");
            return 0.0;
        }
        return (double) produtos / (double) horas;
    }

    public static double calcularEficiencia(int produtos, int horas, int operadores) {
        if (horas <= 0) {
            System.out.println("Horas deve ser maior que 0.");
            return 0.0;
        }
        if (operadores <= 0) {
            System.out.println("Operadores deve ser maior que 0.");
            return 0.0;
        }
        return (double) produtos / ((double) horas * (double) operadores);
    }
    public static void main(String[] args) {
        
        int produtosA = 1200;
        int horasA = 8;
        double eficienciaA = calcularEficiencia(produtosA, horasA);
        System.out.printf("Eficiência (produtos/hora): %.2f (produtos=%d, horas=%d)%n",
                          eficienciaA, produtosA, horasA);

        int produtosB = 1200;
        int horasB = 8;
        int operadoresB = 4;
        double eficienciaB = calcularEficiencia(produtosB, horasB, operadoresB);
        System.out.printf("Eficiência (produtos/hora/operador): %.2f (produtos=%d, horas=%d, operadores=%d)%n",
                          eficienciaB, produtosB, horasB, operadoresB);

        System.out.println("\nTestes de borda:");
        System.out.println("Horas = 0 -> " + calcularEficiencia(100, 0));
        System.out.println("Operadores = 0 -> " + calcularEficiencia(100, 8, 0));
    }

}
