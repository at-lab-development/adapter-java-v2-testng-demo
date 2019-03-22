import com.epam.testng.JIRATestKey;
import com.epam.testng.JIRATestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DriverManager;
import pages.YoutubePage;

@Listeners(JIRATestNGListener.class)
public class YoutubeTest {

    @Test
    @JIRATestKey(key = "EPMFARMATS-829")
    public void alwaysPassedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=UKKYpdWPSL8");
        String author = page.getAuthorName();

        Assert.assertEquals(author, "EPAM Systems Global");
    }

    @Test
    @JIRATestKey(key = "EPMFARMATS-845")
    public void alwaysFailedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=sU4i4DTr1HQ");
        String author = page.getAuthorName();
        Assert.assertEquals("Atlassian", author);
    }

    @Test(dependsOnMethods = "alwaysFailedTest")
    @JIRATestKey(key = "EPMFARMATS-844")
    public void alwaysBlockedTest() {
        Assert.assertTrue(true);
    }

    @AfterClass
    public void close() {
        DriverManager.getInstance().quit();
    }
}
