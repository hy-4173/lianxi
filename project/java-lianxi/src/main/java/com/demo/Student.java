package com.demo;

/**
 * 学生类
 * 展示 Java 面向对象编程（封装、构造方法、方法重写）
 */
public class Student {

    // 封装：私有字段，通过 getter/setter 访问
    private String id;       // 学号
    private String name;     // 姓名
    private int age;         // 年龄
    private double score;    // 成绩

    // 构造方法
    public Student(String id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // ---------- Getter / Setter ----------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0 && age < 150) {
            this.age = age;
        }
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
        }
    }

    /**
     * 根据成绩返回等级
     * A: >= 90, B: >= 80, C: >= 70, D: >= 60, F: < 60
     */
    public String getGrade() {
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    // 重写 toString 方法
    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', age=%d, score=%.1f, grade='%s'}",
                id, name, age, score, getGrade());
    }
}
