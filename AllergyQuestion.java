/*
    Design a class (give different methods and variables that will be used) that will provide information related to an allergy which 
    includes symptoms, who reported the allergy, severity, date reported etc.
*/

import java.sql.Timestamp;

public class AllergyQuestion {
    enum Severity {
        LOW, MEDIUM, HIGH;
    }
    
    public static class Allergy {
        private String reporter;
        private String symptoms;
        private Severity severity;
        private Timestamp reportedDate;
        
        public Allergy(String reporter, String symptoms, Severity severity, Timestamp reportedDate) {
            this.reporter = reporter;
            this.symptoms = symptoms;
            this.severity = severity;
            this.reportedDate = reportedDate;
        }
        
        public String getReporter() {
            return this.reporter;
        }
        
        public void setReporter(String reporter) {
            this.reporter = reporter;
        }
        
        public String getSymptoms() {
            return this.symptoms;
        }
        
        public void setSymptoms(String symptoms) {
            this.symptoms = symptoms;
        }
        
        public Severity getSeverity() {
            return this.severity;
        }
        
        public void setSeverity(Severity severity) {
            this.severity = severity;
        }
        
        public Timestamp getReportedDate() {
            return this.reportedDate;
        }
        
        public void setReportedDate(Severity severity) {
            this.severity = severity;
        }
         
    }
    
    public static void main(String[] args) {
        Allergy peanutAllergy = new Allergy("Boss Man", "Sore throat, difflculting breathing", Severity.LOW, new Timestamp(System.currentTimeMillis()));
        
        System.out.println(peanutAllergy.getReporter());
        System.out.println(peanutAllergy.getSymptoms());
        System.out.println(peanutAllergy.getSeverity());
        System.out.println(peanutAllergy.getReportedDate());
    }
}