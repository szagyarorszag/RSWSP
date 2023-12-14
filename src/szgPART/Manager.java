package szgPART;

public abstract class Manager extends Employee {
    public void addNews(News news){
        Database.newss.add(news);
    }
    public void deleteNews(News news) {
        Database.newss.remove(news);
    }
    public void changeNews(News news, News news2) {
        news = news2;
    }
}
