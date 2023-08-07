public class userInfo{
    private static int position;
    
    public static Car chooseCar(){
        //gives user the choice to pick their car
        func.print("Pick your car category (once chosen you can view the properties and confirm selection");
        func.print("- Hybrid: BMW i8 | 1.5L | 370hp | 1500kg | Increased effeciency\n- Sports: Nissan GTR | 3.8L | 565hp | 1700kg\n- Jeep: Lamborghini Urus | 4.0L | 640hp | 2200kg");
        String choice = func.input("");
        if(choice.equalsIgnoreCase("hybrid")){
            //sets object car as an instance of the sub class the user picks
            Car userPick = setHybrid();
            return userPick;
        }
        else if(choice.equalsIgnoreCase("sports")){
            Car userPick = setSports();
            return userPick;
        }
        else if(choice.equalsIgnoreCase("jeep")){
            Car userPick = setJeep();
            return userPick;
        }
        else{ //invalid car choice
            func.print("Invalid choice, program will close");
            System.exit(0);
            return null;
        }
    }
    
    //getters and setters
    public static void setPosition(int p){
        position = p;
    }
    
    public static int getPosition(){
        return position;
    }
    
    //sets user car as the type they chose
    public static Car setHybrid(){
        Hybrid userCar = new Hybrid("BMW i8", "1.5L", 370, 1500, true, 1);
        return userCar;
    }
    
    public static Car setSports(){
        Sports userCar = new Sports("Nissan GTR", "3.8L", 565, 1700, false, 0.6, 10);
        return userCar;
    }
    
    public static Car setJeep(){
        Car userCar = new Jeep("Lamborghini Urus", "4.0L", 640, 2200, false, 1);
        return userCar;
    }
    
    //set type of car according the option that the user picks. checks
    //the object car to see what type of instance it istype.equals("Sports")
    public static String setType(Car userCar){
        if(userCar instanceof Jeep){
            return "Jeep";
        }
        else if(userCar instanceof Sports){
            return "Sports";
        }
        else if (userCar instanceof Hybrid){
            return "Hybrid";
        }
        else{
            return null;
        }
    }
}