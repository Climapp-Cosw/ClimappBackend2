/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Coordinate;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.repositories.UsersRepository;
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

    @Autowired
    private UsersRepository usersRepository;


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

    @Override
    public List<Zone> addZone(Zone zone, String email) throws ServicesException{
        User u =usersRepository.findUserByEmail(email);
        List<Zone> z=u.getZones();
        z.add(zone);
        u.setZones(z);
        usersRepository.saveAndFlush(u);
        return zonesRepository.getFavoriteZones(email);
    }

    @Override
    public List<Zone> deleteZone(Zone zone,  String email) {
        usersRepository.deleteZone(zone.getName(),email);
        return zonesRepository.getFavoriteZones(email);
    }

    public  Zone insideZone(double lng,double lat){
        List<Zone> zones=zonesRepository.findAll();
        boolean inside=false;
        Zone z= null;
        for (int i=0;i<zones.size() && !inside;i++){
            List<Coordinate> coors=zones.get(i).getCoordinates();

            if((inLongitudeLatitude(lat, coors.get(0).getLatitude(),coors.get(2).getLatitude()) || inLongitudeLatitude(lat, coors.get(1).getLatitude(),coors.get(3).getLatitude()) )   &&
                    (  inLongitudeLatitude(lng,coors.get(1).getLongitude() , coors.get(0).getLongitude()) || inLongitudeLatitude(lng,coors.get(3).getLongitude() , coors.get(2).getLongitude())  ) ){
                z=zones.get(i);
                inside= true;
            }

        }
        if (!inside){
            return null;
            /*Zone z=new Zone(zones.size()+1,zones.size()+1,"Otra", new ArrayList<Coordinate>(Arrays.asList(new Coordinate(0,lat,lng))));
            z.getCoordinates().get(0).setZone(z);
            r.setZone(z);*/
        }

        return z;
    }

    /**
     * Metodo encargado de evaluar la longitud (longitud 1 es mayor a longitud 2)
     * @return boolean <br>
     * <b>true</b>: Si la longitud a evaluar esta entre las dos ubicaciones<br>
     * <b>false</b>: SI la longitud no esta entre las dos ubicaciones<br>
     */
    private boolean inLongitudeLatitude(double longitudEvaluar, double longitud1, double longitud2){

        if(longitud2>longitud1){
            longitud1 = longitud2;
            longitud2 = longitud1;
        }

        return longitudEvaluar<=longitud1 && longitudEvaluar>=longitud2;
    }

}
