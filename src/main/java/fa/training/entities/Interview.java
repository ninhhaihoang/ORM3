package fa.training.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "Interview")
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "interview_id")
    private int interviewId;
    @Column(name = "time")
    private String time;
    @Column(name = "date")
    private Date date;
    @Column(name = "interviewer")
    private String interviewer;
    @Column(name = "comments")
    private String comments;
    @Column(name = "interview_result")
    private String interviewResult;
    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Interview(String time, Date date, String interviewer, String comments, String interviewResult, String remark, Candidate candidate) {
        this.time = time;
        this.date = date;
        this.interviewer = interviewer;
        this.comments = comments;
        this.interviewResult = interviewResult;
        this.remark = remark;
        this.candidate = candidate;
    }
}
