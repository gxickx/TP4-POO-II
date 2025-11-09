package escenario1;

public class Hoja implements ComponentesPC{
    private String nombre;
    private double precio;

    public Hoja(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
}