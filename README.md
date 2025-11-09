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
- **Problema 2 Añadir extras combinables:** El problema es que se tienen que poder agregar extras a un carrito y que se puedan combinar dos extras en un mismo componente. Si se quisiera implementar esto enc código, surgiría complejidad y rigidez, dos problemas que debemos evitar

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



