package com.pamtry.login.repository;

import org.springframework.stereotype.Repository;
import com.pantry.login.database.DBConnection;
import com.pantry.login.model


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class UserRepository {
    public user findByUserName(String userName) {
        string query = "SELECT * FROM users WHERE userName = " + userName +"";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(query);) {
                
            try(ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    User user = new User(rs.getString("username"), rs.getString("password"));
                    return user;
                }
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
            
    }
}