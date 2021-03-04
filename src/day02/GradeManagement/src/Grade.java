public class Grade {
    String subject;
    int total;
    int midTerm;
    int finalTerm;
    int assignment;
    int attend;
    int volunteer;
    double gap;
    String teacher;

    int testCalc(){
        total = midTerm + finalTerm + assignment;
        return total;
    }

    Grade(String subject, int midTerm, int finalTerm, int assignment){
        this.subject = subject;
        this.midTerm = midTerm;
        this.finalTerm = finalTerm;
        this.assignment = assignment;
    }//element

    Grade(String subject, String teacher, int midTerm, int finalTerm, int assignment, int attend, int volunteer){
        this.subject = subject;
        this.teacher = teacher;
        this.midTerm = midTerm;
        this.finalTerm = finalTerm;
        this.assignment = assignment;
        this.attend = attend;
        this.volunteer = volunteer;
    }//element

    Grade(String subject, String teacher, int midTerm, int finalTerm, int assignment, int attend, int volunteer, double gap){
        this.subject = subject;
        this.midTerm = midTerm;
        this.teacher = teacher;

        this.finalTerm = finalTerm;
        this.assignment = assignment;
        this.attend = attend;
        this.volunteer = volunteer;
        this.gap = gap;
    }//element

}//end grade

class Element extends Grade{
    Element(String subject, int midTerm, int finalTerm, int assignment){
        super(subject, midTerm, finalTerm, assignment);
    }

    public String toString() {
        return "초등학생";
    }
}//end element

class Middle extends Grade{
    Middle(String subject, String teacher, int midTerm, int finalTerm, int assignment, int attend, int volunteer){
        super(subject, teacher, midTerm, finalTerm, assignment,attend,volunteer);

    }

    public String toString() {
        return "중학생";
    }
    int testCalc(){
        total = midTerm + finalTerm + assignment + attend + volunteer;
        return total;
    }
}//end middle

class High extends Grade{
    High(String subject, String teacher, int midTerm, int finalTerm, int assignment, int attend, int volunteer, double gap){
        super(subject,teacher, midTerm, finalTerm, assignment, attend, volunteer,gap);

    }
    public String toString() {
        return "고등학생";
    }

    int testCalc(){
        total = midTerm + finalTerm + assignment + attend + volunteer;
        return total;
    }

}//end high
