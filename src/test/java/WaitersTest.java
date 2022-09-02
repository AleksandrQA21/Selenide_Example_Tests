import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class WaitersTest {

    @Test
    public void waitersTest(){
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $(" #checkbox ").shouldBe(Condition.visible, Condition.not(Condition.checked));
        $$("button").find(Condition.exactText("Remove")).click();
        $("#loading").shouldBe(Condition.visible);
        $("#loading").shouldBe(Condition.hidden);
        $("#message").shouldHave(Condition.text("It's gone!"));
        $("#checkbox").shouldNotBe(Condition.visible);
    }

    @Test
    public void waitersTest2(){
        open("https://the-internet.herokuapp.com/dynamic_controls");
        $x("//form[@id=\"input-example\"]/input").shouldBe(Condition.visible);
        $$("button").find(Condition.exactText("Enable")).click();
        $x("//div[text() = 'Wait for it... '][1]").shouldBe(Condition.visible);
        $x("//div[text() = 'Wait for it... '][1]").shouldBe(Condition.hidden);
        $x("//button[text() = \"Disable\"]").shouldBe(Condition.text("Disable"));
        $x("//p[text() = \"It's enabled!\"]").shouldHave(Condition.text("It's enabled!"));
    }
}
