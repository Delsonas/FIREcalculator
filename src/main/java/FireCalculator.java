public class FireCalculator {
    private static final int START_SUM = 0;
    private static final int START_DATE = 2002;
    private static final int END_DATE = 2022;
    private static final double PERCENT_START = 0;
    private static final double PERCENT_DELTA = 0.5;

    public double calculate(int input) {
        double percentMax;
        for (double percent = PERCENT_START; ; percent += PERCENT_DELTA) {
            double testSum = findTestSumForPercent(input, percent);
            percentMax = percent;
            if (testSum <= 0) {
                break;
            }
        }
        return percentMax;
    }
    private double findTestSumForPercent(int input, double percent) {
        double testSum = START_SUM;
        double percentAccumulated = percent;
        for (int date = input - START_DATE; date < END_DATE - START_DATE; date++) {
            //если 2002 год, то мы не считаем увеличение/уменьшение капитала и в этот год и инфляцию за прошлый, т.к. нет данных из предыдущего года
            if (date == 0) {
                testSum -= percentAccumulated;
                continue;
            }
            testSum -= percentAccumulated;
            testSum += ((Constants.MOEX_RATE[date] - Constants.MOEX_RATE[date - 1]) / Constants.MOEX_RATE[date - 1])*100 - Constants.INFLATION_RATE[date - 1];
            percentAccumulated = (percentAccumulated * (1 + Constants.INFLATION_RATE[date - 1] / 100));

       }
        testSum -= percentAccumulated; /* когда 2022 наступал, мы выходили из цикла внутреннего и не делали вычитание процента изъятия
         (чтобы не умереть с голоду в 22 году)*/
        return testSum;
    }
}



