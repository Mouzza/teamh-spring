package be.kdg.teamh.services;

import be.kdg.teamh.entities.Cirkelsessie;
import be.kdg.teamh.exceptions.CirkelsessieNotFound;
import be.kdg.teamh.repositories.CirkelsessieRepository;
import be.kdg.teamh.services.contracts.CirkelsessieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CirkelsessieServiceImpl implements CirkelsessieService
{
    @Autowired
    private CirkelsessieRepository repository;

    @Override
    public List<Cirkelsessie> all()
    {
        return repository.findAll();
    }

    @Override
    public void create(Cirkelsessie cirkelsessie)
    {
        repository.save(cirkelsessie);
    }

    @Override
    public Cirkelsessie find(int id) throws CirkelsessieNotFound
    {
        Cirkelsessie cirkelsessie = repository.findOne(id);

        if (cirkelsessie == null)
        {
            throw new CirkelsessieNotFound();
        }

        return cirkelsessie;
    }

    @Override
    public void update(int id, Cirkelsessie cirkelsessie) throws CirkelsessieNotFound
    {
        Cirkelsessie old = find(id);

        old.setNaam(cirkelsessie.getNaam());
        old.setGebruiker(cirkelsessie.getGebruiker());
        old.setMaxAantalKaarten(cirkelsessie.getMaxAantalKaarten());
        old.setAantalCirkels(cirkelsessie.getAantalCirkels());

        repository.save(old);
    }


    @Override
    public void delete(int id) throws CirkelsessieNotFound
    {
        Cirkelsessie cirkelsessie = find(id);

        repository.delete(cirkelsessie);
    }

    public void clone(int id) throws CirkelsessieNotFound
    {
        Cirkelsessie old = find(id);
        Cirkelsessie clone = new Cirkelsessie(old.getNaam(), old.getMaxAantalKaarten(), old.getAantalCirkels(), true, LocalDateTime.now(), old.getSubthema(), old.getGebruiker());

        clone.cloneDeelnames(old.getDeelnames());

        repository.save(clone);
    }

    @Override
    public List<Cirkelsessie> gepland()
    {
        List<Cirkelsessie> temp = all();
        List<Cirkelsessie> cirkelsessies = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (Cirkelsessie cirkelsessie : temp)
        {

            if (cirkelsessie.isGesloten() && (now.compareTo(cirkelsessie.getStartDatum()) < 1))
            {
                cirkelsessies.add(cirkelsessie);
            }
        }

        return cirkelsessies;
    }

    @Override
    public List<Cirkelsessie> actief()
    {
        List<Cirkelsessie> temp = all();
        List<Cirkelsessie> cirkelsessies = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for (Cirkelsessie cirkelsessie : temp)
        {
            if (!cirkelsessie.isGesloten() && (now.compareTo(cirkelsessie.getStartDatum()) > 0))
            {
                cirkelsessies.add(cirkelsessie);
            }
        }

        return cirkelsessies;
    }
}