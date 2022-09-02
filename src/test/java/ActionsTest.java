import com.codeborne.selenide.Condition;
import com.codeborne.selenide.DragAndDropOptions;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class ActionsTest {
    @Test
    public void dragAndDropTest() {
        open("https://www.pureexample.com/jquery-ui/basic-droppable.html");


        switchTo().frame($("iframe[id^='ExampleFrame-']"));
        $(".square.ui-draggable").dragAndDropTo(".squaredotted.ui-droppable", DragAndDropOptions.usingActions());
        $("#info").shouldHave(Condition.text("dropped!"));
    }

    @Test
    public void dragAndDropTest1(){
        open("https://www.pureexample.com/jquery-ui/basic-droppable.html");

        switchTo().frame($x("//iframe[@id = 'ExampleFrame-94']"));
        actions()
                .clickAndHold($(".square.ui-draggable"))
                .moveToElement($(".squaredotted.ui-droppable"))
                .release()
                .build().perform();
        $("#info").shouldHave(Condition.text("dropped!"));
    }
}
