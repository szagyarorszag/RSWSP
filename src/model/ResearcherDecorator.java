package model;

import java.util.Comparator;
import java.util.*;

public class ResearcherDecorator extends User{
    protected Researcher decoratedResearcher;
    private Vector<ResearchPaper> papers;

    public ResearcherDecorator(Researcher decoratedResearcher) {
        this.decoratedResearcher = decoratedResearcher;
    }

    public String conductResearch() {
        return decoratedResearcher.conductResearch();
    }
    public void printPapers(Comparator<ResearchPaper> comparator) {
        Collections.sort(papers, comparator);
        for (ResearchPaper paper : papers) {
            System.out.println(paper.getName() + " - " + paper.getDate() + " - " + paper.getCitations() + " citations - " + paper.getPages() + " pages");
        }
    }
    //calculates h-index based on the number of cited papers
    public int calculateHIndex(){
        int n=0;
        for(ResearchPaper paper:papers){
            if(paper.getCitations()>0) n++;
        }
        return Math.min(papers.size(), n);
    }


}
