# Trabajo Práctico N°4 - Menacho Natalia A. & Roko María G.

El siguiente es el cuarto trabajo práctico de la materia de Programación Orientada a Objetos II de la carrera de Licenciatura en Sistemas de Información de la UNaM.

## Escenario 1: Sistema de Ensamblaje de Computadoras
### Análisis del escenario
1. Las principales clases que se identificaron en este escenario son:
    * `CarritoDeCompras` (Cliente): Es el carrito en el cual se almacenarán los componentes que el usuario quiera comprar. Su responsabilidad es almacenar una lista de productos y pedirles su precio total.
    * `Hojas` (Componentes simples): Su responsabilidad es conocer su precio base}
    * `Kits` (Componentes compuestos): Su responsabilidad es conocer su precio base mas la suma de los precios de todos los componentes.
    * `Extras`: Son modificadores de precio. Su responsabilidad es tomar un componente y devolver un precio modificado.

2. Problemas de rigidez, complejidad y acoplamiento
- **Problema 1 Tratar Hojas y Kits como iguales:** El problema nace a partir de que el `CarritoDeCompras` debe manejar a los componentes individuales y a los compuestos de la misma manera. Si el carrito tiene que calcular su total, para saber el precio de cada ítem, su código se ve forzado a preguntar el tipo de cada uno. Esto resulta **rígido** en el caso de que el administrador quiera agregar nuevos tipos de items, se deberá modificar el código de la clase, como además resulta **complejo** porque posee una lógica que no le pertenece y genera un **alto acoplamiento**.  
- **Problema 2 Añadir extras combinables:** El problema es que se tienen que poder agregar extras a un carrito y que se puedan combinar dos extras en un mismo componente. Si se quisiera implementar esto en código, surgiría complejidad y rigidez, dos problemas que debemos evitar

### Identificación del patrón

Para cada problema hallado, se identificaron los siguientes patrones estructurales:

* **Problema 1:** Patrón Composite

* **Problema 2:** Patrón Decorator

### Justificación de la elección
**Composite:** Se seleccionó el patrón compositor ya que se considera el indicado para resolver el requisito principal del escenario: que el `CarritoDeCompras` pueda tratar a las `Hojas` y `Kits` como iguales. Este patrón de diseño estructural permite componer objetos en estructuras de árbol, donde:
* **Las hojas** son objetos finales
* **Las ramas** son objetos que contienen otras Hojas u otros Componentes. (por ejemplo; un gabinete tiene una placa madre, y una placa madre contiene la memoria RAM y la CPU).

La finalidad de este patrón es que las hojas y las ramas implementen una interfaz común, que define una operación compartida (en este caso, sería para obtener precio). Esta interfaz común sería `ComponentesPC`, la cual tiene un método `getPrecio()` que contiene la lógica para obtener el precio en cada una de las hojas.

Esta implementación hace que el `CarritoDeCompras`(el cliente) no sepa si está tratando con una Hoja o un Kit. Además de eliminar la rigidez y complejidad, haciendo que CarritoDeCompras no esté acoplado a todas las clases concretas, viendose forzado a utilizar una lógica compleja de `if/else` o `switch` para determinar cómo calcular el precio de cada ítem.

**Decorator:** Se eligió este patrón a partir de la necesidad de poder agregar "extras" a cualquer componente, siendo estos también combinables. Se pueden agregar extras como no, este patrón permite que tengamos una composición dinámica, evitando rigidez y complejidad en el código. Para la implementacón de este patrón, se crean clases "Envoltorio" (`GarantiaExtendida` y `ServicioInstalacion`), ambas implementan también la anterior mencionada interfaz `ComponentesPC`. El decorador envuelve a un `ComponentePC` y modifica su comportamiento
* `GarantiaExtendida.getPrecio()`: Devuelve `componente_envuelto.getPrecio() * 1.10`
* `ServicioInstalacion.getPrecio()`: Devuelve `componente_envuelto.getPrecio() + 50`


## Escenario 2: Módulo de Generación de Reportes 
### Análisis del escenario
1. Las principales clases que se identificaron en este escenario son:
    * `ConectorDB`: Es la clase que nos permite establecer la conexión con la base de datos del sistema.
    * `ServicioWebAFIP`: Es la clase que permite al usuario obtener los datos fiscales de los clientes.
    * `ProcesadorDeImpuestos`: Tiene como responsabilidad procesar los datos fiscales de los clientes para calcular los impuestos que deben cobrárseles.
    * `RenderizadorPDF`: Es la clase encargada de generar el reporte fiscal a partir de los impuestos calculados.

    Por otra parte se cuenta con una clase `LectorDeDatos` que no es de uso exclusivo para este módulo pero se ve involucrada en el proceso.

