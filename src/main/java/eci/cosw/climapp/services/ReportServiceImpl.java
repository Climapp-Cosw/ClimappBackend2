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
        return reportsRepository.save(rep);
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
        reportsRepository.saveAndFlush(r);
    }

    @Override
    public List<Report> getReports() {
        return reportsRepository.findAll();
    }



}
