package org.macro.keys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.awt.*;
import java.awt.event.KeyEvent;

@Getter
@RequiredArgsConstructor
public enum Alpha {
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

    public void upper(Robot robot) {
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(this.getKey());
        robot.delay(1);
        robot.keyRelease(this.getKey());
        robot.keyRelease(KeyEvent.VK_SHIFT);
    }

    public void word(Robot robot, String word) {
        word.chars().filter(Character::isLowerCase).forEach(v -> {});
    }
}