public class FireCalculator {
    public double calculate(int input) {
        int date;
        double percent = 0.5;
        for (double testSum = 100; testSum > 0; percent += 0.5) {
            testSum = 100;
            for (date = input - 2002; date < 20; date++) {
                testSum -= percent;
                //если 2002 год, то мы не считаем увеличение/уменьшение капитала в этот год, т.к. нет данных из предыдущего года
                if (date > 0) {
                    testSum = testSum *
                            (1 + (((Constants.MOEX_RATE[date] - Constants.MOEX_RATE[date - 1]) / Constants.MOEX_RATE[date - 1])
                                    - Constants.INFLATION_RATE[date] / 100));
                }
            }
            testSum -= percent; /* когда 2022 наступал, мы выходили из цикла внутреннего и не делали вычитание процента изъятия
             (чтобы не умереть с голоду в 22 году)*/
        }
        return percent;
    }
}



