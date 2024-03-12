public class Cafe extends Building {
private int nCoffeeOunces;  // The number of ounces of coffee remaining in inventory
private int nSugarPackets;  // The number of sugar packets remaining in inventory
private int nCups;  // The number of cups remaining in inventory
private int nCreams;  // The number of "splashes" of cream remaining in inventory


    // Class constructor
    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors); 
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /**
     * Check if cafe has enough supplies to sell order
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     * @return whether or not store has enough cupplies to fulfill order
     */
    private boolean canSell(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces > size && this.nSugarPackets > nSugarPackets && this.nCreams > nCreams && this.nCups > 0){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Restock cafe supplies by adding extra amounts of coffee ounces, sugar packets, creamers and cups
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     * @param nCups number of cups of coffee user desires 
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    /**
     * Reduces amount of cafe supplies when a cup of coffee is sold
     * @param size number of coffee ounces user desires
     * @param nSugarPackets number of sugar packets user desires
     * @param nCreams number of creams user desires 
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.canSell(size, nSugarPackets, nCreams)){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
        else{
            this.restock(size*5, nSugarPackets*5, nCreams*5, 5);
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= nSugarPackets;
            this.nCreams -= nCreams;
            this.nCups -= 1;
        }
    }
}

/**
 * NOTES TO ME -> personal notes to help future me walk through my code
 * Since all the attributes are private, can I simply change them within the methods as I have done here? No. A class doesn't need an accessor to its own attributes

 * CODE TESTER:
 *  public static void main(String[] args) {
        Cafe compassCafe = new Cafe("Compass Cafe", "Neilson Library", 1, 50, 100, 100, 100);
        compassCafe.sellCoffee(200, 250, 70);
        System.out.println("ncoffeeounce: " + compassCafe.nCoffeeOunces + " Num of sugar: " + compassCafe.nSugarPackets + " nCreams: " + compassCafe.nCreams + " num of cups: " + compassCafe.nCups);
    }
 */