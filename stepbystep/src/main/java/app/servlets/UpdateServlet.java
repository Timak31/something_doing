package app.servlets;

import app.entities.News;
import app.test.entities.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50)
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

        Query query =  session.createQuery("from News where id = :id_news");
        query.setParameter("id_news", idUpdate);

        News news = (News) query.getSingleResult();

        if (!req.getParameter("title_update").isEmpty())
            news.setTitle(new String(req.getParameter("title_update").getBytes(iso), uft));

        if (!req.getParameter("preview_update").isEmpty())
            news.setPreview(new String(req.getParameter("preview_update").getBytes(iso), uft));

        if (!req.getParameter("text_body_update").isEmpty())
            news.setTextBody(new String(req.getParameter("text_body_update").getBytes(iso), uft));


        if (req.getPart("picture_update") != null) {
            System.out.println("picture ok!");
            Part part = req.getPart("picture_update");
            String fileName = extractFileName(part);
            String savePath = "P:\\Java\\tryLogin\\five\\stepbystep\\src\\main\\web\\image\\" + File.separator + fileName;
            File fileSaveDir = new File(savePath);
            part.write(savePath + File.separator);

            news.setPictureName(fileName);
        }

        Query queryUpdate = session.createQuery("update News set title = :title_update," +
                "preview = :preview_update, textBody = :text_body, " +
                "pictureName = :picture_name where id = :id_update");

        queryUpdate.setParameter("id_update", idUpdate);
        queryUpdate.setParameter("title_update", news.getTitle());
        queryUpdate.setParameter("preview_update", news.getPreview());
        queryUpdate.setParameter("text_body", news.getTextBody());
        queryUpdate.setParameter("picture_name", news.getPictureName());

        queryUpdate.executeUpdate();
        session.getTransaction().commit();

        sessionFactory.close();

        doGet(req, resp);
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");

        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
