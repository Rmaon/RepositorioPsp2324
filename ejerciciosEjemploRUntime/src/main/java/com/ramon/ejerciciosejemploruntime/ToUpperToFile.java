package com.ramon.ejerciciosejemploruntime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ToUpperToFile {

    public static void main(String[] args) throws IOException {
        
        try (InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
        BufferedReader brU = new BufferedReader(ipsr);
        BufferedReader br = new BufferedReader(ipsr);
        FileWriter fw = new FileWriter(new File("ExportarAFile1.txt"));
        BufferedWriter bw = new BufferedWriter(fw)
        
            ) {

        String line = "";
            do {
                line = brU.readLine();
                bw.write(line.toUpperCase());
                bw.newLine();

            } while (!line.isBlank());
        }
    }
}