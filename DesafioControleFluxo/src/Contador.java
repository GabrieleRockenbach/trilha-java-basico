import java.util.Scanner;

public class Contador {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Digite o primeiro parâmetro");
		int parametroUm = terminal.nextInt();
		System.out.println("Digite o segundo parâmetro");
		int parametroDois = terminal.nextInt();
		terminal.close();
         
		try {
			contar(parametroUm, parametroDois);
		
		}catch (ParametrosInvalidosException e) {
            System.out.println("O segundo parâmetro deve ser maior que o primeiro.");
		}
		
	}

	static void contar(int parametroUm, int parametroDois ) throws ParametrosInvalidosException {
		if (parametroDois < parametroUm) {
            throw new ParametrosInvalidosException();
        }
		int contagem = parametroDois - parametroUm;
        int[] resultado = new int[contagem];
        for (int i = contagem; i>0;  i--){
            resultado[i-1] = i;
        }
        for (int i : resultado) {
            System.out.println("Imprimindo o número: " + i);            
        }
	}
}