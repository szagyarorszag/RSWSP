package model;

public class EmployeeResearcher extends ResearcherDecorator {
    public EmployeeResearcher(Researcher decoratedResearcher) {
        super(decoratedResearcher);
    }

    @Override
    public void conductResearch() {
        // Implement Employee-specific research behavior here
        super.conductResearch();
    }
    // other researcher methods...
}