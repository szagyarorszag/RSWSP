package szgPART;

import java.util.Objects;

public class Request {
    private Student student;
    private RequestType type;

    public Request() {}

    public Request(Student student, RequestType type){
        this.student = student;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Request request)) return false;
        return Objects.equals(getStudent(), request.getStudent()) && getType() == request.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudent(), getType());
    }

    public Student getStudent() {
        return student;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Request{" +
                "student=" + student +
                ", type=" + type +
                '}';
    }
}
