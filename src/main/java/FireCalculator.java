public class FireCalculator {
    private static final int START_DATE = 2002;
    private static final int END_DATE = 2022;
    private static final double PERCENT_START = 0.5;
    private static final double PERCENT_DELTA = 0.5;

    public double calculate(int input) {
        double percentMax;
        for (double percent = PERCENT_START; ; percent += PERCENT_DELTA) {
            double testSum = findTestSumForPercent(input, percent);
            percentMax = percent;
            if (testSum >= 0) {
                break;
            }
        }
        return percentMax;
    }

    private double findTestSumForPercent(int input, double percent) {
        double testSum = percent * (END_DATE - input + 1);
        double initSum = testSum;
        for (int date = input - START_DATE; date < END_DATE - START_DATE; date++) {
            //если 2002 год, то мы не считаем увеличение/уменьшение капитала и в этот год и инфляцию за прошлый, т.к. нет данных из предыдущего года
            if (date == 0) {
                testSum -= percent;
                continue;
            }
            testSum -= testSum / initSum * percent;
            testSum = testSum * (1 + (Constants.MOEX_RATE[date] - Constants.MOEX_RATE[date - 1]) / Constants.MOEX_RATE[date - 1] - Constants.INFLATION_RATE[date - 1] / initSum);
        }
        testSum -= percent; /* когда 2022 наступал, мы выходили из цикла внутреннего и не делали вычитание процента изъятия
         (чтобы не умереть с голоду в 22 году)*/
        return testSum;
    }
}



