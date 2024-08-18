package Controller;

import Modal.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author upekhansaja
 */
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String mobile = request.getParameter("mobile");
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        User user = new User(mobile, name, country);

        ServletContext sc = request.getServletContext();

        ArrayList<User> userList = (ArrayList<User>) sc.getAttribute("userList");
        userList.add(user);
        
        response.sendRedirect("login.jsp");
        
//        if (sc.getAttribute("userList") == null) {
//
//            ArrayList<User> userList = new ArrayList<User>();
//            userList.add(user);
//
//            sc.setAttribute("userList", userList);
//
//        } else {
//
//            ArrayList<User> userList = (ArrayList<User>) sc.getAttribute("userList");
//            userList.add(user);
//
//            sc.setAttribute("userList", userList);
//
//        }

    }

}
