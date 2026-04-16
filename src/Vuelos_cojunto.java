public class Vuelos_cojunto implements Vuelos_interfaz  {

    public int indice;
    public Vuelo[] conjunto_vuelos;

    public void inicializar_conjunto(){
        conjunto_vuelos=new Vuelo[100];
        indice=0;

    }

    public void agregar_vuelo(Vuelo x){
        if(indice < conjunto_vuelos.length){
            if(!this.pertenece(x)) {
                conjunto_vuelos[indice] = x;
                indice++;
            }
        } else {
            System.out.println("No se pueden agregar más vuelos");
        }
    }

    public boolean pertenece(Vuelo x){
        int i = 0;

        while(i < indice && conjunto_vuelos[i].getId_vuelo() != x.getId_vuelo()){
            i++;
        }
        return (i < indice);
    }

    public void sacar_vuelo(Vuelo x){
        int i=0;
        while(i<indice&&conjunto_vuelos[i]!=x)
            i++;
        if(i<indice){
            conjunto_vuelos[i]=conjunto_vuelos[indice-1];
            indice--;
        }

    }

    public Vuelo elegir_vuelo(){

        if(vuelo_vacio()){
            return null;
        }

        Vuelo ultimo = conjunto_vuelos[0];
        int i = 1;

        while(i < indice){
            if(esPosterior(conjunto_vuelos[i], ultimo)){
                ultimo = conjunto_vuelos[i];
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

    public boolean vuelo_vacio(){
        return(indice == 0);
    }

    public Vuelo buscar_vuelo(int idVuelo){
        int i = 0;

        while(i < indice && conjunto_vuelos[i].getId_vuelo() != idVuelo){
            i++;
        }

        if(i < indice){
            return conjunto_vuelos[i];
        }

        return null;
    }


}
