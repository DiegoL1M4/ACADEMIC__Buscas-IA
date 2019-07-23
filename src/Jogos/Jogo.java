package Jogos;

import java.util.ArrayList;

public interface Jogo {
	public ArrayList<Jogo> funcaoSucessora(int op);
	public boolean testeObjetivo();
	public int funcaoCusto(int a, int b);
	
	public void mostrar();
	public int getProfundidade();
	public int getCusto();
}
