

public interface ColaDeEspera_interfaz {

    void inicializar_cola();

    void acolar_pasajero(Pasajero x);

    void desacolar_pasajero();

    Pasajero primer_pasajero();

    boolean cola_vacia();


}
