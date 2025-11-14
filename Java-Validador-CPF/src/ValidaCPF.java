public class ValidaCPF {

    public static boolean isCPF(String cpf) {
        if (cpf == null) return false;

        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11) return false;
        if (cpf.matches("(\\d)\\1{10}")) return false;

        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = cpf.charAt(i) - '0';
                sm += num * peso;
                peso--;
            }
            r = 11 - (sm % 11);
            if (r == 10 || r == 11) dig10 = '0';
            else dig10 = (char) (r + '0');

            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = cpf.charAt(i) - '0';
                sm += num * peso;
                peso--;
            }
            r = 11 - (sm % 11);
            if (r == 10 || r == 11) dig11 = '0';
            else dig11 = (char) (r + '0');

            return (dig10 == cpf.charAt(9) && dig11 == cpf.charAt(10));

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return false;
        }
    }
}
