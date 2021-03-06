package be.kdg.teamh.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "deelnames")
public class Deelname implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int aangemaakteKaarten;

    @NotNull
    private boolean medeorganisator;

    @NotNull
    private boolean isAanDeBeurt;

    @NotNull
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime datum;

    @ManyToOne
    @JsonManagedReference
    private Cirkelsessie cirkelsessie;

    @ManyToOne
    @JsonManagedReference
    private Gebruiker gebruiker;

    public Deelname()
    {
        //
    }

    public Deelname(int aangemaakteKaarten, boolean medeorganisator, DateTime datum, Cirkelsessie cirkelsessie, Gebruiker gebruiker)
    {
        this.aangemaakteKaarten = aangemaakteKaarten;
        this.medeorganisator = medeorganisator;
        this.datum = datum;
        this.cirkelsessie = cirkelsessie;
        this.gebruiker = gebruiker;
        this.isAanDeBeurt = false;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAangemaakteKaarten()
    {
        return aangemaakteKaarten;
    }

    public void setAangemaakteKaarten(int aangemaakteKaarten)
    {
        this.aangemaakteKaarten = aangemaakteKaarten;
    }

    public boolean isMedeorganisator()
    {
        return medeorganisator;
    }

    public void setMedeorganisator(boolean medeorganisator)
    {
        this.medeorganisator = medeorganisator;
    }

    public DateTime getDatum()
    {
        return datum;
    }

    public void setDatum(DateTime datum)
    {
        this.datum = datum;
    }

    public Cirkelsessie getCirkelsessie()
    {
        return cirkelsessie;
    }

    public void setCirkelsessie(Cirkelsessie cirkelsessie)
    {
        this.cirkelsessie = cirkelsessie;
    }

    public Gebruiker getGebruiker()
    {
        return gebruiker;
    }

    public void setGebruiker(Gebruiker gebruiker)
    {
        this.gebruiker = gebruiker;
    }

    public boolean isAanDeBeurt()
    {
        return isAanDeBeurt;
    }

    public void setAanDeBeurt(boolean aanDeBeurt)
    {
        isAanDeBeurt = aanDeBeurt;
    }
}
