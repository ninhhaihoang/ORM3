package fa.training.dao;

import fa.training.entities.Candidate;
import fa.training.entities.Interview;
import fa.training.utils.HibernateUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class CandidateDAOImpl implements CandidateDAO {
    private EntityManager entityManager;
    private CriteriaBuilder criteriaBuilder;

    public CandidateDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public List<Candidate> findAll() {
        Session session = null;
        Transaction transaction;
        List<Candidate> Candidates = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT c FROM Candidate c";
            Candidates = session.createQuery(hql, Candidate.class).list();

            transaction.commit();

            return Candidates;
        } catch (Exception e) {
            System.out.println(e);
            return Candidates;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Candidate findById(int id) {
        Session session = null;
        Transaction transaction;
        Candidate Candidate = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//			String hql = "FROM Candidate AS c WHERE c.candidateId = :id";
//			candidate = session.createQuery(hql, Candidate.class).setParameter("id", id).uniqueResult();
            Candidate = session.get(Candidate.class, id);

            transaction.commit();

            return Candidate;
        } catch (Exception e) {
            System.out.println(e);
            return Candidate;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Candidate> findAllBySkillAndLevel(String skill, int level) {
        Session session = null;
        Transaction transaction;
        List<Candidate> Candidates = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT c FROM Candidate c WHERE c.skill = ?1 AND c.level = ?2";
            Candidates = session.createQuery(hql, Candidate.class).setParameter(1, skill).setParameter(2, level).list();

            transaction.commit();

            return Candidates;
        } catch (Exception e) {
            System.out.println(e);
            return Candidates;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Candidate> findAllBySkillAndEntryTestResult(String skill, String result, Date date) {
        Session session = null;
        Transaction transaction;
        List<Candidate> Candidates = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT c FROM Candidate c LEFT JOIN FETCH EntryTest et ON c.candidateId = et.candidate.candidateId WHERE c.skill = ?1 AND et.result = ?2 AND et.date =?3";
            Candidates = session.createQuery(hql, Candidate.class).setParameter(1, skill).setParameter(2, result).setParameter(3, date).list();

            transaction.commit();

            return Candidates;
        } catch (Exception e) {
            System.out.println(e);
            return Candidates;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Candidate> findAllByForeignLanguageAndSkill(String foreignLanguage, String skill) {
        Session session = null;
        Transaction transaction;
        List<Candidate> Candidates = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT c FROM Candidate c WHERE c.foreignLanguage = ?1 AND c.skill = ?2";
            Candidates = session.createQuery(hql, Candidate.class).setParameter(1, foreignLanguage).setParameter(2, skill).list();

            transaction.commit();

            return Candidates;
        } catch (Exception e) {
            System.out.println(e);
            return Candidates;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public List<Candidate> findAllByResultInterviewAndDate(String result, Date date) {
//        Session session = null;
//        try {
//            session = HibernateUtils.getSessionFactory().openSession();
//            CriteriaBuilder builder = session.getCriteriaBuilder();
//            // Using FROM and JOIN
//            CriteriaQuery<Interview> criteriaQuery = builder
//                    .createQuery(Interview.class);
//            Root<Interview> candidateRoot = criteriaQuery.from(Interview.class);
//            Root<Candidate> interviewRoot = criteriaQuery.from(Candidate.class);
//            criteriaQuery.select(candidateRoot);
//
//            criteriaQuery.where(builder.equal(candidateRoot.get("candidates"),
//                    interviewRoot.get("candidateId")));
//
//            Query<Interview> query = session.createQuery(criteriaQuery);
//            List<Interview> candidates = query.getResultList();
//
//            return candidates;
//        } finally {
//            session.close();
//        }
        return null;
    }

    private <T> CriteriaQuery<T> createCriteriaQuery(Class<T> klass) {
        return criteriaBuilder.createQuery(klass);
    }

    @Override
    public void save(Candidate candidate) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(candidate);

            transaction.commit();

            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void saveAll(List<Candidate> candidates) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < candidates.size(); i++) {
                session.save(candidates.get(i));
            }

            transaction.commit();

            System.out.println("Saved!");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void delete(int id) {
        Candidate candidate = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//            String hql = "DELETE FROM Candidate WHERE candidateId = :id";
//            int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
            session.delete(candidate);

            transaction.commit();
//            System.out.println(affectedRows + " rows executed");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (session != null)
                session.close();
        }
    }
}
