public class App {
    public static void main(String[] args) throws Exception {
        
        Transacao t1 = new TransacaoCartao(4500.00);
        Transacao t2 = new TransacaoPix(12000.00);
        Transacao t3 = new TransacaoTed(30000.00);

        System.out.println("Cartão");
        t1.processar();
        System.out.println("Status: " + t1.getStatus());

        System.out.println("Pix");
        t2.processar();
        System.out.println("Status: " + t2.getStatus());

        System.out.println("Ted");
        t3.processar();
        System.out.println("Status: " + t3.getStatus());

    }
}
