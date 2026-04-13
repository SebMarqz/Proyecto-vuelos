public class Reservas_Diccionario implements Reserva_interfaz  {

    private int indice;
    private Reserva_vuelos[] reservas;

    public void inicializador_diccionario(){
        indice=0;
        reservas= new Reserva_vuelos[100];

    }

    public int Clave2Ind(int clave){
        int i = indice -1;
        while (i>=0 && reservas[i].numero_reserva!= clave)
            i--;
        return i;
    }


    public void agregar_reservas(int clave, Pasajero pasajero, Vuelo vuelo){
        int pos = Clave2Ind(clave);

        if(pos == -1){
            if(indice < reservas.length){
                pos = indice;
                reservas[pos] = new Reserva_vuelos(clave, pasajero, vuelo);
                reservas[pos].numero_reserva = clave;
                indice++;
            } else {
                System.out.println("No se pueden agregar más reservas");
                return;
            }
        }
        reservas[pos].setPasajero(pasajero);
        reservas[pos].setVuelo(vuelo);
    }

    public void eliminar_reserva(int clave){
        int pos = Clave2Ind(clave);
        if(pos != -1){
            reservas[pos]= reservas[indice-1];
            indice--;
        }

    }
    public Reserva_vuelos recuperar_reserva(int clave){
        int pos = Clave2Ind(clave);
        if(pos == -1){
            return null;
        }
        return reservas[pos];
    }


}
