import java.util.Scanner;

class TestSystem {
    public static void main(String[] args) {

        // Массив 2d с вопросами и вариантами ответов
        String[][] testQuestions = {
                {"1. В файл с каким расширением компилируется java-файл?", "1. cs", "2. java", "3. class", "4 .exe"},
                {"2. С помощью какой команды git можно получить полную копию удаленного репозитория?", "1. commit", "2. push", "3. clone", "4. copy"},
                {"3. Какой применяется цикл, когда не известно количество итераций?" , "1. while", "2. for", "3. loop"}

        };

        // Массив с правильными отвестами на вопрос;
        int [] rightAnswers ={3, 3, 1};

        //переменные учета правильных и неправильных ответов
        byte rightAnsversCount = 0;

        // Перебираем массив вопросвов по строкам
        System.out.println("Ответьте на следующие вопросы:" + '\n');
        for (int i=0; i < testQuestions.length; i++ ){
            System.out.println( "Выберите вариант ответа на следующий вопрос:" + '\n');
            System.out.println(testQuestions[i][0] + '\n');

            // Выводим варианты ответов в строке
            for (int j=1; j < testQuestions[i].length; j++){
                System.out.println(testQuestions[i][j]);

            }

            // Ввод ответа в переменную "int num"
            Scanner answerMy = new Scanner(System.in);
            int num = answerMy.nextInt();

            // Проверяем правильность ответа
            // Получаем правильный ответ из массива ответов
            int rightAnswer = rightAnswers[i];

            // Проверяем на правильность полученный ответ: если он не правльный выводим правильный ответ
            if(num == rightAnswer){
                System.out.println( "Вы ответили правильно!" + '\n');
                rightAnsversCount += 1;

            }else{
                System.out.println("К сожалению, вы ошиблись.");
                System.out.print("Правильный ответ был " + testQuestions[i][rightAnswer] + '\n' );

            }

        }

        // Вывод итогов тестирования
        if (rightAnsversCount > 0){
            if (rightAnsversCount == 1){
                System.out.println("Вы ответили правильно на " + rightAnsversCount + " вопрос");
            }else{
                System.out.println("Вы ответили правильно на " + rightAnsversCount + " вопроса");
            }
        }else{
            System.out.println("Увы, все ответы не правильные");
        }

    }

}

