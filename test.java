import java.util.*;

public class test {
    public static void main(String[] args) {
        StaffManager staffManager = new StaffManager();
        Set<Module> modules = new HashSet<>();
        modules = staffManager.readInModules("out/production/Staff Management System code/modules.TXT");
        Set<Name> names = new HashSet<>();
        names = staffManager.readInStudents("out/production/Staff Management System code/students.TXT");

        System.out.println(modules.toString());
        System.out.println(names.toString());

        Calendar cal = Calendar.getInstance();
        int year = 1980;
        cal.set(Calendar.YEAR, year);
        Date date = cal.getTime();
        String type = "Lecturer", status = "permanent";
        for(Name name : names){
            staffManager.employStaff(name.getFirstName(), name.getSurName(), date,
                    type, status);
            cal.set(Calendar.YEAR, ++year);
            date = cal.getTime();
            Random rand = new Random();
            int number = rand.nextInt(4) ;
            if(number%2 == 0){
                type = "Researcher";
                status = "fixed";
            }else {
                type = "Lecturer";
                status = "permanent";
            }
        }
        for( Staff staff : staffManager.getStaff_List()){
            System.out.println(staff);
        }

    }
}
