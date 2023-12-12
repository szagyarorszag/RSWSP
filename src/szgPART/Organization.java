package szgPART;

import model.Faculty;

import java.util.Date;
import java.util.Objects;
import java.util.Vector;

public class Organization {
    private String name;
    private Vector<Student> members;
    private Student lead;
    private Vector<Faculty> faculties;
    private Date creationDate;

    public Organization() {}

    public Organization(String name, Vector<Student> members, Student lead, Vector<Faculty> faculties, Date creationDate) {
        this.name = name;
        this.members = members;
        this.lead = lead;
        this.faculties = faculties;
        this.creationDate = creationDate;
    }

    public String getName() {
        return name;
    }

    public Vector<Student> getMembers() {
        return members;
    }


    public Student getLead() {
        return lead;
    }

    public Vector<Faculty> getFaculties() {
        return faculties;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setFaculties(Vector<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setLead(Student lead) {
        this.lead = lead;
    }

    public void setMembers(Vector<Student> members) {
        this.members = members;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization that)) return false;
        return Objects.equals(getName(), that.getName())
                && Objects.equals(getMembers(), that.getMembers())
                && Objects.equals(getLead(), that.getLead())
                && Objects.equals(getFaculties(), that.getFaculties())
                && Objects.equals(getCreationDate(), that.getCreationDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getMembers(), getLead(), getFaculties(), getCreationDate());
    }

    @Override
    public String toString() {
        return "Organization{" +
                "name='" + name + '\'' +
                ", members=" + members +
                ", lead=" + lead +
                ", faculties=" + faculties +
                ", creationDate=" + creationDate +
                '}';
    }
}
