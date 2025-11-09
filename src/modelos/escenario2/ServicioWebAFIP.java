package modelos.escenario2;

public class ServicioWebAFIP {
    public void autenticarse() {
        System.out.println("Autenticando con credenciales fiscales...");
        // acá se obtendría un token de sesión
    }

    public String obtenerDatosFiscales(String cuit) {
        System.out.println("Recuperando datos fiscales para el cuit " + cuit +".");
        // devolvería datos 
        return "{'ingresos': 100000, 'deducciones': 20000}";
    }
}
