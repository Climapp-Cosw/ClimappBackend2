/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.restController;

import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.ServicesException;

import java.util.Date;
import java.util.List;

import eci.cosw.climapp.services.UserService;
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
    private ReportService reportService;
    @Autowired
    private UserService userService;

    @RequestMapping( value = "/DHT/{ip}/{lat}&{lng}/{h}&{t}", method = RequestMethod.POST )
    public void SensorDHT(@PathVariable("ip") String ip,@PathVariable("h") float h, @PathVariable("t") float t, @PathVariable("lat") double lat,@PathVariable("lng") double lng) throws ServletException, ServicesException {
        System.out.println("hum: "+ h+" temp: "+t + "lat"+ lat +" "+lng);
        User user = userService.findUserByEmail(ip);
        int weather=3;
        if(t>18.00 ){
            /*clima 0 lluvia- clima 1 soleado -clima 2 nublado -clima 3*/
            weather =1;
        }else if(t<=18.00 ){
            /*clima 0 lluvia- clima 1 soleado -clima 2 nublado -clima 3*/
            weather =2;
        }
        if(user==null){
            user=new User(ip,ip,ip,"",ip,0);
            userService.createUser(user);
            reportService.createReport(new Report(new java.util.Date(),lat, lng, weather, user,new Zone(),0,0));
        }else{
            Report report=reportService.ReportByUserId(user.getId());
            report.setWeather(weather);
            reportService.updateReport(report);
        }
    }
	
	@RequestMapping( value = "/water/{ip}/{lat}&{lng}/{water}", method = RequestMethod.POST )
    public void SensorRain(@PathVariable("water") boolean water, @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lng") double lng) throws ServletException, ServicesException {
        System.out.println("Rain: "+ water);
        User user = userService.findUserByEmail(ip);
        int weather=2;
        if(water ){
            /*clima 0 lluvia- clima 1 soleado -clima 2 nublado -clima 3*/
            weather =0;
        }else{
            /*clima 0 lluvia- clima 1 soleado -clima 2 nublado -clima 3*/
            weather =2;
        }
        if(user==null){
            user=new User(ip,ip,ip,"",ip,0);
            userService.createUser(user);
            reportService.createReport(new Report(new java.util.Date(),lat, lng, weather, user,new Zone(),0,0));
        }else{
            Report report=reportService.ReportByUserId(user.getId());
            report.setWeather(weather);
            reportService.updateReport(report);
        }
		
    }
	
	@RequestMapping( value = "/temperature/{ip}/{lat}&{lng}/{tempReached}", method = RequestMethod.POST )
    public void SensorTemp(@PathVariable("tempReached") String temp , @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lat") double lng) throws ServletException, ServicesException {
        System.out.println("Temperature reached: "+ temp);	
		/**no implementado**/
    }
}
