package app.test.entities;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "id_for_people")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "year_born")
    private int yearBorn;

    public People() {
    }

    public People(String firstName, String secondName, int yearBorn) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.yearBorn = yearBorn;
    }

    @Override
    public String toString() {
        return "People{" +
                "\n\tid=" + id +
                "\n\t, firstName='" + firstName + '\'' +
                "\n\t, secondName='" + secondName + '\'' +
                "\n\t, yearBorn=" + yearBorn +
                "\n}";
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getYearBorn() {
        return yearBorn;
    }

    public void setYearBorn(int yearBorn) {
        this.yearBorn = yearBorn;
    }
}
