public class Main { //Arranca el sistema

    // Metodo principal del programa. Inicializa las estructuras y arranca el menu.
    public static void main(String[] args) {
        Vuelos_cojunto vuelos = new Vuelos_cojunto(); //Crea la estructura de vuelos
        vuelos.inicializar_conjunto(); //Inicializa la estructura de vuelos

        Aerolinea aerolinea = new Aerolinea(vuelos); //Crea una Aerolinea

        Menu_aerolinea menu = new Menu_aerolinea(); //Crea el menu
        menu.iniciar(aerolinea); //Lo lanza
    }
}
 //Punto de entrada del programa: crea las estructuras principales y lanza el menu
