package com.trackminder.trackminder.repository;

import com.trackminder.trackminder.entities.UkgTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UkgTrackRepository extends JpaRepository<UkgTrack, Long> {

    @Query(value ="SELECT top 1 * FROM ukg_track_minder where ukg_track_minder.employeeid = ?1 order by  ukg_track_minder.location_time_stamp desc", nativeQuery=true)
    UkgTrack getEmployeById(String Id);

    @Query("SELECT r FROM UkgTrack r where r.currentLocTagName = ?1 order by r.locationTimeStamp desc")
    List<UkgTrack> getReferenceByCurrentLocTagName(String tag);

    @Query("SELECT r FROM UkgTrack r where r.team.teamId = ?1")
    List<UkgTrack> getReferenceByTeam(Long teamId);

    @Modifying
    @Query("UPDATE UkgTrack r SET r.currentLocLatitude = ?1, r.currentLocLongitude = ?2 where r.employeeID = ?3")
    void updateLocation(String latitude, String longitude, String employeeId);

}
