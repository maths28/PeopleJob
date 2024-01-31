package fr.mb.peoplejob.model.people;

import fr.mb.peoplejob.repository.model.PeopleDB;

import java.time.LocalDate;

public class PeopleSaveRequest {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public PeopleSaveRequest(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PeopleDB toPeopleDB(){
        return new PeopleDB(this.firstName, this.lastName, this.dateOfBirth);
    }
}
