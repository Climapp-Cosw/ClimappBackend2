/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.restController;

import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ServicesException;
import eci.cosw.climapp.services.UserService;
import eci.cosw.climapp.services.ZoneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 *
 * @author JuanArevaloMerchan
 */
@RestController
@RequestMapping( "zones" )
public class ZoneController {
    @Autowired
    private ZoneService zoneServices;
    @Autowired
    private UserService userServices;
    
    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<Zone> getZones() throws ServicesException {
        return zoneServices.getZones();
    }

    @RequestMapping( value = "/favorites/{email}", method = RequestMethod.GET )
    public List<Zone> getFavoriteZones(@PathVariable("email") String email) throws ServicesException {
        return zoneServices.getFavoriteZones(email);
    }

    @RequestMapping( value = "/{email}", method = RequestMethod.POST )
    public List<Zone> addZone(@RequestBody Zone zone, @PathVariable("email") String email) throws ServicesException {
        return zoneServices.addZone(zone, email);
    }

    @RequestMapping( value = "/deletedFavorites/{email}", method = RequestMethod.POST )
    public List<Zone> deleteFavoriteZone(@RequestBody Zone zone, @PathVariable("email") String email) throws  ServicesException {
        return zoneServices.deleteZone(zone, email);
    }
}
