# RETO CARACOL

***DESCRIPCIÓN:*** 

Este sistema simula a un caracol que cae en un pozo entre la altura -10 y la -20, el caracol a medida que van pasando los dias intenta escapar, mientras que se enfrenta a varias adversidades, como la lluvia, el temblor generado por los coches o la fatiga, el caracol también tiene ayudas, como la posibilidad de que se coma una hoja que cae y le da fuerza para subir.

***FUNCIONALIDADES:***

**Clases:**

-Snail: En la clase Snail se crea al caracol, es decir, se le asigna un nombre(mediante un interfaz), una altitud, la caída(mediante un math.random), lo que sube(un número aleatorio entre 1 y 4 dependiendo de la fatiga), lo que baja(un número aleatorio entre 1 y 2) y se le implementa la fatiga y el estado(vivo o muerto).

-Car: En la clase Car se ejecuta en el la clase World implementamos la posiblidad de que pase el coche (35%), el cual mediante los temblores le hace bajar al caracol 2 metros.

-Day: La clase Day contabiliza el paso de los dias

-Fatigue: La clase Fatigue se ejecuta en la clase Snail contabiliza el número de dias que van pasando y dependiendo el día que sea el caracol sube más o menos, o incluso muere por inanición.

-Leaf: La clase Leaf se ejecuta en la clase World, consiste en la caída de una hoja, que el caracol se la come y le hace subir 2 metros, esta clase tiene una probabilidad del 15%, que si se cumple la hoja cae.

-Rain: La clase Rain se ejecuta en la clase World, y consiste en porcentajes, hay un 5% de lluvia fuerte, que hace subir la profundidad del agua 5 metros, un 15% de lluvia debil que sube la profundidad 2 metros y la posibilidad de que no llueva.

-Tier: La clase Tier se ejecuta en la clase Snail, y sirve para crear las alturas.


-Well: La clase Well crea el pozo, con todo lo que conlleva, como el Snail, en esta clase se crea la variable WaterDepth, la cual varia dependiendo de la lluvia y además se comprueba si el caracol esta en la altitud debida.

-World: La clase World, es la principal donde se implementan todas las demás clases, además de donde se construye el pozo, el paso de los días, el coche...

**Excepciones:** 

-Alive: Esta exception sirve para saber el estado del caracol (vivo)

-Death: Esta exception sirve para saber el estado del caracol (muerto)

-CameOut: Esta exception sirve para saber el estado del caracol (fuera del pozo)

**Clases abstractas:**

-Circumstances: Esta clase abstracta sirve para dar una descripción a varias circustancias, como coche o hoja 

- Events: Es una clase abstracta pero que a su vez es una excepción.

**Enum:**

-State: Este enum contiene si el caracol esta vivo o muerto.

-Warning: Este enum contiene si llueve, si pasa el coche o  la caía de la hoja.

**Interfaces:**

-InterfaceSnail: Esta interfaz sirve para asignar un nombre al caracol.

-InterfaceWell: Esta interfaz sirve para asignar una altura a la profundidad del pozo(-20).




***DIAGRAMA DE CLASES:***

![PUML](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/145a9c00-5f82-464f-ada2-7b70c94e6332)


***CAPTURAS DE PANTALLA:***

![6](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/66f648f0-07cf-4f2a-9325-e17d42bd27b4)
![4](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/722e4b87-5d74-4404-94f9-eba83d5fc2fc)
![5](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/f98bc59c-e56e-450d-9fb1-5ece90af974d)
![1](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/a200225a-8068-42bb-a080-4696c318c2d3)
![2](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/ef00d893-18fd-49ac-bdd0-4bb22164c155)
![3](https://github.com/Mariodrm17/awesome-projects-prograii/assets/114480424/75cf93d4-cc41-4cc4-bd50-4ce1e2e5297d)




***INSTRUCCIONES DE USO:***

-Para usar el programa lo único que hay que hacer es ejecutarlo y cada dia irá pasando cada dos segundos para que de tiempo a leerlo.

***AUTORES:*** Mario Del Rio Merino, Aníbal Bayas Galindo y Pablo Cantero Reigadas






