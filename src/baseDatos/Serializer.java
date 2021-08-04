package baseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import gestorAplicación.Cliente;

public class Serializer {

	public static void serializar(Cliente cliente) throws IOException{
		String ruta = System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\clienteInfo.ser";
		//String ruta = "src\\baseDatos\\temp\\clienteInfo.ser";
		File file = new File(ruta);
		if (file.exists()) {
			file.delete();
		}
		FileOutputStream fileOut = new FileOutputStream(ruta);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(cliente);
		out.close();
		fileOut.close();
	}

	public static boolean archivoEsVacio() throws IOException {
		String ruta = System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\clienteInfo.ser";
		//String ruta = "src\\baseDatos\\temp\\clienteInfo.ser";
		File file = new File(ruta);
		if (file.exists()) {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			if (!(br.readLine() == null)) {
				return false;
			}
		}
		return true;
	}
}