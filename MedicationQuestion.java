import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/*
    Building a diagram and writing some code for a system to tell users when to take medication.
*/

public class MedicationQuestion {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    public static class Medication {
        private String name;
        private int amountToTake;
        private List<Day> daysOfConsumption;

        public Medication(String name, int amountToTake, Day[] daysOfConsumption) {
            this.name = name;
            this.amountToTake = amountToTake;
            this.daysOfConsumption = Arrays.asList(daysOfConsumption);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAmountToTake() {
            return this.amountToTake;
        }

        public void setAmountToTake(int amountToTake) {
            this.amountToTake = amountToTake;
        } 

        public Day[] getDaysOfConsumtion() {
            return this.daysOfConsumption;
        }

        public void setDaysOfConsumtion(Day[] daysOfConsumption) {
            this.daysOfConsumption = daysOfConsumption;
        }
    }

    public static class MedicationSchedule {
        List<Medication> medications;

        public MedicationSchedule() {
            this.medications = new ArrayList();
        } 

        public void addMedication(Medication medicine) {
            this.medications.add(medicine);
        }

        public List<Medication> getMedicineForDay(Day dayToGet) {
            List<Medication> medcineForDay = medications.stream()
                .filter(med -> med.daysOfConsumption.contains(dayToGet))
                .collect(Collectors.toList());

            return medcineForDay;
        }

        public String getMedicineForDayAsString(Day dayToGet) {
            List<Medication> medicationForDay = this.getMedicineForDay(dayToGet);

            if (medicationForDay.size() == 0) {
                return "no medicine";
            }

            return String.join(" and ", medicationForDay.stream()
                .map(med -> med.getAmountToTake() + " " + med.getName())
                .collect(Collectors.toList()));
        }

        public Map<Day, String> getMedicineForWeek() {
            Map<Day, String> medicineForWeek = new HashMap<>();

            for (Day day : EnumSet.allOf(Day.class)) {
                medicineForWeek.put(day, this.getMedicineForDayAsString(day));
            }

            return medicineForWeek;
        }

        public String getMedicineForWeekAsString() {
            Map<Day, String> medicineForWeek = this.getMedicineForWeek();
            StringBuilder medicineForWeekString = new StringBuilder();

            for (Day day : EnumSet.allOf(Day.class)) {
                medicineForWeekString.append("For " + day + " The patient should take " 
                    + medicineForWeek.get(day) + "\n");
            }

            return medicineForWeekString.toString();
        }

        public List<Mediation> getMedications() {
            return this.medications;
        }

        public void setMedications(List<Medication> medications) {
            this.medications = medications;
        }
    }

    public static void main(String[] args) {
        Day[] painMedicineDays = {Day.MONDAY, Day.WEDNESDAY, Day.FRIDAY};
        Day[] allergyMedicineDays = {Day.MONDAY};
        Day[] coldMedicineDays = {Day.TUESDAY, Day.THURSDAY};
        Medication painMedicine = new Medication("Aspirin", 3, painMedicineDays);
        Medication allergyMedicine = new Medication("Claritin", 1, allergyMedicineDays);
        Medication coldMedicine = new Medication("Mucinex", 2, coldMedicineDays);
        MedicationSchedule schedule = new MedicationSchedule();

        schedule.addMedication(painMedicine);
        schedule.addMedication(allergyMedicine);
        schedule.addMedication(coldMedicine);

        System.out.println(schedule.getMedicineForWeekAsString());
    }
}