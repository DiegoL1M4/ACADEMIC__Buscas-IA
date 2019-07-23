package Jogos;

import java.util.Scanner;
import Buscas.*;

public class ExecucaoMain {

	private static Scanner in;

	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		Jogo jogoSel = null;
		Busca solucao = null;
		
		System.out.println("######### Trabalho de IA #########\n");
		System.out.println("1 - Oito Peças");
		System.out.println("2 - Oita Rainhas");
		System.out.print("Escolha o jogo: ");
		int jogo = in.nextInt();
		
		while(true) {
			System.out.println("\n###### Opções de Busca ######");
			System.out.println("1 - Profundidade");
			System.out.println("2 - Profundidade com Lista");
			System.out.println("3 - Largura");
			System.out.println("4 - Profundidade Limitada");
			System.out.println("5 - Aprofundamento Iterativo");
			System.out.println("6 - Custo Uniforme");
			System.out.print("Escolha a busca: ");
			int busca = in.nextInt();
			System.out.println();
					
			switch(jogo) {
			case 1:
				int[] t = {3,1,2,4,7,5,6,8,0};
				//int[] t = {1,0,2,3,4,5,6,7,8};
				jogoSel = new OitoPecas(t);
				System.out.println("##### Jogo das Oito Peças #####");
				System.out.print("\nProblema:");
				jogoSel.mostrar();
				break;
			case 2:
				jogoSel = new OitoRainhas();
				System.out.print("##### Jogo das Oito Rainhas #####");
				jogoSel.mostrar();
				break;
			}
			
			switch(busca) {
			case 1:
				solucao = new Profundidade(jogoSel);
				break;
			case 2:
				solucao = new ProfundidadeLista(jogoSel);
				break;
			case 3:
				solucao = new Largura(jogoSel);
				break;
			case 4:
				System.out.print("Escolha o limite de profundidade: ");
				int limite = in.nextInt();
				solucao = new ProfundidadeLimitada(jogoSel,limite);
				break;
			case 5:
				solucao = new AprofIterativo(jogoSel);
				break;
			case 6:
				solucao = new CustoUniforme(jogoSel);
				break;
			}
			
			
			// Execução da Solução
			long inicio = System.currentTimeMillis();  
			int cont = 0;
			while(solucao.executar(false)) {
				cont++;
			}
			long fim  = System.currentTimeMillis();
			
			System.out.println("Tempo de execução: " + (fim-inicio)/1000.0 + " segundos");
			System.out.println("Passos: " + cont);
			
			solucao.resposta();
			
			
			
			
			/*
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			solucao.executar(true);
			*/
		}
		
	}

}
