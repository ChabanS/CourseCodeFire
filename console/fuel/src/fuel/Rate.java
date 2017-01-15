package fuel;

/**
 *
 * @author Sergey
 */
public class Rate {

    private double km;
    private double rate;

    public void setKm(double km) {
        this.km = km;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double multiplication() {
        return (km * rate) / 100;
    }

    public double getKm() {
        return km;
    }
}
