package ru.test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        String csvSplit = ",";

        try {
            FileWriter csvWriter = new FileWriter("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv");
            csvWriter.append("2");
            csvWriter.append(",");
            csvWriter.append("5");
            csvWriter.append(",");
            csvWriter.append("*");
            csvWriter.append(",");
            csvWriter.append("10.00000000");
            csvWriter.append("\n");
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fr = new FileReader("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv");
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String[] splittedLine = line.split(csvSplit);
                if (matchingNumber(splittedLine[0]) && matchingNumber(splittedLine[1]) && matchingSign(splittedLine[2]) && matchingNumber(splittedLine[3])) {
                    System.out.println("MATCHING SUCCESS");
                    double operand1 = Double.parseDouble(splittedLine[0]);
                    double operand2 = Double.parseDouble(splittedLine[1]);
                    char sign = splittedLine[2].charAt(0);
                    double result = 0;
                    switch (sign) {
                        case '+' -> result = operand1 + operand2;
                        case '-' -> result = operand1 - operand2;
                        case '*' -> result = operand1 * operand2;
                        case '/' -> result = operand1 / operand2;
                    }
                    System.out.println(result);
                    if (result == Double.parseDouble(splittedLine[3])) {
                        System.out.println("Проверка выполнена успешно");
                    } else {
                        System.out.println("Результат вычисления отличается от ожидаемого");
                    }
                } else {
                    System.out.println("MATCHING ERROR");
                };
                System.out.println(splittedLine[0] + "__" + splittedLine[1] + "__" + splittedLine[2] + "__" + splittedLine[3]);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static boolean matchingNumber(String splittedString) {
        String regExp = "-?\\d*\\.?\\d+";
        Pattern prtn = Pattern.compile(regExp);
        Matcher matcher = prtn.matcher(splittedString);
        return matcher.matches();

    }

    public static boolean matchingSign(String splittedString) {
        String regExp = "[\\u002d\\u002b\\u002a\\u002f]?";
        Pattern prtn = Pattern.compile(regExp);
        Matcher matcher = prtn.matcher(splittedString);
        return matcher.matches();

    }



}
//if (parser.parser(reader.reader((new File("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv"))))) {
//
//        calculator.calculator(reader.reader((new File("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv"))));
//        System.out.println(calculator.calculator(reader.reader((new File("C:\\Users\\Lias_\\IdeaProjects\\TestLearning\\files\\Hello.csv")))));
//        }