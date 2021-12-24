import Utilities.CommonOps;
import Workflow.ToDoElectron.WF_Electron;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TodoElectron extends CommonOps {

    @Test (description = "Creating task and verifying")
    @Description ("This test creates a task and verifies")
    public void test01_verifyCreateTask() {
        WF_Electron.verifyCreateTask("Task2");
    }

    @Test (description = "Editing task and verifying")
    @Description ("This test edits a task and verifies")
    public void test02_verifyEditTask() {
        WF_Electron.verifyTaskRename("Task2Updated", 0);
    }

    @Test (description = "Deleting task and verifying")
    @Description ("This test deletes a task and verifies")
    public void test03_verifyDeleteTask() {
        WF_Electron.verifyDeleteTask("Task2Updated");
    }

}
