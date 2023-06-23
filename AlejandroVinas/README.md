### Final Proyect Pro II- Warrior-Vampire game                          by: Pablo Lastra Tabuenca & Alejandro Viñas Portilla

The goal of this proyect is to create a program that runs a farily simple game. This game has two characthers:

- A warrior, controled by the user.
- A vampire, automatically controlled by the program. 

During his turn, the warrior can choose between three different options:

1. Attack: the user chooses to attack the vampire, picking one of three weapons to do so:
  - Sword: low damage and high accuracy.
  - Handaxe: medium damage and accuracy.
  - Flail: high damage and low accuracy

2. Item: the user opens the warriors bag, and can choose between two items:
  - Dagger: the warrior hurls a dagger at the vampire, damaging him if hit.
  - Smoke bomb: the warrior throws a smoke grenade which, if it hits the vampire, allow him to run from the fight.

3. Scream: the warrior screams, trying to intimidate the vampire. If he is successful, the vampire will run from the fight

The vampire will automatically select one of three actions every turn:

1. Scratch: low damage and high accuracy.
2. Bite: medium damage and accuracy.
3. Soul Siphon: high damage and low accuracy.

Each character has its own health stat. The game works in a turn based combat system.

The game ends when one character either reaches 0 health points or runs from the fight.

#### List of functionalities:

- Class "Bite":
  - The class "Bite" extends the class "Weapons".
  - A "Bite" class object is created, with name and damage.
  - The function biteAttack() does a bite attack.
  - A random number is established to check accuracy.
  - The program checks if the attack hits, case in which the warrior's health is reduced. If it doesn't hit, nothing will happen and an error message will appear.
  - The program checks if the warrior's health is greater than 0. If it's not, the game will end.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/bite.jpg)

We can see the same process replicated in the class "Claw" and the class "SoulShypon", each of them with their corresponding variables.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Claw.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/soul.jpg)

Additionally, the classes "Sword", "Handaxe" and "Flail" operate in a similar way:

- An object of the corresponding class is created, with name and damage.
- Each class has its own attack function, "swordAttack", etc.
- A random number is established to check accuracy.
- The program checks if the attack hits, case in which the vampire's health is reduced. If it doesn't hit, nothing will happen and an error message will appear.
- The program checks if the vampire's health is greater than 0. If it's not, the game will end.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/sword.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Handaxe.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Flail.jpg)

There is a class called "General Manager", which handles the entire battle dynamic:
  - Several objects and variables are declared beforehand.
  - The iniciate() method initializes the objects and variables created, and creates instances of other classes.
  - the combat() method is the core of the game. The entire combat structure is in this function, ending itself when the health of one of the characters reaches 0.
  - The "Scanner" class is also used, to register the user's inputs and to know what actions the user wants the warrior to perform.
  - After every turn, the game checks the characters' health. If one of them has no health left, the gameOver() variable turns true and the game ends with a message.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/GM1.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/GM2.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/GM3.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/GM4.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/GM5.jpg)

The "Warrior" class is a fairly simple one, in which the warrior is created:
  - The Warrior class extends the Characters class.
  - Instances of the Warrior class are created, with 2 parameters: name and health.
  - The function setName() allows for the program to set the name for the warrior character
  - The function setHealth() allows for the program to set the current health for the warrior character.
  - The functions getName() and getHealth() allows for the program to obtain the current values of the aforementioned variables.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/warrior.jpg)

A very similar process is followed in the "Vampire" class, with only an extra function at the end of it to send a message when the vampire has been defeated.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/vampire.jpg)

The "WarriorActions" class defines the available actions for the warrior character:
  - The class "WarriorActions" extends the "Warrior" class.
  - Instances of the "WarriorActions" class are created, with a name and a damage value.
  - Attack objects like "AttackFlail" and others similar are created.
  - An instance of the "Warrior" class is created, with name and damage.
  - Utility objects like the smoke bomb or intimidation are declared.
  - Attack methods are defined in "attackFlail" and similar functions.
  - The NigerunDayo() method is used for the smoke bomb.
  - The Spooky() mehtod is used for the intimidate action.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/WA1.jpg)

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/WA2.jpg)

Parallel to this class, the "VampireAttack" class defines the actions the vampire can take:
  - The "VampireAttack" class extends the "Weapons" class.
  - An instance of the "VampireAttack" class is created, with damage and accuracy.
  - The objects of the different attacks the vampire can perform are created.
  - The vampireAttack() method selects what attack the vampire will use, taking a generated random number.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/VA.jpg)

