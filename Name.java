
public class Name {
    private String firstName, surName;

    public Name(String firstName, String surName){
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getName() {
        return firstName + "" + surName;
    }

    /**
     * for test
     * @return
     */
    @Override
    public String toString() {
        return  "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' + '\n';
    }
}
