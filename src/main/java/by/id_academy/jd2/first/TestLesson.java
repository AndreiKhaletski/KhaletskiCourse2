package by.id_academy.jd2.first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;

@WebServlet("/test_lesson")
public class TestLesson extends HttpServlet {

//    private String NAME_PARAMETR_HEADER = "ARRAY_NAME_PARAM";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
//        resp.setHeader("Content-Type," , "text/html; charset=UTF-8");

        PrintWriter writer = resp.getWriter();

//        String header = req.getHeader(NAME_PARAMETR_HEADER);
//
//        String[] names = req.getParameterMap().get(header);

//        if (names != null) {
//            for (String name : names) {
//                writer.write("<p>" + header + " : " + name + "</p>");
//            }
//        }

        Enumeration<String> params = req.getParameterNames();

        while (params.hasMoreElements()) {
            String paramName = params.nextElement();
            boolean checked = paramName.startsWith("firstName");
            if (checked) {
                writer.write("<p>" + "Name" + "<i>" + " : " + req.getParameter(paramName) + "</i>" + "</p>");


//test_lesson?firstNameTeacher=Илья&firstNameStudentOne=Антон&firstNameStudentTwo=Андрей
//        -----------------------------------------------------------------------------

//        Enumeration<String> params = req.getParameterNames();

//        while (params.hasMoreElements()) {
//            String paramName = params.nextElement();
//            writer.write(paramName + " : " + req.getParameter(paramName) + "\n");
//


//        -------------------------------------------------------
//        ArrayList<Object> list = new ArrayList<>();
//
//        while (params.hasMoreElements()) {
//            String paramName = params.nextElement();
//            //                writer.write(paramName + " : " + req.getParameter(paramName));
//            if (Objects.equals(paramName, "name"))
//                list.add(req.getParameter(paramName));
//            else {
//                writer.write("ага");
//            }
//
//            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
//            }
                //--------------------------------------------------

                // paramName - это параметр
                // req.getParameter(paramName) - то что написали после =


//            if (Objects.equals(req.getParameter(paramName), "firstName")) {
//                writer.write(paramName + " : " + req.getParameter(paramName));
//            } else {
//                System.out.println(req.getParameter(paramName));
//                writer.write("ага");
//            }


//            ArrayList<Object> list = new ArrayList<>();
//            list.add(paramName);
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i) == "firstName"){
//                    writer.write(paramName + " : " + req.getParameter(paramName));
//                }else {
//                    writer.write("ага");
//                }
//            }


            }
        }
    }
}