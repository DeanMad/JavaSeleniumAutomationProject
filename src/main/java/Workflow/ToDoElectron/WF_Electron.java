package Workflow.ToDoElectron;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WF_Electron extends CommonOps {

    @Step("Create a new task and verify it is created")
    public static void verifyCreateTask(String task) {
        todo.createTask(task);
        Assert.assertTrue(todo.containsTask(task));
    }

    @Step("Rename a task and verify it")
    public static void verifyTaskRename(String new_name, int index) {
        todo.editTask(new_name, index);
        Assert.assertTrue(todo.containsTask(new_name));
    }

    @Step("Delete a task and verify it is deleted")
    public static void verifyDeleteTask(String name) {
        todo.deleteTask(name);
        Assert.assertFalse(todo.containsTask(name));
    }


}
