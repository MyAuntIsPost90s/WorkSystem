package worksystem.base.model;

public class Teacherclasses {
    private String teacherclassid;

    private Long studentclassid;

    private Long teacherid;

    public String getTeacherclassid() {
        return teacherclassid;
    }

    public void setTeacherclassid(String teacherclassid) {
        this.teacherclassid = teacherclassid;
    }

    public Long getStudentclassid() {
        return studentclassid;
    }

    public void setStudentclassid(Long studentclassid) {
        this.studentclassid = studentclassid;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }
}