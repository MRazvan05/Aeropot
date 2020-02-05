public class Flight
{
    int number, seats, bags, passagers, maxBags;

    public Flight(int seats, int number, int passagers, int bags)
    {
        if (passagers < seats)
        {
            this.seats = seats;
            this.number = number;
            this.passagers = passagers;
            this.bags = bags;
            maxBags = this.passagers * 2;
        }
        else
        {
            toManyPassagers();
        }
    }

    public void addMorePassager(int n, int b)
    {
        if(hasSeating(n) && vBags(b))
        {
            passagers += n;
            bags += b;
        }
        else
        {
            toManyPassagers();
        }
    }

    public void add1Passager(int n)
    {
        if(hasSeating() && vBags(n) && n <= 2)
        {
                passagers++;
                bags += n;
        }
        else
        {
            toManyPassagers();
        }

    }
    public boolean hasSeating()
    {
        return passagers < seats;
    }

    public boolean hasSeating(int n)
    {
        return passagers + n <= seats;
    }

    public void toManyPassagers()
    {
        System.out.println("To many passagers");
    }

    public void toManyBags()
    {
        System.out.println("To many bags");
    }

    public boolean vBags(int n)
    {
        return (n + bags) <= (this.passagers * 2);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPassagers() {
        return passagers;
    }

    public void setPassagers(int passagers) {
        this.passagers = passagers;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getBags() {
        return bags;
    }

    public void setBags(int bags) {
        this.bags = bags;
    }

    public int getMaxBags() {
        return maxBags;
    }

    public void setMaxBags(int maxBags) {
        this.maxBags = maxBags;
    }

    @Override
    public String toString() {
        return "Flight number : " + number +
                ", seats : " + seats +
                ", passagers : " + passagers +
                ", bags : " + bags +
                ", maxBags : " + maxBags ;
    }
}
