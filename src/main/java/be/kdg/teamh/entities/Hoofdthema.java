package be.kdg.teamh.entities;

import be.kdg.teamh.entities.Subthema;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hoofdthema {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String naam;

    @NotNull
    private String beschrijving;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Organisatie organisatie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Gebruiker gebruiker;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Tag> tags = new ArrayList<>();

    private Hoofdthema()
    {
        // JPA constructor
    }

    public Hoofdthema(String naam, String beschrijving, Organisatie organisatie, Gebruiker gebruiker)
    {
        this.naam = naam;
        this.beschrijving = beschrijving;
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }
}
