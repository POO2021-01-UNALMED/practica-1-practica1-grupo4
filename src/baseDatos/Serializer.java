package baseDatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import persona.Cliente;

public class Serializer{
	

	public static void serializar(Cliente cliente) throws IOException {
		FileOutputStream fileOut = new FileOutputStream("src\\baseDatos\\temp\\clienteInfo.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(cliente);
		out.close();
		fileOut.close();
	}
}

