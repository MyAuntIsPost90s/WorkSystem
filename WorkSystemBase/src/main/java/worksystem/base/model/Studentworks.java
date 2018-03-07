package worksystem.base.model;

public class Studentworks {
    private Long studentworkid;

    private Long studentid;

    private Long teacherid;

    private Long workid;

    private Integer workscore;

    private String workassess;

    public Long getStudentworkid() {
        return studentworkid;
    }

    public void setStudentworkid(Long studentworkid) {
        this.studentworkid = studentworkid;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public Long getWorkid() {
        return workid;
    }

    public void setWorkid(Long workid) {
        this.workid = workid;
    }

    public Integer getWorkscore() {
        return workscore;
    }

    public void setWorkscore(Integer workscore) {
        this.workscore = workscore;
    }

    public String getWorkassess() {
        return workassess;
    }

    public void setWorkassess(String workassess) {
        this.workassess = workassess;
    }
}