package dos;

public class Capitan {
    private String nombre;
    private String apellido;
    private String matricula;

    public Capitan(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }
}