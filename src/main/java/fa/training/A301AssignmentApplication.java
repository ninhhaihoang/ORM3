package fa.training;

import fa.training.dao.*;
import fa.training.entities.Candidate;
import fa.training.entities.EntryTest;
import fa.training.entities.Interview;
import fa.training.utils.DateUtils;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public class A301AssignmentApplication {
    public static void main(String[] args) {
        /**
         * Candidate DAO is below
         * */
        CandidateDAO candidateDAO = new CandidateDAOImpl();
        Candidate candidate = new Candidate();
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            session.persist(candidate);
            System.out.println("???");
        } finally {
            if (session!= null)
                session.close();
        }

//        Set<ConstraintViolation<Candidate>> constraintViolations =
//                HibernateUtils.getValidator().validate(candidate);
//        String errorMessage = constraintViolations.iterator().next().getMessage();
//        System.out.println(errorMessage);

        // save new candidate
//        Candidate candidate1 = new Candidate("Ninh Hoang", DateUtils.convertStringToUtilDate("04/08/2000"), 1,
//                DateUtils.convertStringToUtilDate("12/22/2022"),"0917496706","ninhhhh@gmail.com","Python/ML",
//                "Japanese",5,"not update",1, "no remark");
//        Candidate candidate2 = new Candidate("Hoang", DateUtils.convertStringToUtilDate("04/08/2000"), 1,
//                DateUtils.convertStringToUtilDate("12/22/2022"),"0917496705","hoang@gmail.com","Angular",
//                "Japanese",2,"not update",2, "no remark");
//        candidateDAO.save(candidate1);
//        candidateDAO.save(candidate2);



        // find by skill and skill level
//        candidateDAO.findAllBySkillAndLevel("Angular", 2).forEach(c -> System.out.println(c));

        // find by foreign language and skill
//        candidateDAO.findAllByForeignLanguageAndSkill("Japanese", "Python/ML").forEach(candidate -> System.out.println(candidate));

        // find by skill and test result and date
//        candidateDAO.findAllBySkillAndEntryTestResult("Java", "pass", DateUtils.convertStringToUtilDate("10/1/2020")).forEach(c -> System.out.println(c));

        // find candidates that pass interview on '15-Oct-2020'.
//        candidateDAO.findAllByResultInterviewAndDate("pass", DateUtils.convertStringToUtilDate("10/1/2022")).forEach(c-> System.out.println(c));
        /**
        * Entry Test Dao is below
        */
        // add new entry test
//        EntryTestDAO entryTestDAO= new EntryTestDAOImpl();
//        EntryTest entryTest1 = new EntryTest("The first", DateUtils.convertStringToUtilDate("10/1/2020"),"good",
//                new BigDecimal("9.1"),"good",new BigDecimal("8.8"),"pass","no remark",
//                "Java", candidateDAO.findById(1));
//        entryTestDAO.save(entryTest1);
        /**
 * Interview Dao is below
 */
        // add new interview
//        InterviewDAO interviewDAO = new InterviewDAOImpl();
//        Interview interview = new Interview("The first", DateUtils.convertStringToUtilDate("10/15/2020"), "HoangNH79",
//                "OK", "pass", "no remark", candidateDAO.findById(2));
//        interviewDAO.save(interview);
    }
}
