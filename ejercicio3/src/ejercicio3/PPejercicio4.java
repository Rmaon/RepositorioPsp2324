package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase representa el proceso padre (PP) que ejecuta comandos en el sistema operativo y muestra la salida estándar.
 */
public class PPejercicio4 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: PPejercicio4 <comando>");
            System.exit(1);
        }

        String comando = args[0];

        try {
            // Construir el comando completo para ejecutar en el sistema operativo
            String comandoCompleto = "cmd /c " + comando; // Para sistemas Windows
            // String comandoCompleto = "bash -c " + comando; // Para sistemas Unix/Linux

            // Ejecutar el comando en el sistema operativo
            Process proceso = Runtime.getRuntime().exec(comandoCompleto);

            // Leer la salida estándar del proceso
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            System.out.println("Resultado:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
