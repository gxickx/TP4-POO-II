package modelos.escenario3;

public class LogisticaVelozAdapter implements IServicioEnvio{
    private ApiLogisticaVeloz apiVeloz;

    // Se agregan dos variables de cache para evitar llamar dos veces a la api
    private Cotizacion cacheCotizacion;
    private String cacheCodigoPostal;

    // Constructor
    public LogisticaVelozAdapter(ApiLogisticaVeloz apiVeloz) {
        this.apiVeloz = apiVeloz;
    }


    private Cotizacion cotizar(String codigoPostal) {
        // comprobamos si el codigo postal es vacio o es distinto al que tenemos guardado en cache
        if (cacheCodigoPostal == null || !cacheCodigoPostal.equals(codigoPostal)) {
            System.out.println("-> Llamando a la API (Sin caché)");
            // Se convierte el CP a entero
            int cp = Integer.parseInt(codigoPostal);
            // llamamos a la api y guardamos el objeto Cotización en cacheCotizacion
            this.cacheCotizacion = apiVeloz.cotizarEnvio(cp);
            // y se guarda el contexto (la cotización es para este código postal)
            this.cacheCodigoPostal = codigoPostal;
        } else {
            // si el if es falso, estamos utilizando la cache de cotización
            System.out.println("-> Utilizando cache");
        }
        //devolvemos la cotización que esté en memoria
        return this.cacheCotizacion;
    }

    //metodos publicos que el cliente (ecommerce) si ve

    @Override
    public float calcularCosto(String codigoPostal) {
        System.out.println("[Adapter] Petición de 'calcularCosto'");
        return cotizar(codigoPostal).getCosto();
    }

    @Override
    public String obtenerTiempoEstimado(String codigoPostal) {
        System.out.println("[Adapter] Petición de 'obtenerTiempoEstimado'");
        int dias = cotizar(codigoPostal).getDias();
        return dias + " días";
    }

    // traducimos los datos que la API espera. Luego llama al metodo de la api y devuelve su respuesta
    @Override
    public String despacharPedido(String direccion, String codigoPostal, String idPedido) {
        System.out.println("[Adapter] Petición de 'despacharPedido'");
        DatosEnvio datos = new DatosEnvio(idPedido, direccion, codigoPostal);

        return apiVeloz.enviarPaquete(datos);
    }

}
