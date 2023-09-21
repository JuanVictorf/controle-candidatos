package candidatura;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
	public static void main(String[] args) {
		System.out.println("Processo seletivo");
		String [] candidatos = {"FELIPE", "JUAN", "JOÃO", "PAULO", "HENRIQUE"};
		
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
		
	}
	
	static void entrandoEmContato(String candidato) {
		int tentativasRealizadas = 1;
		boolean continuarTentando = true;
		boolean atendeu = false;
		do {
			atendeu = atender();
			continuarTentando = !atendeu;
			if(continuarTentando) {
				tentativasRealizadas++;
			}else {
				System.out.println("Contato realizado com sucesso");
			}
		} while (continuarTentando && tentativasRealizadas < 3);
		
		if(atendeu) {
			System.out.println("Conseguimos contato com " + candidato + " Na " + tentativasRealizadas + " tentativa");
		}else {
			System.out.println("NÃO conseguimos contato com o " + candidato + " número máximo de  tentativa: " + tentativasRealizadas);
		}
	}
	
	static boolean atender() {
		return new Random().nextInt(3)==1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE", "JUAN", "JOÃO", "PAULO", "HENRIQUE"};
		System.out.println("Imprimindo lista de candidatos informando o indice do elemento");
		for(int i = 0; i < candidatos.length; i++) {
			System.out.println("O candidato de número " + (i+1) + " é: " + candidatos[i]);
		}
		
		System.out.println("Forma abreviada usando for each: ");
		for(String candidato: candidatos) {
			System.out.println("O candidato selecionado foi: " + candidato);
		}
	}
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE", "JUAN", "JOÃO", "PAULO", "HENRIQUE", "CESAR", "MARIANA", "MARIA", "JOANA", "CARLA"};
		
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 2000.0;
		
		while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
				candidatosSelecionados++;
			}
			candidatosAtual++;
		}
	}
	
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	
	static void analisarCandidato(double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido) {
			System.out.println("Ligar para o candidato");
		}else if(salarioBase == salarioPretendido) {
			System.out.println("Ligar para o candidato com contraproposta");
		}else {
			System.out.println("Aguardando resultado dos demais candidatos");
		}
	}
	
}
