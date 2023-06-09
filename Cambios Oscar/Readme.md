## Proyecto Final Programación II

## Descripción del proyecto.

Nuestro proyecto en Java "Máquina Expendedora de Productos con devolución de cambio" es una aplicación que simula el funcionamiento de una máquina expendedora automatizada. Permite a los usuarios insertar dinero y seleccionar un producto deseado, proporcionando tanto el artículo seleccionado como el cambio correspondiente.
Características principales:

-Selección de productos: Los usuarios pueden elegir entre una variedad de productos disponibles, como refrescos, chocolatinas, etc. Cada artículo tiene un precio asociado.

-Inserción de dinero: Los usuarios pueden insertar dinero en forma de monedas o billetes. El programa acepta diferentes denominaciones y realiza un seguimiento del montón total ingresado.

-Cálculo de cambio: Después de seleccionar un producto y haber insertado suficiente dinero, el programa determina el cambio necesario. Utiliza un algoritmo para calcular la cantidad mínima de monedas y billetes necesarios para devolver el cambio al usuario.

-Entrega del producto: Una vez que se ha realizado la selección y se ha insertado el dinero adecuado, el programa dispensa el producto deseado. Si no hay suficiente dinero ingresado, se mostrará un mensaje indicando la cantidad faltante.

-Gestión de inventario: El programa realiza un seguimiento del inventario de productos, asegurando que solo los productos disponibles se muestren como opciones para los usuarios. Además, si un artículo se agota, se muestra un mensaje adecuado.


-Opciones adicionales: El programa puede incluir características adicionales, como el poder tener incidencias y la posibilidad de guardar la fecha de dicha incidencia.


## Funcionalidades del proyecto.

-Clase Accesories: Son los elementos los cuales no son ni comida ni bebida disponibles en las máquinas expendedoras.

-Clase Alert: enumera las posibles averías que puede tener la máquina.

-Clase Drinks: Las bebidas disponibles, con su ID, precio y cantidad correspondientes.

-Clase FailureException: detecta las averías de la máquina, guardando el ID y la fecha de la avería.

-Clase Food: la comida disponible, con su ID, precio y cantidad correspondiente.

-Incidence: guarda la fecha de una incidencia.

-Clase JamException: detecta los atascos en la máquina, guardando su ID y la fecha del atasco.

-Clase Machine: Una de las clases principales; contiene el dinero, los productos y los ID de estos últimos. También detecta la disponibilidad de esos productos, maneja el cambio del dinero y detecta posibles atascos (si se detecta la probabilidad del 3%, se crea un atasco) y lo mismo con las averías (rebajando el 3% al 2%)

-Clase Management: proporciona métodos para interactuar con las máquinas expendedoras, como mostrar el menú, comprar productos y obtener información general sobre las máquinas y los productos.

-Clase Money: esta clase contiene los distintos tipos de monedas y billetes con sus respectivos valores. Además, esta clase se encarga de añadir el dinero a la máquina, retirarlo, sumarlo , restarlo y de darnos información sobre cuántos billetes y cuántas monedas nos quedan.

-Clase Product: contiene el ID, nombre y cantidad de diferentes productos.

-Clase Salable: se encarga de todo lo relacionado con el número de productos que quedan en stock, su precio y además detecta averías.

## Plant UML del proyecto

<picture><img src = "https://plantuml.ctdesarrollo-sdr.org/png/hLTBRzim3BxxLnWzESkZzw08aBKhqA4TEdItOGV5LXAXjXHOSj2WpNyVPKhM8sxIBikXjIb-54cH7-KDoP_9YgPVYMGoVKrI-EKbaJ9z49pkZ4J_nbjIDdIQBaj1rEy_JaugqN0rJHdNuau-R0ra0oTOKNN72_gIjIPIi3TeKKw3SKbhXS1EgQ4ZhPNYFW3P2bOuJ4qhiQMVmu0dytR5HmnCR87QBw58cHqkoQOY6QQeqdzxt98grbW8KLB2_NYN8lEX-mIJ_rYBeicLIV-Oameo_wHgnbSesTGi1r4XcaL9KSGAbqt_K5h1q5ZCV5EZD303AKCJezI33v9zOhoQvpcLecRKLihGISuoV0EWvyuelfrby9QmigdfjvUSRXGJt2QI5GyaNpDElLGLHC7hlSX9UGEFw4Di80kHMDL3IPM6T4VOxV-TL1rKVdPpK0IyTtQ1jSWJdGghVSghMo4AcsJz_8yfXl-qNfASfdSyPmNbyFHwOckVJIulqxc2FHUDWaeYl4WhgjQYaAbO6iKMv1LU2RJm4JGgHcYJBdSCNluts1PocixhckpkcLHNfbLcgD4shuUGf2IGdodkXM6R7R8kPGvapaHpNv5vVATJ1HA3y3b0wneNf4QyuvWsqAaT2oEsRNWvT0M5djiHw0cZRlrnSKkt4AObWEkwWWBB8c7htS-6SCNKBZF5XrjtdiLQ0H4FoHQwrBhbaokmxwQadCbrnW_3gGY7aNUz9dn5ixnab6FuKom-qmWcVMR3WLaqRWaf6UmBZHTb93zcjJNuY84UiNfTYbLarYuPMefMIpXklsAYKdB1UENcJOxXejbPXJx7MT7b0h6Uptg2sUe_R7gTw0hisTQhK3CeKuCstSOiemGw7S_CRByPm-PwCOJd9gPeFmykGjUgCOlwGNOT_10FTqWffpKfx_pH3H7RYJqUlysyGHdASRA5Cat4oS6yQfUwrtVMkxGauRo9m3sB3cd9iHMRPWw5njl4dUPuFBEacYHuuoCBgMgI6-wDxY_zTvXtxZ4777rmdt7tfpCkDVubxmV0zLb6pcbwQvTyytrtoRR5ii5164ZHUYrmgSz4E1oE3uZe2jk3Coj-m35U2OmdYdkFsNKZtfJ4aGy1PxEFw3zEzgS9_pZfdoJ-_qF-nmV0kKFWn20uFGpscepQhxa9NgLqirvykS0ll8bjPdopXtlrDfc42dy1" width = 1200px></picture>







- PlantUML (se han modificado clases y el código)
- Test

**Nombres de los participantes**   
Raúl Pelayo, Oscar Santamaría y David García Costa
