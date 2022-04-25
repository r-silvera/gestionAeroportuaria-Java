
package Proyecto;

public class Vuelo {
    private String identificador;
    private String ciudadOrigen;
    private String ciudadDestino;
    private double precio;
    private int númeroMaxPasajero;
    private int númeroActualPasajeros;
    private Pasajero listaPasajeros[];

    public Vuelo(String identificador, String ciudadOrigen, String ciudadDestino, double precio, int númeroMaxPasajero) {
        this.identificador = identificador;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.precio = precio;
        this.númeroMaxPasajero = númeroMaxPasajero;
        this.númeroActualPasajeros = 0;
        this.listaPasajeros = new Pasajero[númeroMaxPasajero];
    }
    
    public void insertarPasajero(Pasajero pasajero){
        listaPasajeros[númeroActualPasajeros] = pasajero;
        númeroActualPasajeros++;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNúmeroMaxPasajero() {
        return númeroMaxPasajero;
    }

    public int getNúmeroActualPasajeros() {
        return númeroActualPasajeros;
    }
    
    public Pasajero getPasajero(int i){
        return listaPasajeros[i];
    }
    
    public Pasajero getPasajero(String pasaporte){
        boolean encontrado = false;
        int i = 0;
        Pasajero pasajero = null;
        while((encontrado == false)&&(i<listaPasajeros.length)){
            if(pasaporte == listaPasajeros[i].getPasaporte()){
                encontrado = true;
                pasajero = listaPasajeros[i];
            }
            i++;
        }
        return pasajero;
    }
}
