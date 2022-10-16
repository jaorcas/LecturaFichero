import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Fichero {

	// LEE EL ARCHIVO Y LO MUESTRA POR PANTALLA
	public void leer(String nombre) throws IOException {

		File file = new File("C:/EjerciciosProgramacion/" + nombre);
		BufferedReader leer = null;

		if (file.exists()) {
			
			//EL BUFFERREADER SE VA A ENCARGAR IR RECORRIENDO TODO EL ARCHIVO
			leer = new BufferedReader(new FileReader(file));

			String linea = "";
			
			//RECORRERÁ TODO EL ARCHIVO LÍNEA A LÍNEA Y LAS IMPRIME POR PANTALLA
			while ((linea = leer.readLine()) != null) {

				System.out.println(linea);
			}

		}

		leer.close();
	}

	
	// LEE EL ARCHIVO Y MUESTRA LA CANTIDAD DE CARACTERES Y LINEAS QUE TIENE
	public void estadistica(String nombre) throws IOException {
		
		//INDICAMOS LA RUTA + NOMBRE DEL ARCHIVO
		File file = new File("C:/EjerciciosProgramacion/" + nombre);
		BufferedReader leer = null;

		int contadorCaracteres = 0;
		int contadorLineas = 0;
		
		if (file.exists()) {
			
			//LEER VA A SER LA VARIABLE QUE VA A IR LEYENDO EL ARCHIVO
			leer = new BufferedReader(new FileReader(file));

			String linea = "";
			
			//MIENTRAS QUEDE ALGUNA LÍNEA POR LEER, SUMA LOS CARACTERES Y LAS LÍNEAS, Y LAS MUESTRA
			//POR PANTALLA
			while ((linea = leer.readLine()) != null) {

				contadorCaracteres += linea.length();
				contadorLineas++;
			}

			System.out.println("El archivo tiene " + contadorCaracteres + " caracteres.");
			System.out.println("El archivo tiene " + contadorLineas + " líneas.");

		}

		leer.close();
	}

	
	//ESTE BLOQUE SE VA A ENCARGAR DE ESCRIBIR EN UN ARCHIVO LO QUE ESCRIBA EL USUARIO
	public void escribir(String nombre) throws IOException {

		File file = new File("C:/EjerciciosProgramacion/" + nombre);
		String texto = "";
		
		//EL TRUE EN EL FILEWRITER ES PARA QUE SE PONGA SIEMPRE AL FINAL DEL DOCUMENTO
		//SE PUSIESEMOS FALSE LO SOBRESCRIBIRÍA
		FileWriter writer = new FileWriter(file, true);
		
		//EL PRINTWRITER SE VA A ENCARGAR DE ESCRIBIR EN EL ARCHIVO FILE
		BufferedWriter bufferWriter = new BufferedWriter(writer);
		PrintWriter pw = new PrintWriter(bufferWriter);

		Scanner scan = new Scanner(System.in);		
		texto = scan.nextLine();
		
		//MIENTRAS EL TEXTO NO SEA "ESPACIO", AÑADIRÁ ESA INFORMACIÓN AL ARCHIVO
		while(!texto.isEmpty()) {
			
			//ESCRIBIMOS EN EL DOCUMENTO LO QUE HA ESCRITO EL USUARIO
			pw.println(texto);
			System.out.println("Se ha añadido: " + texto);
			scan = new Scanner(System.in);
			//VOLVEMOS A GUARDAR EN "texto" LO QUE HA ESCRITO EL USUARIO.
			texto= scan.nextLine();
		}
		
		System.out.println("Salgo del bucle");
		bufferWriter.close();
		pw.close();
		scan.close();			
		
	}

}
