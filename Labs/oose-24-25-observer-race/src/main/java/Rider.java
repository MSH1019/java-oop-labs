public class Rider {

    private String firstName;
    private String lastName;

    Rider(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }
    
}
