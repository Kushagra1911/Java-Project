package com.srm.model;

public class Result {

    private int id;
    private int s_id;
    private int m1, m2, m3;
    private int total;
    private double percentage;
    private String grade;

    public Result(int id, int s_id, int m1, int m2, int m3) {
        this.id = id;
        this.s_id = s_id;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;

        this.total = m1 + m2 + m3;
        this.percentage = total / 3.0;
        this.grade = calculateGrade();
    }

    private String calculateGrade() {
        if (percentage >= 90) return "A+";
        if (percentage >= 75) return "A";
        if (percentage >= 60) return "B";
        if (percentage >= 50) return "C";
        return "F";
    }

    // ===== GETTERS =====

    public int getId() {
        return id;
    }

    public int getS_id() {
        return s_id;
    }

    public int getM1() {
        return m1;
    }

    public int getM2() {
        return m2;
    }

    public int getM3() {
        return m3;
    }

    public int getTotal() {
        return total;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Result ID: " + id +
                " | Student ID: " + s_id +
                " | Marks: " + m1 + ", " + m2 + ", " + m3 +
                " | Total: " + total +
                " | %: " + percentage +
                " | Grade: " + grade;
    }
}
