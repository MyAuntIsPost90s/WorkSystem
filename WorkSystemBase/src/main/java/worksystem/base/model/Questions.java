package worksystem.base.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

public class Questions {
    private Long questionid;

    private String questiondesc;

    private Long studentid;

    private Long teacherid;

    private String questionanswer;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date questiontime;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
   	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date answertime;

    public Long getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Long questionid) {
        this.questionid = questionid;
    }

    public String getQuestiondesc() {
        return questiondesc;
    }

    public void setQuestiondesc(String questiondesc) {
        this.questiondesc = questiondesc;
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

    public String getQuestionanswer() {
        return questionanswer;
    }

    public void setQuestionanswer(String questionanswer) {
        this.questionanswer = questionanswer;
    }

    public Date getQuestiontime() {
        return questiontime;
    }

    public void setQuestiontime(Date questiontime) {
        this.questiontime = questiontime;
    }

    public Date getAnswertime() {
        return answertime;
    }

    public void setAnswertime(Date answertime) {
        this.answertime = answertime;
    }
}