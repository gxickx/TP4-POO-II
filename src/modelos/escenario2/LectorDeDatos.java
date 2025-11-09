package modelos.escenario2;

public class LectorDeDatos {
    public String obtenerCuit(int idCliente) {
        System.out.println("Leyendo cuit del cliente ID: " + idCliente);
        // vamos a fingir que se leyó este Cuit muy bonito 
        return "23-46124800-4";
    }
}
