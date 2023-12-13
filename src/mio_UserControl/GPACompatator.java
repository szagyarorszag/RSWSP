package mio_UserControl;

import java.util.Comparator;

public class GPACompatator implements Comparator<UserControl.User> {

    @Override
    public int compare(UserControl.User user1, UserControl.User user2) {
        // Compare user GPAs
        double gpa1 = user1.getGPA(); // Assuming User class has a getGPA() method
        double gpa2 = user2.getGPA(); // Assuming User class has a getGPA() method

        // Compare based on GPA
        if (gpa1 < gpa2) {
            return -1;
        } else if (gpa1 > gpa2) {
            return 1;
        } else {
            // If GPAs are equal, use the NameComparator as a tiebreaker
            return nameComparator.compare(user1, user2);
        }
    }
}
