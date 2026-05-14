package controller.user;

import java.io.IOException;

import dao.UserDAO;
import dto.UserDTO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet
extends HttpServlet{

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)

            throws ServletException,
            IOException{

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

        UserDAO dao=
                new UserDAO();

        UserDTO user=
                dao.login(
                        username,
                        password);
        

        if(user!=null){

            HttpSession session=
                    request.getSession();

            session.setAttribute(
                    "loginUser",
                    user);

            response.sendRedirect(
                    "index.jsp");
        }
        else{

            response.getWriter()
            .println("로그인 실패");
        }



    }

}