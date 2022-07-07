package fa.training.dao;

import fa.training.entities.EntryTest;
import fa.training.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EntryTestDAOImpl implements EntryTestDAO {
    @Override
    public List<EntryTest> findAll() {
        Session session = null;
        Transaction transaction;
        List<EntryTest> entryTests = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            String hql = "SELECT e FROM EntryTest e";
            entryTests = session.createQuery(hql, EntryTest.class).list();

            transaction.commit();

            return entryTests;
        } catch (Exception e) {
            System.out.println(e);
            return entryTests;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public EntryTest findById(int id) {
        Session session = null;
        Transaction transaction;
        EntryTest entryTest = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

			String hql = "SELECT e FROM EntryTest e WHERE e.testId = :id";
			entryTest = session.createQuery(hql, EntryTest.class).setParameter("id", id).uniqueResult();
//            entryTest = session.get(EntryTest.class, id);

            transaction.commit();

            return entryTest;
        } catch (Exception e) {
            System.out.println(e);
            return entryTest;
        } finally {
            if (session != null)
                session.close();
        }
    }

    @Override
    public void save(EntryTest entryTest) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(entryTest);

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
    public void saveAll(List<EntryTest> entryTests) {
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            for (int i = 0; i < entryTests.size(); i++) {
                session.save(entryTests.get(i));
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
        EntryTest entryTest = findById(id);
        Session session = null;
        Transaction transaction;

        try {
            session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();

//            String hql = "DELETE FROM EntryTest WHERE testId = :id";
//            int affectedRows = session.createQuery(hql).setParameter("id", id).executeUpdate();
            session.delete(entryTest);

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
