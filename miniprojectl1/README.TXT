Student name: Mohammed Rifath Ahmed
Student number: 190183969

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 2

LEVEL ONE

My code demonstrates inheritance in the following way:

I have a superclass called Car

This superclass is extended into at least three subclasses called Sports, Jeep, 
Hybrid

***************************************************************************************
Subclass 1.

Subclass Jeep extends the superclass by adding at least one property and its 
getters and setters. The name of the added property is speedcost which is used 
in the overriding method in line 11. This is so the Jeep cars have a reduced 
acceleration compared to the rest of the types of cars. 

Subclass Jeep extends the superclass by overriding the accelerate method, which 
is different for each car type, lines 10-13. 

The overridden methods are used in the working code in the following places:
- class: Track; line: 32, 54, 72, 103, 113
****************************************************************************************
Subclass 2.

Subclass Sports extends the superclass by adding at least one property and its 
getters and setters. The name of the added property is boost which is used in 
the overriding method in line 11. This is so the Sports cars have a increased 
acceleration compared to the rest of the types of cars. 

Subclass Sports extends the superclass by overriding the accelerate method, 
which is different for each car type, lines 11-14. 

The overridden methods are used in the working code in the following places:
- class: Track; line: 32, 54, 72, 103, 113
***************************************************************************************
Sublcass 3.

Subclass Hybrid extends the superclass by adding at least one property and its 
getters and setters. The name of the added property is effeciency which is set 
to true, and this will be used to differentiate the types of cars which will be 
used for the program to decide if it should reduce the petrol levels or not

Subclass Hybrid extends the superclass by overriding the accelerate method, 
which is different for each car type, lines 10-13. 

The overridden methods are used in the working code in the following places:
- class: Track; line: 32, 54, 72, 103, 113
***************************************************************************************

LEVEL TWO

Polymorphism is used to make code more simple by allowing the program to use 
the same instruction regardless of the object type that it's being called with, 
so the method will work for the different possible types. This is done by using 
Substituion princple and Dynamic Binding. Substiution princple states that an 
instance of a superclass can be replaced by an instance of it's subclasses, so 
the object type can change between the superclass and subclasses, so if there 
are overriding methods, then these will replace the original method. This 
introduces dynmaic binding, which is when the program figures out which method 
to run during run time, since the object of the superclass can be changed to an 
instance of its subclasses. 

Places found:
- class: Simulation; line: 6
- class: Track; line: 32, 54, 72, 103, 113
- class: userInfo; line: 11, 15, 19

Polymorphism is necessary in my code since it allows me to use certain methods 
without the need to adjust them so it suits the type of the instance the object 
calls the method on. Regardless of the type, if I call the method accelerate() 
then it will call the relevant method through the use of dynamic binding, since 
the program will figure out which accelerate() method to use during run time. 
Without it the actions would need to be set individually for each different type 
of car. 


ANYTHING ELSE:
Main method in Simulation class