package com.kaishengit.entity;

public class Detail {
    private Integer id;

    private String course;

    private String teacher;

    public Detail(String course, String teacher) {
        this.course = course;
        this.teacher = teacher;
    }

    public Detail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", course='" + course + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}