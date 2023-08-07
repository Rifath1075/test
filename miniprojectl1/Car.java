//superclass for car type
public class Car{
    //properties and variables
    public String brand;
    public String engine;
    public double horsepower;
    public int weight;
    public boolean effeciency;
    public double acceleration;
    private int speed = 40;
    private int petrol = 15;
    //initialise method
    public Car(String brand, String engine, double horsepower, int weight, boolean effeciency, double acceleration){
        this.brand = brand;
        this.engine = engine;
        this.horsepower = horsepower;
        this.weight = weight;
        this.effeciency = effeciency;
        this.acceleration = acceleration;
    }
    
    //abilities
    public void reducePetrol(){
        if(effeciency){
            setPetrol(petrol-5);
        }
    }
    //universal method that gets overridden by subclasses
    public void accelerate(){
    }
    
    public void brake(){
        setSpeed(speed-10);
    }
    
    public void crash(){
        setSpeed(0);
    }
    //getters and setters
    public double getPower(){
        return this.horsepower;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public void setSpeed(int n){
        speed = n;
    }
    
    public void setPetrol(int p){
        petrol = p;
    }
    
    public int getPetrol(){
        return this.petrol;
    }
}