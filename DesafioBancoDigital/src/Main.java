
public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		Banco banco = new Banco();
		banco.setNome("Banco");
		
		Conta cc = new ContaCorrente(venilton , banco);
		Conta poupanca = new ContaPoupanca(venilton , banco);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();

		banco.listarContas();

	}

}
