// === SalaryCalculator.java ===
package util;
import model.Employee;

public class SalaryCalculator {
    public static double calculateGross(Employee e) {
        return e.basicSalary * (e.type.equals("FullTime") ? 1.5 : 1.2);
    }

    public static double calculateTax(double gross) {
        return gross * 0.1;
    }

    public static double calculateDeductions(double gross) {
        return gross * 0.05;
    }
}