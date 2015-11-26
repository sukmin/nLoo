package kr.netty.nloo.web;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.netty.nloo.model.User;
import kr.netty.nloo.service.TestUserService;
//import kr.netty.nloo.validator.RegistrationValidator;

@Controller
@RequestMapping(value="/admin/user")
public class TestUserController {

	@Autowired
	private TestUserService userService;


	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model){
		List<User> users = userService.getAllUser();
		model.addAttribute("users", users);
		User user = new User();
		user.setId(UUID.randomUUID().toString());
		model.addAttribute("user", user);
		return "admin/user";
	}

	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView add(@ModelAttribute(value="user") User user,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/user");
		if(!result.hasErrors()){
			userService.saveUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute(value="user") User user,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/user");
		if(!result.hasErrors()){
			userService.updateUser(user);
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}

	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(value="user") User user,BindingResult result){
//		validator.validate(user, result);
		ModelAndView mv = new ModelAndView("admin/user");
		if(!result.hasErrors()){
			userService.deleteUser(user.getId());
			user = new User();
			user.setId(UUID.randomUUID().toString());
			mv.addObject("user", user);
		}
		mv.addObject("users", userService.getAllUser());
		return mv;
	}
}
