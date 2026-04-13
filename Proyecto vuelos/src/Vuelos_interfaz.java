public interface Vuelos_interfaz {


    void inicializar_conjunto();

    void agregar_vuelo(Vuelo x);

    void sacar_vuelo(Vuelo x);

    Vuelo elegir_vuelo();

    boolean vuelo_vacio();

    Vuelo buscar_vuelo(int Id_vuelo);


}
