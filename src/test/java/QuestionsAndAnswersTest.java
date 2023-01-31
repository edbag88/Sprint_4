import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.services.praktikum.MainPage;


import static org.hamcrest.core.Is.is;
@RunWith(Parameterized.class)
public class QuestionsAndAnswersTest extends BaseTest {

    private By question;
    private By answer;
    private String answerText;

    //конструктор класса
    private QuestionsAndAnswersTest(By question, By answer, String answerText) {
        this.question = question;
        this.answer = answer;
        this.answerText = answerText;
    }

    //параметризация
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {MainPage.question1, MainPage.answer1, MainPage.answerText1},
                {MainPage.question2, MainPage.answer2, MainPage.answerText2},
                {MainPage.question3, MainPage.answer3, MainPage.answerText3},
                {MainPage.question4, MainPage.answer4, MainPage.answerText4},
                {MainPage.question5, MainPage.answer5, MainPage.answerText5},
                {MainPage.question6, MainPage.answer6, MainPage.answerText6},
                {MainPage.question7, MainPage.answer7, MainPage.answerText7},
                {MainPage.question8, MainPage.answer8, MainPage.answerText8}
        };

    }

    //проверка вопросов и ответов
    @Test
    public void getAnswerTextTest() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickCookieButton();
        objMainPage.scrollToElementImportantQuestions();
        objMainPage.clickQuestion(question);
        objMainPage.getAnswerText(answer);
        MatcherAssert.assertThat(objMainPage.getAnswerText(answer), is(answerText));


    }
}


