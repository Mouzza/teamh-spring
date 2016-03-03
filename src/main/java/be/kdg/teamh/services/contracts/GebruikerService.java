package be.kdg.teamh.services.contracts;

import be.kdg.teamh.entities.Cirkelsessie;
import be.kdg.teamh.entities.Gebruiker;
import be.kdg.teamh.exceptions.GebruikerNotFound;

import java.util.List;

public interface GebruikerService
{
    List<Gebruiker> all();

    void create(Gebruiker gebruiker);

    Gebruiker find(int id) throws GebruikerNotFound;

    void update(int id, Gebruiker gebruiker) throws GebruikerNotFound;

    void delete(int id) throws GebruikerNotFound;

    List<Cirkelsessie> showCirkelsessies(int id) throws GebruikerNotFound;
}