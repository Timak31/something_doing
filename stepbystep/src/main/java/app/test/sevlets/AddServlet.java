package app.test.sevlets;

import app.test.entities.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/add/index.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iso = "ISO-8859-1";
        String uft = "UTF-8";

        String firstName = new String(req.getParameter("first_name").getBytes(iso), uft);
        String secondName = new String(req.getParameter("second_name").getBytes(iso), uft);
        int yearBorn = Integer.parseInt(req.getParameter("year_born"));

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        People people = new People(firstName, secondName, yearBorn);

        session.save(people);

        session.beginTransaction().commit();

        sessionFactory.close();

        doGet(req, resp);
    }
}
