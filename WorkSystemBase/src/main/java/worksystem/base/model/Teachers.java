package worksystem.base.model;

public class Teachers {
    private Long teacherid;

    private String teacheridcard;

    private String teachername;

    private Integer teacherage;

    private String teacherpwd;

    private Integer teachersex;

    private String remarks;

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }

    public String getTeacheridcard() {
        return teacheridcard;
    }

    public void setTeacheridcard(String teacheridcard) {
        this.teacheridcard = teacheridcard;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public Integer getTeacherage() {
        return teacherage;
    }

    public void setTeacherage(Integer teacherage) {
        this.teacherage = teacherage;
    }

    public String getTeacherpwd() {
        return teacherpwd;
    }

    public void setTeacherpwd(String teacherpwd) {
        this.teacherpwd = teacherpwd;
    }

    public Integer getTeachersex() {
        return teachersex;
    }

    public void setTeachersex(Integer teachersex) {
        this.teachersex = teachersex;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}