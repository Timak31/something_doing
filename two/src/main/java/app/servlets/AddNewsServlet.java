package app.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

public class AddNewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (req.getParameter("submit_text") == null) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/addNews.jsp");
            dispatcher.forward(req, resp);
        } else {
            String title = req.getParameter("title");
            String preview = req.getParameter("preview");
            String textBody = req.getParameter("textbody");

            System.out.println(title);
            System.out.println(preview);
            System.out.println(textBody);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/admin/addNews.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String charsetName = "UTF-8";
        String charsetNameIso = "ISO-8859-1";

        String title = req.getParameter("title");
        String preview = req.getParameter("preview");
        String textBody = req.getParameter("textbody");
//
//        String title = new String(req.getParameter("title").getBytes(), Charset.forName(charsetName));
//        String preview = new String(req.getParameter("preview").getBytes(), Charset.forName(charsetName));
//        String textBody = new String(req.getParameter("textbody").getBytes(), Charset.forName(charsetName));

        System.out.println(title);
        System.out.println(preview);
        System.out.println(textBody);

        doGet(req, resp);
    }
}
