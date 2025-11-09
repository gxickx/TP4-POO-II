import modelos.escenario2.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Escenario 1




        // Escenario 2: Módulo de Generación de Reportes 
        var generadorReporte = new GeneradorDeReporteFiscalFacade();
        // Generamos un reporte de los datos fiscales de un cliente con id 777
        generadorReporte.generarReporteCompleto(777);
        // Y listo. El usuario solo interactuaría con esta parte del código en una única interfaz. El resto estaría oculto.
    }
}
