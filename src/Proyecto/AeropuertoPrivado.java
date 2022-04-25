    
package Proyecto;

public class AeropuertoPrivado extends Aeropuerto{
    private String listaEmpresas[] = new String[10];
    private int númeroEmpresas;

    public AeropuertoPrivado(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPrivado(String nombre, String ciudad, String pais, Compañia[] c,String e[]) {
        super(nombre, ciudad, pais, c);
        this.listaEmpresas = e;
        númeroEmpresas = e.length;
    }
    
    public void insertarEmpresas(String e[]){
        this.listaEmpresas = e;
        this.númeroEmpresas = e.length;
    }
    
    public void insertarEmpresa(String e){
        listaEmpresas[númeroEmpresas] = e;
        númeroEmpresas++;
    }

    public String[] getListaEmpresas() {
        return listaEmpresas;
    }

    public int getNúmeroEmpresas() {
        return númeroEmpresas;
    }
    
    
}
