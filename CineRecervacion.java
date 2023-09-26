import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**@author Corrales*/
public class CineRecervacion {
    public static void main(String[] args) {
        String[] peliculaNombres = {"La Monja 2", "Saw X", "Spider-Man: Homecoming"};
        int[][] peliculas = new int[3][50]; // Matriz para representar los asientos (0 = disponible, 1 = reservado)
        Scanner teclado = new Scanner(System.in);

        while (true) {
            mostrarCartelera(peliculaNombres);

            System.out.print(" Por favor, elige una película (1, 2 o 3) o ingresa '0' para salir: ");
            int seleccionPelicula = teclado.nextInt();

            if (seleccionPelicula == 0) {
                break; // Salir del programa si se ingresa 0
            }

            if (seleccionPelicula < 1 || seleccionPelicula > 3) {
                System.out.println("Selección de película inválida. Por favor, elige una película válida.");
                continue; // Continuar el bucle si se ingresa una selección inválida
            }
            int[] peliSeleccionada = peliculas[seleccionPelicula - 1];
                       
            mostrarAsientos( peliSeleccionada, peliculaNombres[seleccionPelicula - 1]);

            List<Integer> asientosReservados = new ArrayList<>();
            
            while (true) {
                System.out.println("Por favor, ingresa el número de asiento que deseas reservar (0 para finalizar la reserva): ");
                int seleccionAsiento = teclado.nextInt();

                if (seleccionAsiento == 0) {
                    break; // Finalizar la reserva si se ingresa 0
                }

                if (seleccionAsiento < 1 || seleccionAsiento > 50) {
                    System.out.println("\n Número de asiento inválido. Por favor, ingresa un número válido.");
                    continue; // Continuar el bucle si se ingresa un número de asiento inválido
                }

                if (peliSeleccionada[seleccionAsiento - 1] == 1) {
                    System.out.println("Este asiento ya está reservado. Por favor, elige otro.");
                } else {
                    peliSeleccionada[seleccionAsiento - 1] = 1;
                    asientosReservados.add(seleccionAsiento);
                    System.out.println("¡Asiento " + seleccionAsiento + " reservado con éxito para la película " + peliculaNombres[seleccionPelicula - 1] + "!\n");
                }
            }

            if (!asientosReservados.isEmpty()) {
                System.out.println("\n Reserva completada para la película " + peliculaNombres[seleccionPelicula - 1] + ":");
                System.out.print("Asientos reservados: ");
                for (int asiento : asientosReservados) {
                    System.out.print(asiento + " ");
                }
                System.out.println();
            }
        }

        System.out.println("\n Gracias por reservar con nosotros.");
    }

    public static void mostrarCartelera(String[] peliculaNombres) {
        System.out.println("Cartelera de películas:");
        for (int i = 0; i < peliculaNombres.length; i++) {
            System.out.println((i + 1) + ". " + peliculaNombres[i]);
        }
    }

    public static void mostrarAsientos(int[] pelicula, String nombrePelicula) {
        System.out.println("Estado de los asientos para " + nombrePelicula + ":");
        for (int asiento = 0; asiento < pelicula.length; asiento++) {
            char estado = (pelicula[asiento] == 1) ? 'X' : 'O'; // 'X' si el asiento está reservado, 'O' si está disponible
            System.out.print("Asiento " + (asiento + 1) + ": [" + estado + "]   ");
            if ((asiento + 1) % 10 == 0) {
                System.out.println(); // Salto de línea después de cada 10 asientos
            }
        }
        System.out.println(); // Salto de línea al final
    }
}



