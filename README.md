# Proyecto: Práctica de Estándares con SonarQube y DevContainer

## Descripción
Este proyecto contiene una configuración estándar para analizar código utilizando **SonarQube** dentro de un **DevContainer** en Visual Studio Code. Facilita la evaluación de calidad de código en proyectos Java mediante Maven y SonarQube.

## Características
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
1. Inicia **SonarQube** dentro del DevContainer:
```sh
docker-compose up -d
```
2. Accede a **SonarQube** en [http://localhost:9000](http://localhost:9000)
3. Ejecuta la compilación y análisis con Maven:
```sh
mvn clean install
mvn sonar:sonar
```

## Resolución de Problemas
Si encuentras problemas, revisa los siguientes puntos:
- **Docker no inicia:** Asegúrate de que el servicio está corriendo.
- **Puerto 9000 ocupado:** Cambia el puerto o detén otros procesos en conflicto.
- **Error en DevContainer:** Asegúrate de que la extensión está instalada y usa la opción `Reopen in Container`.

## Contribución
Si deseas contribuir, sigue estos pasos:
1. Haz un **fork** del repositorio
2. Crea una rama (`git checkout -b feature-nueva`)
3. Realiza tus cambios y haz **commit** (`git commit -m 'Agregando nueva característica'`)
4. Sube los cambios (`git push origin feature-nueva`)
5. Abre un **Pull Request**

## Licencia
Este proyecto está bajo la licencia MIT. Para más detalles, consulta el archivo `LICENSE`.

## Contacto
Para dudas o sugerencias, abre un **issue** en el repositorio o contacta con el administrador.

