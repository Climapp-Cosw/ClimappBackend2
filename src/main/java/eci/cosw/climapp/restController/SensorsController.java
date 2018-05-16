/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.restController;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.Sensor;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.SensorService;
import eci.cosw.climapp.services.ServicesException;

import eci.cosw.climapp.services.ZoneService;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

/**
 *
 * @author LauraRamosB
 */
@RestController
@RequestMapping( "sensors" )
public class SensorsController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private ZoneService zoneService;

    @RequestMapping( value = "/DHT/{ip}/{lat}&{lng}/{h}&{t}", method = RequestMethod.POST )
    public void SensorDHT(@PathVariable("ip") String ip,@PathVariable("h") float h, @PathVariable("t") float t, @PathVariable("lat") double lat,@PathVariable("lng") double lng) throws ServletException, ServicesException {
        System.out.println("hum: "+ h+" temp: "+t + "lat"+ lat +" "+lng);
        int ip2=Integer.valueOf(ip.replace(".",""));
        Sensor sns = sensorService.findById(ip2);
        if(sns==null){
            sns=new Sensor(ip2, t, h, 10,zoneService.insideZone(lng,lat),lat,lng,false);
        }else{
            sns.setHumidity(h);
            sns.setTemperature(t);
            double l=sns.getLatitude();
            double ln=sns.getLongitude();
            if(l!=lat || ln!=lng){
                sns.setLatitude(lat);
                sns.setLatitude(lng);
            }
        }
        sensorService.createSensor(sns);
    }
	
	@RequestMapping( value = "/water/{ip}/{lat}&{lng}/{water}", method = RequestMethod.POST )
    public void SensorRain(@PathVariable("water") boolean water, @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lng") double lng) throws ServletException, ServicesException {
        System.out.println("Rain: "+ water);
        int ip2=Integer.valueOf(ip.replace(".",""));
        Sensor sns = sensorService.findById(ip2);
        if(sns==null){
            sns=new Sensor(ip2, 0, 0, 10,zoneService.insideZone(lng,lat),lat,lng,water);
        }else{
            sns.setRain(water);
            double l=sns.getLatitude();
            double ln=sns.getLongitude();
            if(l!=lat || ln!=lng){
                sns.setLatitude(lat);
                sns.setLatitude(lng);
            }
        }
        sensorService.createSensor(sns);
    }
	
	@RequestMapping( value = "/temperature/{ip}/{lat}&{lng}/{tempReached}", method = RequestMethod.POST )
    public void SensorTemp(@PathVariable("tempReached") String temp , @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lat") double lng) throws ServletException, ServicesException {
        System.out.println("Temperature reached: "+ temp);	
		/**no implementado**/
    }
}
