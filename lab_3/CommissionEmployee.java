package lab_3;
public class CommissionEmployee extends Employee {
 
    private double grossSales;
    private double commissionRate;
 
    // TODO 5: Create constructor using super()
    public CommissionEmployee(String first, String last, String ssn, double sales, double rate){
        // call superclass constructor from Employee.java
        super(first, last, ssn); 
        setGrossSales(sales);
        setCommissionRate(rate);
    }

    // TODO 6: Create getters and setters with validation
    //setters with validation
    
 
    // TODO 7: Override earnings()
 
    // TODO 8: Override toString()
}