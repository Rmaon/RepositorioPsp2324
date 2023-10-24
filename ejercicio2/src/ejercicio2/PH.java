package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Esta clase representa el proceso hijo (PH) que calcula y muestra números primos en un rango especificado.
 */
public class PH {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Debes proporcionar los valores de N y M como argumentos.");
            return;
        }

        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        System.out.println("N: " + n);
        System.out.println("M: " + m);
        System.out.println("Números primos entre N y M:");

        for (int i = n; i <= m; i++) {
            if (esPrimo(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * Verifica si un número dado es primo.
     *
     * @param numero El número a verificar.
     * @return {@code true} si el número es primo, {@code false} en caso contrario.
     */
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
