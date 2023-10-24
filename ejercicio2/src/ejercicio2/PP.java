package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase representa el proceso padre (PP) que se encarga de crear y ejecutar el proceso hijo (PH).
 */
public class PP {
    public static void main(String[] args) {
        try {
            String rutaPH = "PH"; 
            
            // Utilizar BufferedReader para leer desde la entrada estándar
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("N: ");
            String nStr = reader.readLine();
            System.out.print("M: ");
            String mStr = reader.readLine();

            // Crear el proceso hijo utilizando ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder("java", rutaPH, nStr, mStr);
            Process procesoHijo = pb.start();

            // Redirigir la salida estándar del proceso hijo al proceso padre
            BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
            String linea;
            System.out.println("Resultados:");

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
