package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.dto.UserDTO;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  String id = request.getParameter("id");
	  String password = request.getParameter("password");
	  String name = request.getParameter("name");
	  String birthDate = request.getParameter("birthDate");
	  String gender = request.getParameter("gender");
	  String email = request.getParameter("email");
	  String location = request.getParameter("location");
	  String phoneNumber = request.getParameter("phoneNumber");

	  
	  UserDTO user = new UserDTO();
	  user.setId(id);
    user.setPassword(password);
    user.setName(name);
    user.setBirthDate(birthDate);
    user.setGender(gender);
    user.setEmail(email);
    user.setLocation(location);
    user.setPhoneNumber(phoneNumber);
    
	  UserDAO dao = UserDAO.getInstance();
	  int count = dao.insertUser(user);
	  System.out.println("count: " + count);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
