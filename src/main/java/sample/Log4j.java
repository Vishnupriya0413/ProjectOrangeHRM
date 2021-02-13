
package sample;

import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
public class Log4j {
    
    static Logger l = Logger.getLogger(Log4j.class.getName());
    public static void main(String[] args) {
    Layout l1 = new SimpleLayout();
    Appender a;
    try
    {
    a = new FileAppender(l1,"mylog.txt", false);
    l.addAppender(a);
    }
    catch(Exception e) {}
    l.info("user enters valid user name and password, system displays home page");
    l.fatal("user enters invalid credentials, system displays invalid credentials");
    l.fatal("user didn't enter any details in user name and password and performed login, system displays user name cannot be empty");
    l.info("performing add function in PIM, system displays add employee details page");
    l.info("user adds new employee details,system saves the entered details");
    l.info("user enters employee name and perform search,system displays the details");
    l.info("user adds candidates details and saves the information,system displays successfully saved");
    l.info("user performs edit function to edit the details,system enables the text field to edit text");
    l.info("user enters the details in personal details tab and performs save operation");
    l.info("performing save operation in personal details tab after editing,system saves the personal details");
    l.info("user performs logout,system displays the login page");
    
    System.out.println("Your logic executed successfully....");
    
    }
}
