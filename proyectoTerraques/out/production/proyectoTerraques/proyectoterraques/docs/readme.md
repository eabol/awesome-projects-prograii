    ██████   █████  ███    ██  ██████  ██████      ███████  █████  ███    ██ ████████  █████  ███    ██ ██████  ███████ ██████  
    ██   ██ ██   ██ ████   ██ ██      ██    ██     ██      ██   ██ ████   ██    ██    ██   ██ ████   ██ ██   ██ ██      ██   ██
    ██████  ███████ ██ ██  ██ ██      ██    ██     ███████ ███████ ██ ██  ██    ██    ███████ ██ ██  ██ ██   ██ █████   ██████  
    ██   ██ ██   ██ ██  ██ ██ ██      ██    ██          ██ ██   ██ ██  ██ ██    ██    ██   ██ ██  ██ ██ ██   ██ ██      ██   ██
    ██████  ██   ██ ██   ████  ██████  ██████      ███████ ██   ██ ██   ████    ██    ██   ██ ██   ████ ██████  ███████ ██   ██ 




    ╔╦╗╔═╗╔═╗╔═╗╦═╗╦╔═╗╔═╗╦╔═╗╔╗╔
     ║║║╣ ╚═╗║  ╠╦╝║╠═╝║  ║║ ║║║║
    ═╩╝╚═╝╚═╝╚═╝╩╚═╩╩  ╚═╝╩╚═╝╝╚╝


Se trata de una aplicación de gestión bancaria, en este caso para el Banco Santander, donde en este caso el banco
Santander necesita un sistema en el que se puedan crear diferentes tipos de clientes y cuentas asi como una forma
para que un trabajador de dicho banco dependiente en la sucursal en la que trabaje pueda acceder a dicho sistema de
gestión



    ╔═╗╦ ╦╔╗╔╔═╗╦╔═╗╔╗╔╔═╗╦  ╦╔╦╗╔═╗╔╦╗╔═╗╔═╗
    ╠╣ ║ ║║║║║  ║║ ║║║║╠═╣║  ║ ║║╠═╣ ║║║╣ ╚═╗
    ╚  ╚═╝╝╚╝╚═╝╩╚═╝╝╚╝╩ ╩╩═╝╩═╩╝╩ ╩═╩╝╚═╝╚═╝

        
* [ ] Un empleado del banco puede seleccionar a que oficina desea conectarse 
* [ ] Cuando se conecta un empleado a una oficina le requiere iniciar sesión con sus credenciales
* [ ] Un empleado solo tendrá acceso a la oficina en la que trabaja 
* [ ] Los datos de las oficinas y de los empleados son obtenidas de ficheros para mantener la persistencia 
* [ ] Creación de clientes standard
* [ ] Creación de clientes accionistas
* [ ] Creación de cuentas de crédito
* [ ] Creación de cuentas de débito
* [ ] Eliminación de cuentas de crédito
* [ ] Eliminación de cuentas de débito
* [ ] Eliminación de clientes
* [ ] Mostrar los clientes existentes (y todos sus datos)
* [ ] Mostrar las cuentas existentes (y los datos de dichas cuentas)
* [ ] Depositar dinero en cuentas
* [ ] Sacar dinero de cuentas
* [ ] Los clientes standard solo pueden tener una cuenta de débito
* [ ] Los clientes accionistas no tienen un máximo de cuentas de débito
* [ ] Solo los clientes accionistas pueden tener una cuenta de crédito
* [ ] Las cuentas de crédito podrán sacar más dinero del disponible y tendrán un 20% de intereses
* [ ] Se llevará un registro de la deuda acumulada en cada cuenta de crédito



    ╦ ╦╔╦╗╦  
    ║ ║║║║║
    ╚═╝╩ ╩╩═╝

Diagrama UML de la aplicación.



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

> accounts.dat: Almacenamiento de las cuentas existentes
> banks.dat: Almacenamiento de los bancos existentes
> clients.dat: Almacenamiento de los clientes existentes
> employees.dat: Almacenamiento de los empleados existentes
> numberOfAccounts.dat: Almacenamiento del numero de cuentas que se pueden crear
	     
src.proyectoterraques.gui
---------------------------
En este paquete se encuentra la clase ejecutable para iniciar la aplicación

> Login: Clase ejecutable que refleja toda la información necesaria para que funcione la aplicación correctamente


src.proyectoterraques.source
------------------------------
En este paquete se encuentran todas las clases que dan funcionalidad a la aplicación

> Account: Clase Abstracta en el que se almacenan las cuentas
> AccountBalance: Interfaz que contiene los métodos deposit, withdraw y mirar los datos de las cuentas
> Bank: Clase principal que contiene todos los datos necesario de cuentas, clientes, etc... 
> Client: Clase Abstracta que crea los clientes y sus datos
> ClientManagement: Interfaz que crea, elimina y lista las cuentas de los clientes
> CreditAccount: Clase que contiene cuentas de crédito y los métodos deposit y withdraw
> DebitAccount: Clase que contiene cuentas de débito y los métodos deposit y withdraw
> FileHandler: Clase que contiene los archivos fichero
> ShareholderClient: Clase de accionistas que contiene toda la información de la clase Client y la interfaz ClientManagement
> StandardClient: Clase de usuarios que contiene toda la información de la clase Client y la interfaz ClientManagement

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


- HUGO FRESNO NAVARRO
- EDUARDO LOSTAL LE BARBIER
- FERNANDO WILLIAM CALVO MÉNDEZ

    