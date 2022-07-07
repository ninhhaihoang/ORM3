package fa.training.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

@SuppressWarnings("serial")
@Entity @Getter @Setter @AllArgsConstructor @NoArgsConstructor @ToString
@Table(name = "Candidate")
public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private int candidateId;

    @Column(name = "full_name")
    @NotNull(message = "full name cannot be null")
    private String fullName;

    @Column(name = "date_of_birth")
    @NotNull
    private Date dateOfBirth;

    @Column(name = "gender")
//    @Range(min = 0, max = 1)
    @Pattern(regexp = "[0-1]{1}?")
    private int gender;

    @Column(name = "graduation_year")
    @NotNull
    private Date graduationYear;

    @Column(name = "phone", unique = true)
    @NotNull
//    @UniqueElements
    private String phone;

    @Column(name = "email", unique = true)
    @NotNull
//    @UniqueElements
    private String email;

    @Column(name = "skill")
    private String skill;

    @Column(name = "foreign_language")
    private String foreignLanguage;

    @Column(name = "level")
    @NotNull
    @Range(min = 0, max = 7)
    private int level;

    @Column(name = "cv")
    private String cv;

    @Column(name = "allocation_status")
    private int allocationStatus;

    @Column(name = "remark")
    private String remark;

    @OneToMany(mappedBy = "candidate")
    @ToString.Exclude
    private List<Interview> interviews;

    public Candidate(String fullName, Date dateOfBirth, int gender, Date graduationYear, String phone, String email, String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.graduationYear = graduationYear;
        this.phone = phone;
        this.email = email;
        this.skill = skill;
        this.foreignLanguage = foreignLanguage;
        this.level = level;
        this.cv = cv;
        this.allocationStatus = allocationStatus;
        this.remark = remark;
    }

    public Candidate(Date dateOfBirth, int gender, Date graduationYear, String phone, String email, String skill, String foreignLanguage, int level, String cv, int allocationStatus, String remark) {
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.graduationYear = graduationYear;
        this.phone = phone;
        this.email = email;
        this.skill = skill;
        this.foreignLanguage = foreignLanguage;
        this.level = level;
        this.cv = cv;
        this.allocationStatus = allocationStatus;
        this.remark = remark;
    }
}
