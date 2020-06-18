package cz.fit.cvut.tjv.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

// DAO
@Entity
@Table(name = "T_COUNTRY")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "T_PERSON_COUNTRY",
            joinColumns = { @JoinColumn(name = "COUNTRY_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PERSON_ID") }
    )
    private Set<Person> citizens;

    public Country(String name) {
        this.id = id;
        this.name = name;
        this.citizens = new HashSet<>();
    }
    public Country() {
    }

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

    public Set<Person> getCitizens() {
        return citizens;
    }
    public void setCitizens(Set<Person> citizens) {
        this.citizens = citizens;
    }

}
