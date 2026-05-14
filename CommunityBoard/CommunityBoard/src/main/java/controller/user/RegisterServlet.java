package controller.user;

import java.io.IOException;

import dao.UserDAO;
import dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet
extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
            IOException {

    	request.setCharacterEncoding("UTF-8");

        response.setContentType(
                "text/html; charset=UTF-8");

        response.setCharacterEncoding(
                "UTF-8");

        String username=
                request.getParameter(
                        "username");

        String password=
                request.getParameter(
                        "password");

        String nickname=
                request.getParameter(
                        "nickname");

        String email=
                request.getParameter(
                        "email");

        UserDTO user=
                new UserDTO();

        user.setUsername(
                username);

        user.setPassword(
                password);

        user.setNickname(
                nickname);

        user.setEmail(
                email);

        UserDAO dao=
                new UserDAO();

        boolean result=
                dao.insertUser(
                        user);

        if(result){

            response.sendRedirect(
                    "index.jsp");

        }

        else{

            response.getWriter()
            .println(
                    "회원가입 실패");

        }
        
    }
}