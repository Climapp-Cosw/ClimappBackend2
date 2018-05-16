package eci.cosw.climapp.restController;


import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.services.ReportService;
import eci.cosw.climapp.services.ServicesException;
import eci.cosw.climapp.services.UserService;
import eci.cosw.climapp.services.ZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping( "reports" )
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private ZoneService zoneService;

    @RequestMapping( value = "/newReport", method = RequestMethod.POST )
    public void createReport(@RequestBody Report report) throws ServicesException {
        report.setDateTimeReport(new Date());
        report.setZone(zoneService.insideZone(report.getLongitude(), report.getLatitude()));
        reportService.createReport(report);
    }


    @RequestMapping( value = "/likeReport/", method = RequestMethod.POST )
    public Report createReport(@PathVariable("lat") String lat,@PathVariable("lon") String lon) throws ServicesException {
        //User u = userService.getUser(report.getReportedUser().getId());
        //u.getReport().add(report);
        return null;
    }

    @RequestMapping( value = "/", method = RequestMethod.GET )
    public List<Report> getReports() {
        return reportService.getReports();
    }

}
