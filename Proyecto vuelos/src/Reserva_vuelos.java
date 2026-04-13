public class Reserva_vuelos {

    int numero_reserva;//clave
    private Pasajero pasajero;
    private Vuelo vuelo;

    public Reserva_vuelos(int numero_reserva,Pasajero pasajero,Vuelo vuelo){
        this.numero_reserva=numero_reserva;
        this.vuelo=vuelo;
        this.pasajero=pasajero;

    }

    public int getNumero_reserva(){
        return numero_reserva;
    }
    public Pasajero pasajero(){
        return pasajero;
    }
    public Vuelo vuelo(){
        return vuelo;
    }

    public void setNumero_reserva(int numero_reserva) {
        this.numero_reserva = numero_reserva;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
}
