package ClienteC;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/*Clase que establece la conexión con el server
 * posteriormente envía el String con los datos
 * introducidos por consola*/

public class Messenger {

	private static Socket miSocket; // variable de clase tipo socket
	Presentator pres = new Presentator(); // Instancia de la clase presentator

	public Messenger() {
	}

	// Método boolean que establece la conexión (true)
	public static boolean enviar(String IP, int puerto) {

		try {
			miSocket = new Socket(IP, puerto);
			System.out.println(">> \n");

		} catch (UnknownHostException e1) {
			// e1.printStackTrace();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
			System.out.println(">> Error en la conexión");
			return false;
		}
		return true;
	}

	// Método que envía el comando al server en formato String
	public void EnviarComando(String comand) throws IOException {

		DataOutputStream flujo_salida = new DataOutputStream(miSocket.getOutputStream());
		flujo_salida.writeUTF(comand);
		pres.mostrar(miSocket);
		flujo_salida.close();
	}
}
