import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class TableTest {
    @Test
    public void tableTest(){
        open("https://the-internet.herokuapp.com/tables");
        SelenideElement table = $("#table1");
        List<String>headers = table.$$("tr>th")
                .shouldBe(CollectionCondition.size(6))
                .shouldHave(CollectionCondition.itemWithText("Email"))
                .texts();
        ElementsCollection trs = table.$$("tbody tr").shouldHave(CollectionCondition.size(4));

        List<Map<String,String>> result = new ArrayList<>();
        for (SelenideElement tr: trs) {
            Map<String,String> row = new HashMap<>();
            List<String>td = tr.$$("td").texts();
            for (int i = 0; i < headers.size(); i++) {
                row.put(headers.get(i), td.get(i));
            }
            result.add(row);
        }
        System.out.println(result);
    }

}
