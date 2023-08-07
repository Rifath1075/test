//subclass of car
public class Hybrid extends Car{
    //unique property
    private boolean effeciency = true;
    
    public Hybrid(String brand, String engine, double horsepower, int weight, boolean effeciency, double acceleration){
        super(brand, engine, horsepower, weight, effeciency, acceleration);
    }
    //method override
    public void accelerate(){
        setSpeed(getSpeed()+10);
    }
}