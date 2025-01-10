public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train (String n, String d) {
        name = n; destination = d;
    }

    public Train (String n, String p, String o, String d, int w, int m) {
        name = n; product = p; origin = o; destination = d;
        weight = w; miles = m;
    }

    public String getName(){
        return name;
    }

    







  public String toString() 
  {
    return name +", "+ product +", "+ origin +", "+ destination +", "+ weight +", "+ miles;
  }
}//end class
