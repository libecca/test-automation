package FlowerShop;

/*Class to create user and shopkeeper with**/
public class Person{
    //private String name;
    private double money;
    public Person(double money){
        this.money=money;
    }
    public double getMoney(){
        return money;
    }
    public void transaction(double money){
        this.money+=money;

    }
}


