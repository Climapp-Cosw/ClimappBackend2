/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Coordinate;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.repositories.ZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author JuanArevaloMerchan
 */
@Service
public class ZoneServiceImpl implements ZoneService{

    @Autowired
    private ZonesRepository zonesRepository;


    public ZoneServiceImpl(){

    }

    @Override
    public List<Zone> getZones() {
        return zonesRepository.findAll();
    }

    @Override
    public int getNumZones() {
        return (int) zonesRepository.count();
    }

    @Override
    public List<Zone> getFavoriteZones(String email) {
        return zonesRepository.getFavoriteZones(email);
    }

    @Override
    public Zone getZone(String name) {
        //implementar
        return null;
    }

}
