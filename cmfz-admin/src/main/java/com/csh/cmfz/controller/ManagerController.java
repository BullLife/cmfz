package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.ManagerService;
import com.csh.cmfz.util.CreateValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URLDecoder;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/4 14:17
 **/
@Controller
@RequestMapping("/mgr")
public class ManagerController {

    @Autowired
    private ManagerService ms;

    @RequestMapping(value = "toLogin")
    public String toLogin(HttpServletRequest request, Model model){
        //new AtomicInteger();
        Cookie[] cookies = request.getCookies();
        String mgrId="";
        if(cookies != null){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("mgrName")){
                    try {
                        mgrId = URLDecoder.decode(cookie.getValue(),"utf-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        model.addAttribute("mgrId",mgrId);
        return "login";
    }

    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(Manager manager, String code, HttpSession session, Model model,String remember,HttpServletResponse response){
        String vcode = (String) session.getAttribute("vcode");
        if(!vcode.equalsIgnoreCase(code)){
            return "login";
        }
        System.out.println("管理员："+manager);
        Manager mgr = ms.queryManagerById(manager.getMgrId(), manager.getMgrPwd());
        if(mgr == null){
            return "login";
        }
        model.addAttribute("manager",mgr);
        session.setAttribute("manager",mgr);
        if(remember != null){
            if(remember.equals("true")){
                String name = mgr.getMgrId();
                try {
                    name = java.net.URLEncoder.encode(name,"utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                Cookie c1 = new Cookie("mgrName",name);
                response.addCookie(c1);
            }
        }
        return "main";
    }

    @RequestMapping(value="/createVcode")
    public String createVcode(HttpServletResponse response, Model model,HttpSession session) throws IOException {
        CreateValidateCode cvc = new CreateValidateCode(150, 70, 4);
        String vcode = cvc.getCode();
        model.addAttribute("vcode", vcode);
        session.setAttribute("vcode", vcode);
        System.out.println(vcode);
        cvc.write(response.getOutputStream());
        return null;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("manager");
        return "login";
    }
}
