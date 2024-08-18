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
import javax.servlet.http.HttpSession;

/**
 *
 * @author upekhansaja
 */
public class LogIn extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String mobile = req.getParameter("mobile");
        
        ServletContext sc = req.getServletContext();
        
        ArrayList<User> userList = (ArrayList) sc.getAttribute("userList");
        
        boolean userFound = false;
        
        for (User user : userList) {
            if (user.getMobile().equals(mobile)) {
                userFound = true;
                
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                
                resp.sendRedirect("home.jsp");
                break;
            }
        }
        
        if (!userFound) {

//            resp.sendRedirect("login.jsp?e=Invalid Mobile :(");
            req.setAttribute("e", "Invalid Mobile");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            
        }
        
    }
    
}
