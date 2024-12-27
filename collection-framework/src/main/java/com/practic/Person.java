package com.practic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


public class Person implements Comparable<Person>{
    private int personId;
    private String personName;
    private String contactNo;
    private String address;

    public Person() {
    }

    public Person(int personId, String personName, String contactNo, String address) {
        this.personId = personId;
        this.personName = personName;
        this.contactNo = contactNo;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId && Objects.equals(personName, person.personName) && Objects.equals(contactNo, person.contactNo) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personName, contactNo, address);
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int compareTo(Person person) {
        int nameCompare =  this.personName.compareTo(person.personName);
        if (nameCompare == 0) {
            int idCompare = Integer.compare(this.personId, person.personId);
            if (idCompare == 0) {
                return contactNo.compareTo(person.contactNo);
            }
            return idCompare;
        }
        return nameCompare;
    }

    public String toString() {
        return "{ Id : "+this.personId+", Name : "+this.personName+", ContactNo: "+this.contactNo+"}";
    }
}
