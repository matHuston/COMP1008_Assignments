public abstract class Employee {
 
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
 
    // TODO 1: Create a constructor
    
    
        //constructor to initialize the three instance variables
        public Employee(String first, String last, String ssn){
            this.firstName = first;
            this.lastName = last;
            this.socialSecurityNumber = ssn;
        }

 
    // TODO 2: Create getters
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }
 
    // TODO 3: Declare abstract method earnings()
    public abstract double earnings();
 
    // TODO 4: Override toString()
    @Override
    public String toString() {
        return String.format("%s %s%nSocial Security Number: %s", 
            getFirstName(), getLastName(), getSocialSecurityNumber());
    }
}
