
package ejerciciooscarmestre;

import java.io.*;

public class Lanzador {
    public void lanzarSumador(Integer n1, Integer n2){
        String clase="Sumador";
        ProcessBuilder pb;
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

            File log = new File("resultados.txt"); 
            pb.redirectOutput(log); // Redireccionar la salida estándar al archivo
            pb.redirectErrorStream(true); // Redireccionar la salida de error a la salida estándar
            
            Process process = pb.start();

            // Espera a que el proceso termine
            int exitCode = process.waitFor();
            System.out.println("Proceso terminado con código: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        Lanzador l=new Lanzador();
        l.lanzarSumador(1, 51);
        l.lanzarSumador(51, 100);
        System.out.println("Ok");
    }
}