public class Statistic {
    private String country;
    private long amount;

    public Statistic() {
    }

    public Statistic(String country, long amount) {
        this.country = country;
        this.amount = amount;
    }

    public String getCountry() {
        return this.country;
    }

    public long getAmount() {
        return this.amount;
    }

    public void print() {
        System.out.print("There are " + this.amount + " from " + this.country + "\n");
    }
}