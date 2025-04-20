package org.example.groupno4_ecoresort_oop.arman;

import java.io.Serializable;
import java.time.LocalDate;

public class SwimmingPoolTestResult implements Serializable {
    private LocalDate testDate;
    private String chlorineLevel;
    private String phLevel;
    private String remarks;

    public SwimmingPoolTestResult(LocalDate testDate, String chlorineLevel, String phLevel, String remarks) {
        this.testDate = testDate;
        this.chlorineLevel = chlorineLevel;
        this.phLevel = phLevel;
        this.remarks = remarks;
    }
    public LocalDate getTestDate() { return testDate; }
    public String getChlorineLevel() { return chlorineLevel; }
    public String getPhLevel() { return phLevel; }
    public String getRemarks() { return remarks; }
}