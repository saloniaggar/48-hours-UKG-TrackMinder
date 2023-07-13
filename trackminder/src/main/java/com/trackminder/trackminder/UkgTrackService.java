package com.trackminder.trackminder;

import com.maxmind.geoip.Location;
import com.maxmind.geoip.LookupService;
import com.trackminder.trackminder.entities.UkgTrack;
import com.trackminder.trackminder.repository.UkgTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class UkgTrackService {

    @Autowired
    private UkgTrackRepository trackRepository;

    public UkgTrack getEmployeeDataBasedOnID(String employeeId) {
        return trackRepository.getEmployeById(employeeId);
    }

    public boolean punchIsEnabledOrNotBasedOnID(String employeeId) {
        UkgTrack employee = trackRepository.getEmployeById(employeeId);
        if(employee != null) {
            if(employee.getCurrentLocTagName().equals("OutOfOffice")) {
                 return false;
            }
        }
        return true;
    }

    public List<UkgTrack> getEmployeeBasedOnTagName(String tag) {
        return trackRepository.getReferenceByCurrentLocTagName(tag);
    }


    public List<UkgTrack> getEmployeeBasedOnTeamName(Long teamId) {
        return trackRepository.getReferenceByTeam(teamId);
    }

    public void updateLocation(String latitude, String longitude, String employeeId) {
        trackRepository.updateLocation(latitude,longitude,employeeId);
    }
}
