/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */

package com.qdpm.operations.utility;

import java.sql.*;
import java.util.HashMap;

/**
 * This class is useful to verify database by using different sql quires
 */
public class DataBaseDriver {

    public synchronized HashMap<String, String> getSqlResultInMap(String sql) {
        HashMap<String, String> data_map = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/qdpm_qa?serverTimezone=UTC", "root", "");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData md = resultSet.getMetaData();

            while (resultSet.next()) {
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    data_map.put(md.getColumnName(i), resultSet.getString(i));
                }
            }
            System.out.println(data_map);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return data_map;
    }

}
