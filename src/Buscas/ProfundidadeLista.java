package Buscas;

import java.util.ArrayList;
import EstruturadeDados.*;
import Jogos.Jogo;

public class ProfundidadeLista implements Busca {
	Pilha<No<Jogo>> borda = new Pilha<No<Jogo>>();
	Arvore<Jogo> arvore = null;
	public No<Jogo> nodeFinal = null;
	
	// Contrutor
	public ProfundidadeLista(Jogo no) {
		System.out.println("\n#### Busca em Profundidade com Lista de Visitados ####");
		No<Jogo> node = new No<Jogo>(no,null,0);
		borda.insere(node);
		this.arvore = new Arvore<Jogo>(no);
	}
	
	// Método de Solução
	public boolean executar(boolean mostre) {	
		if(borda.getTamanho() == 0) {
			System.out.println("\nFalha na busca!");
			return false;
		}
		
		No<Jogo> node = borda.remove();
		Jogo no = node.getElemento();

		if(mostre)
			no.mostrar();
		
		if(no.testeObjetivo()) {
			this.nodeFinal = node;
			System.out.println("\nEstatísticas da Simulação:");
			System.out.println("Profundidade: " + no.getProfundidade());
			return false;
		}
		
		// Acrescenta os nos na borda e na arvore
		ArrayList<Jogo> lista = no.funcaoSucessora(2);
		for (int i = 0; i < lista.size(); i++) {
			No<Jogo> novoNode = arvore.inserirNo(lista.get(i), node);
			borda.insere(novoNode);
		}
		
		return true;
	}
	
	public void resposta() {
		ArrayList<Jogo> resposta = new ArrayList<Jogo>();
		No<Jogo> node = nodeFinal;
		
		if(node != null) {
			System.out.println("Custo total: " + node.getElemento().getCusto());
			
			while(node != null) {
				resposta.add(node.getElemento());
				node = node.getPai();
			}
			
			System.out.print("\nSequência de Ações:");
			for (int i = resposta.size() - 1; 0 <= i ; i--)
				resposta.get(i).mostrar();
		}
	}
	
}
