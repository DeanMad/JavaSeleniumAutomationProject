package pageObject.ElectronToDo;

import Utilities.CommonOps;
import Utilities.UIActions;
import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ToDoPage {

    @FindBy(xpath = "//input[@class='input_b5pqF']")
    private WebElement txt_input;

    @FindBy(xpath = "//div[@class='textWrapper_X9gil']/label[@class='label_5i8SP']")
    private List<WebElement> tasks;

    @FindBy(xpath = "//*[name()='svg' and @class='destroy_19w1q']")
    private List<WebElement> deleteButtons;

    @Step("Create a new task")
    public void createTask(String task) {
        UIActions.updateText(txt_input, task);
        UIActions.keyboardKey(txt_input, Keys.ENTER);
    }

    @Step("Check if a given task is contained in the list")
    public boolean containsTask(String task) {
        return UIActions.contains(task, tasks);
    }

    @Step("Edit a given text by index")
    public void editTask(String name, int index) {
        UIActions.highlightTextInsideElement(tasks.get(index), index);
        UIActions.updateTextUsingActions(name);
    }

    @Step("Delete a given Task")
    public void deleteTask(String task) {
        int index = UIActions.getIndex(task, tasks);
        UIActions.moveToElement(tasks.get(index));
        UIActions.clickNoWait(deleteButtons.get(index));
    }

}
