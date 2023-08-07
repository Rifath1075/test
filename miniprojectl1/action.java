//class for the different things that can happen in the race
public class action extends userInfo{
    public static void overtaken(){
        int position = getPosition();
        //condition created, user only gets overtaken only if they aren't
        //already last place
        if(position < 3){
            //set position as current position plus one
            setPosition(position + 1);
            func.print("You've been overtaken!");
        }
        func.printPosition();
    }
    
    public static void overtake(){
        int position = getPosition();
        //user only overtakes if they aren't already first place
        if(position > 1){
            setPosition(position - 1);
            func.print("Well done, you've overtaken the car");
        }
        func.printPosition();
    }
    //car crash simulation
    public static void carCrash(){
        int position = getPosition();
        setPosition(3);
        func.print("You've crashed!");
        func.print("You are unable to finsih the race");
        func.delay(1);
        func.print("Position: DNF");
        System.exit(0);
        //ends program if the user crashes, unable to race anymore
    }
}