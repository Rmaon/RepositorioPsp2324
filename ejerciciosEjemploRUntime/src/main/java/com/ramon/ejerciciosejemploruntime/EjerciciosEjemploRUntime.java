/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.ramon.ejerciciosejemploruntime;

import java.io.IOException;

/**
 *
 * @author ramon
 */
public class EjerciciosEjemploRUntime {

    private static final String EDGE = "firefox";
    private static final String CMD = "/bin/bash";

    public static void main(String[] args) throws IOException, InterruptedException {

        Process process1 = Runtime.getRuntime().exec(EDGE);
        Process process2 = Runtime.getRuntime().exec(CMD);

        System.out.println("El estado del proceso " + process1.pid() + " es: " + process1.isAlive());
        System.out.println("La información del proceso " + process2.pid() + " es: " + process2.info());
        System.out.println();
        System.out.println("PROCESS 1");
        System.out.println("_________");
        System.out.println();
        System.out.println(process1.info().startInstant()
                .get());
        System.out.println(process1.info()
                .totalCpuDuration()
                .get()
                .getNano() + " ns.");
        System.out.println();
        System.out.print(process1.info().user());
        System.out.println("\n\n\n\n\n");
        System.out.println("PROCESS 2");
        System.out.println("_________");
        System.out.println();
        System.out.println(process2.info().startInstant()
                .get());
        System.out.println(process2.info()
                .totalCpuDuration()
                .get()
                .getNano() + " ns.");
        System.out.println();
        System.out.print(process2.info().getClass().getClass().getName());
        System.out.println();
        System.out.println();

        Thread.sleep(5000);
        process1.destroy();
        System.out.println("La información del proceso " + process1.pid() + " es: " + process1.isAlive());

        Thread.sleep(6000);
        process2.destroy();
        System.out.println("La información del proceso " + process2.pid() + " es: " + process2.isAlive());

    }
}
