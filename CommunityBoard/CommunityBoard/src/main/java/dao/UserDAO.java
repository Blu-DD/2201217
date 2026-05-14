package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.UserDTO;
import util.DBUtil;

public class UserDAO {

    public boolean insertUser(UserDTO user){

        String sql =
        "INSERT INTO users(username,password,nickname,email) VALUES(?,?,?,?)";

        try {

            Connection conn=
                    DBUtil.getConnection();

            PreparedStatement pstmt=
                    conn.prepareStatement(sql);

            pstmt.setString(
                    1,
                    user.getUsername()
            );

            pstmt.setString(
                    2,
                    user.getPassword()
            );

            pstmt.setString(
                    3,
                    user.getNickname()
            );

            pstmt.setString(
                    4,
                    user.getEmail()
            );

            int result=
                    pstmt.executeUpdate();

            return result>0;

        }

        catch(Exception e){

            e.printStackTrace();

        }

        return false;
    }
    
    public boolean isDuplicateUsername(String username){

        String sql =
        "SELECT * FROM users WHERE username=?";

        try{

            Connection conn=
                    DBUtil.getConnection();

            PreparedStatement pstmt=
                    conn.prepareStatement(sql);

            pstmt.setString(1, username);

            ResultSet rs=
                    pstmt.executeQuery();

            return rs.next();

        }

        catch(Exception e){

            e.printStackTrace();
        }

        return false;
    }
    
    public UserDTO login(
            String username,
            String password){

        String sql =
        "SELECT * FROM users WHERE username=? AND password=?";

        try{

            Connection conn =
                    DBUtil.getConnection();

            PreparedStatement pstmt =
                    conn.prepareStatement(sql);

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs =
                    pstmt.executeQuery();

            if(rs.next()){

                UserDTO user =
                        new UserDTO();

                user.setUserId(
                        rs.getInt("user_id"));

                user.setUsername(
                        rs.getString("username"));

                user.setNickname(
                        rs.getString("nickname"));

                user.setEmail(
                        rs.getString("email"));

                return user;
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return null;
    }

}