package szgPART;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable, Cloneable{
    private String name;
    private String surname;
    private Date birthDate;
    private String corporativeEmail;
    private String personalEmail;
    private String login;
    private String password;
    private String id;
    private String phoneNumber;
    private Gender gender;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getCorporativeEmail() {
        return corporativeEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public void setCorporativeEmail(String corporativeEmail) {
        this.corporativeEmail = corporativeEmail;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getName(), user.getName())
                && Objects.equals(getSurname(), user.getSurname())
                && Objects.equals(getBirthDate(), user.getBirthDate())
                && Objects.equals(getCorporativeEmail(), user.getCorporativeEmail())
                && Objects.equals(getPersonalEmail(), user.getPersonalEmail())
                && Objects.equals(getLogin(), user.getLogin())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getId(), user.getId())
                && Objects.equals(getPhoneNumber(), user.getPhoneNumber())
                && getGender() == user.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate(), getCorporativeEmail(), getPersonalEmail(), getLogin(), getPassword(), getId(), getPhoneNumber(), getGender());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", corporativeEmail='" + corporativeEmail + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender;
    }
}
