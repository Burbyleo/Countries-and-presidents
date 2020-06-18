package cz.fit.cvut.tjv.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @ManyToMany(mappedBy = "citizens")
    transient private Set<Country> country;

    public Person(String name, String surname, Set<Country> country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
    public Person() {}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Set<Country> getCountry() {
        return country;
    }
    public void setCountry(Set<Country> country) {
        this.country = country;
    }

}
