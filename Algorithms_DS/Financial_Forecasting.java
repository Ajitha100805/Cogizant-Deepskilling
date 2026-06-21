public class Financial_Forecasting {

    static double futureValue(double currentValue, double growthRate, int years) {

        if(years == 0)
            return currentValue;

        return futureValue(currentValue * (1 + growthRate / 100),
                           growthRate,
                           years - 1);
    }

    public static void Main(String[] args) {

        double currentValue = 10000;
        double growthRate = 10;
        int years = 3;

        double result = futureValue(currentValue, growthRate, years);

        System.out.println("Current Value: " + currentValue);
        System.out.println("Growth Rate: " + growthRate + "%");
        System.out.println("Years: " + years);
        System.out.println("Future Value: " + result);
    }
}