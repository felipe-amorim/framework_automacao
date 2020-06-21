package support.screen.find;

import intern.Instances;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;

public class ClicksScreen {
    public void twice(){
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getSleepScreenClassInstance().until(200);
            Instances.getjRobotClassInstance().click();
            Instances.getjRobotClassInstance().click();
        });
        Instances.getScreenshotClassInstance().print();
        Instances.getReportClassInstance().stepPass(Instances.getMessageClickTwice() + Instances.getScreenLastLocatorLog());
    }

    public void thrice(){
        Instances.getExecuteClassInstance().execute(() -> {
            Instances.getSleepScreenClassInstance().until(200);
            Instances.getjRobotClassInstance().click();
            Instances.getjRobotClassInstance().click();
            Instances.getjRobotClassInstance().click();
        });
        Instances.getScreenshotClassInstance().print();
        Instances.getReportClassInstance().stepPass(Instances.getMessageClickThrice() + Instances.getScreenLastLocatorLog());
    }
}
