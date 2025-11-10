
import modelos.escenario1.*;
import modelos.escenario2.*;
import modelos.escenario3.*;


public class App {
    public static void main(String[] args) throws Exception {
        // Escenario 1
        // Primero creamos algunos componentes
        ComponentesPC ram = new Hoja("Memoria RAM 32GB", 34000.00);
        ComponentesPC cpu = new Hoja("Intel i5 13420X", 90500.00);
        ComponentesPC monitor = new Hoja("Monitor 144HZ", 170500.00);

        // Creación de un kit, luego agregamos los componentes al kit (las hojas)
        Kit kitPCGamer = new Kit("PC Super gamer", 15000.00); // precio base de 15000.00 por el gabinete
        kitPCGamer.agregar(ram);
        kitPCGamer.agregar(cpu);

        //Creacion del carrito de compras y agregamos componentes
        CarritoCompras carrito = new CarritoCompras();
        carrito.agregarItem(monitor);

        // agregamos una pc gamer con garantía e instalacion
        ComponentesPC kitGamerGarantía = new GarantiaExtendida(kitPCGamer);
        ComponentesPC kitGamerCompleto = new ServicioInstalacion(kitGamerGarantía);

        carrito.agregarItem(kitGamerCompleto);

        //finalmente, calculamos el total del carrito
        double total = carrito.calcularTotal();
        System.out.printf("El total del carrito es: $%.2f%n", total);



        // Escenario 2: Módulo de Generación de Reportes
        var generadorReporte = new GeneradorDeReporteFiscalFacade();
        // Generamos un reporte de los datos fiscales de un cliente con id 777
        generadorReporte.generarReporteCompleto(777);
        // Y listo. El usuario solo interactuaría con esta parte del código en una única interfaz. El resto estaría oculto.
    }
}
