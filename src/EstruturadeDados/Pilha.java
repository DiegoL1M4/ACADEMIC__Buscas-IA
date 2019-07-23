package EstruturadeDados;


public class Pilha<tipo> {
	private No<tipo> topo;
	private int tamanho;
	
	public Pilha() {
		topo = null;
		tamanho = 0;
	}
	
	public void insere(tipo elemento) {
		if(topo == null) {
			topo = new No<tipo>(elemento, null);
		} else {
			No<tipo> aux = topo;
			topo = new No<tipo>(elemento,aux);
		}
		tamanho++;
	}
	
	public tipo remove() {
		if(topo == null)
			return null;
		
		No<tipo> aux = topo;
		
		topo = topo.getProximo();
		
		aux.setProximo(null);
		tamanho--;
		
		return aux.getElemento();
	}
	
	public void mostrarPilha() {
		recursaoMostraPilha(topo);
		System.out.println();
	}
	
	public int recursaoMostraPilha(No<tipo> no) {
		if (no == null)
			return 0;
		recursaoMostraPilha(no.getProximo());
		System.out.print(no.getElemento() + "\t");
		return 1;
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
}
