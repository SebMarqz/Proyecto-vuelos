public class Pasajeros_enlazados implements Pasajeros_interfaz {

    class Nodo {
        Pasajero dato;
        Nodo sig;
    }

    private Nodo primero;

    public void InicializarLista() {
        primero = null;
    }

    public void AgregarPasajero(Pasajero pasajero) {
        Nodo nuevo = new Nodo();
        nuevo.dato = pasajero;
        nuevo.sig = primero;
        primero = nuevo;
    }

    public void EliminarPasajero(int pasaporte) {
        if (primero == null) {
            return;
        }

        if (primero.dato.getPasaporte() == pasaporte) {
            primero = primero.sig;
            System.out.println("Pasajero eliminado");
            return;

        }

        Nodo aux = primero;
        while (aux.sig != null && aux.sig.dato.getPasaporte() != pasaporte) {
            aux = aux.sig;

        }

        if (aux.sig != null) {
            aux.sig = aux.sig.sig;
            System.out.println("Pasajero eliminado");
        }
    }

    public Pasajero BuscarPasajero(int pasaporte) {
        Nodo aux = primero;

        while (aux != null) {
            if (aux.dato.getPasaporte() == pasaporte) {
                return aux.dato;
            }
            aux = aux.sig;
        }

        return null;
    }

    public boolean ListaVacia() {
        return primero == null;
    }


}
