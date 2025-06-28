// === PayrollService.java ===
package service;
import model.Employee;
import model.Payroll;
import util.SalaryCalculator;
import dao.PayrollDAO;
import java.util.Date;
import java.text.SimpleDateFormat;

public class PayrollService {
    public static Payroll generatePayroll(Employee e) {
        Payroll p = new Payroll();
        p.empId = e.id;
        p.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        p.grossSalary = SalaryCalculator.calculateGross(e);
        p.tax = SalaryCalculator.calculateTax(p.grossSalary);
        p.deductions = SalaryCalculator.calculateDeductions(p.grossSalary);
        p.netPay = p.grossSalary - p.tax - p.deductions;

        // Save to DB
        PayrollDAO.savePayroll(p);

        // Show salary components clearly
        System.out.println("Gross Salary: " + p.grossSalary);
        System.out.println("Tax Amount: " + p.tax);
        System.out.println("Deductions: " + p.deductions);
        System.out.println("Net Pay: " + p.netPay);

        return p;
    }
}
