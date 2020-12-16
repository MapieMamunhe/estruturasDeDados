package estruturas.pilha.interfaces;

public interface InterfacePilha {
	public void push(Object elemento);
	public void pop();
	public Object peek();
	public Object peekAndPop();
	public boolean isEmpty();
	public int size();
}
