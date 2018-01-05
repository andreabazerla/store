package com.andreabazerla.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.andreabazerla.bean.BeanUser;
import com.andreabazerla.exception.DeleteUserException;
import com.andreabazerla.model.User_t;
import com.andreabazerla.util.EmailValidator;

@Controller
public class AuthenticationController extends ParentController {

  @RequestMapping(value = "/Login", method = RequestMethod.GET)
  public String loginGET(ModelAndView model) throws IOException {
    return "login";
  }

  @RequestMapping(value = "/Login", method = RequestMethod.POST)
  public ModelAndView loginPOST(@ModelAttribute BeanUser beanUser, HttpServletRequest request,
      HttpServletResponse response) throws IOException, ServletException {

    ModelAndView modelAndView = new ModelAndView("login");

    String username = beanUser.getUsername();
    String password = beanUser.getPassword();

    if ((username != null && !username.isEmpty()) && (password != null && !password.isEmpty())) {
      User_t user = getWebFacade().getUserService().load(username);

      if (user != null) {
        if (user.getPassword().equals(request.getParameter("password"))) {
          HttpSession session = request.getSession();
          beanUser.setId(user.getId());
          beanUser.setRole(user.getRole());
          beanUser.setName(user.getName());
          beanUser.setSurname(user.getSurname());
          session.setAttribute("currentUser", beanUser);

          return new ModelAndView("redirect:/Home");
        } else {
          modelAndView.addObject("error", "Wrong password");
          return modelAndView;
        }
      } else {
        modelAndView.addObject("error", "User doesn't exist");
        return modelAndView;
      }
    } else {
      modelAndView.addObject("error", "Empty field");
      return modelAndView;
    }
  }

  @RequestMapping(value = "/Signup", method = RequestMethod.GET)
  public ModelAndView signupGET() {
    ModelAndView modelAndView = new ModelAndView("signup");
    modelAndView.addObject("currentUser", null);
    return modelAndView;
  }

  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/Signup", method = RequestMethod.POST)
  public ModelAndView signupPOST(HttpServletRequest request, HttpServletResponse response, @RequestParam("image") MultipartFile image)
      throws SQLException, IOException, DeleteUserException {

    ModelAndView modelAndView = null;

    HttpSession httpSession = request.getSession();
    httpSession = request.getSession();
    User_t user = (User_t) httpSession.getAttribute("currentUser");

    String feedback = null;
    PrintWriter printWriter = response.getWriter();

    int id = 0;
    String role = request.getParameter("role");
    String code = request.getParameter("code");
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String confirmation = request.getParameter("confirmation");
    String name = request.getParameter("name");
    String surname = request.getParameter("surname");
    String email = request.getParameter("email");
    String birthday = request.getParameter("birthday");
    String city = request.getParameter("city");
    String address = request.getParameter("address");
    int cap = Integer.parseInt(request.getParameter("cap"));
    int number = Integer.parseInt(request.getParameter("number"));
//    String sex = request.getParameter("sex");
//    String region = request.getParameter("region");
    String button = request.getParameter("button");
//    String button = request.getParameter("image");
    String terms = null;
    
//    try {
//      byte[] bytes = image.getBytes();
//      Path path = Paths.get(UPLOADED_FOLDER + image.getOriginalFilename());
//      Files.write(path, bytes);
//
//    } catch (IOException e) {
//      e.printStackTrace();
//    }

    if (role == null)
      role = "USER";
    else
      role = "ADMIN";

    if (button.equals("Signup")) {
      terms = request.getParameter("terms");
    }

    if (!ifNull(name) && !ifNull(surname) && !ifNull(username) && !ifNull(password)
        && !ifNull(confirmation) && !ifNull(email) && !ifNull(birthday) /* && !ifNull(region) */
        && (button.equals("Update") || button.equals("Manage") || terms.equals("on"))) {

      List<User_t> userList = new ArrayList<User_t>();
      userList = (List<User_t>) getWebFacade().getUserService().load(username);
      User_t tempUser = null;

      if (userList != null && !userList.isEmpty()) {
        tempUser = userList.get(0);
      }

      if (tempUser == null) {
        if (button.equals("Signup")) {
          feedback = "{ \"type\": \"1\", \"message\": \"Ok user signup\" }";
          tempUser =
              new User_t(id, role, code, username, password, username, surname, email, birthday, city, address, cap, number);
          getWebFacade().getUserService().create(tempUser);
          request.setAttribute("currentUser", tempUser);
          httpSession.setAttribute("button", button);
          modelAndView = new ModelAndView("Login");
        } else {
          feedback =
              "{ \"type\": \"0\", \"field\": \"username\", \"message\": \"User not equals\" }";
        }
      } else {
        if (button.equals("Signup")) {
          feedback =
              "{ \"type\": \"0\", \"field\": \"username\", \"message\": \"User already exist\" }";
        } else {

          if (!password.equals(confirmation)) {
            feedback =
                "{ \"type\": \"0\", \"field\": \"confirmation\", \"message\": \"Passwords not equals\" }";
          } else if (!EmailValidator.validate(email)) {
            feedback =
                "{ \"type\": \"0\", \"field\": \"email\", \"message\": \"Email not valid\" }";
          } else {
            feedback = "{ \"type\": \"1\", \"message\": \"Ok user updated\" }";

            getWebFacade().getUserService().delete(id);

            user =
                new User_t(id, role, code, username, password, name, surname, email, birthday, city, address, cap, number);

            getWebFacade().getUserService().create(user);

            if (button.equals("Update")) {
              request.getSession().setAttribute("currentUser", user);
              modelAndView = new ModelAndView("Profile");
            } else if (button.equals("Manage")) {
              modelAndView = new ModelAndView("Users");
            }
          }
        }
      }
    } else {
      if (ifNull(birthday)) {
        feedback = "{ \"type\": \"0\", \"field\": \"birthday\", \"message\": \"Empty field\" }";
      }
      modelAndView = new ModelAndView("signup");
    }

    response.setContentType("application/json;charset=utf-8");
    printWriter.print(feedback);
    printWriter.flush();
    printWriter.close();
    return modelAndView;
  }

  @RequestMapping(value = "/CheckUsername", method = RequestMethod.GET)
  @ResponseBody
  public String checkUsername(@RequestParam(value = "username") String username) {
    User_t tempUser = getWebFacade().getUserService().load(username);

    String feedback = null;
    if (tempUser != null) {
      feedback =
          "{ \"type\": \"1\", \"header\": \"Error! \", \"message\": \"Error: username already exists\" }";
    } else {
      feedback = "{ \"type\": \"0\", \"header\": \"Success! \", \"message\": \"Ok\" }";
    }

    return feedback;

  }

  @RequestMapping(value = "/CheckBirthday", method = RequestMethod.GET)
  @ResponseBody
  public String checkDate(@RequestParam(value = "birthday") String birthday) {
    String feedback;

    String[] birthdayArray = birthday.split("-");

    String day = birthdayArray[0];
    String month = birthdayArray[1];
    String year = birthdayArray[2];

    if (day.equals("") || month.equals("") || year.equals("")) {
      feedback =
          "{ \"type\": \"1\", \"header\": \"Error! \", \"message\": \"Error: birthday not valid\" }";
    } else {
      feedback = "{ \"type\": \"0\", \"header\": \"Success! \", \"message\": \"Ok\" }";
    }

    return feedback;

  }

  @RequestMapping(value = "/Logout", method = RequestMethod.POST)
  public ModelAndView logoutUser(HttpServletRequest request) {

    HttpSession session = request.getSession(false);
    session.invalidate();

    return new ModelAndView("redirect:/Login");
  }

}
