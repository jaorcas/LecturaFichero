import java.io.IOException;

public class main {

	
	public static void main (String args[]) throws IOException {
		
		
		String nombreArchivo = "accesoDatosWrite.txt";
		Fichero fichero = new Fichero();
		
		//fichero.leer(nombreArchivo);
		//fichero.estadistica(nombreArchivo);
		
		fichero.escribir(nombreArchivo);
		
	}
	
}

