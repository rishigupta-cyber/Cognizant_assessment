package com.example;

public class ForecastDemo {

    public static void main(String[] args) {

        double startingValue = 10000.0; // e.g. current portfolio or revenue value

        // Growth rate for each upcoming year, pulled from past performance/trends
        double[] pastGrowthRates = {0.05, 0.07, 0.04, 0.06, 0.03};

        System.out.println("---- Recursive Forecast ----");
        double futureValue = FinancialForecast.calculateFutureValue(startingValue, pastGrowthRates, 0);
        System.out.printf("Starting value: %.2f%n", startingValue);
        System.out.printf("Projected value after %d years: %.2f%n", pastGrowthRates.length, futureValue);

        System.out.println("\n---- Memoized Forecast (repeated call) ----");
        long start = System.nanoTime();
        double firstCall = FinancialForecast.calculateFutureValueMemoized(startingValue, pastGrowthRates, 0);
        long afterFirst = System.nanoTime();
        double secondCall = FinancialForecast.calculateFutureValueMemoized(startingValue, pastGrowthRates, 0);
        long afterSecond = System.nanoTime();

        System.out.printf("First call result: %.2f (took %d ns)%n", firstCall, (afterFirst - start));
        System.out.printf("Second call result: %.2f (took %d ns, served from cache)%n", secondCall, (afterSecond - afterFirst));
    }
}