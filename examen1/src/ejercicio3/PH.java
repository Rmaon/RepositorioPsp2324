package ejercicio3;
/**
 * Autor RAMON CAMINERO ARROYO
 */
public class PH {
	//metodo que devolvera por la salida standar un numero si la palabra que recibe por parametro es cualquier cosa menos 10 y que no devolverá nada si es fin
	public static void main(String[] args) {
		//Comprobamos que lo que le pasamos por parametro no sea fin
		if (args[0].equalsIgnoreCase("fin")) {
			
		}else {
			int i = (int) (Math.random()*10);//Como math random genera un numero del 0 al 1 le multiplico por 10 para que de un numero aleatorio del 0 al 10
			System.out.println(i);
		}

	}

}
