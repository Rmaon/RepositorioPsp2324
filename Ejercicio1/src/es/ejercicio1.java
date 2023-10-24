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

            // Usar ProcessBuilder para crear el proceso hijo
            ProcessBuilder pb = new ProcessBuilder(comandoHijo);
            Process procesoHijo = pb.start();

            // Si se debe esperar al proceso hijo
            if (esperar.equals("si")) {
                // Leer la salida del proceso hijo y mostrarla en la consola
                BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                }

                // Esperar a que el proceso hijo termine y mostrar el código de salida
                int exitValue = procesoHijo.waitFor();
                System.out.println("Proceso hijo terminado con código: " + exitValue);
            }
        } catch (Exception e) {
            // Manejar cualquier error que pueda ocurrir al crear o ejecutar el proceso hijo
            System.out.println("Error al ejecutar el proceso hijo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
