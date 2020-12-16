package estruturas.ListaLigada.Interfaces;

public interface InterfaceListaLigada {
	public void adicionaInicio(Object elemento);
	public void adicionaPosicao(int posicao, Object elemento);
	public void adicionaFim(Object elemento);
	public void removeInicio();
	public void removePosicao(int posicao);
	public void removeFim();
	public boolean contem(Object elemento);
	public boolean contem(int posicao);
	public int tamanho();
	public boolean eVazio();
}
