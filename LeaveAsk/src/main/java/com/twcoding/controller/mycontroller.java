package com.twcoding.controller;

import java.io.UnsupportedEncodingException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.twcoding.model.Employee;
import com.twcoding.model.workinghour;
import com.twcoding.service.EmployeeService;
import com.twcoding.service.WorkinghourService;

@Controller
public class mycontroller {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private WorkinghourService workinghourService;
	
	@RequestMapping("")
	public String index(HttpServletRequest httpServletRequest) {
		if(httpServletRequest.getSession().getAttribute("emp")!=null) {
			return "redirect:/homepage";
		}
		//List<Employee> li = employeeService.findAllemp();
		//System.out.println(li);
		return "index";
	}
	@RequestMapping("/homepage")
	public String homepage(HttpServletRequest httpServletRequest) {

		httpServletRequest.setAttribute("MODEL","homepage");
		return "homepage";
	}
	@RequestMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password,
			HttpServletRequest httpServletRequest) {
		
		
		Employee emp=employeeService.findEmpByusername(username);
		if(emp==null) {

			httpServletRequest.setAttribute("username", username);
			httpServletRequest.setAttribute("password", password);
			return "index";
		}
		emp.setPassword("");
		workinghour w=workinghourService.findworkhourByUsername(username);
		httpServletRequest.getSession().setAttribute("emp", emp);
		httpServletRequest.getSession().setAttribute("workinghour", w);
		
		//httpServletRequest.getSession().setAttribute("emp", emp);
		//System.out.println(emp);
		System.out.println(httpServletRequest.getSession().getId());
		return "redirect:/homepage";
	}

	@RequestMapping("/detail")
	public String detail(HttpServletRequest httpServletRequest) {		

		String username=((Employee)httpServletRequest.getSession().getAttribute("emp")).getUsername();
		Employee emp=employeeService.findEmpByusername(username);
		workinghour w=workinghourService.findworkhourByUsername(username);
		httpServletRequest.setAttribute("MODEL", "detail");
		httpServletRequest.setAttribute("emp", emp);
		httpServletRequest.setAttribute("workinghour", w);
		return "homepage";
	}

	@RequestMapping("/leave")
	public String leave(HttpServletRequest httpServletRequest) {
		httpServletRequest.setAttribute("MODEL", "leave");
		httpServletRequest.getSession().removeAttribute("emp");
		return "homepage";
	}
	@RequestMapping("/leaveAsk")
	public String leaveAsk(@RequestParam String beginleave,
			@RequestParam String endleave) {
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
		try {
			System.out.println(beginleave);
			Date D_beginleave=sdf.parse(beginleave);			
			Date D_endleave=sdf.parse(endleave);			
			System.out.println(D_beginleave+""+D_endleave);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		
		return "homepage";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest httpServletRequest,
			HttpSession httpSession) {
		//httpServletRequest.getSession().removeAttribute("emp");
		httpSession.removeAttribute("emp");
		httpSession.removeAttribute("workinghour");
		return "index";
	}
	@RequestMapping("/alteremp")
	public String alteremp(HttpServletRequest httpServletRequest){
		httpServletRequest.setAttribute("MODEL", "alteremp");
		return "homepage";
	}
	@RequestMapping("/saveemp")
	public String saveemp(@ModelAttribute Employee emp,
			@Validated String toworktime_h,
			@Validated String toworktime_m,
			@Validated String offworktime_h,
			@Validated String offworktime_m,
			@Validated String lunchhour_h,
			@Validated String lunchhour_m,
			@Validated String afternoonworktime_h,
			@Validated String afternoonworktime_m,
			HttpServletRequest httpServletRequest) {
		workinghour w=(workinghour)httpServletRequest.getSession().getAttribute("workinghour");
		w.setToworktime(Time.valueOf(toworktime_h+":"+toworktime_m+":0"));
		w.setOffworktime(Time.valueOf(offworktime_h+":"+offworktime_m+":0"));
		w.setLunchhour(Time.valueOf(lunchhour_h+":"+lunchhour_m+":0"));
		w.setAfternoonworktime(Time.valueOf(afternoonworktime_h+":"+afternoonworktime_m+":0"));
		emp.setPassword(employeeService.findEmpByusername(emp.getUsername()).getPassword());
		System.out.println("this:"+emp+w);
		
		workinghourService.saveworkinghour(w);
		employeeService.saveemp(emp);
		
		emp.setPassword("");
		httpServletRequest.getSession().setAttribute("emp", emp);
		httpServletRequest.getSession().setAttribute("workinghour", w);
		
		httpServletRequest.setAttribute("MODEL", "detail");
		return "redirect:/detail";
	}
}
