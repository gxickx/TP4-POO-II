package modelos.escenario2;

public class GeneradorDeReporteFiscalFacade {
    // instanciamos los subsistemas
    private final ConectorDB db;
    private final LectorDeDatos lector;
    private final ServicioWebAFIP afip;
    private final ProcesadorDeImpuestos procesador;
    private final RenderizadorPDF renderizador;

    public GeneradorDeReporteFiscalFacade() 
    {
        this.db = new ConectorDB();
        this.lector = new LectorDeDatos();
        this.afip = new ServicioWebAFIP();
        this.procesador = new ProcesadorDeImpuestos();
        this.renderizador = new RenderizadorPDF();
    }


    public void generarReporteCompleto(int idCliente) 
    {
        System.out.println("\nGenerando Reporte para Cliente ID: " + idCliente);
        try 
        {
            // hacemos los seis pasos de forma simplificada
            // el try lo agrego suponiendo que si estuviera desarrollado de verdad,
            // se tendría que intentar conectar a la BD y si pasa algo agarrar el error
            db.conectar();
            String cuit = lector.obtenerCuit(idCliente);
            afip.autenticarse();
            String datosFiscales = afip.obtenerDatosFiscales(cuit);
            double montoFinal = procesador.calcularMontos(datosFiscales);
            renderizador.generarReporte(montoFinal);
        
        }
        catch (Exception e) 
        {
            System.out.println("Ocurrió un error al generar el reporte: " + e.getMessage());
        }
        finally 
        {
            db.desconectar();
        }
    }
}

