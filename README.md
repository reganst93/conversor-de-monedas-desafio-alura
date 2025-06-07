<h1 align="center">Challenge Conversor de monedas</h1>

<p align="left">
   <img src="https://img.shields.io/badge/STATUS-%20TERMINADO-green">
</p>
Aplicación en Java para convertir entre diferentes monedas usando la API pública de [ExchangeRate-API](https://www.exchangerate-api.com/). Permite consultar tasas de cambio actuales y guardar los resultados en archivos JSON.
## 🔨 Funcionalidad del proyecto

Conversión de moneda entre las siguientes opciones:
USD (Dólar estadounidense), EUR (Euro), JPY (Yen japonés), CLP (Peso chileno), CAD (Dólar canadiense), BRL (Real brasilero), GBP (Libra esterlina).

Consulta de la tasa de conversión actual entre dos monedas.

Guardado de resultados de conversiones en archivos JSON con formato legible.

Menú interactivo con validación de entradas y opción para continuar o salir.

## 🚀 Instrucciones de Uso
### Clonar el repositorio

```bash
git clone https://github.com/reganst93/conversor-de-monedas-desafio-alura.git
cd conversor-de-monedas-desafio-alura
```
Configurar la API Key
Regístrate y obtén tu clave API gratuita en ExchangeRate-API.

Abre el archivo src/conversor/api/ConexionApi.java.

Busca la variable API_KEY y reemplaza el valor por tu clave personal:
Compilar y ejecutar el proyecto
Si usas IntelliJ IDEA o tu IDE favorito, simplemente abre el proyecto y ejecuta la clase conversor.Principal.

Si prefieres usar la consola:

bash
Copiar
Editar

Compilar: 
javac -d out $(find src -name "*.java")

Ejecutar: 
java -cp out conversor.Principal


## 📁 Estructura del proyecto
**¿Por qué esta estructura?**
- **api/**: Para mantener todo el código relacionado con la comunicación con servicios externos en un solo lugar, facilitando mantenimiento y posibles cambios futuros en la API.
- **model/**: Aquí se definen las estructuras de datos que representan la información que manejamos, como las respuestas JSON de la API.
- **utils/**: Contiene utilidades para la interacción con el usuario y otras funcionalidades auxiliares, separando la lógica de presentación y gestión de datos.

```src/
│
├── conversor/
│   ├── Principal.java               ← Clase con método main
│
├── api/
│   └── ConexionApi.java            ← Clase para las llamadas HTTP a la API
│
├── model/
│   └── ConversionResponse.java     ← Registro que modela la respuesta JSON
│
├── utils/
│   └── Menu.java                   ← Menú interactivo y lógica del programa
│
├── utils/
│   └── GeneradorDeArchivo.java     ← Guardado de resultados en archivo JSON
```
## 📦 Dependencias

Este proyecto utiliza la biblioteca **Gson** para la manipulación de JSON, que es necesaria para convertir objetos Java a JSON y viceversa.

Tienes dos opciones para agregar Gson a tu proyecto:

### Opción 1: Descargar el archivo `.jar` manualmente

1. Descarga el archivo `gson.jar` desde el repositorio oficial:  
   [https://github.com/google/gson](https://github.com/google/gson)

2. Agrega el archivo `.jar` a las librerías de tu proyecto.
    - En IntelliJ IDEA:  
      `File > Project Structure > Modules > Dependencies`  
      luego haz clic en `+` para añadir el `.jar`.

### Opción 2: Usar Maven (si tu proyecto está configurado con Maven)

Agrega la siguiente dependencia en tu archivo `pom.xml`:

```xml
<dependency>
  <groupId>com.google.code.gson</groupId>
  <artifactId>gson</artifactId>
  <version>2.10.1</version>
</dependency>
```
## ⚙️ Tecnologías Utilizadas

<p align="center"> 
  <a href="https://skillicons.dev"> 
    <img src="https://skillicons.dev/icons?i=java,git" /> 
  </a> 
</p>

<img src="https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue?logo=intellij-idea&logoColor=white" />

- **Java** para la lógica y estructura del programa.
- **Gson** para el parseo de JSON y manipulación de datos.
- La aplicación utiliza la API pública de tipos de cambio de **[ExchangeRate-API](https://www.exchangerate-api.com/)** para obtener las tasas de conversión actualizadas.

> ⚠️ **Importante:** Para que la aplicación funcione, es necesario configurar tu propia clave API en el archivo `ConexionApi.java`.  
> Debes reemplazar el valor de la variable `API_KEY` con tu key personal obtenida tras registrarte en [exchangerate-api.com](https://www.exchangerate-api.com/).

## 🙏 Agradecimientos

Gracias a ExchangeRate-API por proveer la API pública que hace posible las conversiones de moneda en esta aplicación.

Gracias por utilizar este conversor de monedas. Este proyecto fue desarrollado con fines de aprendizaje y para demostrar el uso de APIs y estructuras en Java.

Si tienes dudas, sugerencias o comentarios, ¡estaré encantado de escucharlas!