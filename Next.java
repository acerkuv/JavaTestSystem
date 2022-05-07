package ru.kuvaldin;

import java.util.Scanner;

interface  UserOutput{
    String print(String message);
}
interface  UserInput{
    default String read( String string){
        return string;
    }
}
///
class Test implements UserOutput{
    int rightAnswersCount;

    public void passedTest(int value){
        switch (value){
            case 1 -> print("Правилный ответ на один вопрос");
            case 2 -> print("Два ответа правильные");
            case 3 -> print("Все ответы правильные");
            default -> print("Вы не ответили ни на один вопрос");
        }

    }

    @Override
    public String print(String message) {
        System.out.println(message);
        return message;
    }
}
///
class TestElement implements UserInput {
    String[] Answer;
    String [] Questions;
    int rightAnswerIndex;

    public boolean isNumber(String userInput) {
        try{
            Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    @Override
    public String read(String userInput) {
        return userInput;
    }
    public Scanner read(){
        Scanner scanner = new Scanner(System.in);
        return scanner ;
    }
    public boolean ask(int userAnswer, int rightAnswer){
        if (userAnswer == rightAnswer){
            return true;
        }else{
            return false;
        }
    }
}
///
class Answer{
    String text;
    public void showText(boolean answer){
        if(answer) System.out.println("Првильно");
        else System.out.println("Ошибка");

    }
}


public class Next {
    public static void main(String[] args){
        String[][] AllAnswers = {
                {"1. cs", "2.java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3.loop"}
        };
        int [] AllRightAnswers = {3,3,1};
        //


        Test test = new Test();
        test.rightAnswersCount = 0;

        TestElement testElement = new TestElement();
        testElement.rightAnswerIndex = 0;

        testElement.Questions = new String[]{
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"};

        Answer answer = new Answer();
        answer.text = "Поздравляю";

        //Вывод вопросов
        for (int i=0; i < testElement.Questions.length; i++){
            testElement.Answer = AllAnswers[i];
            test.print(testElement.Questions[i]);
            testElement.rightAnswerIndex = AllRightAnswers[i];

            //Вывод вариантов ответов
            for (String j: testElement.Answer){
                test.print(j);
            }
            /// Ввод и проверка данных
            Scanner userAnswer = testElement.read();

            // Проверяем ответ вользователя на качество ввода(число) и на правильность ответа
            // до тех пор пока он не введет номер, после этого проверка правильности ответа в тесте
            boolean going = true;
            while (going) {

                //Опрашиваем пользователя
                String userInput = userAnswer.nextLine();

                //Проверяем ввел ли он номер (true)
                boolean userNumInput = testElement.isNumber(userInput);

                //Если ввел номер, топроверяем его на правильность
                if (userNumInput) {
                    boolean result = testElement.ask(Integer.parseInt(userInput), testElement.rightAnswerIndex);

                    //Выводим результат на экран
                    answer.showText(result);

                    // Если ответ правильный, то увеличиваем счетчик правильных ответов
                    if (result) test.rightAnswersCount++;

                    //Так как ответ получен, то мы выходим из цикла while
                    going = false;

                // Если пользователь ввел сиволы, то сообщаем пользователю об этом и предлагаем
                    // повторить ввод
                }else{
                    test.print("Введите число");
                }
            }
        }
        // Вывод результата
        test.print(answer.text);
        test.passedTest(test.rightAnswersCount);

    }

}