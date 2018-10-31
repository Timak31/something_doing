package app.servlets;

import app.entities.News;
import app.test.entities.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/add/index.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("picture");
        String fileName = extractFileName(part);
        String savePath = "P:\\Java\\tryLogin\\five\\stepbystep\\src\\main\\web\\image\\" + File.separator + fileName;
        File fileSaveDir = new File(savePath);
        part.write(savePath + File.separator);

        String uft = "UTF-8";
        String iso = "ISO-8859-1";


        String title = new String(req.getParameter("title").getBytes(iso), uft);
        String preview = new String(req.getParameter("preview").getBytes(iso), uft);
        String textBody = new String(req.getParameter("text_body").getBytes(iso), uft);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        News news = new News(title, preview, textBody, fileName);

        session.save(news);

        session.beginTransaction().commit();

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
