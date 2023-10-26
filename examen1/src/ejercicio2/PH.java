package ejercicio2;
/**
 * Autor RAMON CAMINERO ARROYO
 */
public class PH {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		if(esPrimo(n)) {
			System.out.println("si");
		}else {
			System.out.println("no");
		}
	}
	//metodo que devuelve false en el caso de no ser primo
	public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
