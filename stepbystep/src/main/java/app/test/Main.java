package app.test;

import app.test.entities.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    private String checkIt(People people, String s) {
        if (s == null) {
            return people.getFirstName();
        }


        return null;
    }

    public static void main(String[] args) {

//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//
//        sessionFactory.close();



        /*
        TODO Remove field from database

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        People people = new People("slkdfj", "Молот", 1212);

        int idRemove = 7;

        Query query = session.createQuery("delete People where id = :id_remove");

        query.setParameter("id_remove", idRemove);

        .executeUpdate();
        session.getTransaction().commit();

        sessionFactory.close();
        */

        /*
        TODO Update field in database

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        People people = new People("slkdfj", "Молот", 1212);

        int idUpdate = 7;

        Query query = session.createQuery("update People set firstName = :first_name, " +
          "secondName = :second_name, yearBorn = :year_born " +
          "where id = :id_update");

        query.setParameter("first_name", people.getFirstName());
        query.setParameter("second_name", people.getSecondName());
        query.setParameter("year_born", people.getYearBorn());
        query.setParameter("id_update", idUpdate);

        query.executeUpdate();
        session.getTransaction().commit();

        sessionFactory.close();
        */


        /*
        TODO Get single relust from database

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query =  session.createQuery("from People where id = :id_people");
        query.setParameter("id_people", 3);

        People people = (People) query.getSingleResult();

        System.out.println(people);

        sessionFactory.close();
        */

        /*
        TODO Get all list from database

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query =  session.createQuery("from People");

        List<People> peopleList = query.list();

        for (People people : peopleList) {
            System.out.println(people);
        }

        sessionFactory.close();
        */

        /*
        TODO Add in database

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        People people = new People();
        people.setFirstName("Татяна");
        people.setSecondName("Ланевич");
        people.setYearBorn(1971);

        session.save(people);

        session.beginTransaction().commit();
        sessionFactory.close();
        */
    }
}
