/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.repositories;


import eci.cosw.climapp.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Laura Ramos
 */
@Repository
public interface ZonesRepository extends JpaRepository <Zone,Integer >{
    @Query(value ="select * from Zones z where z.id = ?1", nativeQuery = true)
    public Zone findZoneById(int id);

    @Query(value ="select z.id, z.name, z.number from Zones z join FavoriteZone as fz on z.id=fz.Zone_id join Users on fz.User_id=Users.id where Users.email = ?1", nativeQuery = true)
    public List<Zone> getFavoriteZones(String email);
}
