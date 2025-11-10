package modelos.escenario3;

public class ApiLogisticaVeloz {

    public Cotizacion cotizarEnvio(int cpDestino) {
            // Lógica interna... supongamos que calcula basado en el CP
            float costo = 150.50f + (cpDestino % 100);
            int dias = (cpDestino < 5000) ? 2 : 4;

            System.out.println("[ApiVeloz] Cotizando para CP: " + cpDestino + ". Total: $" + costo + ", Días: " + dias);
            return new Cotizacion(costo, dias);
        }

        public String enviarPaquete(DatosEnvio datos) {
            System.out.println("[ApiVeloz] Despachando pedido: " + datos.getIdPedido() + " a " + datos.getDireccion());
            return "LV-987654321"; // devuelve un id
        }
    }

