import java.util.*;
public class Researcher extends StaffFactory{
    Set<Name> student_Set = new HashSet<>();
    Researcher(StaffID staffID, SmartCard smartCard){
        super(staffID, smartCard);
    }

    @Override
    public String getStaffType() {
        return "Researcher";
    }

    public Set<Name> listStudentsSupervised(){
        return student_Set;
    }

    public boolean testResearcherWork() {
        int studentsNum = 0;
        for (Name name : student_Set) {
            studentsNum++;
        }
        if(studentsNum == 10){
            return true;
        }else {
            return false;
        }
    }

    public void setResearcher(Name name){
        student_Set.add(name);
    }
}
