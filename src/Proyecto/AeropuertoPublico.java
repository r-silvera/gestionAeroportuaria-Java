
package Proyecto;

public class AeropuertoPublico extends Aeropuerto{
    private double subvención;

    public AeropuertoPublico(String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
    }

    public AeropuertoPublico(double subvención, String nombre, String ciudad, String pais, Compañia[] c) {
        super(nombre, ciudad, pais, c);
        this.subvención = subvención;
    }

    public AeropuertoPublico(double subvención, String nombre, String ciudad, String pais) {
        super(nombre, ciudad, pais);
        this.subvención = subvención;
    }

    public double getSubvención() {
        return subvención;
    }
    
    
}
