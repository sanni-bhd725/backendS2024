package FinalProject.SleepTracker.domain;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
public class Sleep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "app_user_id")
    private AppUser appUser;

    @Pattern(message = "Fill the date in form dd.mm.yyyy", regexp = "^(0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[012])\\.(20)\\d\\d$")
    private String dateInput;

    @Range(min = 1, max = 100)
    private int sleepScore;

    @Range(min = 2, max = 20)
    private int sleepTimeHours /* , sleepTimeMins */;

    @Range(min = 1, max = 10)
    private int sleepCycles;
    // private int awakeHours, awakeMins, awakePercentage;
    // private int physicalHours, physicalMins, physicalPercentage;
    // private int mentalHours, mentalMins, mentalPercentage;

    public Sleep() {
    }

    public Sleep(AppUser appUser, String dateInput, int sleepScore, int sleepTimeHours, int sleepCycles) {
        this.appUser = appUser;
        this.dateInput = dateInput;
        this.sleepScore = sleepScore;
        this.sleepTimeHours = sleepTimeHours;
        this.sleepCycles = sleepCycles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getDateInput() {
        return dateInput;
    }

    public void setDateInput(String dateInput) {
        this.dateInput = dateInput;
    }

    public int getSleepScore() {
        return sleepScore;
    }

    public void setSleepScore(int sleepScore) {
        this.sleepScore = sleepScore;
    }

    public int getSleepTimeHours() {
        return sleepTimeHours;
    }

    public void setSleepTimeHours(int sleepTimeHours) {
        this.sleepTimeHours = sleepTimeHours;
    }

    public int getSleepCycles() {
        return sleepCycles;
    }

    public void setSleepCycles(int sleepCycles) {
        this.sleepCycles = sleepCycles;
    }

    @Override
    public String toString() {
        return "Sleep [appUser=" + appUser + ", dateInput=" + dateInput + ", sleepScore=" + sleepScore
                + ", sleepTimeHours=" + sleepTimeHours + ", sleepCycles=" + sleepCycles + "]";
    }

}
