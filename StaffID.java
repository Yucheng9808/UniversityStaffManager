import java.util.*;
public class StaffID {
    private char letter;
    private int number;
    private String staffID;
    private static Map<String, StaffID> ID = new HashMap<String, StaffID>();

    private StaffID(char letter, int number, String staffID) {
        this.letter = letter;
        this.number = number;
        this.staffID = staffID;
    }

    public static StaffID getInstance() {
        Random rand1 = new Random();
        int number = 100 + rand1.nextInt(900) ;
        Random rand2 = new Random();
        char letter = (char) (rand2.nextInt(26) + 'a');
        String staffID = String.valueOf(letter) + number;
        StaffID id = ID.get(staffID);
        if (id == null) {
            id = new StaffID(letter, number, staffID);
            ID.put(staffID, id);
            return id;
        }else {
            throw new IllegalArgumentException("StaffID already exists");
        }

    }

    @Override
    public String toString() {
        return staffID;
    }

}


