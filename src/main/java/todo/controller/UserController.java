package todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import todo.model.User;
import todo.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/all")
	public ModelAndView getAllUsers(){
		ModelAndView model = new ModelAndView("/users/list");
		model.addObject("list", userService.getAllUsers());
		return model;
	}
	
	@RequestMapping("/{id}")
	public ModelAndView getUserById(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("/users/list");
		model.addObject("list", userService.getUserById(id));
		return model;
	}
	
	@RequestMapping("/update/{id}")
	public ModelAndView updateUser(@PathVariable("id") int id){
		ModelAndView model = new ModelAndView("/users/form");
		User user = userService.getUserById(id);
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping("/add")
	public ModelAndView addUser(){
		ModelAndView model = new ModelAndView("/users/form");
		User user = new User();
		model.addObject("userForm", user);
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute User user){
		userService.addUser(user);
		return new ModelAndView("redirect:/users/all");
	}
	
	@RequestMapping("/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") int id){
		userService.deleteUser(id);
		return new ModelAndView("redirect:/users/all");
	}
}
