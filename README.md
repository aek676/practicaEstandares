# Proyecto: Práctica de Estándares con SonarQube y DevContainer

## Descripción
Este proyecto contiene una configuración estándar para analizar código utilizando **SonarQube** dentro de un **DevContainer** en Visual Studio Code. Facilita la evaluación de calidad de código en proyectos Java mediante Maven y SonarQube.

## Caracter\u00EDsticas
- ✅ Uso de **SonarQube** para análisis de calidad del código
- ✅ Configuración de **DevContainer** para entorno de desarrollo sin necesidad de instalación manual
- ✅ Integración con **Maven** para ejecución automática del análisis

## Requisitos Previos
Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas:

- [Docker](https://www.docker.com/get-started) (necesario para DevContainer y SonarQube)
- [Visual Studio Code](https://code.visualstudio.com/) (para abrir el entorno de desarrollo)
- [Extensión Dev Containers](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)
- [Git](https://git-scm.com/) (para clonar el repositorio)

## Instalación
Clona este repositorio en tu máquina local:
```sh
git clone https://github.com/aek676/practicaEstandares.git
cd practicaEstandares
```

Abre el proyecto en **Visual Studio Code** y presionar el botón:  
➡️ **"Reopen in Container"** (Volver a abrir en el contenedor)

![image](https://github.com/user-attachments/assets/fe1084e6-0073-4f1b-81ed-1c0eeaf5acfb)
Si el botón no aparece, también puedes abrir la paleta de comandos con:
```sh
Ctrl+P → > → Reopen in Container
```
![image](https://github.com/user-attachments/assets/cb65dee4-b4e7-413b-96f7-a62cc8340bc7)
Esto cargará el entorno preconfigurado con todas las herramientas necesarias.


## Uso
#### 1. Abrir un nueva terminal:

![image](https://github.com/user-attachments/assets/6b71140a-92dc-460f-b115-5f7c9ae561a7)
#### 2. Situarse en el proyecto:
```sh
cd practicaEstandares
```
#### 3. Comprobar que maven este instalado:
```sh
mvn -v
```
#### 4. Accede a **SonarQube** en [http://localhost:9000](http://localhost:9000)
Con usuario y contraseña "admin". Esta contraseña la hemos especificado en el archivo docker-compose.yml, en el apartado de "environment". Como es el usuario admin, te pedirá una nueva contraseña que cumpla ciertos requisitos. Por ejemplo: admin123.
#### 5. Una vez entremos en la interfaz web, deber\u00EDamos ver una pantalla como la que sigue. Después, procedemos a crear un proyecto manual.
![image](https://github.com/user-attachments/assets/3216138c-034f-4b9e-a0a5-9c74c8746ebc)
#### 6. Como se observa en la siguiente imagen, se ha puesto un nombre de ejemplo, pero puedes poner el más acorde según el proyecto que vayas a realizar. Y después elegiremos utilizar una configuración global.
![image](https://github.com/user-attachments/assets/4f8653c8-1ba1-48c6-82f7-b692b89e4dc7)
#### 7. Una vez llegados a este punto, ya tienes creado un proyecto base de SonarQube. Ahora, procederemos a analizar el repositorio de forma local. Si tienes dudas sobra su localización, puedes ver la siguiente imagen.
![image](https://github.com/user-attachments/assets/14c20d09-8626-43d7-a535-224f1a65e3be)
#### 8. Después, crearemos un token secreto y personal. Le podemos dar el nombre que nos parezca más oportuno y que sea funcional durante un tiempo determinado.
![image](https://github.com/user-attachments/assets/208364a0-1eab-44f6-a5d3-787a471b7d2d)
#### 9. Una vez reiniciado, volvemos a al VSCode e introducimos el token en el Run.sh
![image](https://github.com/user-attachments/assets/00aa5652-cda5-43fb-91dd-34ab5ecc3dd8)
#### 10. Antes de todo hay que instalar CheckStyle en SonarQube, tendremos que ir a ```Administration > Marteplace > Buscar: CheckStyle```. Despues, reiniciamos el server.
![image](https://github.com/user-attachments/assets/19c8d4bb-cfd5-4871-a22b-f28b26bb0685)
#### 11. Ahora ejecutamos en la terminal:
```sh
./Run.sh
```
Si no es posible habra que darle permisos de ejecución:
```sh
chmod +x Run.sh
```
### 12. Ahora ya podremos hacer la práctica.

