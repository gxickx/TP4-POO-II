package escenario1;
public abstract class ExtraDecorador implements ComponentesPC {

    // Atributo para saber a quién está "envolviendo"
    protected ComponentesPC componenteEnvuelto;

    public ExtraDecorador(ComponentesPC componenteEnvuelto) {
        this.componenteEnvuelto = componenteEnvuelto;
    }

    @Override
    public double getPrecio() {
        return componenteEnvuelto.getPrecio();
    }
}