package RuletaMejorada;

public class Ruleta {

    // Quitamos el Scanner de aquí. La lógica no debe pedir datos, solo procesarlos.
    
    final String ROJO = "rojo";
    final String NEGRO = "negro";
    final String VERDE = "verde";
    
    int saldo;

    // Método corregido: añadido void y lógica de seguridad
    public void setSaldo(int saldo) {
        if (saldo <= 0) {
            System.out.println("Error: No se puede iniciar con saldo negativo o cero.");
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }
    }

    int getSaldo() {
        return this.saldo;
    }

    String mostrarSaldo() {
        return "Tu saldo actual es: " + saldo;
    }
            
    public int tirarRule() {
        // Genera numero del 0 al 36
        return (int) (Math.random() * 37);
    }

    String color(int bolita) {
        String[] COLORES = { VERDE, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, NEGRO, ROJO, NEGRO,
                ROJO, NEGRO, ROJO, NEGRO, ROJO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, NEGRO,
                ROJO, NEGRO, ROJO, NEGRO, ROJO, NEGRO, ROJO };
        
        if (bolita < 0 || bolita > 36) return "desconocido";
        
        return COLORES[bolita];
    }

    // --------------- APUESTA A UN COLOR ---------------------------
    int apuestaColor(String colorElegido, int apuesta, String colorResult) {
        try {
            saldo = saldo - apuesta;
            
            if (colorElegido.toLowerCase().equals(colorResult)) {
                
                if (colorResult.equals(VERDE)) {
                    saldo = saldo + (apuesta * 36);
                } else {
                    saldo = saldo + (apuesta * 2);
                }
                System.out.println("¡Has ganado! Ha salido " + colorResult);
            } else {
                System.out.println("Has perdido. Salió " + colorResult);
            }
        } catch (NullPointerException e) {
            System.out.println("Error: Se ha introducido un color no válido.");
        }
        return saldo;
    }

    // --------------- APUESTA A NÚMERO ---------------------------
    int apuestaNumero(int numeroElegido, int apuesta, int numeroResult) {
        if (numeroElegido < 0 || numeroElegido > 36) {
            System.out.println("Apuesta cancelada: El número elegido no existe en la ruleta.");
            return saldo;
        }

        saldo = saldo - apuesta;
        
        if (numeroElegido == numeroResult) {
            saldo = saldo + (apuesta * 36);
            System.out.println("¡INCREÍBLE! ¡Has acertado el número exacto!");
        } else {
            System.out.println("Has perdido. Salió el " + numeroResult);
        }
        return saldo;
    }

    // --------------- APUESTA PAR / IMPAR ---------------------------
    int apuestaTipo(int tipoElegido, int apuesta, int numeroResult) {
        saldo = saldo - apuesta;

        switch (tipoElegido) {
            case 1 -> {
                if (numeroResult != 0 && numeroResult % 2 == 0) {
                    saldo = saldo + (apuesta * 2);
                    System.out.println("Has ganado, ha salido PAR");
                } else {
                    System.out.println("Has perdido (Salió Impar o 0)");
                }
            }
            case 2 -> {
                if (numeroResult != 0 && numeroResult % 2 != 0) {
                    saldo = saldo + (apuesta * 2);
                    System.out.println("Has ganado, ha salido IMPAR");
                } else {
                    System.out.println("Has perdido (Salió Par o 0)");
                }
            }
            default -> System.out.println("Opción no válida seleccionada.");
        }
        return saldo;
    }

    // --------------- APUESTA FILAS ---------------------------
    int apuestaFila(int filaElegida, int apuesta, int numeroResult) {
        boolean ganar = false;
        saldo = saldo - apuesta;

        switch (filaElegida) {
            case 1 -> {
                for (int i = 1; i < 37; i = i + 3) {
                    if (i == numeroResult) {
                        ganar = true;
                        break;
                    }
                }
            }
            case 2 -> {
                for (int i = 2; i < 37; i = i + 3) {
                    if (i == numeroResult) {
                        ganar = true;
                        break;
                    }
                }
            }
            case 3 -> {
                for (int i = 3; i < 37; i = i + 3) {
                    if (i == numeroResult) {
                        ganar = true;
                        break;
                    }
                }
            }
            default -> System.out.println("Fila no válida.");
        }

        if (ganar) {
            saldo = saldo + (apuesta * 3);
            System.out.println("¡Has ganado! Ha salido tu fila.");
        } else {
            System.out.println("Has perdido la apuesta de fila.");
        }
        return saldo;
    }

    // --------------- APUESTA DOCENAS ---------------------------
    int apuestaDocena(int docenaElegida, int apuesta, int numeroResult) {
        saldo = saldo - apuesta;

        switch (docenaElegida) {
            case 1 -> {
                if(numeroResult >= 1 && numeroResult <= 12) {
                    System.out.println("Has ganado, Primera docena.");
                    saldo = saldo + (apuesta * 3);
                } else {
                    System.out.println("Has perdido");
                }
            }
            case 2 -> {
                if(numeroResult >= 13 && numeroResult <= 24) {
                    System.out.println("Has ganado, Segunda docena.");
                    saldo = saldo + (apuesta * 3);
                } else {
                    System.out.println("Has perdido");
                }
            }
            case 3 -> {
                if(numeroResult >= 25 && numeroResult <= 36) {
                    System.out.println("Has ganado, Tercera docena.");
                    saldo = saldo + (apuesta * 3);
                } else {
                    System.out.println("Has perdido");
                }
            }
            default -> System.out.println("Docena inválida.");
        }
        return saldo;
    }
}