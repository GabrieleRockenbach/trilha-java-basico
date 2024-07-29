import java.util.ArrayList;
import java.util.List;

public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco() {
		this.contas = new ArrayList<Conta>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void adicionarConta(Conta conta) {
		contas.add(conta);
	}

	public void listarContas() {
		System.out.println(" ");
		System.out.println("===Lista de Contas===");
		for (Conta conta : this.getContas()){
			System.out.println(conta);
		}		
	}
}
