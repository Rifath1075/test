import java.util.*;
//class with all the track details such as corners
public class Track{
    public static void startRace(String type, Car userCar){
        func.print("Race is starting in : 3"); func.delay(1);
        func.print("2"); func.delay(1);
        func.print("1"); func.delay(1);
        func.print("GO");
        func.input("Press enter to go");
        //position of user on the first straight depends on the car they chose
        if(type.equals("Jeep")){
            func.print("You have chosen a Jeep which has times more power than non Jeep cars\nYou are second");     
            userInfo.setPosition(2);
        }
        else if(type.equals("Sports")){
            func.print("You have chosen a Sports car which has the fastest acceleration\nYou are first");
            userInfo.setPosition(1);
        }
        else{
            func.print("You have chosen a hybrid car which is the most effecient\nYou are last");
            userInfo.setPosition(3);
        }
    }
    //First corner
    public static void firstCorner(String type, Car userCar){
        func.delay(1);
        //provide speed for the user so they can make a decision based on it
        func.print("Your speed is "+userCar.getSpeed()+"mph");
        String userOption = func.input("You are approaching the first small corner. Would you like to accelerate, brake, or do nothing?");
        if(userOption.equalsIgnoreCase("accelerate")){
            //car accelerates and prints position accordingly
            userCar.accelerate();
            func.printPosition();
        }
        
        else if(userOption.equalsIgnoreCase("brake")){
            //if user brakes then they'll be overtaken
            userCar.brake();
            action.overtaken();
            func.printPosition();
        }
        else{ //do nothing option
            func.printPosition();
        }
    }
    //Second corner
    public static void secondCorner(String type, Car userCar){
        func.delay(1);
        func.print("Your speed is "+userCar.getSpeed()+"mph"); func.delay(1);
        String userOption = func.input("You are approaching a tight muddy bend. Would you like to accelerate, brake, or do nothing?");
        
        //different outcomes according to the type of car you chose
        if(userOption.equalsIgnoreCase("accelerate") && userCar.getPower()>600.0){
            userCar.accelerate();
            action.overtake();
        }
        else if(type.equals("Sports")){
            if(userOption.equalsIgnoreCase("brake")){
                userCar.brake();
                action.overtaken();
            }
            else if(userCar.getSpeed()>58){
            //sports car will crash if accelerates at high speeds and end race
                userCar.crash();
                action.carCrash();
            }
            else if(userOption.equalsIgnoreCase("accelerate")){
                func.printPosition();
            }
        }
        else if(userOption.equalsIgnoreCase("accelerate") && type.equals("Sports")){ //option of hybrid car
            userCar.accelerate();
            //creates rng which simulates if the ai crashes
            Random rand = new Random();
            int x = rand.nextInt(2); //option of 0 or 1
            String n = Integer.toString(x);
            func.print("debug"+n);
            //50/50 chance if the ai crashes or not. If they crash hybrid car overtakes
            if(x==0){ 
                func.printPosition();//ai didn't crash
            }
            else{
                action.overtake();//ai crashes
            }
        }
        else if(userOption.equalsIgnoreCase("brake")){
            userCar.brake();
            func.printPosition();
        }
        else{ //do nothing option
            func.printPosition();
        }
    }
    //Last corner
    public static void finalStretch(String type, Car userCar){
        func.delay(1);
        //creates rng if ai runs out of petrol. Option only for hybrid car
        Random rand = new Random();
        int y = rand.nextInt(2);
        func.print("Your speed is "+userCar.getSpeed()+"mph"); func.delay(1);
        String userOption = func.input("This is the final straight! Would you like to accelerate, brake, or do nothing?");
        if(userOption.equalsIgnoreCase("accelerate") && userCar.effeciency){
            userCar.accelerate();
            if(y==0){ //ai doesn't run out of petrol
                func.printPosition();
            }
            else{ //ai runs out of petrol so user car overtakes
                func.print("The car in front has run out of petrol"); func.delay(1);
                action.overtake();
            }
        }
        else if(userOption.equalsIgnoreCase("accelerate")){
            userCar.accelerate();
            //sports and jeep car lose a lot of petrol. If there's no more petrol left they are overtaken
            int petrol = userCar.getPetrol();
            if(petrol==0){
                func.print("Your petrol has run out and you're slowing down"); func.delay(1);
                action.overtaken();
            }
            else{ //if petrol is above 0 then accelerate and overtake if there's a car in front
                action.overtake();
            }
        }
        else if(userOption.equalsIgnoreCase("brake")){
            action.overtaken();
        }
        else{ //do nothing option
            func.printPosition();
        }
    }
}