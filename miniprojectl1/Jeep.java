//subclass of car
public class Jeep extends Car{
    //unique property
    private final int speedCost = 5;
    
    public Jeep(String brand, String engine, double horsepower, int weight, boolean effeciency, double acceleration){
        super(brand, engine, horsepower, weight, effeciency, acceleration);
    }  
    //method override
    public void accelerate(){
        setSpeed(getSpeed()+10-speedCost);
        reducePetrol();
    }
}