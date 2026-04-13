public class Main {
    public static void main(String[] args) {
        Vuelos_cojunto vuelos = new Vuelos_cojunto();
        vuelos.inicializar_conjunto();

        Aerolinea aerolinea = new Aerolinea(vuelos);

        Menu_aerolinea menu = new Menu_aerolinea();
        menu.iniciar(aerolinea);
    }
}
