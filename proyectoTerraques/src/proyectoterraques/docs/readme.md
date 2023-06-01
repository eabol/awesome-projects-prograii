
    ██████   █████  ███    ██  ██████  ██████      ███████  █████  ███    ██ ████████  █████  ███    ██ ██████  ███████ ██████  
    ██   ██ ██   ██ ████   ██ ██      ██    ██     ██      ██   ██ ████   ██    ██    ██   ██ ████   ██ ██   ██ ██      ██   ██
    ██████  ███████ ██ ██  ██ ██      ██    ██     ███████ ███████ ██ ██  ██    ██    ███████ ██ ██  ██ ██   ██ █████   ██████  
    ██   ██ ██   ██ ██  ██ ██ ██      ██    ██          ██ ██   ██ ██  ██ ██    ██    ██   ██ ██  ██ ██ ██   ██ ██      ██   ██
    ██████  ██   ██ ██   ████  ██████  ██████      ███████ ██   ██ ██   ████    ██    ██   ██ ██   ████ ██████  ███████ ██   ██ 


       ┌┬┐┌─┐┌─┐┌─┐┬─┐┬┌─┐┌─┐┬┌─┐┌┐┌
        ││├┤ └─┐│  ├┬┘│├─┘│  ││ ││││
       ─┴┘└─┘└─┘└─┘┴└─┴┴  └─┘┴└─┘┘└┘

        Se trata de una aplicación Bancaria, en este caso para el Banco Santander, donde podrán...


       ┌─┐┌─┐┌┬┐┬─┐┬ ┬┌─┐┌┬┐┬ ┬┬─┐┌─┐
       ├┤ └─┐ │ ├┬┘│ ││   │ │ │├┬┘├─┤
       └─┘└─┘ ┴ ┴└─└─┘└─┘ ┴ └─┘┴└─┴ ┴

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


       ┬ ┬┌─┐┌─┐
       │ │└─┐│ │
       └─┘└─┘└─┘
		
		 IDE (IntelliJ, NetBeans, etc.)
		--------------------------------	
		> Para iniciar la aplicación desde un entorno de desarrollo abriremos el proyecto
          llamado "proyectoTerraques" y ejecutaremos la clase proyectoterraques.gui.Login
		
		
		 CONSOLA
		---------	
		> Para ejecutar la aplicación en consola desde nuestro sistema operativo sin necesidad
          de un entorno de desarrollo debemos ejecutar el archivo "BancoSantander.jar"
          (Es necesario tener instalado java en nuestro sistema operativo).

! [plantuml](https://www.plantuml.com/plantuml/png/lLPHRzCm47xFhx36omQql4zHDEWwRH8CnCe3J-WQtnOBnowsip6L_NVYkDVKOssjBU8fyNUNx-uxdyyviGwCQsgPPLafmLgsCFeUIwST6WE_6hHZgnjJulW3g9zicOsOK8v1MUf6kHcgowQUex4jVkMCK3TCNr-B4ljrtXJJozd5x7l-hYbwkFlUtA_ukBWHRg9RHCiM-YYiooTIe785Axkd9VXz25rG3ZPxm_9yOX0S5WNpQHuUjLZ4SOCkl5go4L4mTkzaLNWNd6aLh65fiDQtIFOriEbYAqq4GIo1v4Hezf1bCBVEGEdOdl87GhRCNb45kHBzGa6D_Ses9WQ0SuFMzi2YqWh3tiNrYn9_k-L1efQK_KF0V2bFbJZSPZjhfFI9xNGu1GUjmyFUZhogm62b9KT3rOcrn0xfiluLiqN2KubJUvtYNBXrZ_7LYZfsOf2l0LPsgnyGbYdI7IWEXc_HJTR_ANfJhvSRwqbjSoBmVKwHLZIXMptETJENoA3sS2mzFc9ncn4VdNUYVDIDHE_TkWYFxRTQyCtpl2g1bocKGtCD9UvL-0bTfRdrMnS8EIwq5UumH3yY-4wuYXkuM-CfSMXWH64wEk2SIhHw7WLBDCUeVcIJmcwEo8G6ZRhXKNkIBGwqStUUt99j-v2G7Xs_TRDHXBmfBYvdqw_JgrbtNv71TxIBPH37otH4O5kP5qix4nBFGN69XYtfqWmv5KmAXJQMqVk756D_3Tmx-AiPDrIEs5nhYQ2Oi5_0LTDwuUvxQqnYy6cI7LhmTuaB9xIouoczBhF4BoxKBKZ19nNuyugcPuYLR_MBBkZTFqHwD687dyVZrmVxPzenEmVxOZuwsOFHnGDfq2nJMKbI_gSbJh_liyJWGz5IgOWmOVPbgMKVWZAfYlHpC6G9YNE0-j5m7go0wPpKtQDHaJPUZzatYpQ1xNdZYlZJnYCLu3cHiXDKlAdbNm00)
![](https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png){width='100px'}