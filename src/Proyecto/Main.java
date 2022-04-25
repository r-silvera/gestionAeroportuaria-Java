
package Proyecto;

import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    final static int num = 4; //Número de aeropuerto
    static Aeropuerto aero[] = new Aeropuerto[num];
    
    
    
    public static void main(String[] args){
        
        //Insertar datos de los aeropuertos
        insertarDatosAeropuerto(aero);
        menu();
    }
    
    public static void insertarDatosAeropuerto(Aeropuerto aero[]){
        aero[0] = new AeropuertoPublico(80000000, "Jorge Chavez", "Lima", "Peru");
        aero[0].insertarCompanía(new Compañia("AeroPeru"));
        aero[0].insertarCompanía(new Compañia("LATAM"));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB20","Lima","Mexico",150.90,150));
        aero[0].getCompañia("AeroPeru").insertarVuelo(new Vuelo("IB21","Lima","Buenos Aires",180.99,120));
        aero[0].getCompañia("LATAM").insertarVuelo(new Vuelo("FC12", "Lima", "Londres", 500.90, 180));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Alejandro", "20BGHP", "Peruana"));
        aero[0].getCompañia("AeroPeru").getVuelo("IB20").insertarPasajero(new Pasajero("Maria", "PJKL20", "Mexicana"));
        aero[0].getCompañia("LATAM").getVuelo("FC12").insertarPasajero(new Pasajero("Raul", "JH21K1", "Peruana"));
       
        aero[1] = new AeropuertoPublico(50000000,"Ministro Pistarini", "Ezeiza", "Argentina");
        aero[1].insertarCompanía(new Compañia("Aerolineas Argentina"));
        aero[1].insertarCompanía(new Compañia("Austral"));
        aero[1].getCompañia("Aerolineas Argentina").insertarVuelo(new Vuelo("IB22","Buenos Aires", "Rio de Janeiro",145.80,140));
        aero[1].getCompañia("Aerolineas Argentina").insertarVuelo(new Vuelo("IB23","Buenos Aires", "Paris",400.50,110));
        aero[1].getCompañia("Aerolineas Argentina").insertarVuelo(new Vuelo("IB24","Buenos Aires", "Los Angeles",350,130));
        aero[1].getCompañia("Austral").insertarVuelo(new Vuelo("FC13", "Buenos Aires", "Lima", 190.99, 130));
        aero[1].getCompañia("Austral").insertarVuelo(new Vuelo("FC14", "Buenos Aires", "Mexico", 250.60, 140));
        aero[1].getCompañia("Aerolineas Argentina").getVuelo("IB24").insertarPasajero(new Pasajero("Robertino", "TY25GH", "Argentina"));
        aero[1].getCompañia("Aerolineas Argentina").getVuelo("IB23").insertarPasajero(new Pasajero("Roberto", "NF77KB", "Uruguaya"));
        aero[1].getCompañia("Aerolineas Argentina").getVuelo("IB24").insertarPasajero(new Pasajero("Franco", "ZS36CA", "Argentina"));
        aero[1].getCompañia("Aerolineas Argentina").getVuelo("IB22").insertarPasajero(new Pasajero("Myriam", "H69KOP", "Argentina"));
        
        aero[2] = new AeropuertoPrivado("MPS", "Marcos Paz", "Argentina");
        aero[2].insertarCompanía(new Compañia("PRV Aerolineas"));
        String empresas[] = {"Cobresol","Anguila34"};
        ((AeropuertoPrivado)aero[2]).insertarEmpresas(empresas);
        aero[2].getCompañia("PRV Aerolineas").insertarVuelo(new Vuelo("AE025", "Madrid", "Buenos Aires", 560.80, 100));
        aero[2].getCompañia("PRV Aerolineas").getVuelo("AE025").insertarPasajero(new Pasajero("Brisa", "G7JK28", "Argentina"));
        
        aero[3] = new AeropuertoPublico(90500000,"El Palomar", "Palomar", "Argentina");
        aero[3].insertarCompanía(new Compañia("AirAmerica"));
        aero[3].getCompañia("AirAmerica").insertarVuelo(new Vuelo("IB25","Buenos Aires", "Venecia",700.80,130));
        aero[3].getCompañia("AirAmerica").insertarVuelo(new Vuelo("IB26","Buenos Aires", "New York",650.50,135));
        aero[3].getCompañia("AirAmerica").getVuelo("IB25").insertarPasajero(new Pasajero("Lucas", "3RTJU8", "Argentina"));

    }
    
    public static void menu(){
        int opción;
        String nombreAeropuerto, nombreCompañia, origen, destino;
        Aeropuerto aeropuerto;
        Compañia compañia;

        do{
            System.out.println("\t.:MENU:.");
            System.out.println("1. Ver Aeropuertos gestionados(Publicos o privados)");
            System.out.println("2. Ver empresas(Privado) o subvención(Publico)");
            System.out.println("3. Lista de compañia de un Aeropuerto");
            System.out.println("4. Lista de vuelos por compañia");
            System.out.println("5. Listar posibles vuelos de Origen a Destino");
            System.out.println("6. Salir");
            System.out.print("Opción: ");
            opción = entrada.nextInt();
            
            switch(opción){
                case 1: System.out.println(""); 
                    mostrarDatosAeropuertos(aero);
                    break;
                case 2: System.out.println("");
                    mostrarPatrocinio(aero);
                    break;
                case 3: entrada.nextLine();
                    System.out.print("Digite el nombre del aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aero);
                    if(aeropuerto == null){
                        System.out.println("El aeropuerto no existe");
                    }
                    else{
                        mostrarCompañias(aeropuerto);
                    }
                    break;
                case 4: entrada.nextLine();
                    System.out.print("Digite el nombre del aeropuerto: ");
                    nombreAeropuerto = entrada.nextLine();
                    aeropuerto = buscarAeropuerto(nombreAeropuerto, aero);
                    if(aeropuerto == null){
                        System.out.println("El aeropuerto no existe");
                    }
                    else{
                        System.out.print("Digite el nombre de la compañia: ");
                        nombreCompañia = entrada.nextLine();
                        compañia = aeropuerto.getCompañia(nombreCompañia);
                        mostrarVuelos(compañia);
                    }
                    break;
                case 5: entrada.nextLine();
                    System.out.print("\nDigite la ciudad origen: ");
                    origen = entrada.nextLine();
                    System.out.print("Digte la ciudad destino: ");
                    destino = entrada.nextLine();
                    mostrarVueloDeOrigenADestino(origen, destino, aero);
                    break;
                case 6: break;
                default: System.out.println("\nError, opción del menu incorrecta...");
            }
            System.out.println("");
        }while(opción != 6);
    }
    
    public static void mostrarDatosAeropuertos(Aeropuerto aeropuertos[]){
        int indice = 0;
        System.out.println("\tAeropuertos Publicos:");    
        for (int i = 0; i < aeropuertos.length; i++) {
                if(aeropuertos[i] instanceof AeropuertoPublico){
                    System.out.println("Aeropuerto "+(indice+1)+"...");
                    System.out.println("Nombre: "+aeropuertos[i].getNombre());
                    System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                    System.out.println("Pais: "+aeropuertos[i].getPais());
                    indice++;
                }
                System.out.println("");
        }
        
        System.out.println("\tAeropuertos Privados: ");{
        indice = 0;
        for (int i = 0; i < aeropuertos.length; i++) {
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                    System.out.println("Aeropuerto "+(indice+1)+"...");
                    System.out.println("Nombre: "+aeropuertos[i].getNombre());
                    System.out.println("Ciudad: "+aeropuertos[i].getCiudad());
                    System.out.println("Pais: "+aeropuertos[i].getPais());
                    indice++;
                }
            System.out.println("");
            }
        }
    }
    public static void mostrarPatrocinio(Aeropuerto aeropuertos[]){
        String empresas[];
        for (int i = 0; i < aeropuertos.length; i++) {
            if(aeropuertos[i] instanceof AeropuertoPrivado){
                System.out.println("Aeropuerto privado: "+aeropuertos[i].getNombre());
                empresas = ((AeropuertoPrivado)aeropuertos[i]).getListaEmpresas();
                System.out.println("Las empresas son: ");
                for (int j = 0; j < empresas.length; j++) {
                    System.out.println(empresas[j]);
                }
            }
            else{
                System.out.println("Aeropuerto publico: "+aeropuertos[i].getNombre());
                System.out.println("Subvención: "+((AeropuertoPublico)aeropuertos[i]).getSubvención());
            }
            System.out.println("");
        }
    }
    public static Aeropuerto buscarAeropuerto(String nombreAeropuerto, Aeropuerto aeropuertos[]){
        boolean encontrado = false;
        int i = 0;
        Aeropuerto aero = null;
        
        while((!encontrado) && (i<aeropuertos.length)){
            if(nombreAeropuerto.equals(aeropuertos[i].getNombre())){
                encontrado = true;
                aero = aeropuertos[i];
            }
            i++;
        }
        return aero;
    }
    public static void mostrarCompañias(Aeropuerto aeropuerto){
        System.out.println("\nLas compañias del aeropuerto: "+aeropuerto.getNombre());
         for (int i = 0; i < aeropuerto.getNúmeroCompañias(); i++) {
             System.out.println(aeropuerto.getCompañia(i).getNombre());
        }
    }
    public static void mostrarVuelos(Compañia compañia){
        Vuelo vuelo;
        System.out.println("");
        System.out.println("Los vuelos de la compañia: "+compañia.getNombre());
        for (int i = 0; i < compañia.getNúmeroVuelo(); i++) {
            vuelo = compañia.getVuelo(i);
            System.out.println("");
            System.out.println("Identificador: "+vuelo.getIdentificador());
            System.out.println("Ciudad Origen: "+vuelo.getCiudadOrigen());
            System.out.println("Ciudad Destino: "+vuelo.getCiudadDestino());
            System.out.println("Precio: $"+vuelo.getPrecio());
        }
    }
    
    public static Vuelo[] buscarVuelosOrigenDestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelo;
        int contador = 0;
        Vuelo listaVuelos[];
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNúmeroCompañias(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNúmeroVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if((origen.equals(vuelo.getCiudadOrigen()))&&(destino.equals(vuelo.getCiudadDestino()))){
                        contador++;
                    }
                }
            }
        }
        listaVuelos = new Vuelo[contador];
        int q = 0;
        for (int i = 0; i < aeropuertos.length; i++) {
            for (int j = 0; j < aeropuertos[i].getNúmeroCompañias(); j++) {
                for (int k = 0; k < aeropuertos[i].getCompañia(j).getNúmeroVuelo(); k++) {
                    vuelo = aeropuertos[i].getCompañia(j).getVuelo(k);
                    if((origen.equals(vuelo.getCiudadOrigen())) && (destino.equals(vuelo.getCiudadDestino()))){
                        listaVuelos[q] = vuelo;
                        q++;
                    }
                }
            }
        }
        return listaVuelos;
    }
    
    public static void mostrarVueloDeOrigenADestino(String origen, String destino, Aeropuerto aeropuertos[]){
        Vuelo vuelos[];
        vuelos = buscarVuelosOrigenDestino(origen, destino, aeropuertos);
        if(vuelos.length == 0){
            System.out.println("No existen vuelos de esa ciudad origen a destino");
        }
        else{
            System.out.println("\nVuelos encontrados: ");
            for (int i = 0; i < vuelos.length; i++) {
                System.out.println("Identificador"+vuelos[i].getIdentificador());
                System.out.println("Ciudad Origen"+vuelos[i].getCiudadOrigen());
                System.out.println("Ciudad Destino"+vuelos[i].getCiudadDestino());
                System.out.println("Precio: $"+vuelos[i].getPrecio());
                System.out.println("");
            }
        }
    }
}