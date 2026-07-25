package com.example;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    // Simple recursive approach.
    // Each year has its own growth rate (real companies rarely grow at a fixed
    // rate every year), so we recurse through the array one year at a time
    // instead of just doing presentValue * (1+rate)^years.
    //
    // Base case: no more years left to grow -> return the value as is.
    // Recursive case: grow the value by this year's rate, then move to the next year.
    public static double calculateFutureValue(double presentValue, double[] growthRates, int year) {
        if (year == growthRates.length) {
            return presentValue;
        }

        double grownValue = presentValue * (1 + growthRates[year]);
        return calculateFutureValue(grownValue, growthRates, year + 1);
    }

    // Same idea, but memoized.
    // On its own this recursion doesn't repeat subproblems, so memoization
    // doesn't help a single call. Where it actually pays off is when the tool
    // is asked to forecast the same starting value + rates combination
    // multiple times (e.g. a user re-running "what if" scenarios on the
    // same inputs) - we cache the result instead of recomputing it every time.
    private static final Map<String, Double> cache = new HashMap<>();

    public static double calculateFutureValueMemoized(double presentValue, double[] growthRates, int year) {
        String key = presentValue + "-" + year;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        double result;
        if (year == growthRates.length) {
            result = presentValue;
        } else {
            double grownValue = presentValue * (1 + growthRates[year]);
            result = calculateFutureValueMemoized(grownValue, growthRates, year + 1);
        }

        cache.put(key, result);
        return result;
    }
}