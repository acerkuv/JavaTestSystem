import java.util.Scanner;

// Интерфейс
interface Elems{
    Object getElem(int pos);

}
// Класс вопросов
class Questions implements Elems{
    String [] questions;
    @Override
    public String getElem(int pos) {
        return questions[pos];
    }
}
// Класс номеров правильных ответов
class RightAnswers implements Elems{
    int [] goal;
    public Integer getElem(int pos){
        return goal[pos];
    }

}
//Класс вариантов ответов на вопрос
class AnswersFor {
    String[][] answers;
    public String [] getRowAnswerRow (int row){
        return answers[row];
    }
}

public class TestObj {

    //Проверка введенного строкового значения на содержание номеров или символов
    //Возвращает true, если строка содержит цифры, иначе возварщает false
    private static boolean checkInt(String s){
        try {
            Double.parseDouble(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Создаем экземплар класса вопросов с последующей инициализацией
        Questions quest = new Questions();
        quest.questions = new String[] {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"};

        //Создаем экземплар класса вариантов ответов на вопрос с последующей инициализацией
        AnswersFor answer = new AnswersFor();
        answer.answers = new String[][] {
                {"cs", "java", "class", "exe"},
                {"commit", "push", "clone", "copy"},
                {"while", "for", "loop"}
        };

        //Счетчик правилных ответов
        byte countRightAnswers = 0;

        //Создаем экземплар класса вариантов номеров правильных ответов на вопрос с последующей инициализацией
        RightAnswers readGoals = new RightAnswers();
        readGoals.goal = new int[] {3, 3, 1};


        //Выводим последовательно вопрос и ..
        for (int i = 0; i < quest.questions.length; i++) {
            System.out.println(quest.getElem(i));
            // Переменная номера вопросв процедуре вывода на экран
            byte rowNumber = 0;
            // вариаенты возможных ответов
            for (String j : answer.getRowAnswerRow(i)) {
                System.out.println(++rowNumber + ". " + j);
            }
                // Опрос: опрашиваем до таех пор, пока не будет введено чило
                // Перемеенная процесса опроса пользователя: работаем до тех пор, пока пользователь не введет цифровой ответ
                boolean going = true;
                while (going) {

                    //Опрашиваем пользоателя
                    Scanner scanner = new Scanner(System.in);
                    String customerAnswer = scanner.nextLine();

                    // Проверка ответа на тип
                    boolean checkAnswer = checkInt(customerAnswer);

                    //Если пользователь ввел символы вместо цифр, то просим его повторить ввод
                    if (!checkAnswer) {
                        System.out.println("Введите число");
                    } else {

                        // Проверка ответа на правильность введенных цифр
                        // Переводим строковое значение номер в int дла проверки правильости
                        int foo = Integer.parseInt(customerAnswer);

                        //Проверяем ответ поользователя с правильным ответом полученным при помощи метода класса
                        // из экземпляра класса вариантов правильных ответов
                        if (foo == readGoals.getElem(i)) {
                            System.out.println("Правильно");

                            // Считаем правильный ответ
                            countRightAnswers ++;
                        } else {
                            System.out.println("Неравильно");
                        }
                        // Ответ на заданный вопрос получен, выходим из цикла опроса "while"
                        going = false;

                    }
                }

            }
        // Вывод итогов тестирования
        switch (countRightAnswers){
            case 1 -> System.out.println("Вы ответили правильно на один вопрос.");
            case 2 -> System.out.println("Вы ответили правильно на два вопроса.");
            case 3 -> System.out.println("Точно в цель! Все ответы правильные!");
            default -> System.out.println("Повторите материал! Все ответы неверные ;-(");
        }
    }

}
