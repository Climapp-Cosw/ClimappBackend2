/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Zone;
import java.util.List;

/**
 *
 * @author JuanArevaloMerchan
 */
public interface ZoneService {
 
    /**
     * 
     * @return 
     */
    public List<Zone> getZones();

    /**
     * @param lat
     * @param lng
     */
    public Zone insideZone(double lat,double lng) throws ServicesException;

    /**
     * @param name
     * @return
     */
    public Zone getZone(String name);

    /**
     *
     * @return
     */
    public int getNumZones();

    public List<Zone> getFavoriteZones(String email);

    
    
}
