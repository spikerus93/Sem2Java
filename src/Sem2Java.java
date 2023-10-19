import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Sem2Java {
    public static void main(String[] args){
        task2Log("");

    }
    static void task0(int n, char c1, char c2){

//        Дано четное число N (>0) и символы c1 и c2.
// Написать метод, который вернет строку длины N, которая
// состоит из чередующихся символов c1 и c2, начиная с c1.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n/2; i++) {
            stringBuilder.append(c1).append(c2);

        }
        System.out.println(stringBuilder);

    }
    static void task1(String str){

//        Напишите метод, который сжимает строку.
//� Пример: вход aaaabbbcdd.
//    a4b3c1d2
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i-1]) {
                count++;

            } else {
                stringBuilder.append(chars[i-1]).append(count+1);
                count = 0;
            }


        }
        stringBuilder.append(chars[chars.length - 1]).append(count+1);
        System.out.println(stringBuilder.toString());
    }

    static void task2Log(String str){
//        Напишите метод, который составит строку,
//        состоящую из 100 повторений слова TEST и метод,
//        который запишет эту строку в простой текстовый файл,
//        обработайте исключения.
        String path = "/g/g/g/text.txt";
        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt", true);
        } catch (IOException e) {
            e.printStackTrace();

        }
        logger.addHandler(fileHandler);

        SimpleFormatter simpleFormatter = new SimpleFormatter();
        fileHandler.setFormatter(simpleFormatter);

        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(str);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.INFO, e.getMessage());
        }
    }
    static String RepeatStr(String str, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);

        }
        return sb.toString();
//        repeat = str.repeat(n);

    }



}

