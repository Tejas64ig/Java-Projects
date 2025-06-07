import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DATA_BASE_CONNECTIVITY {

    public Statement s;

    DATA_BASE_CONNECTIVITY() {

        Connection c;


        try {
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bankMagementsystem",
                    "root",
                    "Phoneix64489"
            );
            s= c.createStatement();

        } catch (Exception e) {

            System.out.println(e);

        }
    }


}
