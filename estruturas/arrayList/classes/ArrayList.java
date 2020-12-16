package estruturas.arrayList.classes;

import estruturas.arrayList.interfaces.InterfaceArrayList;

public class ArrayList implements InterfaceArrayList {
	private int totElementos;
	private Object []lista;
	public ArrayList() {
		this.lista = new Object[100];
		this.totElementos = 0;
	}
	private void garantirEspaco() {
		if(this.tamanho() == this.lista.length) {
			Object novaLista[] = new Object [this.lista.length*2];
			for(int i = 0; i < this.totElementos-1; i++) {
				novaLista[i] = this.lista[i];
			}
			this.lista = novaLista;
		}
	}
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
	
	@Override
	public void adicionaInicio(Object elemento) {
		// TODO Auto-generated method stub
		if(this.elementoValido(elemento)) {
			this.garantirEspaco();
			if(this.totElementos == 0) {
				this.lista[0] = elemento;
			}else {
				for(int i = this.tamanho(); i > 0; i--) {
					this.lista [i] = this.lista[i-1];
				}
				this.lista [0] = elemento;
			}
			this.totElementos++;
		}

	}

	@Override
	public void adicionaPosicao(int posicao, Object elemento) {
		// TODO Auto-generated method stub
		if(this.elementoValido(elemento)) {
			this.garantirEspaco();
			if(this.posicaoValida(posicao)) {
				if(posicao == 0) {
					this.adicionaInicio(elemento);
				}else {
					if(posicao == this.totElementos) {
						this.adicionaFim(elemento);
					}else {
						for(int i = this.totElementos; i > posicao; i--) {
							this.lista[i] = this.lista[i-1];
						}
						this.lista[posicao] = elemento;
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
			this.garantirEspaco();
			if(this.tamanho() == 0) {
				this.adicionaInicio(elemento);
			}else {
				this.lista [this.totElementos] = elemento;
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
		for(int i = 0; i < this.totElementos-1; i++) {
			this.lista[i] = lista [i+1];
		}
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
					for(int i = posicao; i < this.totElementos-1; i++) {
						this.lista[i]=this.lista[i+1];
					}
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
		this.lista[this.totElementos-1] = null;
		this.totElementos--;

	}

	@Override
	public boolean contem(Object elemento) {
		// TODO Auto-generated method stub
		boolean resposta = false;
		if(this.elementoValido(elemento)) {
			Object obj;
			for(int i = 0; i< this.totElementos-1; i++) {
				obj = this.lista[i];
				if(obj.equals(elemento)) {
					resposta = true;
					return resposta;
				}
			}
		}
		return resposta;
	}

	@Override
	public boolean contem(int posicao) {
		// TODO Auto-generated method stub
		if((posicao < 0)  || (posicao > this.totElementos)) {
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
		if(this.tamanho() == 0) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for(int i = 0; i < this.totElementos-1; i++) {
			s.append(this.lista[i]);
			s.append(", ");
		}
		s.append(this.lista[this.totElementos-1]);
		s.append("]");
		return s.toString();
	}
	

}
