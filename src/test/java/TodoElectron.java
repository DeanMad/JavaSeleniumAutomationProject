import Utilities.CommonOps;
import Workflow.ToDoElectron.WF_Electron;
import org.testng.annotations.Test;

public class TodoElectron extends CommonOps {

    @Test
    public void test01_verifyCreateTask() {
        WF_Electron.verifyCreateTask("Task2");
    }

    @Test
    public void test02_verifyEditTask() {
        WF_Electron.verifyTaskRename("Task2Updated", 0);
    }

    @Test
    public void test03_verifyDeleteTask() {
        WF_Electron.verifyDeleteTask("Task2Updated");
    }

}
