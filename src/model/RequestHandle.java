package model;

public interface RequestHandle {
    void registerSubscriber(TechSupport employee);
    void removeSubscriber(TechSupport employee);
    void notifySubscribers();
}
