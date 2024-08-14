import org.junit.jupiter.api.Test;
import org.tkbank.exercise.constants.Constant;
import org.tkbank.exercise.pages.MainPage;

public class SendLetterTest extends BaseTest{

    @Test
    public void sendLetterTest(){
        MainPage mainPage = new MainPage();
        mainPage.writeMessage(Constant.RECIPIENT, Constant.TEXT);
    }
}
