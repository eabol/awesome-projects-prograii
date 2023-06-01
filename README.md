
    ██████   █████  ███    ██  ██████  ██████      ███████  █████  ███    ██ ████████  █████  ███    ██ ██████  ███████ ██████  
    ██   ██ ██   ██ ████   ██ ██      ██    ██     ██      ██   ██ ████   ██    ██    ██   ██ ████   ██ ██   ██ ██      ██   ██
    ██████  ███████ ██ ██  ██ ██      ██    ██     ███████ ███████ ██ ██  ██    ██    ███████ ██ ██  ██ ██   ██ █████   ██████  
    ██   ██ ██   ██ ██  ██ ██ ██      ██    ██          ██ ██   ██ ██  ██ ██    ██    ██   ██ ██  ██ ██ ██   ██ ██      ██   ██
    ██████  ██   ██ ██   ████  ██████  ██████      ███████ ██   ██ ██   ████    ██    ██   ██ ██   ████ ██████  ███████ ██   ██ 



    ╔╦╗╔═╗╔═╗╔═╗╦═╗╦╔═╗╔═╗╦╔═╗╔╗╔
     ║║║╣ ╚═╗║  ╠╦╝║╠═╝║  ║║ ║║║║
    ═╩╝╚═╝╚═╝╚═╝╩╚═╩╩  ╚═╝╩╚═╝╝╚╝

    Se trata de una aplicación Bancaria, en este caso para el Banco Santander, donde podrán...


    ╔═╗╦ ╦╔╗╔╔═╗╦╔═╗╔╗╔╔═╗╦  ╦╔╦╗╔═╗╔╦╗╔═╗╔═╗
    ╠╣ ║ ║║║║║  ║║ ║║║║╠═╣║  ║ ║║╠═╣ ║║║╣ ╚═╗
    ╚  ╚═╝╝╚╝╚═╝╩╚═╝╝╚╝╩ ╩╩═╝╩═╩╝╩ ╩═╩╝╚═╝╚═╝
        
    * [ ] Un empleado del banco puede seleccionar a que oficina desea conectarse 
    * [ ] Cuando se conecta un empleado a una oficina le requiere iniciar sesión con sus credenciales
    * [ ] Un empleado solo tendra acceso a la oficina en la que trabaja
    * [ ] Los datos de las oficinas y de los empleados son obtenidas de ficheros para mantener la persistencia
    * [ ] Creacion de clientes
    * [ ] 
    * [ ]
    * [ ]
        

    ╦ ╦╔╦╗╦  
    ║ ║║║║║  
    ╚═╝╩ ╩╩═╝

![](uml.png)


    ╔═╗╔═╗╔╦╗╦═╗╦ ╦╔═╗╔╦╗╦ ╦╦═╗╔═╗
    ║╣ ╚═╗ ║ ╠╦╝║ ║║   ║ ║ ║╠╦╝╠═╣
    ╚═╝╚═╝ ╩ ╩╚═╚═╝╚═╝ ╩ ╚═╝╩╚═╩ ╩

    src.proyectoterraques.docs
    ----------------------------
    En este paquete se encuentran los documentos utilizados.       

    > diagram.puml: Diagrama UML de la aplicación
    > readme.md: Archivo de texto que proporciona información de la aplicación.
    > account_structure.jpeg: Imagen que muestra el formato utilizado para los números de cuenta bancaria
		
		
    src.proyectoterraques.exceptions
    ----------------------------------
    En este paquete se encuentran las clases para el manejo de excepciones.

    > InvalidCharacterException: Clase que maneja los errores de caracteres inválidos
        - Constructor: Recibe un String con el texto del error


    src.proyectoterraques.files
    -----------------------------
    En este paquete se encuentran los archivos necesarios para guardar la información de forma persistente.

    > accounts.dat: 
    > banks.dat:
    > clients.dat:
    > employees.dat:
    > numberOfAccounts.dat: 
	     
    src.proyectoterraques.gui
    ---------------------------
    En este paquete se encuentra la clase ejecutable para iniciar la aplicación

    > Login: 


    src.proyectoterraques.source
    ------------------------------
    En este paquete se encuentran todas las clases que dan funcionalidad a la aplicación

    > Account:
    > AccountMethods:
    > Bank:
    > Client:
    > ClientMethods:
    > CreditAccount:
    > DebitAccount:
    > FileHandler:
    > ShareholderClient:
    > StandardClient:

    test
    ------
    > Test1: 
    >
    

    ╔═╗╔═╗╔═╗╔╦╗╦ ╦╦═╗╔═╗╔═╗
    ║  ╠═╣╠═╝ ║ ║ ║╠╦╝╠═╣╚═╗
    ╚═╝╩ ╩╩   ╩ ╚═╝╩╚═╩ ╩╚═╝

    Seran incluidas al desarrollarse la aplicacion...


    ╦ ╦╔═╗╔═╗
    ║ ║╚═╗║ ║
    ╚═╝╚═╝╚═╝

    ## IDE (IntelliJ, NetBeans, etc.)
    Para iniciar la aplicación desde un entorno de desarrollo abriremos el proyecto
    llamado "proyectoTerraques" y ejecutaremos la clase proyectoterraques.gui.Login
		
		
    ## CONSOLA
    Para ejecutar la aplicación en consola desde nuestro sistema operativo sin necesidad
    de un entorno de desarrollo debemos ejecutar el archivo "BancoSantander.jar"
    (Es necesario tener instalado java en nuestro sistema operativo).

    
    ╔═╗╦ ╦╔╦╗╔═╗╦═╗╔═╗╔═╗
    ╠═╣║ ║ ║ ║ ║╠╦╝║╣ ╚═╗
    ╩ ╩╚═╝ ╩ ╚═╝╩╚═╚═╝╚═╝


    