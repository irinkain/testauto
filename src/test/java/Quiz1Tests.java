import Steps.Quiz1Steps;
import org.testng.annotations.Test;

public class Quiz1Tests {
    Quiz1Steps steps = new Quiz1Steps();

    @Test
    public void quizTest() {
        steps.login()
                .checkLogoutButton()
                .gotoBookStore()
                .checkRowCount()
                .pocketGuide()
                .validateTitle()
                .clickOnAdd()
                .checkAlert()
                .gotoBookStore()
                .logout();
    }
}
