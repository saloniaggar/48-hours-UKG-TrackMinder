package com.trackminder.trackminder.controller;

import com.trackminder.trackminder.UkgTrackService;
import com.trackminder.trackminder.entities.UkgTrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class TrackMinderController {

    @Autowired
    private UkgTrackService ukgTrackService;

    @GetMapping("/get-employee-Location")
    public UkgTrack getEmployeeDataBasedOnID(@RequestParam(name = "employeeId", required = true) String employeeId) throws ScriptException, FileNotFoundException, NoSuchMethodException {

        return ukgTrackService.getEmployeeDataBasedOnID(employeeId);
}

    @GetMapping("/is-punch-enabled")
    public boolean punchIsEnabledOrNot(@RequestParam(name = "employeeId", required = true) String employeeId) {
        return ukgTrackService.punchIsEnabledOrNotBasedOnID(employeeId);
    }

    @GetMapping("/get-employees-based-on-tag")
    public List<UkgTrack> getEmployeeBasedOnTagName(@RequestParam(name = "tag", required = true) String tag) {
        return ukgTrackService.getEmployeeBasedOnTagName(tag);
    }

    @GetMapping("/getEmployeeBasedOnTeamName")
    public List<UkgTrack> getEmployeeBasedOnTeamId(@RequestParam(name = "teamId", required = true) Long teamId) {
        return ukgTrackService.getEmployeeBasedOnTeamName(teamId);
    }

    @PutMapping("/updateEmployeeLocation")
    public String updateEmployeeLocation(@RequestParam(name = "employeeId", required = true) String employeeId,
                                                 @RequestParam(name = "latitude", required = true) String latitude,
                                                 @RequestParam(name = "longitude", required = true) String longitude) {
        ukgTrackService.updateLocation(latitude,longitude,employeeId);
        return "Updated successfully";
    }
}
