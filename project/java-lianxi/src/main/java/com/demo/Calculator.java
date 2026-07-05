package com.demo;

/**
 * 简单计算器
 * 展示 Java 类和方法的基本用法
 */
public class Calculator {

    /**
     * 执行四则运算
     *
     * @param a  第一个操作数
     * @param op 运算符 (+, -, *, /)
     * @param b  第二个操作数
     * @return 计算结果
     * @throws ArithmeticException 当除以零时抛出
     */
    public double calculate(double a, String op, double b) {
        switch (op) {
            case "+":
                return add(a, b);
            case "-":
                return subtract(a, b);
            case "*":
                return multiply(a, b);
            case "/":
                return divide(a, b);
            default:
                throw new IllegalArgumentException("不支持的运算符: " + op);
        }
    }

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("除数不能为零！");
        }
        return a / b;
    }
}
