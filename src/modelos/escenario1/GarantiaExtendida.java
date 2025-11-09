package escenario1;

public class GarantiaExtendida extends ExtraDecorador {

    public GarantiaExtendida(ComponentesPC componenteEnvuelto) {
        super(componenteEnvuelto);
    }

    @Override
    public double getPrecio() {
        double precio = super.getPrecio();
        return precio * 1.10;
    }

}