The "Dagger" class is really simple. It extends the "Equipment" class, and it creates an instance of the "Dagger" class, with name and cuantity.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Dagger.jpg)

The "SmokeBomb" class does the exact same thing, only it also provides with a message in case the smoke bomb lands and the warrior runs from the battle.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/smoke bomb.jpg)

The "DaggThrow" class behaves the same as the class of any of the other warrior weapons.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/DaggThrow.jpg)

The "Intimidate" class is another subclass of the "Weapons" class, and it works exactly like the "DaggThrow" class.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Intimidate.jpg)

The abstract class "Characters" class only has 2 protected variables:
  - Health, which is a double.
  - Name, which is a string.
  - With these 2 variables, it creates and instance of the "Characters" class
![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Characters.jpg)

The "Equipment" class also has only 2 protected variables:
  - Name, which is a string.
  - Cuantity, which is an int.
  - With these 2 variables, it creates an instance of the "Equipment" class.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/Equipment.jpg)

The "Main" class only has an object of the class "General Manager" which initiates the "initiate" and "combat" actions, defined in the "GeneralManager" class.

![](https://github.com/AlejandroVinas/awesome-projects-prograii/blob/main/AlejandroVinas/docs/main.jpg)



As far as user instructions, they are pretty simple. The program will ask the user to select an action. The user then has to insert by console a number between 1 and 3, to select his main action. If 1 is selected, then the user will be asked to choose a weapon by another console input: if 1, he will use the sword, the handaxe if 2 and the flail if 3. If the first input was 2, then the user will again be asked to input a number. If 1 is selected, the character will use the dagger throw, if it's 2, he will use the smoke bomb. Finally, if the user's first input is 3, the character will use the intimidate action. Any other input that differs from what was explained will result in an error message and the game asking the user to select another option.


![](https://plantuml.ctdesarrollo-sdr.org/png/rLQzRjim4Dxz50Iws4Zo0a9Hm4dQfa2JeGwQeUXmbWY9i4Iw51L72FBkfSaJHKgYeo9PwiKKx_lkZyVZfINKDRbaYXBwf2ZFQl90OIzulKYDwAg4GqHq3NbEfHD-_jEmVKMvyiJtXHGn-aOqvQRT5u9705zAO6L4TWCyWwUOqz-uOXNB81hLfX8xUYcgRTJxpK78BCB-2TMUoLxtLG4IKaNb0B1M2j9THCa3ICc4Z2j1m3fLJBDwBNPxWQXRO9myBuZ-dLLwlGIPrmdPACbu_kltAY6FWcMBbmLiQtKqG2pFnOla3nmgsl7iJjg0pgDg4y9qMem5nrhwy7CIG5TZQtrmSNC51LKM2Sb4iosfjTVp1WOrk5GEl3BeaLLCE9gyoA22d0O6BY1D6yreGxC7InpO3FddPCYrNfpbL5qRv78LQjM2DLA6ejfnGYFTyNKWnn_PTi0N__PWOPZrSgR_1cnBztMAxr_1rBAlD-yQeHTcFTUB-WX-Bo-mMw0VXVsQwmd2t-vBs1pGcKVxTRAyjHLZ_FMaKNMdzGJAXYLqOrGl1nV81-KED2vWetxbBkxBLCCB8vkRjmbIFJf8R7veuM2__jFSOKZ7jnVZsUhbt4GTiPZQOPAEJpPgr1k7kHgFs8Z6hvHJ2UKjSAseopwUHKBm6EmkLe9MO1TszuU-Gw8YqlpXOyMuzx1KyEHz1LMGXDLb4NRsI7066JnEQocX_SvgbH2pBFNoevD-mcxKZG19FmqOIJyy9DxQalObj5JUDrBxlXMYfC2jW76MCWrR1jMGQfqmqHJTvDDrHhSnkprgHkImmha1BTXBO5fxOfy6VzzqviGsQtyV-sRIDL1VDdK2hYGU_9A8PlhiLAh3C6Oy_twCuJ5uGKu9CBWfaGqkbDmnlTLeIYj2mMOlnAuTdOVLyRp0cWqZ6GrEWzdv-TIjSgYvLPFD9_Y1EJjOSKFm-OcXPUevxe_wP7WzxD_SjUVmRXDCLx8dVNMeDnZy2m00)
