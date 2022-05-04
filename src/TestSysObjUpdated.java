import java.util.Scanner;

public class TestSysObjUpdated {
    public static void main(String[] args) {

        /* Массив  с вопросами и вариантами ответов */
        String[] questionsForTest = {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"};

        /* Варианты ответов */
        String[][] AllAnswers = {
                {"1. cs", "2.java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3.loop"}
        };
        /* Массив с правильными отвестами на вопрос; */
        int[] rightAnswers = {3, 3, 1};

        // Счетчик правильных ответов
        byte rightAnswersCount = 0;
        Scanner getInput = new Scanner(System.in);

        /*  основной цикл  в ктором опроашиваем пользователя, проверяем его овет тип и правильность ответа */
        Test testQuestions = new Test();
        testQuestions.questionsNew = questionsForTest;

        /* Счетчик номера строки вариантов ответов */
        int numAnswerVariants = 0;

        //Выводим вопросы на экран
        for (String i : testQuestions.questionsNew) {
            System.out.println(i);

            //Выводим варианты ответов, а также номер правильного ответа через экземпляр класса QuestionNew
            QuestionsNew tempAnswers = new QuestionsNew();
            tempAnswers.rightAnswerIndex = rightAnswers[numAnswerVariants];
            tempAnswers.answerNew = AllAnswers[numAnswerVariants];

            // Выводим варианты возможных ответов на экран
            for (String j : tempAnswers.answerNew) {
                System.out.println(j);
            }
            numAnswerVariants++;

            /* Проверка вввода в цикле while: оправшиваем пользователя на вариант праильнго ответа
             делаем это до тех пор, пока он не введет цифроывой вариант ответа */
            boolean run = true;
            while (run) {

                // Ввод ответа пользователя
                String userInput = getInput.nextLine();

                // Проверяем тип ввода данные через метод класса checkString
                boolean foo = checkString.checkNum(userInput);

                // Если в ответе цифры, то проверяем его на правильность
                if (foo) {
                    // Переодеваем ответ пользователя из String num в Integer
                    int numberInput = Integer.parseInt(userInput);

                    // Проверяем ответ пользователе на правильность ответв теста через метод класса QuestionsNew
                    boolean right = QuestionsNew.ask(numberInput);

                    // Вывод ответа правильнсоти ответа через метод класса Answer
                    System.out.println(Answer.showText(right));

                    // Если ответ правилньный, то увеличиваем счетчик правильных ответов, а также изменяем фраг цикла
                    // while на значение false, чтобы выйти из цикла опроса пользователя
                    if (right)
                        rightAnswersCount++;
                        run = false;

                    // Инваче выводим ему сообщение о ввод цифр с клавиатуры
                    } else {
                        System.out.println(Answer.textNew);
                    }
                }

            }
        // Вывод результата теста через метод класса Test, принимаемый аргумент - количество впроавильных ответов
        System.out.println(Test.passedTest(rightAnswersCount));
        }
    }


class Test{
    String [] questionsNew;
    static String  passedTest(int countRightAnswers){
        switch (countRightAnswers){
            case 1:
                return "Вы ответили только на один вопрос";
            case 2:
                return "Вы ответили на два вопроса";
            case 3:
                return "Браво! Все ответы правильные";
            default:
                return "Вы ошиьлись во всех ответах";
        }
    }

}
//
class QuestionsNew{
    public static int rightAnswerIndex;
    String [] answerNew;
    static boolean ask(int userChoice){
        if (rightAnswerIndex == userChoice) {
            return true;
        }else{
            return  false;
        }
    }
}

//
class Answer{
    public static String textNew = "Введите число";
    static  String  showText(boolean answer) {
        if (answer) {
            return  "Правильно";
        }else {
            return "Неверно";
        }
    }
}
//
class checkString {

    // метод проверки сроки на числовой ввод
    static boolean checkNum(String s) {
        try{
            Double.parseDouble(s);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}

