package fa.training.dao;

import fa.training.entities.Interview;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class InterviewDAOImpl implements InterviewDAO{
    @Override
    public List<Interview> findAll() {
        Session session = null;
        Transaction transaction;
        List<Interview> interviews = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT i FROM Interview i";
            interviews = session.createQuery(hql, Interview.class).list();

            transaction.commit();

            return interviews;
        } catch (Exception e) {
            System.out.println(e);
            return interviews;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public Interview findById(int id) {
        Session session = null;
        Transaction transaction;
        Interview interview = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//			String hql = "SELECT i FROM Interview i WHERE i.interviewId = :id";
//			interview = session.createQuery(hql, Interview.class).setParameter("id", id).uniqueResult();
            interview = session.get(Interview.class, id);

            transaction.commit();

            return interview;
        } catch (Exception e) {
            System.out.println(e);
            return interview;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void save(Interview interview) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(interview);

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
    public void saveAll(List<Interview> interviews) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < interviews.size(); i++) {
                session.save(interviews.get(i));
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
        Interview interview = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//            String hql = "DELETE FROM Interview WHERE interviewId = :id";
//            int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
            session.delete(interview);

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
