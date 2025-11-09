package modelos.escenario2;

public class ProcesadorDeImpuestos {
    public double calcularMontos(String datosFiscalesJson) {
        System.out.println("Calculando impuestos basados en: " + datosFiscalesJson);
        // acá se haría un cálculo. Para el ejemplo, hardcodeamos los datos.
        return 100000 * 0.21 - 5000; 
    }
}
