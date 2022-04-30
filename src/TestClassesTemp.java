import java.util.Scanner;

class Test{
        String questions;
        String  passTest(int count){
            switch (count){
                case 1:
                    return "Вы ответили правилльно на один вопрос";
                case 2:
                    return "Вы ответили правилльно на два вопроса";
                case 3:
                    return "Все ответы правильные";
                default:
                    return "Все ответы ошибочны";
            }
        }
}

class Questions extends Test{
    String []  answers;
    int  rightAnswerIndex;

    boolean ask(int index){
        if (index == rightAnswerIndex){
            return true;
        }else{
            return false;
        }
    }
}
class Answer extends Questions{
    String text;
    String showText(){
        return text;
    }
}

public class TestClassesTemp {
    public static void main(String[] args) {

        //Варианты вопросов
        String[] AllQuestions = {
                "1. В файл с каким расширением компилируется java-файл?",
                "2. С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "3. Какой применяется цикл, когда не известно количество итераций?"
        };
        //Варианты ответов
        String[][] AllAnswers = {
                {"1. cs", "2.java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3.loop"}
        };
        // Массив с вариантами правильных ответов
        int [] AllRightAnswersValues = {3, 3, 1};
        // Счетчик правильных ответов
        byte counterRightAnswers = 0;

        //Выводим очередной вопрос в цикле
        for (int i = 0; i < AllAnswers.length; i++) {
            //Инициализируем и создаем экземпляр класса очеродного вопроса
            Test questions = new Test();
            questions.questions = AllQuestions[i];
            // Аналонично поступаем с очередным списком вариантов ответов
            Questions answers = new Questions();
            answers.answers = AllAnswers[i];
            answers.rightAnswerIndex = AllRightAnswersValues[i];

            //Вывод на экран очередного вопроса
            System.out.println(questions.questions);

            // Вывод на экран оередного списка выриантов ответов
            for (String j : answers.answers) {
                System.out.println(j);
            }
                // Опрашиваем пользователя в цикле while до тех пор, пока он не введет числовой ввод
                // варианта ответа
                boolean going = true;
                while (going) {

                    // Опрашиваем пользователя
                    Scanner inputs = new Scanner(System.in);
                    String userInput = inputs.nextLine();

                    // Проверяем значение введенное пользователем значение
                    var foo = itsNumber(userInput);

                    //Если введено число, то проверяем на праильность ответа пользователя с правильным вар
                    if (foo){
                        if (Integer.parseInt(userInput)== answers.rightAnswerIndex) {
                            Answer cost = new Answer();
                            cost.text = "Правильно";
                            System.out.println(cost.showText());
                            counterRightAnswers++;
                            going = false;
                        }else{
                            Answer cost = new Answer();
                            cost.text = "Неверно";
                            System.out.println(cost.showText());
                            going = false;
                        }


//                    System.out.println(answers.ask(2));
                    ///
                }else{
                        System.out.println("Введите число");
                    }
                }
        }
        //Вывод итогов
        Test passedTest = new Test();
        String result = passedTest.passTest(counterRightAnswers);
        System.out.println(result);
    }
    //Проверяем введенное значение на введение цифр
    public static boolean itsNumber(String s) {
        try {
            Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
