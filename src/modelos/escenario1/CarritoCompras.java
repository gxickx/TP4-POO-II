package modelos.escenario1;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<ComponentesPC> items = new ArrayList<>();

    public void agregarItem(ComponentesPC item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ComponentesPC item : this.items){
            total += item.getPrecio();
        }
        return total;
    }



}