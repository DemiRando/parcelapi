package com.parcelapi.parcelapi.respository;

import com.parcelapi.parcelapi.SQLUtilities;
import com.parcelapi.parcelapi.entity.User;
import com.parcelapi.parcelapi.exceptions.EtAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Primary
public interface UserRepository extends JpaRepository<User,Integer> {
    default Integer getCountByEmail(String email){
        final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM [ParcelMessenger].[dbo].[apiUsers] WHERE [email] = ?";
        int count = 0;
        SQLUtilities.Connect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = SQLUtilities.connection.prepareStatement(SQL_COUNT_BY_EMAIL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (true){
            try {
                if (!r.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                count = r.getInt(1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return count;
    };

    default User findByEmailAndPassword(String email, String password) throws EtAuthException {
        String pass="";
        int userID= 0;
        String firstN="";
        String lastN="";
        String mail="";
        User user = new User();
        final String SQL_FIND_BY_EMAIL = "SELECT [userID], [firstName], [lastName], [email], [password] " +
                "FROM [ParcelMessenger].[dbo].[apiUsers] WHERE [email] = ?";
        SQLUtilities.Connect();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = SQLUtilities.connection.prepareStatement(SQL_FIND_BY_EMAIL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            preparedStatement.setString(1,email);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet r = SQLUtilities.ExecuteQuery(preparedStatement);
        while (true){
            try {
                if (!r.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                userID = r.getInt(1);
                firstN = r.getString(2);
                lastN = r.getString(3);
                mail = r.getString(4);
                pass = r.getString(5);
                user.setEmail(mail);
                user.setPassword(pass);
                user.setFirstName(firstN);
                user.setLastName(lastN);
                user.setUserId(userID);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(!BCrypt.checkpw(password, pass))
                throw new EtAuthException("Invalid email/password");
             }
        return user;
    }
     }


