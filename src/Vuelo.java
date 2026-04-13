public class Vuelo {
   private int Id_vuelo;
   private int cantidad_asientos;
   private String origen;
   private String destino;
   private String fecha;
   private String hora;
   private ColaDeEspera_cola colaDeEsperaCola;
   private Reservas_Diccionario reservasDiccionario;


   public Vuelo(int Id_vuelo ,int cantidad_asientos, String origen, String destino, String fecha, String hora) {
        this.Id_vuelo=Id_vuelo;
        this.cantidad_asientos = cantidad_asientos;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.hora = hora;
        this.colaDeEsperaCola=new ColaDeEspera_cola();
        colaDeEsperaCola.inicializar_cola();
        this.reservasDiccionario=new Reservas_Diccionario();
        reservasDiccionario.inicializador_diccionario();

   }

    public int getId_vuelo() {
        return Id_vuelo;
    }

    public void setId_vuelo(int id_vuelo) {
        Id_vuelo = id_vuelo;
    }

    public int getCantidad_asientos() {
        return cantidad_asientos;
    }

    public void setCantidad_asientos(int cantidad_asientos) {
        this.cantidad_asientos = cantidad_asientos;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public ColaDeEspera_cola getColaDeEsperaCola() {
        return colaDeEsperaCola;
    }

    public Reservas_Diccionario getReservasDiccionario(){return reservasDiccionario;}
}
