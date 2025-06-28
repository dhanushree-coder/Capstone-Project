// === EmployeeDAO.java ===
package dao;
import model.Employee;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class EmployeeDAO {

    public static void addEmployee(Employee e) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO employee(name, email, designation, type, basicsalary) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.name);
            ps.setString(2, e.email);
            ps.setString(3, e.designation);
            ps.setString(4, e.type);
            ps.setDouble(5, e.basicSalary);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void updateEmployee(Employee e) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE employee SET name=?, email=?, designation=?, type=?, basicsalary=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, e.name);
            ps.setString(2, e.email);
            ps.setString(3, e.designation);
            ps.setString(4, e.type);
            ps.setDouble(5, e.basicSalary);
            ps.setInt(6, e.id);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void deleteEmployee(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            conn.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            while (rs.next()) {
                Employee e = new Employee();
                e.id = rs.getInt("id");
                e.name = rs.getString("name");
                e.email = rs.getString("email");
                e.designation = rs.getString("designation");
                e.type = rs.getString("type");
                e.basicSalary = rs.getDouble("basicsalary");
                list.add(e);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return list;
    }
}
