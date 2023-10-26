package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Autor RAMON CAMINERO ARROYO
 */
public class PP {
    public static void main(String[] args) {
    	
    	int nPrimos=0;
    	//Try que comprueba que no haya ningún error
    	try {
    		String rutaPH = "PH"; //Ruta del proceso hijo
        	//if que comprueba que estemos dentro de los margenes posibles
        	if(!(args.length<2 | args.length>10)) {
        		//Informacion para que el usuario sepa que se han mandado bien los argumentos
        		System.out.println("Introducidos " + args.length + " argumentos");
        		
        		int[] lista = new int[args.length];
        		//For que recorre los argumentos introducidos
        		for(int i = 0; i<args.length;i++) {
        			//parse a integer y se le muestra al usuario
        			lista[i]=Integer.parseInt(args[i]);
        			System.out.print(args[i] +" ");
        			//Creamos el proceso con la ruta del proceso hijo y se le pasa el numero ha probar
        			ProcessBuilder pb = new ProcessBuilder("java", rutaPH, args[i]);
                    Process procesoHijo = pb.start();
                    //buffered reader que recoge la salida standar del proceso hijo
                    BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
                    String linea = br.readLine();
                    //comprobamos que no sea null e imprimimos por consola el si o no recogido de la salida standar del proceso hijo
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                        if(linea.equals("si")) {
                        	nPrimos++;
                        }
                    }
                    System.out.println("");
                    
        		}
        		//comprobamos que el numero de primos, que hemos estado sumando con cada si, que hay no sea impar e imprimimos los mensajes
        		if (nPrimos%2==0) {
					System.out.println("PARiendo primos");
				}else {
					System.out.println("sIMPARticos primos tengo");
				}
        		
        	}else {
        		System.out.println("Introduce entre 2 y 10 numeros por argumento por favor");
        	}
    	}catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    }
	
}
