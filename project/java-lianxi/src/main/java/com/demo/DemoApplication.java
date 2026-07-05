package com.demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Java Demo 应用程序
 *
 * 功能：展示 Java 基础语法特性
 * 1. 简单计算器
 * 2. 学生管理系统（面向对象）
 * 3. 实用小工具
 */
public class DemoApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("  Java Demo 应用程序");
        System.out.println("  当前时间: " + getCurrentTime());
        System.out.println("  Java 版本: " + System.getProperty("java.version"));
        System.out.println("==========================================");
        System.out.println();

        while (true) {
            showMenu();
            System.out.print("请选择功能 (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    runCalculator(scanner);
                    break;
                case "2":
                    runStudentManager(scanner);
                    break;
                case "3":
                    runNumberGame(scanner);
                    break;
                case "4":
                    System.out.println("感谢使用，再见！");
                    scanner.close();
                    return;
                default:
                    System.out.println("无效选项，请重新选择！");
            }
            System.out.println();
        }
    }

    private static void showMenu() {
        System.out.println("------------------ 功能菜单 -----------------");
        System.out.println("  1. 简单计算器");
        System.out.println("  2. 学生信息管理");
        System.out.println("  3. 猜数字游戏");
        System.out.println("  4. 退出程序");
        System.out.println("-------------------------------------------");
    }

    private static String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

    // =============== 功能 1: 计算器 ===============
    private static void runCalculator(Scanner scanner) {
        System.out.println("\n----- 简单计算器 -----");
        try {
            System.out.print("请输入第一个数字: ");
            double a = Double.parseDouble(scanner.nextLine());

            System.out.print("请输入运算符 (+, -, *, /): ");
            String op = scanner.nextLine();

            System.out.print("请输入第二个数字: ");
            double b = Double.parseDouble(scanner.nextLine());

            Calculator calc = new Calculator();
            double result = calc.calculate(a, op, b);
            System.out.printf("结果: %.2f %s %.2f = %.2f%n", a, op, b, result);

        } catch (NumberFormatException e) {
            System.out.println("错误: 请输入有效的数字！");
        } catch (ArithmeticException e) {
            System.out.println("错误: " + e.getMessage());
        }
    }

    // =============== 功能 2: 学生管理 ===============
    private static void runStudentManager(Scanner scanner) {
        System.out.println("\n----- 学生信息管理 -----");

        // 创建学生对象（展示面向对象特性）
        Student[] students = {
            new Student("S001", "张三", 20, 85.5),
            new Student("S002", "李四", 21, 92.0),
            new Student("S003", "王五", 19, 78.5),
            new Student("S004", "赵六", 22, 95.5)
        };

        // 打印学生列表
        System.out.println("\n学号\t姓名\t年龄\t成绩\t等级");
        System.out.println("----------------------------------------");
        for (Student s : students) {
            System.out.printf("%s\t%s\t%d\t%.1f\t%s%n",
                s.getId(), s.getName(), s.getAge(), s.getScore(), s.getGrade());
        }

        // 计算统计数据
        double total = 0;
        double max = students[0].getScore();
        double min = students[0].getScore();
        String topStudent = students[0].getName();
        String worstStudent = students[0].getName();

        for (Student s : students) {
            total += s.getScore();
            if (s.getScore() > max) {
                max = s.getScore();
                topStudent = s.getName();
            }
            if (s.getScore() < min) {
                min = s.getScore();
                worstStudent = s.getName();
            }
        }

        double avg = total / students.length;

        System.out.println("\n📊 成绩统计:");
        System.out.printf("  平均分: %.2f%n", avg);
        System.out.printf("  最高分: %.1f (%s)%n", max, topStudent);
        System.out.printf("  最低分: %.1f (%s)%n", min, worstStudent);
    }

    // =============== 功能 3: 猜数字游戏 ===============
    private static void runNumberGame(Scanner scanner) {
        System.out.println("\n----- 🎯 猜数字游戏 -----");
        System.out.println("系统已随机生成一个 1-100 之间的数字，请猜猜看！");

        int target = (int) (Math.random() * 100) + 1;
        int attempts = 0;
        final int MAX_ATTEMPTS = 7;

        while (attempts < MAX_ATTEMPTS) {
            System.out.printf("剩余机会: %d 次%n", MAX_ATTEMPTS - attempts);
            System.out.print("请输入你的猜测: ");

            try {
                int guess = Integer.parseInt(scanner.nextLine());
                attempts++;

                if (guess < target) {
                    System.out.println("📈 太小了，再大一点！");
                } else if (guess > target) {
                    System.out.println("📉 太大了，再小一点！");
                } else {
                    System.out.printf("🎉 恭喜你！猜对了！答案就是 %d，你用了 %d 次机会！%n", target, attempts);
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("请输入有效的整数！");
            }
        }

        System.out.printf("😢 游戏结束！正确答案是 %d%n", target);
    }
}
