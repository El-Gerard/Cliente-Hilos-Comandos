package ClienteC;

import java.io.DataInputStream;
import java.io.IOException;
//import java.net.ServerSocket;
import java.net.Socket;

public class Presentator {

	/*
	 * Clase que recibe los datos del server y los muestra por pantalla, en caso de
	 * que el server solicite números hace un llamado por consola para pedirlos y
	 * los reenvía para su proceso
	 */
	public void mostrar(Socket soc) {

		try {

			// Variables para recibir mensajes del servidor
			DataInputStream flujo_entrada = new DataInputStream(soc.getInputStream());
			String Mensaje_texto = flujo_entrada.readUTF();

			// Condicional que pregunta si es una respueta solicitando números
			if (Mensaje_texto.indexOf("N") == 2) {

				Capturator.Numeros(Mensaje_texto);

				// Sino es una solicitud entonces es la respuesta y la muestra por pantalla
			} else {
				System.out.println(Mensaje_texto);
				// Llama a la clase principal para seguir introduciendo comandos
				Capturator.Proces();
			}
			// Cierre del socket
			soc.close();

		} catch (IOException e) {
			// e.printStackTrace();
		}
	}

	// método que muestra la respuesta final del servidor
	public void mostrarRes(Socket SO) throws IOException {

		DataInputStream flujo_entrada2 = new DataInputStream(SO.getInputStream());
		String Mensaje_texto = flujo_entrada2.readUTF();
		System.out.println(Mensaje_texto);
		Capturator.Proces();
	}

}
