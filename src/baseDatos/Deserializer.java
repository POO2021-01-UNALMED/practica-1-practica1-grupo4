package baseDatos;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import gestorAplicación.Cliente;

public class Deserializer{
	
	public static Cliente deserializar(Cliente cliente) throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\clienteInfo.ser");
		//FileInputStream fileIn = new FileInputStream("src\\baseDatos\\temp\\clienteInfo.ser");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		cliente = (Cliente) in.readObject();
		in.close();
		fileIn.close();
		return cliente;
				
	}
}