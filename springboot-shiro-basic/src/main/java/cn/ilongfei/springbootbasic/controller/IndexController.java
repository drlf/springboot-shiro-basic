package cn.ilongfei.springbootbasic.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static Logger log = LoggerFactory.getLogger(IndexController.class);
	
	/*
	@RequestMapping(value = "/login" , method = RequestMethod.GET    )
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return "login";
    }
	
	@RequestMapping(value = "/login" , method = RequestMethod.POST    )
    public String doLogin(HttpServletRequest req, Model model) {
		String error = null;
		String username = req.getParameter("username"); 
		String password = req.getParameter("password"); 
		Subject subject = SecurityUtils.getSubject(); 
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try { subject.login(token);
		} catch (UnknownAccountException e) { error = "用户名/密码错误";
		} catch (IncorrectCredentialsException e) { error = "用户名/密码错误";
		} catch (AuthenticationException e) { //其他错误,比如锁定,如果想单独处理请单独 catch 处理 error = "其他错误:" + e.getMessage();
		}
		if(error != null) {//出错了,返回登录页面
		req.setAttribute("error", error);
		return "login"; } else {//登录成功
			
		return "success"; }
    }*/
	
	
}
