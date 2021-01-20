package com.carlos.me;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String args[]) throws IOException {
		 final String ruta = "https://www.bolsamadrid.es/esp/aspx/Mercados/Precios.aspx?indice=ESI100000000&punto=indice";
		 final URL url = new URL(ruta);
		 final String fichero = "C:\\Users\\Carlos\\Desktop\\HTML.txt";
		 
		 //descargarHTML(url, ruta, fichero);
		 extraerInformacion(fichero);
	}
	
	private static void descargarHTML(URL url, String ruta, String fichero) {
		 try {
			BufferedInputStream in = new BufferedInputStream(url.openStream());
			FileOutputStream fos = new FileOutputStream(fichero);
			
			try {
				byte dataBuffer[] = new byte[1024];
				int bytesRead;
				while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
					fos.write(dataBuffer, 0, bytesRead);
					}
				} catch (IOException e) {
				    // handle exception
				}
			
			fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void extraerInformacion(String fichero) throws IOException {
		File file = new File(fichero);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;
		while((linea = br.readLine()) != null) {
			if(linea.contains("FichaValor")) {
				String[] texto;
				texto = linea.split(">");
				for(String t:texto) {
					if(t.startsWith("<") || t.startsWith("\\")) {
						t = ";";
					} else {
						
					}
					if(t.contains("</td")) {
					}
					System.out.println(t);
				}
			}
		}
	}
}
