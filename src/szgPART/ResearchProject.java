package szgPART;

import java.util.Vector;

public class ResearchProject {
    private String topic;
    private String desciption;
    private Vector<Researcher> members;
    {
        members = null;
    }


    public ResearchProject() {}
    public ResearchProject(String topic, String desciption, Vector<Researcher> members) {
        this.topic = topic;
        this.desciption = desciption;
        this.members = members;
    }
    public void addMmember(Researcher researcher) {
        members.add(researcher);
    }
    public void deleteMember(Researcher researcher) {
        members.remove(researcher);
    }
}
