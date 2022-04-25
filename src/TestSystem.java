import java.util.Scanner;
import java.util.stream.IntStream;

class TestSystem {

    public static void main(String[] args) {

        /* Массив  с вопросами и вариантами ответов */
        String[] testQuestions = {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"};

        String[][] testAnswers = {
                {"cs", "java", "class", "exe"},
                {"commit", "push", "clone", "copy"},
                {"while", "for", "loop"}
        };

        /* Массив с правильными отвестами на вопрос; */
        int[] rightAnswers = {3, 3, 1};

        /* переменные учета правильных и неправильных ответов */
        byte rightAnsversCount = 0;

        /* Перебираем массив вопросвов по строкам */
        System.out.println("Ответьте на следующие вопросы:" + '\n');

        int questCount = 0;

        while (questCount < testQuestions.length) {

            System.out.println(testQuestions[questCount]);
            /* Выводим варианты ответов в строке */
            int questPosition = 1;

            for (int j = 0; j < testAnswers[questCount].length; j++) {

                System.out.println(questPosition + ". " + testAnswers[questCount][j]);
                questPosition += 1;
            }

            /* Проверяем правильность ответа до тех пор пока не будет введено числовое значение */
            boolean myInput = false;

            while (!myInput) {

                Scanner inputNum = new Scanner(System.in);
                var myNumCheck = inputNum.nextLine();
                myInput = Check.itsNumber(myNumCheck);
                if (!myInput) {
                    System.out.println("Ведите число" + '\n');
                } else {

                    /* Получаем правильный ответ из массива ответов */
                    var rightAnswer = rightAnswers[questCount];

                    /* Проверяем на правильность полученный ответ: если он не правльный выводим правильный ответ */
                    System.out.println(myNumCheck);
                    int foo = Integer.parseInt(myNumCheck);

                    if (foo == rightAnswer) {
                        System.out.println("Вы ответили правильно!" + '\n');
                        rightAnsversCount += 1;

                    } else {
                        System.out.println("К сожалению, вы ошиблись.");

                    }
                    questCount += 1;
                }
            }
            /* Выводим итоговый результат теста */
            switch (rightAnsversCount) {
                case 1 -> System.out.println("Вы ответили на один вопрос правильно");
                case 2 -> System.out.println("Вы отвестилиправильно на два вопроса");
                case 3 -> System.out.println("Молодец! Вы ответили правильно на все вопросы.");
                default -> System.out.println("Вам стоит пройти материал ещё раз, Вы не ответили ни на один вопрос");
            }
        }
    }
}