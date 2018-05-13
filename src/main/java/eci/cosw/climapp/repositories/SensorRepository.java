package eci.cosw.climapp.repositories;

import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
    @Query(value ="SELECT * FROM Sensor s WHERE s.id = ?1", nativeQuery = true)
    Sensor SensorFindById(int id);
}
