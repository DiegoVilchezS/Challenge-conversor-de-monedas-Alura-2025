# Challenge Conversor de Moneda - Alura & ONE

¡Bienvenido, mi nombre es Diego Vilchez y soy de Perú! 

Este proyecto es una aplicación de consola en Java que permite realizar conversiones de divisas de manera rápida y precisa, consumiendo datos en tiempo real de una API externa.

## Funcionalidades
* **Consultas en tiempo real:** Utiliza la [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener las tasas de cambio más recientes.
* **Menú interactivo:** Interfaz sencilla en consola que permite al usuario elegir entre 6 opciones de conversión populares.
* **Historial de Conversiones:** Registro detallado de cada operación realizada, incluyendo el valor original, el resultado y la marca de tiempo exacta de la consulta.
* **Gestión de Errores:** Sistema robusto que previene cierres inesperados ante ingresos de datos no válidos (letras o caracteres especiales).

## Tecnologías Utilizadas
* **Java JDK 17+:** Lenguaje base del proyecto.
* **Maven:** Para la gestión de dependencias y construcción del proyecto.
* **Gson 2.10.1:** Librería para la manipulación y análisis de datos JSON.
* **HttpClient & HttpRequest:** Para la comunicación eficiente con el servidor de la API.

## Estructura del Proyecto
El código sigue los principios de la Programación Orientada a Objetos (POO) y separación de responsabilidades:
1. **`ConversorMonedas`**: Clase principal que gestiona el menú y la interacción con el usuario.
2. **`ConsultaMoneda`**: Clase de servicio encargada de realizar las peticiones HTTP y devolver los datos.
3. **`MonedaDTO`**: Record de Java para mapear de forma segura la respuesta JSON de la API.

## Configuración
Para ejecutar este proyecto en tu entorno local:
1. Clona el repositorio.
2. Importa el proyecto como un proyecto Maven.
3. Asegúrate de tener tu **API Key** configurada en la clase `ConsultaMoneda`.
4. Ejecuta la clase `ConversorMonedas`.

---
**Desarrollado por:** Diego Vilchez - Estudiante de Ingeniería de Sistemas y Computación (UTP) 🇵🇪
