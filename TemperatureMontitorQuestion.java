class TemperatureMontiorQuestion {

    enum BodyLocation {
        MOUTH, ARMPIT, RECTUM, EAR
    }

    enum RecentPhysicalActivity {
        LOW, MEDIUM, HIGH
    }

    public static class TemperatureMontior {
        private float temperature;
        private BodyLocation location;
        private RecentPhysicalActivity physicalActivity;

        public TemperatureMontior(float temperature, BodyLocation location, RecentPhysicalActivity physicalActivity) {
            this.temperature = temperature;
            this.location = location;
            this.physicalActivity = physicalActivity;
        }

        public boolean hasFever() {
            if (temperature > 100.4f) {
                return true;
            }
            else {
                return false;
            }
        }

        public float getTemperature() {
            return this.temperature;
        }

        public void setTemperature(float temperature) {
            this.temperature = temperature;
        }

        public BodyLocation getLocation() {
            return this.location;
        }

        public void setLocation(BodyLocation location) {
            this.location = location;
        }

        public RecentPhysicalActivity getPhysicalActivity() {
            return this.physicalActivity;
        }

        public void setPhysicalActivity(RecentPhysicalActivity physicalActivity) {
            this.physicalActivity = physicalActivity;
        }
    }

    public static void main(String[] args) {
        TemperatureMontior healthyPatient = new TemperatureMontior(98.9f, BodyLocation.MOUTH, RecentPhysicalActivity.MEDIUM);
        TemperatureMontior sickPatient = new TemperatureMontior(103.2f, BodyLocation.EAR, RecentPhysicalActivity.LOW);

        System.out.printf("For the healthy patient, their temperature is %.1ff, the location of where the temperature was"
            + " taken was the patient's %s, while their recent physical activaty was %s. This patient %s have a fever.\n",
            healthyPatient.getTemperature(), healthyPatient.getLocation(), healthyPatient.getPhysicalActivity(),
            healthyPatient.hasFever() ? "does" : "does not");
        System.out.printf("For the sick patient, their temperature is %.1ff, the location of where the temperature was"
            + " taken was the patient's %s, while their recent physical activaty was %s. This patient %s have a fever",
            sickPatient.getTemperature(), sickPatient.getLocation(), sickPatient.getPhysicalActivity(),
            sickPatient.hasFever() ? "does" : "does not");
    }
}