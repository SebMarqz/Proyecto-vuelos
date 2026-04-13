public interface Pasajeros_interfaz {
    void InicializarLista();
    void AgregarPasajero(Pasajero pasajero);
    void EliminarPasajero(int pasaporte);
    Pasajero BuscarPasajero(int pasaporte);
    boolean ListaVacia();
}
