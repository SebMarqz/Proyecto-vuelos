// SOLICITUD DE ESPERA= nombre-apellido-pasaporte-origen-destino-fecha y hora

public class ColaDeEspera_cola implements ColaDeEspera_interfaz {

    class Nodo{
        Pasajero dato;
        Nodo sig;
    }

    Nodo primero;
    Nodo ultimo;

    public void inicializar_cola(){
        primero=null;
        ultimo=null;
    }

    public void acolar_pasajero(Pasajero x){
        Nodo nuevo =new Nodo();
        nuevo.dato= x;
        nuevo.sig=null;
        if(ultimo!= null)
            ultimo.sig=nuevo;
        ultimo=nuevo;
        if(primero==null){
            primero=ultimo;
        }
    }

    public void desacolar_pasajero(){
        if(primero != null){
            primero = primero.sig;
            if(primero == null){
                ultimo = null;
            }
        }
    }
    public boolean cola_vacia(){
        return (ultimo==null);
    }

    public Pasajero primer_pasajero(){
        if (cola_vacia()) return null;
        return primero.dato;
    }







    }
