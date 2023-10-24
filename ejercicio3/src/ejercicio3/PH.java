package ejercicio3;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Esta clase representa el proceso hijo (PH) que calcula la diferencia en días entre una fecha proporcionada y la fecha actual.
 */
public class PH {
    public static void main(String[] args) {
        try {
            String fechaUsuario = args[0];

            Date fechaActual = new Date();

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaUsuarioDate = formato.parse(fechaUsuario);

            long diferenciaEnMilisegundos = fechaUsuarioDate.getTime() - fechaActual.getTime();
            long diferenciaEnDias = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24);

            if (diferenciaEnDias < 0) {
                diferenciaEnDias = 0;
            }

            System.out.println(diferenciaEnDias);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
