package estruturas.ListaLigada.classes;

import estruturas.ListaLigada.Interfaces.InterfaceListaLigada;

public class ListaLigada implements InterfaceListaLigada {
	private class No{
		private No anterior;
		private Object elemento;
		private No proximo;
		public No getProximo() {
			return proximo;
		}
		public void setProximo(No proximo) {
			this.proximo = proximo;
		}
		public No getAnterior() {
			return anterior;
		}
		public void setAnterior(No anterior) {
			this.anterior = anterior;
		}
		public Object getElemento() {
			return elemento;
		}
		public void setElemento(Object elemento) {
			this.elemento = elemento;
		}
		public No(No anterior, Object elemento, No proximo) {
			super();
			this.anterior = anterior;
			this.elemento = elemento;
			this.proximo = proximo;
		}
		public No(Object elemento, No proximo) {
			super();
			this.elemento = elemento;
			this.proximo = proximo;
		}
		public No(No anterior, Object elemento) {
			super();
			this.anterior = anterior;
			this.elemento = elemento;
		}
		public No(Object elemento) {
			super();
			this.elemento = elemento;
		}
		
		
	}
	private No primeiro, ultimo;
	private int totElementos;
	private boolean posicaoValida(int posicao) {
		boolean valido = false;
		if((posicao < 0) || (posicao > this.totElementos)) {
			throw new IndexOutOfBoundsException("Posicao Invalida");
		}
		return !valido;
	}
	public boolean elementoValido(Object elemento) {
		boolean valido = false;
		if(elemento == null) {
			throw new NullPointerException("Parametro nao deve ser nulo");
		}
		return !valido;
	}
	private No pegaNo(int posicao) {
		No actual = primeiro;
		if(this.posicaoValida(posicao)) {
			for(int i = 0; i < posicao-1; i++) {
				actual = actual.getProximo();
			}
		}
		return actual;
	}
	public ListaLigada() {
		this.totElementos = 0;
	}
	@Override
	public void adicionaInicio(Object elemento) {
		// TODO Auto-generated method stub
		if(this.elementoValido(elemento)) {
			if(this.eVazio()) {
				No novo = new No(elemento);
				primeiro = novo;
				ultimo = primeiro;
			}else {
				No novo = new No(elemento, primeiro);
				primeiro.setAnterior(novo);
				primeiro = novo;
			}
			this.totElementos++;
		}

	}

	@Override
	public void adicionaPosicao(int posicao, Object elemento) {
		// TODO Auto-generated method stub
		if(this.posicaoValida(posicao)) {
			if(this.elementoValido(elemento)) {
				if(posicao == 0) {
					this.adicionaInicio(elemento);
				}else {
					if(posicao==this.totElementos) {
						this.adicionaFim(elemento);
					}else {
						No anterior = this.pegaNo(posicao);
						No proximo = anterior.getProximo();
						No actual = new No(anterior, elemento, proximo);
						proximo.setAnterior(actual);
						anterior.setProximo(actual);
						this.totElementos++;
					}
				}
			}
		}

	}

	@Override
	public void adicionaFim(Object elemento) {
		// TODO Auto-generated method stub
		if(this.elementoValido(elemento)) {
			if(this.eVazio()){
				this.adicionaInicio(elemento);
			}else {
				No novo = new No(elemento);
				novo.setAnterior(ultimo);
				ultimo.setProximo(novo);
				ultimo = novo;
				this.totElementos++;
			}
		}

	}

	@Override
	public void removeInicio() {
		// TODO Auto-generated method stub
		if(this.eVazio()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		No segundo = primeiro.getProximo();
		primeiro = segundo;
		this.totElementos--;

	}

	@Override
	public void removePosicao(int posicao) {
		// TODO Auto-generated method stub
		if(this.eVazio()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		if(this.posicaoValida(posicao)) {
			if(posicao == 0) {
				this.removeInicio();
			}else {
				if(posicao == this.totElementos) {
					this.removeFim();
				}else {
					No anterior = this.pegaNo(posicao);
					No actual = anterior.getProximo();//A remover
					No proximo = actual.getProximo();
					anterior.setProximo(proximo);
					proximo.setAnterior(anterior);
					this.totElementos--;
				}
			}
		}
	}

	@Override
	public void removeFim() {
		// TODO Auto-generated method stub
		if(this.eVazio()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		No penultimo = ultimo.getAnterior();
		ultimo = penultimo;
		this.totElementos--;

	}

	@Override
	public boolean contem(Object elemento) {
		// TODO Auto-generated method stub
		if(this.eVazio()) {
			throw new IllegalArgumentException("Estrutura vazia");
		}
		No actual = primeiro;
		for(int i = 0; i < this.totElementos; i++) {
			if(actual.getElemento().equals(elemento)) {
				return true;
			}
			actual = actual.getProximo();
		}
		return false;
	}

	@Override
	public boolean contem(int posicao) {
		// TODO Auto-generated method stub
		if((posicao < 0) || (posicao > this.totElementos)) {
			return false;
		}
		return true;
	}

	@Override
	public int tamanho() {
		// TODO Auto-generated method stub
		return this.totElementos;
	}

	@Override
	public boolean eVazio() {
		// TODO Auto-generated method stub
		if(this.totElementos == 0) {
			return true;
		}
		return false;
	}
	public Object pega(int posicao) {
		No novo = this.pegaNo(posicao);
		return novo.getElemento();
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		No actual=primeiro;
		for(int i = 0; i < this.totElementos-1; i++) {
			s.append(actual.getElemento());
			s.append(", ");
			actual = actual.getProximo();
		}
		s.append(actual.getElemento());
		s.append("]");
		return s.toString();
	}
	

}
