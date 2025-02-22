package internet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import supports.Browser;

import java.util.List;

public class ToDoMVCPage {

    public void open(){
        Browser.visit("https://todomvc.com/examples/react/dist/#");
    }
    public void addNewToDo(String name){
        Browser.fill(By.id("todo-input"),name + "\n");
    }

    public String getLastTodoName(){
        List<WebElement> toDoList = Browser.getElements(By.xpath("//main//ul//li//label"));
        if(toDoList.isEmpty())
            return "";
        return toDoList.get(toDoList.size()-1).getText();
    }

    public void markCompleteToDo(String name){
        getToDoByName(name).findElement(By.xpath("//ul//li//input")).click();
    }

    public WebElement getToDoByName(String name){
        List<WebElement> toDoList = Browser.getElements(By.xpath("//main//ul//li"));
        return toDoList.stream()
                .filter(toDo -> toDo.getText().equals(name))
                .findFirst()
                .get();
    }

    public int getSize(){
        return Browser.getElements(By.cssSelector(".todo-list li")).size();
    }

    public boolean isCompleted(String existToDoName){
        return getToDoByName(existToDoName).getAttribute("class").contains("completed");
    }

    public void deleteByName(String name){
        WebElement todo = getToDoByName(name);
        Browser.hover(todo);
        todo.findElement(By.cssSelector("button[data-testid='todo-item-button']")).click();
    }
}
