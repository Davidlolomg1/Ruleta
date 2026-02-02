package RuletaMejorada;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Interfaz {

	Scanner sc;
	Ruleta rule;

	int saldo;
	int saldoI;
	int apuesta;

	public Interfaz() {
		this.sc = new Scanner(System.in);
		this.rule = new Ruleta();
	}

	public void inicioRuleta() {
		do {
		    try {
		        System.out.println("Introduce tu saldo: ");
		        saldo = sc.nextInt();
		    } catch (InputMismatchException error) {
		        System.out.println("Has introducido saldo invalido");
		        sc.nextLine();
		        saldo = 0;
		    }
		} while (saldo <= 0);
		rule.setSaldo(saldo); 
		while (true) {

			do {
				try {
					System.out.println("¿Cuanto dinero quieres apostar?: ");
					apuesta = sc.nextInt();
				} catch (InputMismatchException error) {
					System.out.println("Has introducido una apuesta invalida");
					sc.nextLine();
					apuesta = -1;
				}
			} while (apuesta > rule.getSaldo() || apuesta <= 0);

			
			int eleccionApuesta = 0;
			boolean menuValido = false;

			do {
				try {
					System.out.println("¿A que quieres apostar?");
					System.out.println("1. Apostar a un color");
					System.out.println("2. Apostar a un numero");
					System.out.println("3. Apostar a par/impar");
					System.out.println("4. Apostar a una fila");
					System.out.println("5. Apostar a una docena");
					eleccionApuesta = sc.nextInt();
					menuValido = true;
				} catch (InputMismatchException error) {
					System.out.println("Opción invalida");
					sc.nextLine();
					menuValido = false;
				}
			} while (!menuValido);

			int numero = rule.tirarRule();
			String color = rule.color(numero);
			String mostrarSaldo = rule.mostrarSaldo();

			switch (eleccionApuesta) {
			case 1 -> {
				System.out.println("¿Que color?: ");
				String colorElegido = sc.next();
				System.out.println("Resultado = " + numero + " " + color);
				int apuestaColor = rule.apuestaColor(colorElegido.toLowerCase(), apuesta, color);
				System.out.println(rule.mostrarSaldo());
			}
			case 2 -> {
				int numeroElegido = -1;
				do {
					try {
						System.out.println("¿Que Número?: ");
						numeroElegido = sc.nextInt();
					} catch (InputMismatchException error) {
						System.out.println("Numero invalido");
						sc.nextLine();
						numeroElegido = -1;
					}
				} while (numeroElegido < 0 || numeroElegido > 36);

				System.out.println("Resultado = " + numero + " " + color);
				int apuestaNumero = rule.apuestaNumero(numeroElegido, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			case 3 -> {
				int tipoElegido = 0;
				do {
					try {
						System.out.println("1. Par");
						System.out.println("2. Impar");
						tipoElegido = sc.nextInt();
					} catch (InputMismatchException error) {
						System.out.println("Opcion invalida");
						sc.nextLine();
						tipoElegido = 0;
					}
				} while (tipoElegido != 1 && tipoElegido != 2);

				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaTipo(tipoElegido, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			case 4 -> {
				int filaElegida = 0;
				do {
					try {
						System.out.println("1. Fila de Abajo");
						System.out.println("2. Fila del medio");
						System.out.println("3. Fila de arriba");
						filaElegida = sc.nextInt();
					} catch (InputMismatchException error) {
						System.out.println("Opcion invalida");
						sc.nextLine();
						filaElegida = 0;
					}
				} while (filaElegida < 1 || filaElegida > 3);

				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaFila(filaElegida, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			case 5 -> {
				int docenaElegida = 0;
				do {
					try {
						System.out.println("¿A qué docena?");
						System.out.println("1. Primera");
						System.out.println("2. Segunda");
						System.out.println("3. Tercera");
						docenaElegida = sc.nextInt();
					} catch (InputMismatchException error) {
						System.out.println("Opcion invalida");
						sc.nextLine();
						docenaElegida = 0;
					}
				} while (docenaElegida < 1 || docenaElegida > 3);

				System.out.println("Resultado = " + numero + " " + color);
				int apuestaTipo = rule.apuestaDocena(docenaElegida, apuesta, numero);
				System.out.println(rule.mostrarSaldo());
			}
			}

			if (rule.getSaldo() <= 0) {
				break;
			}
			if (rule.getSaldo() > 0) {
				int seguirJugando = 0;
				do {
					try {
						System.out.println("");
						System.out.println("Quieres seguir jugando?");
						System.out.println("1. Si");
						System.out.println("2. No");
						seguirJugando = sc.nextInt();
					} catch (InputMismatchException error) {
						System.out.println("Opcion invalida");
						sc.nextLine();
						seguirJugando = 0;
					}
				} while (seguirJugando != 1 && seguirJugando != 2);

				if (seguirJugando == 1) {
					continue;
				} else {
					break;
				}
			}
		}
	}
}