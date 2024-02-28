# ClienteServidorProyecto

# Cronograma
|SEMANA DE TRABAJO|QUE SE HACE|
|-----------------|-----------|
|Semana 7|Alexander creo el repositorio de git,se crearon las primeras ideas para el diagrama de clases y el diagrama de flujo por parte de Santiago,Ignacio Desgloso los requerimientos y Alexander los agrego al README,Anthony hizo la descripcion de las actividadesy Aleander las agrego al README,Santiago ideo la descripcion de la solucion del problema y lo agrego al README y por ultimo se entrego el Primer avance del proyecto.
|Semana 8|Se piensa arrancar con la progamacion del codigo todos en conjunto mas que todo en la parte del FideMotor app
|Semana 9|Se continuara con la programacion del FideMotor app y se espera terminarlo
|Semana 10|Se arrancara con la programacion del FideMotor Business
|Semana 11|Se continuara con la progamacion del FideMotor Business y se empezara a trabajar en la interfaz grafica esperando que el FideMotor Business este terminado
|Semana 12|Se terminara el proyecto en su totalidad y se dara el ultimo Testing antes de entregar el Avance Final
|Semana 14|Se expondra el proyecto durante la clase 
|Semana 15|Se expondra el proyecto durante la clase 
# Descripcion De Las Actividades
## FideMotor App:
## Registro de Cuenta Cliente: 
El usuario proporciona su información básica, que se envía al servidor para registrar un nuevo usuario. El servidor verifica si ya existe un usuario con la misma información y devuelve una respuesta de confirmación o error.
## Inicio de Sesión: 
El usuario ingresa su identificación y contraseña, que se verifican con el servidor. Si las credenciales son correctas, se muestran las opciones al usuario.
## Salir de la sesión:
 El usuario tiene la opción de cerrar su sesión cuando lo desee.
## Visualizar Vehículos Disponibles para la Venta:
 Se muestra al usuario una lista de los vehículos disponibles para la venta.
## Realizar Compras de Vehículos: 
El usuario es capaz de ver los vehículos disponibles, de poder seleccionar una forma de pago ya sea con efectivo o con tarjeta, se puedan validar los datos de la tarjeta si es seleccionada, se pueda confirmar la compra y enviarla al servidor. Luego se le muestra una animación de carga y un mensaje de confirmación.
## Realizar Puntuaciones de Vehículos: 
Dentro de este requerimiento los clientes son capaces de calificar los vehículos que han adquirido.
## Visualizar Compras Realizadas:
 Se le mostrara al usuario un historial de sus compras realizadas, incluyendo el estado de cada compra.
## Editar Datos:
 El usuario podrá modificar ciertos datos de su perfil.
## FideMotor Business:
## Visualizar Compras de Clientes:
 Se estará realizando un programa donde se puedan ver todas las compras realizadas por los clientes y para que de esta manera se pueda acceder a los detalles de cada compra.
## Gestionar Estados de Compras: 
Se puede dentro de esta se podrá cambiar el estado de las compras.
## Editar Inventario de Vehículos:
 Se pueden agregar, eliminar y editar vehículos en el inventario. Cada vehículo debe tener marca, año, modelo y precio.
## Requerimientos Técnicos:
## Multihilos:
 La aplicación debe soportar múltiples sesiones activas de clientes y manejar múltiples solicitudes sin problemas.
## Interfaz de Usuario:
 La interfaz de usuario debe ser desarrollada con Java Swing, ser simple y agradable de utilizar, debe permitir la navegación entre opciones y mostrar una animación y un mensaje tras la compra.
## Persistencia de Datos: 
Se debe utilizar una base de datos MySQL para almacenar información, incluyendo usuarios, inventario, compras, etc. Esta debe permitir agregar, modificar y eliminar datos.
## Sistema de Gestión: 
La aplicación debe seguir una arquitectura cliente-servidor, con comunicación a través de sockets. La lógica de negocio reside en el servidor.
# Descripcion General De La Solucion 
Planeamos utilizar SQL como el hueso de los programas, creando en memoria volátil "copias" de la información que se encuentra en este, por ejemplo, iniciar sesión: El programa solicita el correo y contraseña del usuario que desea ingresar, este después compara la información en SQL para ver si un usuario cumple con estos datos y entonces crea un objeto “Usuario” con la información almacenada en SQL con esas credenciales correspondientes, en caso de que estas no se encuentren el la base de datos o que esta no responda entonces se comunica con un mensaje de error al usuario, para crear un nuevo usuario, el sistema pide la información correspondiente y la compara con la base de datos con otra información que puede ser conflictiva, si encuentra un conflicto o no recibe respuesta de la base de datos, un mensaje de error es mostrado al usuario, en caso de crearse de forma exitosa entonces se le comunica al programa el cual usa esa misma información para crear el objeto usuario. Usando este sistema manejamos también la modificación de vehículos y ordenes de compra para asegurar la permanencia de los datos.
# Desglose De Los Requerimientos 
## Requerimientos para FideMotor:
## FideMotor App:
- Registro de Cuenta Cliente:
  - Solicitar información básica del usuario.
  - Enviar solicitud al servidor para registrar nuevo usuario.
  - Verificar duplicados.
  - Respuesta de confirmación o error.
- Inicio de Sesión:
	- Ingresar identificación y contraseña.
	- Verificación de credenciales con el servidor.
	- Mostrar opciones al usuario.
- Salir de la sesión
  - Permite al usuario salir de sesión.
- Visualizar Vehículos Disponibles para la Venta:
  - Mostrar lista de vehículos disponibles para venta.
- Realizar Compras de Vehículos:
  - Visualizar vehículos disponibles.
  - Seleccionar forma de pago (efectivo o tarjeta).
  - Validar datos de tarjeta si es seleccionada.
  - Confirmar compra y enviar al servidor.
  - Mostrar animación de carga y mensaje de confirmación. 
- Realizar Puntuaciones de Vehículos:
  - Permitir a los clientes calificar los vehículos adquiridos.
- Visualizar Compras Realizadas:
  - Mostrar historial de compras realizadas.
  - Mostrar el estado de cada compra.
- Editar Datos:
  - Permitir al usuario modificar ciertos datos de su perfil.
## FideMotor Business:
- Visualizar Compras de Clientes:
  - Ver todas las compras realizadas por los clientes.
  - Acceder a los detalles de cada compra.
- Gestionar Estados de Compras:
  - Permitir cambiar el estado de las compras.
- Editar Inventario de Vehículos:
  - Agregar, eliminar y editar vehículos en inventario.
  - Cada vehículo debe tener marca, año, modelo y precio.
## Requerimientos Técnicos:
- Multihilos:
  - Soportar múltiples sesiones activas de clientes.
  - Manejar múltiples solicitudes sin problemas.
- Interfaz de Usuario:
	- Desarrollada con Java Swing.
  - Simple y agradable de utilizar.
  - Permitir navegación entre opciones.
  - Mostrar animación y mensaje tras la compra.
- Persistencia de Datos:
  - Base de datos MySQL para almacenar información.
  - Almacenar usuarios, inventario, compras, etc.
  - Permitir agregar, modificar y eliminar datos.
- Sistema de Gestión:
  - Arquitectura cliente-servidor.
  - Comunicación a través de sockets.
  - La lógica de negocio reside en el servidor.
## Documentación:
- Diseño:
  - Diagrama de bloques general.
  - Descripción de partes del proyecto.
  - Descripción general de la solución.
  - Diagrama de clases general.
- Planeamiento:
  - Descripción de actividades para cada requerimiento.
  - Cronograma de desarrollo con fechas de entrega y responsables.

