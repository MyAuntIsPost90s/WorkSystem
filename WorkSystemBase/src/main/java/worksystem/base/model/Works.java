package worksystem.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Works {
    private Long workid;

    private Long studentclassid;

    private String workurl;

    private String workdesc;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date workcreatetime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date workcommittime;

    private Long teacherid;

    public Long getWorkid() {
        return workid;
    }

    public void setWorkid(Long workid) {
        this.workid = workid;
    }

    public Long getStudentclassid() {
        return studentclassid;
    }

    public void setStudentclassid(Long studentclassid) {
        this.studentclassid = studentclassid;
    }

    public String getWorkurl() {
        return workurl;
    }

    public void setWorkurl(String workurl) {
        this.workurl = workurl;
    }

    public String getWorkdesc() {
        return workdesc;
    }

    public void setWorkdesc(String workdesc) {
        this.workdesc = workdesc;
    }

    public Date getWorkcreatetime() {
        return workcreatetime;
    }

    public void setWorkcreatetime(Date workcreatetime) {
        this.workcreatetime = workcreatetime;
    }

    public Date getWorkcommittime() {
        return workcommittime;
    }

    public void setWorkcommittime(Date workcommittime) {
        this.workcommittime = workcommittime;
    }

    public Long getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Long teacherid) {
        this.teacherid = teacherid;
    }
}