package Modal;

import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author upekhansaja
 */
public class ServContListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        System.out.println("######### Context Initialized #########");
        
        ArrayList<User> userList = new ArrayList<User>();
        
        sce.getServletContext().setAttribute("userList", userList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("######### Context Destroyed #########");
    }

}
