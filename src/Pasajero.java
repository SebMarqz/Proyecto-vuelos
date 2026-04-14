public class Pasajero { // Crea un pasajero con nombre, apellido y pasaporte.
    private String nombre;
    private String apellido;
    private int pasaporte;

    // Clase que representa a un pasajero del sistema.
    public Pasajero(String nombre, String apellido, int pasaporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(int pasaporte) {
        this.pasaporte = pasaporte;
    }
}
//get Devuelve . Set Modifica
