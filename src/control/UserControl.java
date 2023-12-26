package control;
import szgPART.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class UserControl {
    public static void main(String [] args) throws IOException {
        UserControl.login();
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void saveEnterLog(User user) throws IOException {
        Log log = new Log(user.getId(),"SUCCESFUL ENTER");
        Vector<Object> objects = new Vector<Object>();
        objects.add(log);
        Database.saveToFile(objects,"src/assets/logs.ser");
    }
    public static Vector<Object> getNews() {
        return Database.loadObjectsFromFile("src/assets/news.ser");
    }
    public static User isLoginAndPasswordCorrect(String login, String password){
        for ( User user : Database.users ) {
            if( user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        return null;
    }
    public static void login() throws IOException {
        System.out.println("Oral sufferings were started" );
        while(true) {
            System.out.println("Enter login");
            String login = br.readLine();
            System.out.println("Enter password");
            String password = br.readLine();

            User user = isLoginAndPasswordCorrect(login, password);
            if (user == null) {
                System.out.println("Wrong password or login .Try again");
                continue;
            }

            for( Object o : getNews()) {
                News news = (News) o;
                System.out.println(news.toString());
            }

            UserControl.saveEnterLog(user);

            if (user instanceof Student) {
                /*student control*/
            }
            if (user instanceof Teacher) {
                /*teacher control*/
            }
            if (user instanceof Manager) {
                /*manager control*/
            }
            if (user instanceof Researcher) {
                /*researcher control*/
            }
            else {
                System.out.println("Do u want to exit ?Y/N");
                String mode = br.readLine();
                if(mode.equals("Y")) break;
            }
        }
    }
}
