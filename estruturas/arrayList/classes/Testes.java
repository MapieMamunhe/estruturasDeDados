package estruturas.arrayList.classes;

public class Testes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList lista = new ArrayList();
		lista.adicionaInicio("Nando");
		lista.adicionaInicio("Mapie");
		lista.adicionaInicio("Diego");
		lista.adicionaPosicao(2, "Carlos");
		
		System.out.println(lista.contem(-2));
	}

}
