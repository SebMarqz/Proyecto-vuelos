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
        return conjunto_vuelos[0];
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
