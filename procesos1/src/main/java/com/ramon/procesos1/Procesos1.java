
package com.ramon.procesos1;

import java.util.Arrays;
import java.io.IOException;
//ejemplo creacion procesos
public class Procesos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		ProcessBuilder pb = new ProcessBuilder(args);
		try {
			Process process = pb.start();
                        Thread.sleep(6000);
                        process.destroy();
			int retorno = process.waitFor();
			System.out.println("La ejecucion de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S!!");
			System.exit(-1);
		}catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			System.exit(-1);
		}
	}

}