public class Main {
    public static void main(String[] args) throws Exception {
        int input = Start.start();
        FireCalculator fireCalculator = new FireCalculator();
        System.out.println(fireCalculator.calculate(input));
    }
}


