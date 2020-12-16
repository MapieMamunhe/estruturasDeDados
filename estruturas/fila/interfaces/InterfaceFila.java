package estruturas.fila.interfaces;

public interface InterfaceFila {
	public void push(Object elemento);
	public void dequeue();
	public Object peek();
	public Object peekAndDequeue();
	public boolean isEmpty();
	public int size();
}
