import java.util.Scanner;

public class Start {
    public static int start() throws Exception{
        String inputLine = getInputLine();
        return checkDate(inputLine);
    }

    private static String getInputLine() {
        System.out.println("Привет! Давай рассчитаем максимальный процент изъятия.");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введи год, начиная с которого ты будешь жить на проценты(2002-2021) ");
        String inputLine;
        inputLine = keyboard.nextLine();
        keyboard.close();
        return inputLine;
    }

    private static int checkDate(String inputLine) throws Exception {
        int input = Integer.parseInt(inputLine);
        if (input > 2021 || input < 2002) {
            throw new Exception("Ввели не подходящий год");
        }
        return input;
    }
}
