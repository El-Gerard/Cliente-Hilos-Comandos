package ClienteC;

import java.io.IOException;
import java.util.Scanner;

/*Clase que recibe datos para ser procesados
 * y enviados a las clases Messenger para ser enviados
 * al servidor*/

public class Capturator {

	public static String code = ">> "; // token identificador de la terminal
	public static String server, numeros; // variables para la recogida de datos
	public static int puerto; // puerto del servidor
	public static Scanner leer = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		System.out.println(">> Terminal de acceso\n");
		System.out.print(">> IP Servidor: ");
		server = leer.next(); // se guarda la iP escrita en consola
		System.out.print(">> Puerto Servidor: ");
		puerto = leer.nextInt(); // se guarda el puerto
		System.out.println(">> Conectando...");
		Proces(); // se llama al método que inicia el proceso
	}

	public static void Proces() throws IOException {

		// condicional que se ejecuta si hubo una conexión exitosa con el server
		if (Messenger.enviar(server, puerto)) {

			System.out.println(">> Use el comando /help para ayuda");
			System.out.print(code);
			String comand = leer.next(); // guarda el comando ejecutado
			if (comand.indexOf("/") == 0) { // condicional que comprueba que sea un comando, iniciando por "/"
				Messenger Men = new Messenger(); // Crea una instancia de la clase messenger
				Men.EnviarComando(comand); // Envia el comando
			} else {
				System.out.println(">> Error el comando no existe");
			}
		}
	}

	// Método para enviar los números al servidor
	public static void Numeros(String msn) throws IOException {

		// Condicional que verifica que la conexión sigue establecida
		if (Messenger.enviar(server, puerto)) {

			System.out.print(">> Numeros: ");
			numeros = msn + "-";
			numeros += leer.next();
			// Se envían los números al método de Messenger
			Messenger Men = new Messenger();
			Men.EnviarComando(numeros);
		}
	}
}
