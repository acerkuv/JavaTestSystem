class Test{
    String [] questions;
    void  passTest(){
        return;
    }
}

class Questions extends Test{
    String [] answers;
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
    void showText(){

    }
}

public class TestClassesTemp {
    public static void main(String[] args) {
        //
        Test questions = new Test();
        questions.questions = new String[]{
                "1. В файл с каким расширением компилируется java-файл?",
                "2. С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "3. Какой применяется цикл, когда не известно количество итераций?"
        };
        Questions answers = new Questions();
        answers.answers = new String[]{"1. cs", "2.java", "3. class", "4. exe"};
        answers.rightAnswerIndex = 2;

        //
        for (String i: questions.questions) {
            System.out.println(i);

            for (String j : answers.answers) {
                System.out.println(j);
            }
        }
        ///тестовый ответ в переменнй temp
        int temp = 2;
        System.out.println(answers.ask(2));
        ///
    }
}


