import java.util.*;
public class Lecturer extends StaffFactory{
    Set<Module> module_Set = new HashSet<>();
     Lecturer(StaffID staffID, SmartCard smartCard){
        super(staffID, smartCard);
    }

    @Override
    public String getStaffType() {
        return "Lecturer";
    }

    public Set<Module> listLecturerModules(){
        return module_Set;
    }

    public boolean testLecturerWork(){
         int credits1 = 0;
         int credits2 = 0;
         for(Module module : module_Set) {
             if(module.getSemester() == 1) {
                 credits1 = credits1 + module.getCredits();
             }else {
                 credits2 = credits2 + module.getCredits();
             }
         }
             if (credits1 == 40 && credits2 == 40) {
                 return true;
             } else {
                 return false;
             }
         }

    public void setModule(Module module) {
        module_Set.add(module);
    }
}
