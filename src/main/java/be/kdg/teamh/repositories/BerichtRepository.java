package be.kdg.teamh.repositories;

import be.kdg.teamh.entities.Bericht;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
public interface BerichtRepository extends JpaRepository<Bericht, Integer>
{
    //
}
