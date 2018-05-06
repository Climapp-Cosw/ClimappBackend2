package eci.cosw.climapp.repositories;


import eci.cosw.climapp.models.Report;
import eci.cosw.climapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Laura Ramos
 */
@Repository
public interface ReportsRepository extends JpaRepository <Report, Integer>{

    @Query(value ="SELECT * FROM Report r WHERE r.User_id = ?1", nativeQuery = true)
    public List<Report> ReportByUserId(int id);

    @Query(value ="SELECT * FROM Report r WHERE r.id = ?1", nativeQuery = true)
    public Report ReportByReportId(int id);
}
