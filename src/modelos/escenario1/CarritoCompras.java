package escenario1;
import java.util.ArrayList;
import java.util.List;

public class CarritoCompras {
    private List<ComponentePC> items = new ArrayList<>();

    public void agregarItem(ComponentesPC item) {
        this.items.add(item);
    }

    public double calcularTotal() {
        double total = 0;
        for (ComponentesPC item : this.items){
            totao += item.getPrecio();
        }
    }



}