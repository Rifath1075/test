import java.util.*;
//different general functions that are used throughout the project
public class func{
    public static void print(String output){
        System.out.println(output);
    }
    
    public static String input(String message){
        Scanner scanner = new Scanner(System.in);
        print(message);
        String userInput = scanner.nextLine();
        return userInput;
    }
    //creates a delay in the runtime of the code to create a simulation effect
    public static void delay(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
    //prints current position of the user
    public static void printPosition(){
        int p = userInfo.getPosition();
        print("Position: "+p);
    }
}