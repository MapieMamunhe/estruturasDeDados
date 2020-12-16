package estruturas.fila.classes;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fila fila = new Fila();
		fila.push("Mapie");
		fila.push("Carlos");
		fila.push("Nair");
		Object obj = fila.peekAndDequeue();
		System.out.println(fila.size());
	}

}
