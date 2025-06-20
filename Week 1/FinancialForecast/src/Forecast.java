public class Forecast {
     public static void main(String[] args) {
        double presentValue = 10000;
        double rate = 0.13;          
        int years = 5;

        double futureValue = FinancialForecast.forecastRecursive(presentValue, rate, years);
        System.out.printf("Forecasted value after %d years (recursive): Rs. %.2f\n", years, futureValue);

        Double[] memo = new Double[years + 1];
        double optimizedValue = FinancialForecast.forecastMemo(presentValue, rate, years, memo);
        System.out.printf("Optimized forecast using memoization: Rs. %.2f\n", optimizedValue);
    }
}
