package Buscas;

import java.util.ArrayList;

import EstruturadeDados.*;
import Jogos.Jogo;

public class CustoUniforme implements Busca {
	Lista<No<Jogo>> borda = new Lista<No<Jogo>>();
	Arvore<Jogo> arvore = null;
	public No<Jogo> nodeFinal = null;
	
	// Contrutor
	public CustoUniforme(Jogo no) {
		System.out.println("\n#### Busca de Custo Uniforme ####");
		No<Jogo> node = new No<Jogo>(no,null,0);
		borda.insereOrdenado(new No<No<Jogo>>(node, null, null));
		this.arvore = new Arvore<Jogo>(no);
	}
	
	// Método de Solução
	public boolean executar(boolean mostre) {	
		if(borda.getTamanho() == 0) {
			System.out.println("\nFalha na busca!");
			return false;
		}
		
		No<Jogo> node = borda.removeInicio();
		Jogo no = node.getElemento();

		if(mostre)
			no.mostrar();
		
		if(no.testeObjetivo()) {
			this.nodeFinal = node;
			System.out.print("\nEstatísticas da Simulação:");
			System.out.println("\nProfundidade: " + no.getProfundidade());
			return false;
		}
		
		// Acrescenta os nos na borda e na arvore
		ArrayList<Jogo> lista = no.funcaoSucessora(1);
		for (int i = 0; i < lista.size(); i++) {
			No<Jogo> novoNode = arvore.inserirNo(lista.get(i), node);
			No<No<Jogo>> nodeLista = new No<No<Jogo>>(novoNode, null, null);
			nodeLista.setCusto(lista.get(i).getCusto());
			borda.insereOrdenado(nodeLista);
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
