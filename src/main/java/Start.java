import java.util.Scanner;

public class Start {
    public static int start() throws Exception{
        System.out.println("Привет! Давай рассчитаем максимальный процент изъятия.");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Введи год, начиная с которого ты будешь жить на проценты(2002-2022) ");
        String inputLine = "";

        inputLine = keyboard.nextLine();
        keyboard.close();

        //проверка, что ввели число, а не текст, нужна?
        int input = Integer.parseInt(inputLine);

        if (input > 2022 || input < 2002) {
            throw new Exception("Ввели не подходящий год");
        }

        return input;
    }
}
