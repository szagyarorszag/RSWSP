package szgPART;

import java.util.Date;
import java.util.Vector;

public class ResearchPaper {
    private Researcher author;
    private String title;
    private Date publicationDate ;
    private String annotation ;



    public ResearchPaper() {}
    public ResearchPaper(Researcher author, String title, Date publicationDate, String annotation) {
        this.author = author;
        this.title = title;
        this.publicationDate = publicationDate;
        this.annotation = annotation;
    }
}
