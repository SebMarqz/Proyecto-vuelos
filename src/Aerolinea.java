public class Aerolinea {

    private Vuelos_cojunto vuelos; //Guarda el conjunto de vuelos cargados en el sistema.
    private Pasajeros_interfaz pasajeros; //Guarda los pasajeros registrados.
    private int proximoNumeroReserva; //Genera numeros de reserva automaticos
    private int proximoIdVuelo; //Sirve para generar IDs unicos para cada vuelo

    public Aerolinea() {

    }

    public boolean existePasajero(int pasaporte) {
        return buscarPasajero(pasaporte) != null;
    }

    // Inicializa la aerolinea con la estructura de vuelos y crea la lista de pasajeros.
    public Aerolinea(Vuelos_cojunto vuelos){
        this.vuelos=vuelos; //Guarda la referencia a vuelos
        this.pasajeros = new Pasajeros_enlazados(); //Crea la lisla de pasajeros
        this.pasajeros.InicializarLista(); //Inicializa esa lista
        this.proximoNumeroReserva = 1; //Arranca el numero de reserva en 1
        this.proximoIdVuelo = 1; //Arranca el ID de vuelo en 1

    }

    //METODOS PASAJERO: Registra un pasajero en la estructura de pasajeros.
    public void registrarPasajero(Pasajero pasajero) {
        if (pasajero == null) {
            System.out.println("El pasajero es invalido");
            return;
        }
        if (existePasajero(pasajero.getPasaporte())) {
            System.out.println("Ya existe un pasajero con ese pasaporte");
            return;
        }
        pasajeros.AgregarPasajero(pasajero);
        System.out.println("Pasajero registrado");
    }

    // Elimina un pasajero buscando por su pasaporte.
    public void eliminarPasajero(int pasaporte){
        pasajeros.EliminarPasajero(pasaporte);
    }

    // Busca y devuelve un pasajero segun su pasaporte.
    public Pasajero buscarPasajero(int pasaporte){
        return pasajeros.BuscarPasajero(pasaporte);
    }



    //METODOS DE VUELO

    // Crea un vuelo nuevo con ID automatico y lo agrega al conjunto de vuelos.
    public void agregarVuelo(int cantidad_asientos, String origen, String destino, String fecha, String hora){
        Vuelo vuelo = new Vuelo(proximoIdVuelo, cantidad_asientos, origen, destino, fecha, hora);
        vuelos.agregar_vuelo(vuelo); //lo agrega al conjunto de vuelos
        System.out.println("Vuelo agregado con id: " + proximoIdVuelo); //Muestra el ID generado
        proximoIdVuelo++; //Incrementa
    }

    // Agrega al sistema un vuelo ya creado.
    public void agregarVuelo(Vuelo vuelo){
        vuelos.agregar_vuelo(vuelo);
    }

    // Elimina un vuelo del conjunto de vuelos.
    public void eliminarVuelo(Vuelo vuelo){
        if (!vuelo.getReservasDiccionario().reservas_vacias()) {
            System.out.println("No se puede eliminar el vuelo porque tiene reservas activas");
            return;
        }

        if (!vuelo.getColaDeEsperaCola().cola_vacia()) {
            System.out.println("No se puede eliminar el vuelo porque tiene pasajeros en cola de espera");
            return;
        }

        vuelos.sacar_vuelo(vuelo);
        System.out.println("Vuelo eliminado");
    }

    // Devuelve el vuelo mas reciente segun fecha y hora.
    public Vuelo consultarUltimoVuelo(){
        if (vuelos.vuelo_vacio()) {
            return null;
        }

        Vuelo ultimo = vuelos.conjunto_vuelos[0];
        int i = 1;

        while (i < vuelos.indice) {
            if (esPosterior(vuelos.conjunto_vuelos[i], ultimo)) {
                ultimo = vuelos.conjunto_vuelos[i];
            }
            i++;
        }

        return ultimo;
    }

    private boolean esPosterior(Vuelo vuelo1, Vuelo vuelo2){
        int anio1 = Integer.parseInt(vuelo1.getFecha().substring(6, 10));
        int anio2 = Integer.parseInt(vuelo2.getFecha().substring(6, 10));

        if(anio1 != anio2){
            return anio1 > anio2;
        }

        int mes1 = Integer.parseInt(vuelo1.getFecha().substring(3, 5));
        int mes2 = Integer.parseInt(vuelo2.getFecha().substring(3, 5));

        if(mes1 != mes2){
            return mes1 > mes2;
        }

        int dia1 = Integer.parseInt(vuelo1.getFecha().substring(0, 2));
        int dia2 = Integer.parseInt(vuelo2.getFecha().substring(0, 2));

        if(dia1 != dia2){
            return dia1 > dia2;
        }

        int hora1 = Integer.parseInt(vuelo1.getHora().substring(0, 2));
        int hora2 = Integer.parseInt(vuelo2.getHora().substring(0, 2));

        if(hora1 != hora2){
            return hora1 > hora2;
        }

        int minuto1 = Integer.parseInt(vuelo1.getHora().substring(3, 5));
        int minuto2 = Integer.parseInt(vuelo2.getHora().substring(3, 5));

        return minuto1 > minuto2;
    }

    // Busca un vuelo por su ID.
    public Vuelo buscarVuelo(int idVuelo){
        return vuelos.buscar_vuelo(idVuelo);
    }

    // Devuelve el primer pasajero en la cola de espera del vuelo.
    public Pasajero verColaEsperaDeVuelo(Vuelo vuelo){
        return vuelo.getColaDeEsperaCola().primer_pasajero();
    }

    //METODOS RESERVA

    // Reserva un pasaje si hay asientos; si no, agrega al pasajero a la cola de espera.
    public void reservarPasaje(Vuelo vuelo, Pasajero pasajero){
        if(vuelo.getCantidad_asientos() > 0){ // CASO 1. Si hay asientos:
            vuelo.getReservasDiccionario().agregar_reservas(proximoNumeroReserva, pasajero, vuelo); //agrega la reserva al diccionario del vuelo
            vuelo.setCantidad_asientos(vuelo.getCantidad_asientos() - 1); //Descuenta 1 asiento
            System.out.println("Reserva realizada. Numero de reserva: " + proximoNumeroReserva); //informa el numero de reserva
            proximoNumeroReserva++; //incrementa
        } else { // CASO 2. Si NO hay asientos:
            vuelo.getColaDeEsperaCola().acolar_pasajero(pasajero); //Manda al pasajero a la cola de espera del vuelo
            System.out.println("Sin asientos, pasajero asignado a la cola de espera");
        }
    }

    // Cancela una reserva y reasigna el asiento al primer pasajero en espera si corresponde.
    public void cancelarReserva(Vuelo vuelo, int numero_reserva){
        Reserva_vuelos reserva = vuelo.getReservasDiccionario().recuperar_reserva(numero_reserva); //busca la reserva en el diccionario del vuelo

        if(reserva == null){ //si no existe reserva, informa error
            System.out.println("La reserva no existe");
            return;
        }
        //si existe: La elimina
        vuelo.getReservasDiccionario().eliminar_reserva(numero_reserva);

        if(!vuelo.getColaDeEsperaCola().cola_vacia()){ //Si hay pasajeros en espera: Toma el primero de la cola (103/104)
            Pasajero pasajeroEnEspera = vuelo.getColaDeEsperaCola().primer_pasajero();
            vuelo.getColaDeEsperaCola().desacolar_pasajero();
            vuelo.getReservasDiccionario().agregar_reservas(proximoNumeroReserva, pasajeroEnEspera, vuelo); //crea una nueva reserva para esa persona
            System.out.println("Reserva cancelada y asiento reasignado al primer pasajero en espera");
            System.out.println("Nuevo numero de reserva: " + proximoNumeroReserva);
            proximoNumeroReserva++;
        } else { //si no hay nadie en espera:
            vuelo.setCantidad_asientos(vuelo.getCantidad_asientos() + 1); //Suma un asiento al vuelo
            System.out.println("Reserva cancelada");
        }
    }
    // Busca una reserva por numero dentro del vuelo indicado.
    public Reserva_vuelos buscarReserva(Vuelo vuelo, int numero_reserva){
        return vuelo.getReservasDiccionario().recuperar_reserva(numero_reserva);
    }





}