// === PayrollDAO.java ===
package dao;
import model.Payroll;
import util.DBConnection;
import java.sql.*;

public class PayrollDAO {
    public static void savePayroll(Payroll p) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO payroll(empid, date, grosssalary, tax, deductions, netpay) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, p.empId);
            ps.setString(2, p.date);
            ps.setDouble(3, p.grossSalary);
            ps.setDouble(4, p.tax);
            ps.setDouble(5, p.deductions);
            ps.setDouble(6, p.netPay);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
