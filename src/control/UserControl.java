package control;
import szgPART.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserControl extends User {
    public static void main(String [] args) {
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static User isLoginAndPasswordCorrect(String login, String password){
        for ( User user : Database.users ) {
            if( user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        return null;
    }
    public static boolean login() throws IOException {
        System.out.println("Oral sufferings is started" );
        while(true) {
            System.out.println("Enter login");
            String login = br.readLine();
            System.out.println("Enter password");
            String password = br.readLine();

            if (isLoginAndPasswordCorrect(login, password).equals(null)) continue;
            if (isLoginAndPasswordCorrect(login, password) instanceof Student) {

                }
            if (isLoginAndPasswordCorrect(login, password) instanceof Teacher) {

                }
            if (isLoginAndPasswordCorrect(login, password) instanceof Manager) {

            }
            if (isLoginAndPasswordCorrect(login, password) instanceof TechSupport ) {

            }



        }

    }
}
