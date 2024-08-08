package uno;
public class Parqueadero {
    private Carro[][] espacios;
    private double tarifaPorHora;

    public Parqueadero(int filas, int columnas, double tarifaPorHora) {
        this.espacios = new Carro[filas][columnas];
        this.tarifaPorHora = tarifaPorHora;
    }

    public boolean parquearCarro(Carro carro, int fila, int columna) {
        if (fila < 0 || fila >= espacios.length || columna < 0 || columna >= espacios[0].length) {
            return false;
        }
        if (espacios[fila][columna] != null) {
            return false;
        }
        espacios[fila][columna] = carro;
        return true;
    }

    public double cobrarPorTiempo(Carro carro, int horas) {
        return tarifaPorHora * horas;
    }

    public Carro buscarCarroPorPlaca(String placa) {
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[i].length; j++) {
                if (espacios[i][j] != null) {
                    System.out.println("Revisando espacio ...(" + i + ", " + j + ") con placa: " + espacios[i][j].getPlaca());
                    if (espacios[i][j].getPlaca().equals(placa)) {
                        return espacios[i][j];
                    }
                }
            }
        }
        return null;
    }

    public boolean retirarCarro(String placa, int horas) {
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[i].length; j++) {
                if (espacios[i][j] != null && espacios[i][j].getPlaca().equals(placa)) {
                    double costo = cobrarPorTiempo(espacios[i][j], horas);
                    System.out.println("El costo por " + horas + " horas de estacionamiento del carro con placa " + placa + " es: " + costo);
                    espacios[i][j] = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void mostrarEstadoParqueadero() {
        for (int i = 0; i < espacios.length; i++) {
            for (int j = 0; j < espacios[i].length; j++) {
                if (espacios[i][j] != null) {
                    System.out.print("X - ");
                } else {
                    System.out.print("  - ");
                }
            }
            System.out.println();
        }
    }
}
