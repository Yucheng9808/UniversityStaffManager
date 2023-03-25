public abstract class StaffFactory implements Staff{
    public static final String Lecturer = "lecturer";
    public static final String Researcher = "Researcher";
    private StaffID staffID;
    private SmartCard smartCard;

    public StaffFactory(StaffID staffID, SmartCard smartCard) {
        this.staffID = staffID;
        this.smartCard = smartCard;
    }

    /**
     * Use factory methods create Staff object
     * @param type
     * @param staffID
     * @param smartCard
     * @return
     */
    public static Staff getInstance(String type, StaffID staffID, SmartCard smartCard){

        Staff staff;
        if(type.equals("Lecturer")){
            return staff = new Lecturer(staffID, smartCard);
        }else if(type.equals("Researcher")){
            return staff = new Researcher(staffID, smartCard);
        }else{
            throw new IllegalArgumentException("invalid staff type " + type);
        }
    }

    @Override
    public StaffID getStaffID() {
        return staffID;
    }

    @Override
    public SmartCard getSmartCard() {
        return smartCard;
    }

    @Override
    public String getStaffEmploymentStatus() {
        return smartCard.getStatus();
    }

    @Override
    public String toString() {
        return  "staffID=" + staffID.toString() +
                ", smartCard=" + smartCard.toString() + "\n";
    }
}
