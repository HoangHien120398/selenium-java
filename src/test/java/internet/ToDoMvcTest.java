package internet;

import internet.pages.ToDoMVCPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import supports.Browser;

public class ToDoMvcTest {
    ToDoMVCPage toDoMVCPage;
    @BeforeMethod
    void setup(){
        Browser.openBrowser("chrome");
        toDoMVCPage = new ToDoMVCPage();
        toDoMVCPage.open();
    }

    @Test
    void ableCreateNewToDo(){
        toDoMVCPage.addNewToDo("Learn Japanese");
        Assert.assertTrue(toDoMVCPage.getLastTodoName().contains("Learn Japanese"));
    }

    @Test
    void ableMarkCompleteToDo(){
        toDoMVCPage.addNewToDo("Learn Automation");

        toDoMVCPage.markCompleteToDo("Learn Automation");
        Assert.assertTrue(toDoMVCPage.isCompleted("Learn Automation"));
    }

    @Test
    void ableDeletedToDo(){
        toDoMVCPage.addNewToDo("Reading Book");

        int sizeBefore = toDoMVCPage.getSize();
        toDoMVCPage.deleteByName("Reading Book");
        int sizeAfter = toDoMVCPage.getSize();
        Assert.assertEquals(sizeBefore-sizeAfter,1);

    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
