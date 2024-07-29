class FutureValuePredictor {
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static double calculateAverageGrowthRate(double[] pastValues) {
        double totalGrowthRate = 0;
        int periods = pastValues.length - 1;
        for (int i = 1; i < pastValues.length; i++) {
            totalGrowthRate += (pastValues[i] - pastValues[i - 1]) / pastValues[i - 1];
        }
        return totalGrowthRate / periods;
    }
    public static double predictFutureValue(double[] pastValues, int periods) {
        double averageGrowthRate = calculateAverageGrowthRate(pastValues);
        return calculateFutureValue(pastValues[pastValues.length - 1], averageGrowthRate, periods);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0; // Initial value
        double growthRate = 0.05; // Growth rate (5%) for future value calculation
        int futurePeriods = 10; // Number of periods (years) for future value calculation

        double futureValues = calculateFutureValue(presentValue, growthRate, futurePeriods);
        System.out.println("Future Value after " + futurePeriods + " periods: $" + futureValues);

        double[] pastValues = { 1000.0, 2000.0, 1100.5, 1130.63, 1200.51 }; // Example past values
        int predictionPeriods = 5; // Number of future periods to predict

        double FutureValuepredicted = predictFutureValue(pastValues, predictionPeriods);
        System.out.println("Predicted Future Value after " + predictionPeriods + " periods: $" + FutureValuepredicted);
    }
}