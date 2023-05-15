public class items {
    String name;
    String description;
    double price;
    double resaleValue;
    int indexvalue;


    items(String name, double price, double resaleValue){
        this.name = name;
        this.price = price;
        this.resaleValue = resaleValue;  
    }

    public items() {
        this.name = "";
        this.price = 0;
        this.resaleValue = 0;
    }

    public void setDescription(String specificDescription){
        description = specificDescription;
        System.out.println(specificDescription);
    }
    public void description(){
        setDescription("Thank you for buying this item");
    }
}
class Watch extends items{
    private boolean fancy;

    public Watch(String name, double price, double resaleValue, boolean fancy){
        super(name, price, resaleValue);
        this.fancy = fancy;
    }

    @Override
    public void description(){
        if (fancy){
            setDescription("Thank you for buying one of our most expensive watches. Now you can show up to dinner in style.");
        } else{
            setDescription("Expensive watches are only for the foolish, now you can dress in style for a fraction of the price.");
        }
    }
}
class Vehicle extends items{
    private boolean isCar;

    public Vehicle(String name, double price, double resaleValue, boolean isCar){
        super(name, price, resaleValue);
        this.isCar = isCar;

    }

    @Override
    public void description(){
        if (isCar){
            setDescription("Thank you for buying a car. Now you can have easy travels on land.");
        }else{
            setDescription("Thank you for buying a boat, now you can have speedy travels across water.");
        }
    }
}
class Groceries extends items{
    private boolean servingSizelrg;

    public Groceries(String name, double price, double resaleValue, boolean servingSizelrg){
        super(name, price, resaleValue);
        this.servingSizelrg = servingSizelrg;
    }

    @Override
    public void description(){
        if (servingSizelrg){
            setDescription("Thats a lot of groceries, are you hosting a party? Can I come?");
        } else {
            setDescription("Restocking for the house? I hope you enjoy your meal");
        }
    }
}