import com.codeborne.selenide.Condition;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.*;
import static java.io.File.createTempFile;


public class UploadDownloadTest {

    @Test
    public void uploadTest(){
        File file = new File("C:\\Users\\Admin\\Desktop\\Солярис.pdf");
        open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFile(file);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(Condition.text(file.getName()));

    }

    @Test
    public void downloadTest() throws IOException {
        File file = new File("C:\\Users\\Admin\\Desktop\\Солярис.pdf");
        open("https://the-internet.herokuapp.com/upload");
        $("#file-upload").uploadFile(file);
        $("#file-submit").click();
        $("#uploaded-files").shouldHave(Condition.text(file.getName()));

        open("https://the-internet.herokuapp.com/download");
        File download = $(By.linkText(file.getName())).download();
        Assert.assertTrue(FileUtils.contentEquals(download,file));
    }


}
