package uno;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(5, 10, 2.5);

        int opcion;
        System.out.println("Bienvenido al parqueadero, seleccione una opcion");
        do {
            System.out.println("Menú:");
            System.out.println("1. Ver estado del parqueadero");
            System.out.println("2. Agregar un carro");
            System.out.println("3. Retirar un carro");
            System.out.println("4. Buscar por placa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    //parqueadero
                    System.out.println("Estado actual del parqueadero:");
                    parqueadero.mostrarEstadoParqueadero();
                    break;
                case 2:
                    //agregar
                    System.out.println("Ingrese los detalles del carro:");
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();

                    Carro nuevoCarro = new Carro(placa, marca, modelo);

                    System.out.print("Ingrese la fila para estacionar (0 a 4): ");
                    int fila = scanner.nextInt();
                    System.out.print("Ingrese la columna para estacionar (0 a 9): ");
                    int columna = scanner.nextInt();
                    scanner.nextLine();

                    if (parqueadero.parquearCarro(nuevoCarro, fila, columna)) {
                        System.out.println("El carro con placa: " + placa + " fue estacionado exitosamente en (" + fila + ", " + columna + ").");
                    } else {
                        System.out.println("No se pudo estacionar el carro con placa " + placa + " en (" + fila + ", " + columna + "). Espacio ya ocupado o fuera de rango.");
                        System.out.println("intentelo de nuevo con un estacionamiento diferente");
                    }
                    break;
                case 3:
                    // sacar
                    System.out.print("Ingrese la placa del carro para retirar: ");
                    String placaRetiro = scanner.nextLine();

                    System.out.print("Ingrese el número de horas de estacionamiento para calcular el costo:");
                    int horas = scanner.nextInt();
                    scanner.nextLine();

                    if (parqueadero.retirarCarro(placaRetiro, horas)) {
                        System.out.println("El carro con placa " + placaRetiro + " ha sido retirado.");
                    } else {
                        System.out.println("Carro con placa " + placaRetiro + " no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese la placa del carro que desea buscar: ");
                    String placaBuscar = scanner.nextLine();

                    parqueadero.buscarCarroPorPlaca(placaBuscar);
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

}
