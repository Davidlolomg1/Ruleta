package RuletaMejorada;

import java.util.Scanner;

import Enemigo.Enemigo;

public class Juego {

	public static void main(String[] args) {

		// RULETA
		Ruleta rule = new Ruleta();
		final String ROJO = "rojo";
		final String NEGRO = "negro";
		final String VERDE = "verde";

		Scanner sc = new Scanner(System.in);
		int saldo;
		int saldoI;
		int apuesta;
		
		do {
			System.out.println("Introduce tu saldo: ");
			saldo = sc.nextInt();
			saldoI = rule.inicioSaldo(saldo);
		}while(saldoI <= 0);

		
		while (true) {
			do {
				System.out.println("¿Cuanto dinero quieres apostar?: ");
				apuesta = sc.nextInt();
			} while (apuesta > rule.saldoInt());

			System.out.println("¿A que quieres apostar?");
			System.out.println("1. Apostar a un color");
			System.out.println("2. Apostar a un numero");
			System.out.println("3. Apostar a par/impar");
			System.out.println("4. Apostar a una fila");
			System.out.println("5. Apostar a una docena");
			int eleccionApuesta = sc.nextInt();
			// BOLITA
			int numero = rule.tirarRule();
			// COLOR
			String color = rule.color(numero);
			String mostrarSaldo = rule.mostrarSaldo();
			switch (eleccionApuesta) {
			case 1 -> {
				// APUESTA COLOR

				System.out.println("¿Que color?: ");
				String colorElegido = sc.next();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaColor = rule.apuestaColor(colorElegido.toLowerCase(), apuesta, color);
				System.out.println(rule.mostrarSaldo());

			}
			case 2 -> {
				System.out.println("¿Que Número?: ");
				int numeroElegido = sc.nextInt();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaNumero = rule.apuestaNumero(numeroElegido, apuesta, numero);
				System.out.println(rule.mostrarSaldo());

			}
			case 3 -> {
				System.out.println("1. Par");
				System.out.println("2. Impar");

				int tipoElegido = sc.nextInt();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaTipo(tipoElegido, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			case 4 -> {
				System.out.println("1. Fila de Abajo");
				System.out.println("2. Fila del medio");
				System.out.println("3. Fila de arriba");
				int filaElegida = sc.nextInt();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaFila(filaElegida, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			case 5 -> {
				System.out.println("¿A qué docena?");
				System.out.println("1. Primera");
				System.out.println("2. Segunda");
				System.out.println("3. Tercera");
				int docenaElegida = sc.nextInt();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaDocena(docenaElegida, apuesta, numero);
				System.out.println(rule.mostrarSaldo());

			}
			}
			if (rule.saldoInt() <= 0) {
				break;
			}
			if (rule.saldoInt() > 0) {
				System.out.println("");
				System.out.println("Quieres seguir jugando?");
				System.out.println("1. Si");
				System.out.println("2. No");
				int seguirJugando = sc.nextInt();

				if (seguirJugando == 1) {
					continue;
				} else {
					break;
				}
			}

		}
	}

}
