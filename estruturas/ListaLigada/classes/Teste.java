package estruturas.ListaLigada.classes;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListaLigada lista = new ListaLigada();
		lista.adicionaFim("Nando");
		lista.adicionaFim("Mapie");
		lista.adicionaFim("Diego");
		lista.adicionaPosicao(1, "Carlos");
		System.out.println(lista.contem("Manuel"));

	}

}
