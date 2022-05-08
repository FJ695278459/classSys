package cn.onehand.acss.pojo;

import java.io.Serializable;

public class Syinfo implements Serializable {
    private int id;
    private String time;
    private String room_name;
    private String class_id;
    private String course_name;
    //教师id
    private String teacher_name;
    private String d_create;
    private String d_modified;

    public Syinfo(){}

    public Syinfo(String time, String room_name, String class_id, String course_name, String teacher_name) {
        this.time = time;
        this.room_name = room_name;
        this.class_id = class_id;
        this.course_name = course_name;
        this.teacher_name=teacher_name;
    }

    public Syinfo(int id, String time, String room_name, String class_id, String course_name, String teacher_name, String d_create, String d_modified) {
        this.id = id;
        this.time = time;
        this.room_name = room_name;
        this.class_id = class_id;
        this.course_name = course_name;
        this.teacher_name=teacher_name;
        this.d_create = d_create;

        this.d_modified = d_modified;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getD_create() {
        return d_create;
    }

    public void setD_create(String d_create) {
        this.d_create = d_create;
    }

    public String getD_modified() {
        return d_modified;
    }

    public void setD_modified(String d_modified) {
        this.d_modified = d_modified;
    }

    @Override
    public String toString() {
        return "Syinfo{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", room_name='" + room_name + '\'' +
                ", class_id='" + class_id + '\'' +
                ", course_name='" + course_name + '\'' +
                ", teacher_name='" + teacher_name + '\'' +
                ", d_create='" + d_create + '\'' +
                ", d_modified='" + d_modified + '\'' +
                '}';
    }
}
