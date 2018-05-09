package eci.cosw.climapp.services;

import eci.cosw.climapp.models.Coordinate;
import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.Zone;
import eci.cosw.climapp.repositories.CoordinatesRepository;
import eci.cosw.climapp.repositories.ReportsRepository;
import eci.cosw.climapp.repositories.ZonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private  Report insideZone(Report r,double pointx,double pointy){
        List<Zone> zones=zonesRepository.findAll();

        for (int i=0;i<zones.size();i++){
            List<Coordinate> coor=zones.get(i).getCoordinates();
            boolean inside=false;

            for (int i2 = 0, j = coor.size() - 1; i2 < coor.size(); i2++) {
                if((coor.get(i2).getLatitude() < pointy && coor.get(j).getLatitude() >=pointy || coor.get(j).getLatitude()<pointy && coor.get(i2).getLatitude()>=pointy )
                        &&(coor.get(i2).getLongitude()<=pointx||coor.get(j).getLongitude()<=pointx  )){
                    if(coor.get(i2).getLongitude()+(pointy-coor.get(i2).getLatitude())/(coor.get(j).getLatitude()-coor.get(i2).getLatitude())*
                            (coor.get(j).getLongitude()-coor.get(i2).getLongitude())<pointx){
                        inside=!inside;
                    }
                }
                j =i2;
            }
            System.out.print(coor.toString()+"  lkrbdfvkibdfibf "+inside);
            if(inside){
                r.setZone(zones.get(i));
                return r;
            }
        }
        r.setZone(zonesRepository.findZoneById(11));
        return null;
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
