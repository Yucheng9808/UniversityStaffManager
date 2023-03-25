import java.util.*;
public class SmartCard {
    private Name name;
    private Date birth;
    private SmartCardNumber smartCardNumber;

    private String status;

    private Date expiryDate = new Date();

    public SmartCard(String firstName, String surName, Date birth, String status) {
        Name name= new Name(firstName, surName);
        this.name = name;
        Calendar currentDate = Calendar.getInstance();
        Date date = currentDate.getTime();
        this.smartCardNumber = smartCardNumber.getInstance(name,date);
        this.birth = birth;
        this.status = status;
    }

    public Name getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    public SmartCardNumber getSmartCardNumber() {
        return smartCardNumber;
    }

    public int getIssueYear(){
        return smartCardNumber.getIssueYear();
    }

    public String getStatus() {
        return status;
    }


    private void setExpiryDate() {
        if (status.equals("permanent")) {
            int year = smartCardNumber.getIssueYear() + 10;
            Calendar cal = new GregorianCalendar();
            cal.setTime(smartCardNumber.getIssueDate());
            cal.set(Calendar.YEAR, year);
            expiryDate = cal.getTime();
        } else if (status.equals("fixed")) {
            int year = smartCardNumber.getIssueYear() + 2;
            Calendar cal = new GregorianCalendar();
            cal.setTime(smartCardNumber.getIssueDate());
            cal.set(Calendar.YEAR, year);
            expiryDate = cal.getTime();
        } else {
            throw new IllegalArgumentException("invalid status" + status);
        }
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * test
     */
    @Override
    public String toString() {
        return  name.toString() +
                ", birth=" + birth +
                "," + smartCardNumber.toString() +
                ", status='" + status + '\'' + "\n";
    }
}


