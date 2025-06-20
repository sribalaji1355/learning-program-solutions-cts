public class FinancialForecast {

    public static double forecastRecursive(double presentValue, double rate, int years) {
        if (years == 0)
            return presentValue;
        return (1 + rate) * forecastRecursive(presentValue, rate, years - 1);
    }

    public static double forecastMemo(double presentValue, double rate, int years, Double[] memo) {
        if (years == 0)
            return presentValue;

        if (memo[years] != null)
            return memo[years];

        memo[years] = (1 + rate) * forecastMemo(presentValue, rate, years - 1, memo);
        return memo[years];
    }
}
