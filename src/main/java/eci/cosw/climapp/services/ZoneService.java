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
    public List<Zone> getZones()throws ServicesException;

    /**
     * @param lat
     * @param lng
     */
    public Zone insideZone(double lat,double lng) throws ServicesException;

    /**
     * @param name
     * @return
     */
    public Zone getZone(String name)  throws ServicesException;

    /**
     *
     * @return
     */
    public int getNumZones();

    public List<Zone> getFavoriteZones(String email)  throws ServicesException;

    /**
     *
     * @param zone
     * @param email
     * @return
     * @throws eci.cosw.climapp.services.ServicesException
     */
    public List<Zone> addZone(Zone zone, String email) throws ServicesException;

    /**
     *
     * @param zone
     * @param email
     * @return
     * @throws eci.cosw.climapp.services.ServicesException
     */
    public List<Zone> deleteZone(Zone zone, String email) throws ServicesException;

    
    
}
