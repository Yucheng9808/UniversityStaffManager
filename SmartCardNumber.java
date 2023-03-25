import java.util.*;

public class SmartCardNumber {
    private final String initialName;
    private final int randomNumber;
    private Date issueDate;

    private final String smartCardNumber;
    private static final Map<String, SmartCardNumber> SCNumber = new HashMap<String, SmartCardNumber>();
    private SmartCardNumber(String initialName, int randomNumber, Date issueDate, String smartCardNumber){
        this.initialName = initialName;
        this.randomNumber = randomNumber ;
        this.issueDate = issueDate;
        this.smartCardNumber = smartCardNumber;
    }
    public SmartCardNumber(){
        this.initialName = null;
        this.randomNumber = 0 ;
        this.issueDate = null;
        this.smartCardNumber = null;
    }

    public static SmartCardNumber getInstance(Name name, Date issueDate) {
        String firstName = name.getFirstName();
        String surName = name.getSurName();
        String initialName =  firstName.charAt(0) + surName.substring(0,1);
        Random rand = new Random();
        int randomNumber = rand.nextInt(100) ;
        Calendar cal = Calendar.getInstance();
        cal.setTime(issueDate);
        String smartCardNumber = initialName + "-" + randomNumber + "-" + cal.get(Calendar.YEAR);
        SmartCardNumber number = SCNumber.get(smartCardNumber);
        if (number == null) {
            number = new SmartCardNumber(initialName, randomNumber, issueDate, smartCardNumber);
            SCNumber.put(smartCardNumber, number);
        }else {
            throw new IllegalArgumentException("Smart Card Number already exists");
        }

        return number;
    }

    public int getIssueYear() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(issueDate);
        return cal.get(Calendar.YEAR);
    }

    public Date getIssueDate(){
        return issueDate;
    }

    /**
     * test
     */
    @Override
    public String toString() {
        return ", smartCardNumber='" + smartCardNumber + '\''+ "\n";
    }
}
