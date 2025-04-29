import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        System.out.printf("Hello and welcome!");

//        Class.forName("com.mysql.cj.jdbc.Driver");
           try {
               Connection conn = DriverManager.getConnection(
                       "jdbc:mysql://localhost:3306/jdbc" ,"root" ,"root");

               if(conn != null){
                   System.out.println("Connected to DB");

               }else  {
                   System.out.println("Not connected");
               }

               // 3. Insert a student
//               String insertSql = "INSERT INTO student (id, name, salary) VALUES (?, ?, ?)";
//               PreparedStatement ps = conn.prepareStatement(insertSql);
//               ps.setInt(1, 104);
//               ps.setString(2, "Vivek");
//               ps.setInt(3, 17000);
//               ps.executeUpdate();
//               System.out.println("📥 Inserted record");


//               Update a student
               String updateStudent = "UPDATE student SET salary = ? WHERE id = ? ";

               PreparedStatement us = conn.prepareStatement(updateStudent);
               us.setInt(1,25000);
               us.setInt(2,101);
               us.executeUpdate();
               System.out.println("updated salary");

//               delete a student
               String deleteStudent = "DELETE FROM student WHERE id = ?";

               PreparedStatement ds = conn.prepareStatement(deleteStudent);
               int id = 102;
               ds.setInt(1,id);
               ds.executeUpdate();
               System.out.println("deleted student with id " + id);




               String querSel = "SELECT * FROM student";
               ResultSet res = conn.createStatement().executeQuery(querSel);
               System.out.println("Student table");

               while (res.next()){
                   System.out.println("id " + res.getInt("id") + " " +
                           res.getString("name")
                   + " " + res.getInt("salary")
                   );
               }

               res.close();
//               ps.close();
               conn.close();
               System.out.println("connection closed");

           }catch (Exception e){
               e.printStackTrace();
        }




    }
}