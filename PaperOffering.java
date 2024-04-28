import java.util.Random;

public class PaperOffering {
    private Paper paper;
    private Lecturer lecturer;
    private String mode;

    //Paper and Lecturer are public, so this works
    public PaperOffering(Paper paper, Lecturer lecturer, String mode) {
        this.paper = paper;
        this.lecturer = lecturer;
        this.mode = mode;
    }
    public Paper getPaper() {
        return this.paper;
    }
    public Lecturer getLecturer() {
        return this.lecturer;
    }
    public String getMode(){
        return this.mode;
    }
    public void displayDetails() {
        String alignDetails = String.format("%-10s %-15s %-15s",//played around with this format for awhile to get right format
                paper.getPaperNumber(),
                mode,
                lecturer.getFullName());
        System.out.println(alignDetails);//everything is nicely aligned now
    }
}
