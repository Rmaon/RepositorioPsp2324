package processtercerprincipal;


import java.io.*;
import java.nio.charset.*;

public class ExportarAFile {

	public static void main(String[] args) throws IOException {
		
		try (InputStreamReader ipsr = new InputStreamReader(System.in, Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(ipsr);
		FileWriter fw = new FileWriter(new File("ExportarAFile.txt"));
		BufferedWriter bw = new BufferedWriter(fw)) {
				
		String line = "";
		do {
			line = br.readLine();
			bw.write(line);
			bw.newLine();
            
		} while (!line.isBlank());
		}catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
      }
		
		
	}

}