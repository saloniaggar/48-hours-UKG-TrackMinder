package com.trackminder.trackminder.entities;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ukg_track_minder")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UkgTrack {

    @Id
    private Long id;

    @Column(name = "EmployeeID")
    private String employeeID;

    @Column(name = "EmployeeName")
    private String employeeName;

    @Column(name = "BaseLocation")
    private String baseLocation;

    @Column(name = "CurrentLocLatitude")
    private String currentLocLatitude;

    @Column(name = "CurrentLocLongitude")
    private String currentLocLongitude;

    @Column(name = "CurrentLocTagName")
    private String currentLocTagName;

    @Column(name = "Date")
    private Date date;

    @Column(name = "LocationTimeStamp")
    private Date locationTimeStamp;

    @ManyToOne
    @JoinColumn(name="team_id", nullable=false)
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getBaseLocation() {
        return baseLocation;
    }

    public void setBaseLocation(String baseLocation) {
        this.baseLocation = baseLocation;
    }

    public String getCurrentLocLatitude() {
        return currentLocLatitude;
    }

    public void setCurrentLocLatitude(String currentLocLatitude) {
        this.currentLocLatitude = currentLocLatitude;
    }

    public String getCurrentLocLongitude() {
        return currentLocLongitude;
    }

    public void setCurrentLocLongitude(String currentLocLongitude) {
        this.currentLocLongitude = currentLocLongitude;
    }

    public String getCurrentLocTagName() {
        return currentLocTagName;
    }

    public void setCurrentLocTagName(String currentLocTagName) {
        this.currentLocTagName = currentLocTagName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimeStamp() {
        return locationTimeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.locationTimeStamp = timeStamp;
    }
}
