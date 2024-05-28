import java.util.Scanner;
import java.util.Locale;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

         Scanner scanner = new Scanner(System.in).useLocale(new Locale("pt" , "BR"));

         System.out.println("Por favor, digite seu nome:");
         String nomeCliente = scanner.next().concat(" " + scanner.next());

         System.out.println("Por favor, digite sua agência:");
         String agenciaCliente = scanner.next();

         System.out.println("Por favor, digite sua conta:");
         int contaCliente = scanner.nextInt();

         System.out.println("Por favor, digite seu saldo:");
         double saldoCliente = scanner.nextDouble();

         scanner.close();

         System.out.println("Olá " + nomeCliente + ", obrigada por criar uma conta em nosso banco, sua agência é " + agenciaCliente + ", conta " + contaCliente + " e seu saldo R$ " + saldoCliente + " já está disponível para saque.");
    }
}
