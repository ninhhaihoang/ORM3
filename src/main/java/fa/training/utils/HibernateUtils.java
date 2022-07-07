package fa.training.utils;


import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    static {
        // Create a new Configuration object
        Configuration cfg = new Configuration();
        cfg.configure();

        // Get the SessionFactory object from Configuration
        if (sessionFactory == null) {
            sessionFactory = cfg.buildSessionFactory();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

//    private static Validator validator = buildValidator();
//
//    public static Validator getValidator() {
//        return validator;
//    }
//
//    private static Validator buildValidator() {
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        return factory.getValidator();
//    }

    /*
     * demo validator
     */
    private static Validator validator = buildValidator();

    public static Validator getValidator() {
        return validator;
    }

    private static Validator buildValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory.getValidator();
    }
}
