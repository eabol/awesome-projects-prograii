### Proyecto final Programación II - Juego del Guerrero y el Vampiro.

El objetivo de este trabajo era realizar un programa que ejecute un juego sencillo, en el que hay dos personajes:

- Un guerrero, controlado por el usuario.
- Un vampiro, que ejecuta acciones automáticamente.

En el turno del guerrero, el usuario puede escoger diferentes opciones:

1. Atacar: el usuario elige atacar al vampiro, escogiendo entre una de sus 3 armas:
  1. Espada: poco precisión alta a cambio de daño bajo.
  2. Hacha de mano: daño y precisión neutras.
  3. Mangual: daño alto a cambio de baja precisión.

2. Objeto: el usuario abre la bolsa y elige  entre dos objeto para usar:
  1. Daga: el guerrero lanza una daga al vampiro, causándole daño
  2. Bomba de humo: el guerrero lanza una granada de humo, lo que le permite huir de la pelea si acierta

3. Grito: el guerrero grita a su oponente, tratando intimidarle y, de esa forma, hacerle huir de la pelea.

El vampiro, por su parte, realizará una acción aleatoria entre las 3 que posee:

1. Arañazo: poco daño a cambio de mucha precisión.
2. Mordisco: daño y precisión neutros.
3. Devorador de almas: mucho daño a cambio de poca precisión.

Cada personaje tiene su estadística de vida correspondiente. El juego funciona en un sistema de turnos, empezando siempre el guerrero.

El juego acaba cuando uno de los dos personajes pierde todos sus puntos de vida o huye del combate.

#### Lista de funcionalidades:

- Clase "Bite":
  - La clase Bite extiende la clase Weapons.
  - Se crea un objeto de la clase Bite, con nombre y daño.
  - La función biteAttack() realiza un ataque de mordisco.
  - Se establece un número aleatorio para la precisión.
  - Se comprueba si el ataque acierta, en cuyo caso se reduce la salud del guerrero. En caso contrario, no hará nada y aparecerá un mensaje de fallo.
  - Se comprueba si la salud del guerrero es mayor que 0. En caso contrario, el juego termina.

Este mismo proceso lo podemos ver replicado en la clase "Claw" y la clase "SoulShypon", cada una con sus respectivas variables.

Del mismo modo, en las clases "Sword", "Handaxe" y "Flail" realizan un proceso similar:

- Se crea un objeto de la respectiva clase, con nombre y daño.
- Cada clase tiene su función de ataque, "swordAttack", etc.
- Se establece un número aleatorio para la precisión.
- Se comprueba si el ataque acierta, en cuyo caso se reduce la salud del vampiro. En caso contrario, no hará nada y aparecerá un mensaje de fallo.
- Se comprueba si la salud del vampiro es mayor que 0. En caso contrario, el juego termina.


Existe una clase llamada "General Manager", que se encarga de manejar toda la dinñamica de combate.

