package mio_UserControl;

import java.util.Comparator;

public interface MyComparator<T> extends Comparator<T> {

    void compateTo();

    void equals();
}
