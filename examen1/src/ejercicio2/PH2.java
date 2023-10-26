package ejercicio2;
/**
 * Autor RAMON CAMINERO ARROYO
 */
public class PH2 {
	//Comprueba el numero de si que hay si el numero pasado por parametro es par devuelve la primera opcion
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if (n % 2 == 0) {
			System.out.println("PARiendo primos");
		}else{
			System.out.println("sIMPARticos primos tengo");
		}
	}

}
