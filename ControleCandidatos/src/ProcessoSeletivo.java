import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.text.DecimalFormat;
import java.util.TreeMap;

public class ProcessoSeletivo {

    private static double salarioBase = 2000.0;
    public static void main(String[] args) throws Exception {
        System.out.println("Processo Seletivo");

        String [] candidatos = {"FELIPE","MÁRCIA","JULIA","PAULO","AUGUSTO","MÔNICA","FABRÍCIO","MIRELA","DANIELA","JORGE"};

        ligarCandidato(selecaoCandidatos(candidatos));
    }

    static double valorPretendido() {
        DecimalFormat df = new DecimalFormat("#.##");
        double valorPretendido = Double.parseDouble(df.format(ThreadLocalRandom.current().nextDouble(1800, 2200)).replace(",", "."));
        return valorPretendido;
   }

    static ArrayList<String> selecaoCandidatos(String [] candidatos){

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        Map<String , Double> candidatosAprovados = new HashMap<>();
        ArrayList<String> listaCandidatosAproados = new ArrayList<>();

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            if (salarioBase >= salarioPretendido) {
                candidatosAprovados.put(candidato , salarioPretendido);
                listaCandidatosAproados.add(candidato);
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        imprimirAprovados(candidatosAprovados);
        return listaCandidatosAproados;
    }

    static void imprimirAprovados(Map<String , Double> candidatosAprovados) {
        Map<String , Double> candidatosAprovadosOrdenados = new TreeMap<>(candidatosAprovados);
        System.out.println("Os candidatos aprovados para vaga foram:");
        for(Map.Entry<String , Double> candidatoAprovado : candidatosAprovadosOrdenados.entrySet()) {
            System.out.println(candidatoAprovado.getKey() + "   //   Salário pedido: R$ " +  candidatoAprovado.getValue());
        }
    }

    static boolean atender() {
		return new Random().nextInt(3)==1;	
	}

    static void ligarCandidato(ArrayList<String> candidatosSelecionados) {
		for (String candidatoSelecionado : candidatosSelecionados) {
                
            int tentativasRealizadas = 1;
            boolean continuarTentando = true;
            boolean atendeu=false;
            do {
                atendeu= atender();
                continuarTentando = !atendeu;
                if(continuarTentando)
                    tentativasRealizadas++;
                else
                    System.out.println("CONTATO REALIZADO COM SUCESSO!");
                
            }while(continuarTentando && tentativasRealizadas<3);
            
            if(atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidatoSelecionado +" NA " + tentativasRealizadas + "ª TENTATIVA.");
            else
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidatoSelecionado +", NÚMERO MAXIMO TENTATIVAS: " + tentativasRealizadas + " REALIZADA(S)");
    	}
    }
}