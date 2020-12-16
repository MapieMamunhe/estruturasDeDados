package estruturas.pilha.classes;

import estruturas.ListaLigada.classes.ListaLigada;
import estruturas.pilha.interfaces.InterfacePilha;

public class Pilha implements InterfacePilha {
	private ListaLigada list;
	public Pilha() {
		this.list = new ListaLigada();
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
	public void pop() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		this.list.removeFim();

	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		return this.list.pega(this.size());
	}

	@Override
	public Object peekAndPop() {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		Object peek = this.peek();
		this.pop();
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

}
