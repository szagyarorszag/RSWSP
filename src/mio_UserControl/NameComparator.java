package mio_UserControl;
import szgPART.User;
import java.util.Comparator;

public class NameComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return 0;
    }

    /*private final NameComparator nameComparator = new NameComparator();
    @Override
    public int compare(UserControl.User user1, UserControl.User user2) {
        // Compare user names
        String name1 = user1.getName();
        String name2 = user2.getName();

        return name1.compareToIgnoreCase(name2);
        //compareToIgnoreCase for case-insensitive comparison
    }*/
}
