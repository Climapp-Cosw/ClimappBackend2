/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eci.cosw.climapp.restController;

import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.ServicesException;

import java.util.Date;
import java.util.List;
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

    @RequestMapping( value = "/DHT/{ip}/{lat}&{lng}/{h}&{t}", method = RequestMethod.POST )
    public void SensorDHT(@PathVariable("ip") String ip,@PathVariable("h") float h, @PathVariable("t") float t, @PathVariable("lat") double lat,@PathVariable("lat") double lng) throws ServletException, ServicesException {
        System.out.println("hum: "+ h+" temp: "+t);
        int ip2=Integer.valueOf(ip.replace(".",""));
        Report report= reportService.ReportByReportId(ip2);
        int weather=0;
        if(t>18.00 ){
            /*clima 0 lluvia- clima 1 soleado -clima 2 nublado -clima 3*/
            weather =1;
        }
        if(report==null){
            reportService.createReport(new Report(ip2,new java.util.Date(),lat, lng, weather, null,new Zone(),0,0));
        }else{
            report.setWeather(weather);
            reportService.updateReport(report);
        }
    }
	
	@RequestMapping( value = "/water/{ip}/{lat}&{lng}/{water}", method = RequestMethod.POST )
    public void SensorRain(@PathVariable("water") boolean water, @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lat") double lng) throws ServletException, ServicesException {
        System.out.println("Rain: "+ water);
        int ip2=Integer.valueOf(ip.replace(".",""));
        Report report= reportService.ReportByReportId(ip2);
        if(report==null){
            reportService.createReport(new Report(ip2,new java.util.Date(),lat, lng, 0, null,new Zone(),0,0));
        }else{
            report.setWeather(0);
            reportService.updateReport(report);
        }
		
    }
	
	@RequestMapping( value = "/temperature/{ip}/{lat}&{lng}/{tempReached}", method = RequestMethod.POST )
    public void SensorTemp(@PathVariable("tempReached") String temp , @PathVariable("ip") String ip,@PathVariable("lat") double lat,@PathVariable("lat") double lng) throws ServletException, ServicesException {
        System.out.println("Temperature reached: "+ temp);	
		/**no implementado**/
    }
}
