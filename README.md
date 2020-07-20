# Product_Inventory
Create a Product class called Product with instance variables as follows (ensure encapsulation is
enforced):
• item number (The first starts at 0 and increments every time a new product is created)
• the name of the product
• the number of units in stock
• the price of each unit
• the product status
You want to be able to mark your products as active or discontinued. If a product is discontinued
it means that the remaining stock will be the last of it, and no more orders are to be made.
Create a constructor that takes the following parameters: product name, number of units in stock,
price and product status. Initialize the instance variables.
Write getter/accessor and setter/mutator methods for each of the five instance variables. Ensure
that the number of units in stock and price of unit is non-negative.
Override the toString() method from the object class that will show a description of each object
that includes the variable values. The product status, should read Active or Discontinued.
Create an abstract method called stockValue in the Product class that will calculate the value of
each inventory item using the quantity on hand and price. This method accepts no arguments and
returns a double value. (For example, if I have 10 cd’s at a cost of $50 each, the value in the
inventory for that item is ($500).
Override the equals() method from the object class, two objects are equal if their item number is
the same.
Create two new methods in the Product class
• one that will allow the user to add to the number of units in stock
• one that will allow the user to deduct from the number of units in stock.
Both methods should have a parameter for the number of items to add/deduct. Ensure the
units don’t become negative.
Word has spread about your inventory software and you have been approached by a company
that sells exclusively CDs and DVDs. They would like you to customise your software so that it
can store the length, age rating and film studio for DVDs as well as artist, number of songs and
label for their CDs. 
Implement inheritance by creating subclasses of the Product class. Create a subclass of
the Product class called DVD that has additional instance fields to store the movie length
in minutes, the age rating and the Film Studio that released the movie.
Create a single constructor that accepts values for every instance field required for both
the DVD and Product classes. Use the super() call to the constructor in Product passing
the required parameters.
Create getters and setters for the DVD instance fields.
Override toString() method to include the new DVD fields, note the Stock Value needs to
be calculated and displayed when the toString() method is invoked. DO NOT CREATE AN
INSTANCE FIELD FOR STOCK VALUE
In the DVD subclass, override the method stockValue. The DVD subclass method should
also add a 5% restocking fee to the value of the inventory of that product. You will need
to get the values for price and quantity in stock from the superclass.
Sample data for a DVD
Item Number 1
Name Daredevil
Movie Length 99
Age Rating 15
Film Studio 20th Century Fox
Quantity in stock. 50
Price 8.99
Stock Value 471.975
Product Status Active
Follow exactly the same process to create a subclass of Product named CD. Create the
instance fields, constructor, getter and setters, toString() method and implement
stockValue.

 Sample data for a CD
Item Number 2
Name Dreams we never lost
Artist Tidelines
Songs on Album 14
Record label Tide Lines Music
Quantity in stock 50
Price 7.99
Stock Value 399.5
Product Status Active
Using JavaFx, produce a user interface for this application with the following menu items
Create a Product Add units Deduct units Discontinue Product Print Products
Menu Items Details
Create a Product
On selecting this menu option, prompt the user to select the type of object to be created, either
a CD or a DVD. A radio button can be used for simplicity, the form fields required to create the
particular product would appear for the user to complete. When the form is submitted, the
corresponding object should be created and stored in ONE ArrayList . This ArrayList has the ability
to store any product.
Add Units
Prompt the user to enter the item number to be altered. Search for the product and prompt
the user to enter the number of units to be added. Update the stock Units. NB if the product is
discontinued, this option isn’t available. An appropriate message should be displayed.
Deduct Units
Prompt the user to enter the item number to be altered. Search for the product and prompt
the user to enter the number of units to be removed. Update the stock Units.
Discontinue Product
Prompt the user to enter the item number of the product you wish to discontinue. Search for
the product and apply the changes. A message should appear indicating that the action was
completed.
Print Inventory
Display all items in the inventory well formatted
Additional Requirements
You will observe that you have to search for the product a few times, create a method that
handles this operation.
Create Custom Exceptions to handle
1. Attempting to add units to a discontinued product
2. Attempting to deduct more units than available. 
