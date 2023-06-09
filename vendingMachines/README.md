<p align="center">
  <br>
  <samp>
    Hello there! We're a group formed by Álvaro Lostal, Daniel Puente and Adrián García
    <br>We are first-year Computer Engineering students at the Universidad Europea del Atlántico.<br>

</samp>

  <img src="https://raw.githubusercontent.com/TanZng/TanZng/master/assets/hollor_knight3.gif" width="200"/>

</p>


<details align="center">

<summary> <b> <samp> Come and see! </samp></b></summary>
<samp>
<b><h2 style="color: #fc6203">V E N D I N G &nbsp; M A C H I N E</h2> </b>
  
<p>Description</p>
<p align = "left"> We have 3 vending machines with five products per each (Cookies, Chocolate, Drink, Sandwich and Candies). Each product has a name, price and ID. Each machine has an amount of products and  a different amount of money (for the change management).
There are different types of money: Bills (20€, 10€ and 5€) and coins (2€, 1€, 0.5€, 0.2 and 0.05€).
The project simulates the buying/selling of the user managing the user money, the machine money, the change, the amount of products in the machine.
The project keeps in mind the possible failures and jams that might occur during the operation. </p>
<p></p>
<p></p>
 
<p>Functionalities</p>
<p align = "left"> -> Management: The constructor initializes the lists of machines and issues and creates a few Machine instances with products and money in each.
  The screen method displays the report for the specified machine. When it finds the machine with the corresponding ID, it calls the machineReport() method of that machine to display the report.
  The paymentManagement method manages the process of paying and purchasing a product from a specific machine. It takes as input the machine ID, the desired product ID, and the customer's money represented by a Money object. </p>
 
<p align = "left"> -> Machine: The machineReport method prints a report showing the money available and the list of products for the machine.
  The manageChange method manages change during a purchase, calculating the change needed based on the money entered by the customer and the price of the product.
  The possibleJam method simulates a possible jam in the machine, returning a jam status if a random condition is met.</p>
  
<p align = "left"> -> Money: The Money class is in charge of representing and managing an amount of money, allowing operations such as insertion, addition, subtraction and obtaining information related to the denominations and amounts of money.</p>

 <p align = "left"> -> Product: The Product class represents a product with its name, price, identifier, and available quantity. It allows obtaining and establishing information about the product, as well as making sales and updating the available quantity.</p>
<p align = "left"> -> Status: The Status enumerator defines the possible states of a machine. Statuses include "JAM", "FAILURE", "END_STOCK", "NO_CHANGE", and "NORMAL".</p>
<p align = "left"> -> ProductCategory: The ProductCategory abstract class represents a category of products and provides methods to access the category name and description. Product categories can be extended by concrete classes to define specific categories of products.</p>
<p align = "left"> -> FoodCategory: The FoodCategory class is a subclass of ProductCategory that represents a specific category of food. It has an additional sell method that allows you to sell products in this category, updating the quantity available based on the quantity sold. If the quantity requested for sale exceeds the available quantity, a message is displayed that there is not enough stock and the current available quantity is displayed.</p>
<p align = "left"> -> Drinks: The Drinks class is a subclass of Product that represents beverage products. It has additional properties such as isAlcoholic (indicates if it is alcoholic) and milliliters (amount in milliliters). Implements the sell method to reduce the number of drinks available when a sale is made. It also provides an isAlcoholic method to check if the product is alcoholic.</p>
<p align = "left"> -> Alert: The Alert class is an abstract class that extends the Exception class. It serves as the basis for defining custom alert types. It has a constructor that takes a message as a parameter and passes it to the constructor of the Exception base class. In addition, it has an empty alertException() method that can be implemented by subclasses to perform specific actions related to the alert.</p>
  


</p> 


</samp>
</details>

----
Credits:
[lostal](https://github.com/lostal)
[Daaniii23](https://github.com/Daaniii23)
[aadrigaar](https://github.com/aadrigaar)
