public class TwoPlacesDecimal {

    public static void main(String[] args) {
        double val = 123.400d;
        double rounded = Math.round(val*100.0)/100.0;
        System.out.println(rounded);
        System.out.println(String.format("%.2f", val));
    }
}