package cz.fit.cvut.tjv.model;

import javax.persistence.*;

@Entity
@Table(name = "T_PRESIDENT")
public class President {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "SERIAL_CNT")
    private int yearsOnPosition;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Country country;

    public President(String name, String surname, int yearsOnPosition, Country country) {
        this.name = name;
        this.surname = surname;
        this.yearsOnPosition = yearsOnPosition;
        this.country = country;
    }
    public President() {}

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

    public int getYearsOnPosition() {
        return yearsOnPosition;
    }
    public void setYearsOnPosition(int yearsOnPosition) {
        this.yearsOnPosition = yearsOnPosition;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Country getCountry() {
        return country;
    }
    public void setCountry(Country country) {
        this.country = country;
    }

}
