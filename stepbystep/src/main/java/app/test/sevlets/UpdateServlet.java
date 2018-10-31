package app.test.sevlets;

import app.test.entities.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/update/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iso = "ISO-8859-1";
        String uft = "UTF-8";

        int idUpdate = Integer.parseInt(req.getParameter("id_update"));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query =  session.createQuery("from People where id = :id_people");
        query.setParameter("id_people", idUpdate);

        People people = (People) query.getSingleResult();

        if (!req.getParameter("first_name_update").isEmpty()) {
            people.setFirstName(new String(req.getParameter("first_name_update").getBytes(iso), uft));
//            System.out.println("first name of");
        }
        if (!req.getParameter("second_name_update").isEmpty()) {
            people.setSecondName(new String(req.getParameter("second_name_update").getBytes(iso), uft));
//            System.out.println("second name ok");
        }
        if (!req.getParameter("year_born_update").isEmpty()) {
            people.setYearBorn(Integer.parseInt(req.getParameter("year_born_update")));
//            System.out.println("year born ok");
        }

        Query queryUpdate = session.createQuery("update People set firstName = :first_name, " +
                "secondName = :second_name, yearBorn = :year_born " +
                "where id = :id_update");

        queryUpdate.setParameter("first_name", people.getFirstName());
        queryUpdate.setParameter("second_name", people.getSecondName());
        queryUpdate.setParameter("year_born", people.getYearBorn());
        queryUpdate.setParameter("id_update", idUpdate);

        queryUpdate.executeUpdate();
        session.getTransaction().commit();

        sessionFactory.close();

        doGet(req, resp);
    }
}
