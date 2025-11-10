package modelos.escenario1;

public class ServicioInstalacion extends ExtraDecorador{
    public ServicioInstalacion(ComponentesPC componenteEnvuelto) {
        super(componenteEnvuelto);
    }
    public double getPrecio() {
        double precio = super.getPrecio();
        return precio + 50;
    }
}