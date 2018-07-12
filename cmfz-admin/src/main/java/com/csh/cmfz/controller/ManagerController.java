package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.ManagerService;
import com.csh.cmfz.util.CreateValidateCode;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    /**
     * 管理员的登录
     * @param code 验证码
     * @param session
     * @param model
     * @param rememberMe 是否要保存账户信息
     * @return
     */
    @RequestMapping(value = "/login",method= RequestMethod.POST)
    public String login(String username,String password, String code, HttpSession session, Model model,boolean rememberMe){
        String vcode = (String) session.getAttribute("vcode");
        if(!vcode.equalsIgnoreCase(code)){
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password,rememberMe));

            System.out.println(subject.hasRole("root")?"是root角色":"不是root角色");
            System.out.println(subject.hasRole("guru:update")?"拥有上师修改权限":"没有上师修改权限");
            Manager mgr = ms.queryManagerByName(username);
            model.addAttribute("manager",mgr);
            session.setAttribute("manager",mgr);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            return "login";
        } catch (IncorrectCredentialsException ice){
            ice.printStackTrace();
            return "error";
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return "main";
    }

    /**
     * 生成验证码
     * @param response
     * @param model
     * @param session
     * @return
     * @throws IOException
     */
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

    /**
     * 管理员用户登出
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("manager");
        return "login";
    }

    /**
     * 去往管理员的登录页面（为了cookie）
     * @param request
     * @param model
     * @return
     */
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

}
