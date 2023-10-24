package ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Esta clase representa el proceso padre (PP) que se encarga de solicitar una fecha al usuario, verificar el formato y calcular los días restantes hasta esa fecha.
 */
public class PP {
    public static void main(String[] args) {
        boolean formatoCorrecto = false;
        
        while (!formatoCorrecto) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Introduce una fecha en formato dd/mm/yyyy: ");
                String fechaUsuario = reader.readLine();

                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoFecha.setLenient(false);

                try {
                    formatoFecha.parse(fechaUsuario);
                    formatoCorrecto = true; 
                } catch (ParseException e) {
                    System.out.println("Formato de fecha incorrecto. Debe ser dd/mm/yyyy.");
                }

                if (formatoCorrecto) {
                    // Crear el proceso hijo para calcular la diferencia de días
                    ProcessBuilder pb = new ProcessBuilder("java", "PH", fechaUsuario);
                    Process procesoHijo = pb.start();

                    // Leer el resultado del proceso hijo
                    BufferedReader br = new BufferedReader(new InputStreamReader(procesoHijo.getInputStream()));
                    String resultado = br.readLine();

                    if (resultado != null && !resultado.isEmpty()) {
                        int diasRestantes = Integer.parseInt(resultado);
                        if (diasRestantes == 0) {
                            System.out.println("¡Es el día de las prácticas!");
                        } else {
                            System.out.println("Días restantes hasta las prácticas: " + diasRestantes);
                        }
                    } else {
                        System.out.println("No se pudo calcular la cantidad de días restantes.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
