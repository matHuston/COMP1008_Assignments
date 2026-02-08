public class PayrollTest {
 
    public static void main(String[] args) {

        // TODO 9: Create a CommissionEmployee object
        CommissionEmployee cEmployee = new CommissionEmployee("Mat", "Huston", "555-555-5555", 6000, .05);

        // TODO 10: Display employee details
        System.out.println(cEmployee.toString()); // invokes toString()
 
        // TODO 11: Display earnings
        System.out.printf("Earnings: $%.2f%n", cEmployee.earnings());
    }

    
}