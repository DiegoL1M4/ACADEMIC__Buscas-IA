package EstruturadeDados;


public class Fila<tipo> {
	
	private No<tipo> cabeca;
	private int tamanho;
	
	public Fila() {
		cabeca = null;
		tamanho = 0;
	}
	
	public void insere(tipo elemento) {
		if(cabeca == null) {
			cabeca = new No<tipo>(elemento, null);
		} else {
			getCauda().setProximo(new No<tipo>(elemento,null));
		}
		tamanho++;
	}
	
	public No<tipo> getCauda() {
		No<tipo> aux = cabeca;
				
		if(aux == null)
			return null;
		
		while(aux.getProximo() != null) 
			aux = aux.getProximo();
		
		return aux;
		
	}
	
	public tipo remove() {
		if(cabeca == null)
			return null;
		
		No<tipo> aux = cabeca;
		
		cabeca = cabeca.getProximo();
		
		aux.setProximo(null);
		tamanho--;
		
		return aux.getElemento();
	}
	
	public void mostrarFila() {
		No<tipo> aux = cabeca;
		
		if(aux == null)
			System.out.println("Lista Vazia!");
		
		while(aux != null) {
			System.out.print(aux.getElemento() + "\t");
			aux = aux.getProximo();
		}
		
		System.out.println();
	}
	
	public int getTamanho() {
		return this.tamanho;
	}
	
}
