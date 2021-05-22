package baseDatos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import persona.Cliente;

public class Serializer {

	public static void serializar(Cliente cliente) throws IOException {
<<<<<<< HEAD
		/*FileOutputStream fileOut = new FileOutputStream(
		System.getProperty("user.dir") + "/baseDatos/temp/clienteInfo.ser");*/
		FileOutputStream fileOut = new FileOutputStream("src\\baseDatos\\temp\\clienteInfo.ser");
=======
		FileOutputStream fileOut = new FileOutputStream(
		System.getProperty("user.dir") + "/baseDatos/temp/clienteInfo.ser");
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(cliente);
		out.close();
		fileOut.close();
	}

	public static boolean archivoEsVacio() throws IOException {
<<<<<<< HEAD
		//String ruta = System.getProperty("user.dir") + "/baseDatos/temp/clienteInfo.ser";
		String ruta = "src\\baseDatos\\temp\\clienteInfo.ser";
=======
		String ruta = System.getProperty("user.dir") + "/baseDatos/temp/clienteInfo.ser";
>>>>>>> 6e0909946f2d364dcf39dc17d18d7d0cd3a9f045
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