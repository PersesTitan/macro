package org.macro.keys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.macro.tool.ButtonTool;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Locale;

@Getter
@RequiredArgsConstructor
public enum Alpha implements ButtonTool {
    A(KeyEvent.VK_A, 'a'),
    B(KeyEvent.VK_B, 'b'),
    C(KeyEvent.VK_C, 'c'),
    D(KeyEvent.VK_D, 'd'),
    E(KeyEvent.VK_E, 'e'),
    F(KeyEvent.VK_F, 'f'),
    G(KeyEvent.VK_G, 'g'),
    H(KeyEvent.VK_H, 'h'),
    I(KeyEvent.VK_I, 'i'),
    J(KeyEvent.VK_J, 'j'),
    K(KeyEvent.VK_K, 'k'),
    L(KeyEvent.VK_L, 'l'),
    M(KeyEvent.VK_M, 'm'),
    N(KeyEvent.VK_N, 'n'),
    O(KeyEvent.VK_O, 'o'),
    P(KeyEvent.VK_P, 'p'),
    Q(KeyEvent.VK_Q, 'q'),
    R(KeyEvent.VK_R, 'r'),
    S(KeyEvent.VK_S, 's'),
    T(KeyEvent.VK_T, 't'),
    U(KeyEvent.VK_U, 'u'),
    V(KeyEvent.VK_V, 'v'),
    W(KeyEvent.VK_W, 'w'),
    X(KeyEvent.VK_X, 'x'),
    Y(KeyEvent.VK_Y, 'y'),
    Z(KeyEvent.VK_Z, 'z');

    private final int key;
    private final char c;

    @Override
    public void click(Robot robot) {
        robot.keyPress(key);
        robot.delay(robot.getAutoDelay());
        robot.keyRelease(key);
    }

    @Override
    public void press(Robot robot) {
        robot.keyPress(key);
    }

    @Override
    public void release(Robot robot) {
        robot.keyRelease(key);
    }

    public void upper(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(this.getKey());
        robot.delay(robot.getAutoDelay());
        robot.keyRelease(this.getKey());
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public static void word(Robot robot, String word) {
        word.toUpperCase(Locale.ROOT)
                .chars()
                .filter(Character::isUpperCase)
                .mapToObj(Character::toString)
                .map(Alpha::valueOf)
                .forEach(v -> v.press(robot));
    }

    public static boolean isAlpha(char c) {
        return Character.isAlphabetic(c);
    }
}