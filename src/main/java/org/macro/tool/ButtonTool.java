package org.macro.tool;

import org.macro.keys.Special;

import java.awt.*;

public interface ButtonTool {
    int getKey();
    void click(Robot robot);
    void press(Robot robot);
    void release(Robot robot);

    static void click(Robot robot, ButtonTool...keys) {
        for (ButtonTool key : keys) {
            key.click(robot);
        }
    }

    static void clicks(Robot robot, Special...keys) {
        for (Special key : keys) robot.keyPress(key.getKey());
        robot.delay(robot.getAutoDelay());
        for (int i = keys.length - 1; i >= 0; i--) {
            robot.keyRelease(keys[i].getKey());
        }
    }
}
