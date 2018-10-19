package entities;

import javax.persistence.*;

@Entity
@Table(name = "car_example")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "id_for_car_example")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;

    public Car() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
