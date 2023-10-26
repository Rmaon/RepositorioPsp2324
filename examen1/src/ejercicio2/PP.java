package ejercicio2;

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
    		String rutaPH = "PH";//Ruta del proceso hijo
    		String rutaPH2 = "PH2";//Ruta del proceso hijo 2
    		//if que comprueba que estemos dentro de los margenes posibles
        	if(!(args.length<2 | args.length>10)) {
        		//Informacion para que el usuario sepa que se han mandado bien los argumentos
        		System.out.println("Introducidos " + args.length + " argumentos");
        		int[] lista = new int[args.length];
        		
        		for(int i = 0; i<args.length;i++) {
            		//For que recorre los argumentos introducidos
        			lista[i]=Integer.parseInt(args[i]);
        			//parse a integer y se le muestra al usuario
        			System.out.print(args[i] +" ");
        			//Creamos el proceso con la ruta del proceso hijo y se le pasa el numero ha probar
        			ProcessBuilder pb = new ProcessBuilder("java", rutaPH, args[i]);
                    Process procesoHijo = pb.start();
                    
                    //buffered reader que recoge la salida standar del proceso hijo
                    BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
                    String linea = br.readLine();
                    
                    //comprobamos que no sea null y mandamos el resultado del proceso hijo al proceso hijo 2 que creamos para recoger su salida standar
                    while ((linea = br.readLine()) != null) {
                    	System.out.println(linea);
                        if(linea.equals("si")) {
                        	nPrimos++;
                        }                    
                    }
                    System.out.println("");
                    
        		}
        		//Creamos el proceso del hijo 2 mandandole por parametro el numero de primos que hay y recoger por la entrada standar la frase correspondiente
        		ProcessBuilder pb2 = new ProcessBuilder("java", rutaPH2, Integer.toString(nPrimos));
                Process procesoHijo2 = pb2.start();
                
                BufferedReader br2 = new BufferedReader(new InputStreamReader(procesoHijo2.getInputStream()));
                String linea2 = br2.readLine();
                
                System.out.println(linea2);
        	}else {
        		System.out.println("Introduce entre 2 y 10 numeros por argumento por favor");
        	}
    	}catch (IOException e) {
            e.printStackTrace();
        }
    	
    	
    }
	
}
