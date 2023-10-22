package es;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejercicio1 {

	public static void main(String[] args) {
		// Verificar que al menos hay dos argumentos (el comando y "si" o "no")
		if (args.length < 2) {
			System.out.println("Uso: java CreadorDeProcesos <comando> [argumentos]... <si|no>");
			System.exit(1);
		}

		// Obtener si el proceso padre debe esperar al hijo
		String esperar = args[args.length - 1];
		if (!esperar.equals("si") && !esperar.equals("no")) {
			System.out.println("El último argumento debe ser 'si' o 'no'.");
			System.exit(1);
		}

		// Crear el proceso hijo
		try {
			// Construir el comando para el proceso hijo
			String[] comandoHijo = new String[args.length - 1];
			System.arraycopy(args, 0, comandoHijo, 0, args.length - 1);

			ProcessBuilder pb = new ProcessBuilder(comandoHijo);
			Process procesoHijo = pb.start();

			// Si se debe esperar al proceso hijo
			if (esperar.equals("si")) {
				BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
				String linea;
				while ((linea = br.readLine()) != null) {
					System.out.println(linea);
				}
				int exitValue = procesoHijo.waitFor();
				System.out.println("Proceso hijo terminado con código: " + exitValue);
			}
		} catch (Exception e) {
			System.out.println("Error al ejecutar el proceso hijo: " + e.getMessage());
			e.printStackTrace();
		}
	}
}