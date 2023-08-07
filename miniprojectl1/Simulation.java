import java.util.*;
import java.lang.*;

class Simulation{
    public static void main(String[] args){
        Car userCar = userInfo.chooseCar(); //user selects car choice
        func.print("You have chosen "+userCar.brand);
        String type = userInfo.setType(userCar); //creates a variable of the type of car according to the car that the user choice
        Track.startRace(type, userCar); //starts the simulation and game
        Track.firstCorner(type, userCar);
        Track.secondCorner(type, userCar);
        Track.finalStretch(type, userCar);
        func.delay(1); //creates a 1 second delay in the program so it runs smoothly
        int position = userInfo.getPosition();//gets the final place of the user
        func.print("Well done you've finished the race!\nYou've placed: "+position);
        System.exit(0);
        
        //String f = func.input("what is your name?");
        //String g = func.
    }
}