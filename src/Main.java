import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static boolean numberIsRoman = false;
    static String[] symbols = {"M","CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};



    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String input = s.nextLine();
        System.out.println(calc(input));

    }

    public static String arab_to_rome(int arab) {
        String result = new String();
        int num = arab;
        int[] cost = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for(int i = 0; i < cost.length;){
            if(num >= cost[i]){
                result += symbols[i];
                num-=cost[i];
            }

            else{
                i++;
            }
        }

        return result.toString();
    }

    public static String calc(String input) throws Exception {
        for (int i = 0; i < symbols.length; i++){
            if(input.contains(symbols[i])) {
                numberIsRoman = true;
            }
        }
        String[] digits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        if(numberIsRoman == true) {
            for(int i = 0; i < digits.length; i++){
                if(input.contains(digits[i])){
                        throw new Exception("В одной строке не может быть и римских, и арабских чисел");
                }
            }
        }

        int result = 0;
        String[] split = input.split(" ");
        if(split.length > 3){
            throw new Exception("Вы можете ввести только 2 числа и оператор");
        }

        String num1 = split[0];
        String operation = split[1];
        String num2 = split[2];
        int x;
        int y;

        if(numberIsRoman == true) {
            x = Roman.valueOf(num1).toInt();
            y = Roman.valueOf(num2).toInt();

        } else{
            x = Integer.parseInt(num1);
            y = Integer.parseInt(num2);
        }

        while(true) {
            if (x > 10 || y > 10) {
                    throw new IOException();

            } else {
                break;
                }

            }


            switch (operation) {
                case "+":
                    result = (x + y);
                    break;

                case "-":
                    result = (x - y);
                    break;

                case "*":
                    result = (x * y);
                    break;

                case "/":
                    result = (x / y);
                    break;

            }

        if(numberIsRoman == true) {
            return arab_to_rome(result);
        }
            return String.valueOf(result);
    }
}
