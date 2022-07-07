package fa.training.entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@SuppressWarnings("serial")
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "EntryTest")
public class EntryTest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private int testId;
    @Column(name = "time")
    private String time;
    @Column(name = "date")
    private Date date;
    @Column(name = "language_valuator")
    private String languageValuator;
    @Column(name = "language_result")
    @Range(min = 0, max = 10)
    private BigDecimal languageResult;
    @Column(name = "technical_valuator")
    private String technicalValuator;
    @Column(name = "technical_result")
    @Range(min = 0, max = 10)
    private BigDecimal technicalResult;
    @Column(name = "result")
    @Length(min = 4, max = 4)
    @Pattern(regexp = "(pass)|(fail)")
    private String result;
    @Column(name = "remark")
    private String remark;
    @Column(name = "entry_test_skill")
    private String entryTestSkill;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public EntryTest(String time, Date date, String languageValuator, BigDecimal languageResult, String technicalValuator, BigDecimal technicalResult, String result, String remark, String entryTestSkill, Candidate candidate) {
        this.time = time;
        this.date = date;
        this.languageValuator = languageValuator;
        this.languageResult = languageResult;
        this.technicalValuator = technicalValuator;
        this.technicalResult = technicalResult;
        this.result = result;
        this.remark = remark;
        this.entryTestSkill = entryTestSkill;
        this.candidate = candidate;
    }
}
