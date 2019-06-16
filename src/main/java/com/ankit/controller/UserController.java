package com.ankit.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ankit.command.UserCommand;
import com.ankit.dto.UserDTO;
import com.ankit.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String showForm(Model model) {
		// create command object keeps in model attribute
		UserCommand user = new UserCommand();
		model.addAttribute("UserCmd", user);
		// return logical view name
		return "login";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public String processForm(Model model, @ModelAttribute("UserCmd") UserCommand cmd, BindingResult errors) {
		String result = null;
		UserDTO dto = null;
		dto = new UserDTO();
		// convert Command obj to dto
		BeanUtils.copyProperties(cmd, dto);
		result = service.authenticate(dto);
		// keeps the model data in attribute
		model.addAttribute("result", result);
		// return logic View Name
		return "login";
	}
}
