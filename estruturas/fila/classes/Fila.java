package estruturas.fila.classes;

import estruturas.ListaLigada.classes.ListaLigada;
import estruturas.fila.interfaces.InterfaceFila;

public class Fila implements InterfaceFila {
	private ListaLigada list;
	
	public Fila() {
		list = new ListaLigada();
	}
	public boolean elementoValido(Object elemento) {
		boolean valido = false;
		if(elemento == null) {
			throw new NullPointerException("Parametro nao deve ser nulo");
		}
		return !valido;
	}
	@Override
	public void push(Object elemento) {
		// TODO Auto-generated method stub
		if(this.elementoValido(elemento)) {
			this.list.adicionaFim(elemento);
		}
	}

	@Override
	public void dequeue() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		this.list.removeInicio();
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		return list.pega(0);
	}

	@Override
	public Object peekAndDequeue() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		Object peek = this.peek();
		this.dequeue();
		return peek;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(this.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.list.tamanho();
	}
	@Override
	public String toString() {
		return this.list.toString();
	}
	

}
