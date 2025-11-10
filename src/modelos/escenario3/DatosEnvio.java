package modelos.escenario3;

public class DatosEnvio {
    private String idPedido;
    private String direccion;
    private String codigoPostal;

    public DatosEnvio(String idPedido, String direccion, String codigoPostal) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getIdPedido() { return idPedido; }
    public String getDireccion() { return direccion; }
    public String getCodigoPostal() { return codigoPostal; }

}
