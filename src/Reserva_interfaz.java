public interface Reserva_interfaz {

    void inicializador_diccionario();

    int Clave2Ind(int clave);

    void agregar_reservas(int clave,Pasajero pasajero,Vuelo vuelo);

    void eliminar_reserva(int clave);

    Reserva_vuelos recuperar_reserva(int clave);

}
