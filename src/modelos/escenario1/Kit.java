package escenario1;
import java.util.ArrayList;
import java.util.List;

public class Kit implements ComponentesPC {

    private string nombre;
    private double precio;
    private List<ComponentesPC> componentes = new ArrayList<>();

    public Kit(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    public void agregar(ComponentesPC componente) {
        this.componentes.add(componente);
    }

    public void remover(ComponentesPC componente) {
        this.componentes.remove(componente);
    }

    @Override
    public double getPrecio() {

        double total = this.precio;

        for (ComponentesPC componente : componentes) {
            total += componente.getPrecio();
        }

        return total;

}