package RuletaMejorada;

import java.util.Scanner;

public class Ruleta {

	Scanner sc = new Scanner(System.in);

	int saldo;
	String colores;

	int inicioSaldo(int saldo) {
		if (saldo <= 0) {
			System.out.println("Error saldo inferior o igual a 0");
		} else {
			this.saldo = saldo;
		}
		return saldo;
	}

	int saldoInt() {
		return saldo;
	}
	String mostrarSaldo() {
		String saldoActual = ("Tu saldo actual es: " + saldo);
		return saldoActual;
	}
			
	public int tirarRule() {
		int bolita = (int) (Math.random() * 37);
		return bolita;
	}

	String color(int bolita) {
		final String ROJO = "rojo";
		final String NEGRO = "negro";
		final String VERDE = "verde";
		String[] COLORES = { VERDE, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, NEGRO, ROJO, NEGRO,
				ROJO, NEGRO, ROJO, NEGRO, ROJO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, NEGRO,
				ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO };

		String colorGanador = COLORES[bolita];
		return colorGanador;
	}

	int numeroBolita(int bolita) {
		int bola = bolita;
		return bola;
	}

	// --------------- APUESTA A UN COLOR ---------------------------
	int apuestaColor(String colorElegido, int apuesta, String colorResult) {
		saldo = saldo - apuesta;
		if (colorElegido.equals(colorResult)) {

			if (colorResult.equals("verde")) {
				saldo = saldo + apuesta * 36;
			} else {
				saldo = saldo + apuesta * 2;
			}
		}
		return saldo;
	}

	int apuestaNumero(int numeroElegido, int apuesta, int numeroResult) {
		saldo = saldo - apuesta;
		if (numeroElegido == numeroResult) {
			saldo = saldo + apuesta * 36;
		}
		return saldo;
	}

	int apuestaTipo(int tipoElegido, int apuesta, int numeroResult) {
		saldo = saldo - apuesta;

		switch (tipoElegido) {
		case 1 -> {
			if (numeroResult % 2 == 0) {
				saldo = saldo + apuesta * 2;
				System.out.println("Has ganado, a salido PAR");

			} else {

				System.out.println("Has perdido");
			}

		}
		case 2 -> {
			if (numeroResult % 2 != 0) {
				saldo = saldo + apuesta * 2;
				System.out.println("Has ganado, a salido IMPAR");
			}
			System.out.println("Has perdido");
		}
		}
		return saldo;
	}

	int apuestaFila(int filaElegida, int apuesta, int numeroResult) {
		boolean ganar = true;
		saldo = saldo - apuesta;

		switch (filaElegida) {

		case 1 -> {
			for (int i = 1; i < 37; i = i + 3) {
				if (i == numeroResult) {
					saldo = saldo + apuesta * 3;
					System.out.println("Has ganado, a salido 1 fila");
					return saldo;
				} else {
					ganar = false;

					continue;
				}
			}
		}
		case 2 -> {
			for (int i = 1; i < 37; i = i + 3) {
				if (i == numeroResult) {
					saldo = saldo + apuesta * 3;
					System.out.println("Has ganado, a salido 2 fila");
					return saldo;
				} else {
					ganar = false;
					continue;
				}

			}
		}
		case 3 -> {
			for (int i = 1; i < 37; i = i + 3) {
				if (i == numeroResult) {
					saldo = saldo + apuesta * 3;
					System.out.println("Has ganado, a salido 3 fila");
					return saldo;
				} else {
					ganar = false;

					continue;
				}
			}
		}

		}
		if (ganar == false) {
			System.out.println("Has perdido");
		}
		return saldo;
	}

	int apuestaDocena(int docenaElegida, int apuesta, int numeroResult) {
		saldo = saldo - apuesta;

		switch (docenaElegida) {
		case 1 ->{
			if(numeroResult >= 1 && numeroResult <= 12) {
				System.out.println("Has ganado, Primera docena.");
				saldo = saldo + apuesta *3;
				return saldo;
			}else {
				System.out.println("Has perdido");
			}
				
		}
		
		case 2 -> {
			if(numeroResult >= 13 && numeroResult <= 24) {
				System.out.println("Has ganado, Segunda docena.");
				saldo = saldo + apuesta *3;
				return saldo;
			}else {
				System.out.println("Has perdido");
			}
				
		}
		case 3 -> {
			if(numeroResult >= 25 && numeroResult <= 36) {
				System.out.println("Has ganado, Tercera docena.");
				saldo = saldo + apuesta *3;
				return saldo;
			}else {
				System.out.println("Has perdido");
			}
				
		}
		}

		return saldo;
	}
}
