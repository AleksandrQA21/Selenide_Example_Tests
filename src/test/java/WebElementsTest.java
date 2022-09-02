import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class WebElementsTest {
    @Test
    public void inputElementTest(){
        open("https://the-internet.herokuapp.com/login");
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $(".radius").click();
        $(".success").shouldBe(Condition.visible);
    }

    @Test
    public void dropDownTest(){
        open("https://the-internet.herokuapp.com/dropdown");
        SelenideElement dropdown = $("#dropdown");
        dropdown.selectOption("Option 1");
        dropdown.getSelectedOption().shouldHave(Condition.value("1"));


    }
}
