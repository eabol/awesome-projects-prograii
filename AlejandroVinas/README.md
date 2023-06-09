### Proyecto final Programación II - Warrior-Vampire game

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

#### Lista de funcionalidades:

- Class "Bite":
  - The class "Bite" extends the class "Weapons".
  - A "Bite" class object is created, with name and damage.
  - The function biteAttack() does a bite attack.
  - A random number is established to check accuracy.
  - The program checks if the attack hits, case in which the warrior's health is reduced. If it doesn't hit, nothing will happen and an error message will appear.
  - The program checks if the warrior's health is greater than 0. If it's not, the game will end.

We can see the same process replicated in the class "Claw" and the class "SoulShypon", each of them with their corresponding variables.

Additionally, the classes "Sword", "Handaxe" and "Flail" operate in a similar way:

- An object of the corresponding class is created, with name and damage.
- Each class has its own attack function, "swordAttack", etc.
- A random number is established to check accuracy.
- The program checks if the attack hits, case in which the vampire's health is reduced. If it doesn't hit, nothing will happen and an error message will appear.
- The program checks if the vampire's health is greater than 0. If it's not, the game will end.

There is a class called "General Manager", which handles the entire battle dynamic:
  - Several objects and variables are declared beforehand.
  - The iniciate() method initializes the objects and variables created, and creates instances of other classes.
  - the combat() method is the core of the game. The entire combat structure is in this function, ending itself when the health of one of the characters reaches 0.
  - The "Scanner" class is also used, to register the user's inputs and to know what actions the user wants the warrior to perform.
  - After every turn, the game checks the characters' health. If one of them has no health left, the gameOver() variable turns true and the game ends with a message.

The "Warrior" class is a fairly simple one, in which the warrior is created:
  - The Warrior class extends the Characters class.
  - Instances of the Warrior class are created, with 2 parameters: name and health.
  - The function setName() allows for the program to set the name for the warrior character
  - The function setHealth() allows for the program to set the current health for the warrior character.
  - The functions getName() and getHealth() allows for the program to obtain the current values of the aforementioned variables.

A very similar process is followed in the "Vampire" class, with only an extra function at the end of it to send a message when the vampire has been defeated.

The "WarriorActions" class defines the available actions for the warrior character:
  - The class "WarriorActions" extends the "Warrior" class.
  - Instances of the "WarriorActions" class are created, with a name and a damage value.
  - Attack objects like "AttackFlail" and others similar are created.
  - An instance of the "Warrior" class is created, with name and damage.
  - Utility objects like the smoke bomb or intimidation are declared.
  - Attack methods are defined in "attackFlail" and similar functions.
  - The NigerunDayo() method is used for the smoke bomb.
  - The Spooky() mehtod is used for the intimidate action.

Parallel to this class, the "VampireAttack" class defines the actions the vampire can take:
  - The "VampireAttack" class extends the "Weapons" class.
  - An instance of the "VampireAttack" class is created, with damage and accuracy.
  - The objects of the different attacks the vampire can perform are created.
  - The vampireAttack() method selects what attack the vampire will use, taking a generated random number.

The "Dagger" class is really simple. It extends the "Equipment" class, and it creates an instance of the "Dagger" class, with name and cuantity.

The "SmokeBomb" class does the exact same thing, only it also provides with a message in case the smoke bomb lands and the warrior runs from the battle.

The "DaggThrow" class behaves the same as the class of any of the other warrior weapons.

The abstract class "Characters" class only has 2 protected variables:
  - Health, which is a double.
  - Name, which is a string.
  - With these 2 variables, it creates and instance of the "Characters" class

The "Equipment" class also has only 2 protected variables:
  - Name, which is a string.
  - Cuantity, which is an int.
  - With these 2 variables, it creates an instance of the "Equipment" class.

The "Main" class only has an object of the class "General Manager" which initiates the "initiate" and "combat" actions, defined in the "GeneralManager" class.

