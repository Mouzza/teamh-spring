package be.kdg.teamh.services.contracts;

import be.kdg.teamh.entities.Organisatie;
import be.kdg.teamh.exceptions.OrganisatieNotFound;

import java.util.List;

public interface OrganisatieService
{
    List<Organisatie> all();

    void create(Organisatie organisatie);

    Organisatie find(int id) throws OrganisatieNotFound;

    void update(int id, Organisatie organisatie) throws OrganisatieNotFound;

    void delete(int id) throws OrganisatieNotFound;
}