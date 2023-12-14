package model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public abstract class User implements Serializable, Cloneable, Comparable {
    private String name;
    private String surname;
    private Date birthDate;
    private String corporativeEmail;
    private String login;
    private String password;
    private String id;
    private String phoneNumber;
    private String address;
    private Gender gender;
    //Initialize constructor
    public User(){

    }
    public User(String name, String surname, Date birthDate, String id, String login, String password, String phoneNumber, String address, Gender gender){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.id=id;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address=address;
        this.gender = gender;
    }

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
    public String getAddress(){
        return address;
    }
    //Address setter
    public void updateAddress(String newAddress) {
        this.address=newAddress;
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
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getName(), user.getName())
                && Objects.equals(getSurname(), user.getSurname())
                && Objects.equals(getBirthDate(), user.getBirthDate())
                && Objects.equals(getCorporativeEmail(), user.getCorporativeEmail())
                && Objects.equals(getLogin(), user.getLogin())
                && Objects.equals(getPassword(), user.getPassword())
                && Objects.equals(getId(), user.getId())
                && Objects.equals(getPhoneNumber(), user.getPhoneNumber())
                && getGender() == user.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getBirthDate(), getCorporativeEmail(),  getLogin(), getPassword(), getId(), getPhoneNumber(), getGender());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", corporativeEmail='" + corporativeEmail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender;
    }


    @Override
    public User clone() {
        try {
            User clone = (User) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}