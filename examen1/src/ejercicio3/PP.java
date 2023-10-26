package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Autor RAMON CAMINERO ARROYO
 */
public class PP {
    public static void main(String[] args) throws IOException {
    	
    	String entrada=null;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    	String rutaPH = "PH";
    	do {
    		
    		entrada = reader.readLine().trim();
    		
    		//Creamos el proceso con la ruta del proceso hijo y se le pasa la palabra escrita
			ProcessBuilder pb = new ProcessBuilder("java", rutaPH, entrada);
            Process procesoHijo = pb.start();
            //buffered reader que recoge la salida standar del proceso hijo
            BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String linea = br.readLine();
            
            //comprobamos que no sea null e imprimimos por consola el numero generado, en caso de que sea null, no se imprime nada
            //Así en el caso de que introduzca fin simplemente terminará el programa
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("");
			
		} while (entrada.equalsIgnoreCase("fin"));
    }
}
