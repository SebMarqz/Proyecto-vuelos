public class Aerolinea {

    private Vuelos_cojunto vuelos;
    private Pasajeros_interfaz pasajeros;
    private int proximoNumeroReserva;
    private int proximoIdVuelo;

    public Aerolinea() {

    }

    public Aerolinea(Vuelos_cojunto vuelos){
        this.vuelos=vuelos;
        this.pasajeros = new Pasajeros_enlazados();
        this.pasajeros.InicializarLista();
        this.proximoNumeroReserva = 1;
        this.proximoIdVuelo = 1;

    }

    //METODOS PASAJERO

    public void registrarPasajero(Pasajero pasajero) {
        pasajeros.AgregarPasajero(pasajero);
        System.out.println("Pasajero registrado");
    }

    public void eliminarPasajero(int pasaporte){
        pasajeros.EliminarPasajero(pasaporte);
    }

    public Pasajero buscarPasajero(int pasaporte){
        return pasajeros.BuscarPasajero(pasaporte);
    }



    //METODOS DE VUELO

    public void agregarVuelo(int cantidad_asientos, String origen, String destino, String fecha, String hora){
        Vuelo vuelo = new Vuelo(proximoIdVuelo, cantidad_asientos, origen, destino, fecha, hora);
        vuelos.agregar_vuelo(vuelo);
        System.out.println("Vuelo agregado con id: " + proximoIdVuelo);
        proximoIdVuelo++;
    }

    public void agregarVuelo(Vuelo vuelo){
        vuelos.agregar_vuelo(vuelo);
    }

    public void eliminarVuelo(Vuelo vuelo){
        vuelos.sacar_vuelo(vuelo);
        System.out.println("Vuelo eliminado");
    }
    public Vuelo consultarUltimoVuelo(){
        return vuelos.elegir_vuelo();
    }

    public Vuelo buscarVuelo(int idVuelo){
        return vuelos.buscar_vuelo(idVuelo);
    }

    public Pasajero verColaEsperaDeVuelo(Vuelo vuelo){
        return vuelo.getColaDeEsperaCola().primer_pasajero();
    }

    //METODOS RESERVA


    public void reservarPasaje(Vuelo vuelo, Pasajero pasajero){
        if(vuelo.getCantidad_asientos() > 0){
            vuelo.getReservasDiccionario().agregar_reservas(proximoNumeroReserva, pasajero, vuelo);
            vuelo.setCantidad_asientos(vuelo.getCantidad_asientos() - 1);
            System.out.println("Reserva realizada. Numero de reserva: " + proximoNumeroReserva);
            proximoNumeroReserva++;
        } else {
            vuelo.getColaDeEsperaCola().acolar_pasajero(pasajero);
            System.out.println("Sin asientos, pasajero asignado a la cola de espera");
        }
    }

    public void cancelarReserva(Vuelo vuelo, int numero_reserva){
        Reserva_vuelos reserva = vuelo.getReservasDiccionario().recuperar_reserva(numero_reserva);

        if(reserva == null){
            System.out.println("La reserva no existe");
            return;
        }

        vuelo.getReservasDiccionario().eliminar_reserva(numero_reserva);

        if(!vuelo.getColaDeEsperaCola().cola_vacia()){
            Pasajero pasajeroEnEspera = vuelo.getColaDeEsperaCola().primer_pasajero();
            vuelo.getColaDeEsperaCola().desacolar_pasajero();
            vuelo.getReservasDiccionario().agregar_reservas(proximoNumeroReserva, pasajeroEnEspera, vuelo);
            System.out.println("Reserva cancelada y asiento reasignado al primer pasajero en espera");
            System.out.println("Nuevo numero de reserva: " + proximoNumeroReserva);
            proximoNumeroReserva++;
        } else {
            vuelo.setCantidad_asientos(vuelo.getCantidad_asientos() + 1);
            System.out.println("Reserva cancelada");
        }
    }

    public Reserva_vuelos buscarReserva(Vuelo vuelo, int numero_reserva){
        return vuelo.getReservasDiccionario().recuperar_reserva(numero_reserva);
    }





}
