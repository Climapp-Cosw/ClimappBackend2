package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Coordinate;
import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.repositories.CoordinatesRepository;
import eci.cosw.climapp.repositories.ReportsRepository;
import eci.cosw.climapp.repositories.ZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by laura on 11/02/2018.
 */
@Service
public class ReportServiceImpl implements ReportService{

    @Autowired
    private ReportsRepository reportsRepository;

    @Autowired
    private ZonesRepository zonesRepository;

    @Autowired
    private CoordinatesRepository coordinatesRepository;



    @Override
    public Report createReport(Report rep) throws ServicesException{
        reportsRepository.save(insideZone(rep,rep.getLongitude(),rep.getLatitude()));
        return rep;
    }

    private  Report insideZone(Report r,double lng,double lat){
        List<Zone> zones=zonesRepository.findAll();
        boolean inside=false;
        for (int i=0;i<zones.size() && !inside;i++){
            List<Coordinate> coors=zones.get(i).getCoordinates();

            if((inLongitudeLatitude(lat, coors.get(0).getLatitude(),coors.get(2).getLatitude()) || inLongitudeLatitude(lat, coors.get(1).getLatitude(),coors.get(3).getLatitude()) )   &&
                    (  inLongitudeLatitude(lng,coors.get(1).getLongitude() , coors.get(0).getLongitude()) || inLongitudeLatitude(lng,coors.get(3).getLongitude() , coors.get(2).getLongitude())  ) ){
                r.setZone(zones.get(i));
                inside= true;
            }

        }
        if (!inside){
            return null;
            /*Zone z=new Zone(zones.size()+1,zones.size()+1,"Otra", new ArrayList<Coordinate>(Arrays.asList(new Coordinate(0,lat,lng))));
            z.getCoordinates().get(0).setZone(z);
            r.setZone(z);*/
        }

        return r;
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

    @Override
    public void deleteReport(int id) {
        reportsRepository.deleteById(id);
    }

    @Override
    public Report ReportByReportId(int id) {
        return reportsRepository.ReportByReportId(id);
    }
    @Override
    public Report ReportByUserId(int id) {
        return reportsRepository.ReportByUserId(id).get(0);
    }

    @Override
    public void updateReport(Report r) {
        reportsRepository.save(r);
    }

    @Override
    public List<Report> getReports() {
        return reportsRepository.findAll();
    }



}
