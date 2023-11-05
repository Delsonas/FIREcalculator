public class FireCalculator {
    public double calculate(int input) {
        int date = 0;
        double percent = 0.5;
        for (double testSum = 100; testSum > 0; ) {
            testSum = 100;
            for (date = input - 2002; date < 20; date++) {
                testSum -= percent;
                //если 2002 год, то мы не считаем увеличение/уменьшение капитала в этот год, т.к. нет данных из предыдущего года
                if (date != 0){
                    testSum = testSum +
                            testSum*(((Constants.MOEX_RATE[date] - Constants.MOEX_RATE[date - 1]) / Constants.MOEX_RATE[date - 1] * 100)
                                    -  Constants.INFLATION_RATE[date])/100;
                }
            }
            percent += 0.5;
        }
        return percent;
    }
}


