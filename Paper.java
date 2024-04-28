import java.util.Random;

public class Paper {
        private String paperNumber;
        private String name;
        private String[] majors;
        private int assignments; //added assignments, tests and exams data later
        private int tests;
        private String exam;

    public Paper(String paperNumber, String name, String[] majors, int assignments, int tests, String exam) {
        this.paperNumber = paperNumber;
        this.name = name;
        this.majors = majors;
        this.assignments = assignments;
        this.tests = tests;
        this.exam = exam;
    }
    public int getAssignments() {
        return assignments;
    }
    public int getTests() {
        return tests;
    }
    public String getExam() {
        return exam;
    }
    public String getMajor(){
        return "(" + String.join(" ",  majors) + ")";//a lot of playing with this
    }
    public String[] getMajors(){
        return majors;
    }
    public String getPaperNumber(){
        return paperNumber;
    }
    public String getName() {
        return name;
    }
    public void displayPaperDetails() {
        System.out.print(getPaperNumber() + " " + getName() + " " + getMajor());
        System.out.println(); //this will printdetails in a single line
    }
}
