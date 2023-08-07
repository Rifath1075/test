//subclass of car
public class Sports extends Car{
    //unique property
    private int boost;
    
    public Sports(String brand, String engine, double horsepower, int weight, boolean effeciency, double acceleration, int b){
        super(brand, engine, horsepower, weight, effeciency, acceleration);
        this.boost = b;
    }
    //method override
    public void accelerate(){
        setSpeed(getSpeed()+10+this.boost);
        reducePetrol();
    }
}