2. Problemas de rigidez, complejidad y acoplamiento
- **Problema: El sistema es demasiado complejo.** Existe un gran problema acerca de la **complejidad** del proceso para generar un reporte. El usuario debe realizar numerosos pasos (conectarse a la DB, leer los datos, autenticarse en el servicio de la AFIP, obtener los datos que desea...) para poder generar un reporte. El proceso está **fuertemente acoplado** a cuatro clases, y se preferiría simplificar todo esto. 

### Identificación del patrón

Se identificó que para este escenario lo ideal es aplicar el patrón **Facade**.


### Justificación de la elección
Se eligió **Facade** ya que resulta la mejor opción para resolver este escenario. Este patrón nos permite simplicar los pasos requeridos para crear el reporte. Toda la lógica compleja será encapsulada por él. El usuario solo tendrá que interectuar con una clase (`GeneradorReporteFiscalFacade`) para poder realizar su tarea.

Asimismo, se podrá desacoplar al cliente de las clases internas del subsistema. Si en algún momento la implementación de cualquiera de estas clases cambia, solo se modificará la fachada y la interfaz del cliente permanecerá igual.




## Escenario 3: Integración de API de Logística 
### Análisis del escenario
1. Las principales clases que se determinaron son: 
    * `IServicioEnvio`(Interfaz Target): Es la interfaz que nuestro sistema de E-Commerce (el cliente) espera. Sus responsabilidades son `calcularCosto`, `obtenerTiempoEstimado` y `despacharPedido`. Todas operando con `String`
    * `ApiLogisticaVeloz`(Clase Adaptee): Clase externa, no modificable, que queremos utiilzar. Sus responsabilidades son `cotizarEnvio` y `enviarPaquete`.
    * `SistemaEcommerce` (Cliente): Es el sistema principal del escenario. No sabe ni debe saber nada sobre `ApiLogisticaVeloz`.

2. Los problemas identificados son:
     * **Incompatibilidad de interfaz:** Los nombres de los métodos son distintios. (`calcularCosto` y `cotizarEnvio`).
     * **Incompatibilidad de tipos de datos:** Para el código postal, la interfaz `Target` utiliza `String` mientras que el `Adaptee` usa `int`.
     * **Incompatibilidad de estructura de datos:** El sistema cliente separa `calcularCosto` y `obtenerTiempoEstimado` en dos llamadas. La api devuelve ambos datos juntos en un objeto `Cotizacion` en una única llamada. Además, el sistema envía los datos de despacho como strings primitivos, cuando la api requiere que estos datos se agrupen en un objeto `DatosEnvio`.
     * Rigidez: El sistema cliente del escenario no puede utilizar `ApiLogisticaVeloz` directamente. Si lo hicieramos, deberíamos reescribir todo el sistema.
       
### Identificación del patrón
Este escenario describe perfectamente la necesidad de un **patrón adaptador (Adapter)**

### Justificación de la elección
Se eligió el patrón **Adapter** porque su intención es **convertir la interfaz de una clase en otra interfaz que el cliente espera**. En este caso sería adaptar a `ApiLogisticaVeloz` para que el cliente `SistemaEcommerce` pueda utilizarla. El Adapter permite que clases con interfaces incompatibles colaboren, algo que de otra manera sería imposible. 
En nuestro caso, crearemos una clase `LogisticaVelozAdapter` que servirá como adaptador intermedio:
1. **Implementará la interfaz `Target`**: El adaptador implementa la interfaz `IServicioEnvio`. Para el cliente, el adaptador se verá y comportará como cualquier otro servicio de envío.
2. **Envolverá al `Adaptee`**: El adaptador tendrá una instancia de `ApiLogisticaVeloz` como atributo.
3. **Realizara la traducción**: Cuando el cliente llame al método `calcularCosto (String cp)` en el adaptador, este:
    * Transforma el `String` "1234" en un `int` 1234
    * Llama al método `apiVeloz.cotizarEnvio(1234)`
    * Recibe el objeto `Cotizacion`
    * Extrae y devuelve únicamente el costo
  
De esta manera, ni el sistema cliente ni la api externa necesitan ser modificados, permitiendo una integración limpia y manteniendo el desacoplamiento.




