package org.macro.keys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.event.KeyEvent;

@RequiredArgsConstructor
public enum Number {
    K0(KeyEvent.VK_0),
    K1(KeyEvent.VK_1),
    K2(KeyEvent.VK_2),
    K3(KeyEvent.VK_3),
    K4(KeyEvent.VK_4),
    K5(KeyEvent.VK_5),
    K6(KeyEvent.VK_6),
    K7(KeyEvent.VK_7),
    K8(KeyEvent.VK_8),
    K9(KeyEvent.VK_9);

    @Getter
    private final int key;

    public void check(Robot robot) {
        robot.keyPress(this.getKey());
        robot.delay(1);
        robot.keyRelease(this.getKey());
    }

    public void press(Robot robot) {
        robot.keyPress(this.getKey());
    }

    public void release(Robot robot) {
        robot.keyRelease(this.getKey());
    }
}
