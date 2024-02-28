# ClienteServidorProyecto

# Cronograma

# Descripcion De Las Actividades

# Descripcion General De La Solucion 
Planeamos utilizar SQL como el hueso de los programas, creando en memoria volátil "copias" de la información que se encuentra en este, por ejemplo, iniciar sesión: El programa solicita el correo y contraseña del usuario que desea ingresar, este después compara la información en SQL para ver si un usuario cumple con estos datos y entonces crea un objeto “Usuario” con la información almacenada en SQL con esas credenciales correspondientes, en caso de que estas no se encuentren el la base de datos o que esta no responda entonces se comunica con un mensaje de error al usuario, para crear un nuevo usuario, el sistema pide la información correspondiente y la compara con la base de datos con otra información que puede ser conflictiva, si encuentra un conflicto o no recibe respuesta de la base de datos, un mensaje de error es mostrado al usuario, en caso de crearse de forma exitosa entonces se le comunica al programa el cual usa esa misma información para crear el objeto usuario. Usando este sistema manejamos también la modificación de vehículos y ordenes de compra para asegurar la permanencia de los datos.

# Desglose De Los Requerimientos 
