import java.util.Random;//ability to randomise, better than Math.random() for my progrm.

public class AssignmentOne {
    private static void displayInfo() {
        System.out.println();
        System.out.println("*******************************************");
        System.out.println("Assignment 1, 159.234 Semester 1 2024");
        System.out.println("Submitted by: Taylor Saywell, ID: 23015257");
        System.out.println("My Major at Massey: Computer Science");
        System.out.println("*******************************************");
        System.out.println();
    }
    private static void schoolName() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("School Name: School of Mathematical and Computational Sciences");
        System.out.println();
    }
    private static void displayAllPaperDetails(Paper[] papers) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("All paper details:");
        for (Paper paper : papers) {
            paper.displayPaperDetails(); //I had to re-do this method as I had deleted from displayDetails in order to align text for task 6
        }
        System.out.println();
    }
    public static void main(String[] args) {
        displayInfo();//calling displayInfo method
        schoolName();//calling schoolName method - both of these are above.
        //create papers
        Paper[] papers = new Paper[]{
                new Paper("158100", "Information Technology Principles", new String[]{"IT", "IS"}, 70, 30, "No"),
                new Paper("158120", "Web-based IT Fundamentals", new String[]{"IT", "IS"}, 60, 40, "No"),
                new Paper("159101", "Applied Programming", new String[]{"IT", "IS", "CS", "DS", "SE"}, 50, 50, "No"),
                new Paper("159234", "Object-Oriented Programming", new String[]{"CS", "SE"}, 40, 20, "Yes"),
                new Paper("159201", "Algorithms and Data Structures", new String[]{"CS", "DS", "SE", "IS"}, 50, 10, "Yes"),
                new Paper("158337", "Database Development", new String[]{"IT", "SE", "DS"}, 60, 0, "Yes"),
                new Paper("158345", "Professionalism in the Information Sciences", new String[]{"IT", "IS", "CS", "DS", "SE"}, 100, 0, "No")
        };
        //create lecturers
        Lecturer[] lecturers = new Lecturer[]{
                new Lecturer("1230", "Michael", "Scott", "Auckland"),
                new Lecturer("1240", "Neil", "deGrasse Tyson", "Palmerston North"),
                new Lecturer("1250", "Anthony", "Stark", "Auckland"),
                new Lecturer("1260", "Robert", "Balboa", "Palmerston North"),
                new Lecturer("1270", "Albert", "Einstein", "Auckland"),
                new Lecturer("1280", "Nikola", "Tesla", "Auckland"),
                new Lecturer("23015257", "Taylor", "Saywell", "Auckland")
        };
        displayAllPaperDetails(papers);
        displayPapersForMajor(papers, "CS");//change major to see different versions of the displayPapers program
        displayExams(papers);//little confused where how to arrange these at first.
        displayPapersWithWeight(papers);

        Random random = new Random();
        PaperOffering[] offerings = new PaperOffering[21];//
        String[] modes = {"Distance", "Auckland", "PN"};//*deleted internal, not in specs

        for (int i = 0; i < 21; i++) {//changed loop to increment 21 times instead of original index of 7
            int lecturerIndex = random.nextInt(lecturers.length); //random lecturer index
            int paperIndex = random.nextInt(papers.length);//random paper index
            int modeIndex = random.nextInt(modes.length);//random mode index
            String mode = modes[modeIndex];//random mode
            offerings[i] = new PaperOffering(papers[paperIndex], lecturers[lecturerIndex], mode);//use random paper and lecturer
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Paper offerings:");
        for (PaperOffering offering : offerings) {
            offering.displayDetails();
        }
        papersTaught(offerings);//finally got this to work, confused on placement and whether I had correctly defined it
        lecturerOfPaper159234(offerings, "Auckland"); //call task 8
    }
    private static void displayPapersForMajor(Paper[] papers, String major) {//task 3 loop
        System.out.println("--------------------------------------------------------------");
        System.out.println("All papers belong to Major " + major + " at Massey University:");
        int count = 0;//initialise count before loop
        for (Paper paper : papers) {
            for (String paperMajor : paper.getMajors()) {
                if (paperMajor.equals(major)) {
                    System.out.println("Paper - " + paper.getPaperNumber() + " " + paper.getName());
                    count++;//increment until loop finishes
                    break;//found major, won't check further and program breaks loop
                }
            }
        }
        System.out.println("Total matching papers in specified Major - " + major + ": " + count);
    }
    private static void displayExams(Paper[] papers) {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("All papers that have an exam:");
        int countExam = 0;
        for (Paper paper : papers) {
            if ("Yes".equals(paper.getExam())) {  //check if exam is "Yes"
                System.out.println("Paper - " + paper.getPaperNumber() + " " + paper.getName());
                countExam++; //increment countExam
            }
        }
        System.out.println("Total number of papers that have an exam: " + countExam);
        System.out.println();
    }
    private static void displayPapersWithWeight(Paper[] papers) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("All papers whose assignments weigh more than 50% in total:");
        int weightCount = 0;
        for (Paper paper : papers) {
            if (paper.getAssignments() > 50) {//checks if the assignment weight is greater than 50%
                System.out.println("Paper - " + paper.getPaperNumber() + " " + paper.getName());
                weightCount++;//use the same count method as previous loops
            }
        }
        System.out.println("Total number of papers tha have assignments weighted more than 50%: " + weightCount);
        System.out.println();
    }
    private static void papersTaught(PaperOffering[] offerings) {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("The papers I am teaching:");
        int countTaught = 0;
        for (PaperOffering offering : offerings) {
            if ("Taylor Saywell".equals(offering.getLecturer().getFullName())) {
                //re-using spacing format to make task 7 readable, played with spacing to satisfy OCD
                String formatTask7 = String.format("%-15s %-13s %-12s Lecturer: %s",
                        "Paper Offering -",
                        offering.getPaper().getPaperNumber() + " ",
                        offering.getMode(),
                        offering.getLecturer().getFullName());
                System.out.println(formatTask7);
                countTaught++;
            }
        }
        System.out.println("I am teaching " + countTaught + " paper(s)");
    }
    private static void lecturerOfPaper159234(PaperOffering[] offerings, String campus) {
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("The lecturer of " + campus + " offering of 159234" + ":");
        String lecturerFullName = "";
        for (PaperOffering offering : offerings) {
            if ("159234".equals(offering.getPaper().getPaperNumber()) && campus.equalsIgnoreCase(offering.getMode())) {
                lecturerFullName = offering.getLecturer().getFullName();
                System.out.println("Lecturer: " + lecturerFullName);
                //assuming there is only one lecturer for 159234 at Akl campus
            }
        }
        if (!lecturerFullName.isEmpty()) {
            int countTaught = 0;
            for (PaperOffering offering : offerings) {
                if (offering.getLecturer().getFullName().equals(lecturerFullName)) {
                    countTaught++;
                }
            }
            System.out.println("This lecturer is teaching " + countTaught + " paper(s).");
        } else {
            System.out.println("No lecturer found for paper 159234 on the " + campus + " campus.");
        }
        System.out.println();
        System.out.println("Thanks for running, End of Program.");
    }
}


//to-do/self-review list:
//re-do Paper[] - done. originally had boolean values true/false for exams, but changed to String, happy with it, check back during tests.
//lecturers - done. happy with it, 1:1 ratio of lects to papers, originally had 8 lecturers.
//calling functions - not working, need to re-arrange throughout program, bugs galore. **Update - fixed, moved in order of program specs and found a suitable place where program runs effectively.
//random - find method to randomise - *update done, replaced Math.random() with java.util.Random framework.
//papersTaught and lecturerOfPaper159234 calls - fixed and placed properly, works fine now.
//displayPaperDetails - formatted correctly once spacing block was implemented
//issues with spacing format - fixed
//fix task 6 spacing and paper offerings - more than one lecturer takes AKL - 159234 - done.
//fix task 6 loop issue -
//randomise task 8 - lecturer/paper 159234? - no, looked at instructions, specifically says for paper 159234
//check loops and conditionals - done, changed loop index to iterate 21 times instead of 7, replicating assignment 1 specs
//separate files - done. 4x files for assignment 1
//organise - done, code should be readable now after tidying.
//double check all files - done.
//zip and finish - Monday 15 April @ 10:15am





