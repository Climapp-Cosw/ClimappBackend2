package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laura Ramos
 */
@Repository
public interface CoordinatesRepository extends JpaRepository<Coordinate, Integer> {

}