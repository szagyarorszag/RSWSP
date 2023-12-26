package model;

public class StudentResearcher extends ResearcherDecorator {
    public StudentResearcher(Researcher decoratedResearcher) {
        super(decoratedResearcher);
    }

    @Override
    public void conductResearch() {
        // Implement Student-specific research behavior here
        super.conductResearch();
    }
    // other researcher methods...
}