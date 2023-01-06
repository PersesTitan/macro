package org.macro.tool;

import org.macro.keys.Option;

import java.awt.*;

public interface ButtonTool {
    int getKey();
    void click(Robot robot);
    void press(Robot robot);
    void release(Robot robot);

    static void click(Robot robot, int key) {
        robot.keyPress(key);
        robot.delay(robot.getAutoDelay());
        robot.keyRelease(key);
    }

    static void click(Robot robot, ButtonTool...keys) {
        for (ButtonTool key : keys) {
            key.click(robot);
        }
    }

    static void press(Robot robot, ButtonTool...keys) {
        for (ButtonTool key : keys) {
            key.press(robot);
        }
    }

    static void release(Robot robot, ButtonTool...keys) {
        for (ButtonTool key : keys) {
            key.release(robot);
        }
    }

    static void clicks(Robot robot, Option...keys) {
        for (Option key : keys) robot.keyPress(key.getKey());
        robot.delay(robot.getAutoDelay());
        for (int i = keys.length - 1; i >= 0; i--) {
            robot.keyRelease(keys[i].getKey());
        }
    }
}
