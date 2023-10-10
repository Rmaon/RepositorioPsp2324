
package com.ramon.procesos1;

import java.util.Arrays;
import java.io.IOException;
//ejemplo creacion procesos
public class Procesos2 {
        
    

	public static void main(String[] args) {
            final String PROGRAMA = "code";
		// TODO Auto-generated method stub
		if (PROGRAMA.length() <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(PROGRAMA);
		try {
			Process process = pb.start();
                        Thread.sleep(6000);
                        process.destroy();
			int retorno = process.waitFor();
			System.out.println("La ejecucion de code devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);
		}
	}

}