package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Log;
import com.csh.cmfz.entity.Manager;
import com.csh.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

/**
 * @Description 额外功能
 * @Author 程少华
 * @Date 2018/7/9 19:11
 **/
@Aspect
public class LogListener {
    @Autowired
    private LogService logService;
    /**
     * 在controller层调用service的这些的方法之间  建立的切点
     * 一旦调用就触发
     */
    @Pointcut("execution(* com.csh.cmfz.service.impl.*.modify*(..)) || execution(* com.csh.cmfz.service.impl.*.remove*(..)) || execution(* com.csh.cmfz.service.impl.*.add*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        Log log = new Log();
        String id = UUID.randomUUID().toString().replace("-","");
        log.setLogId(id);
        log.setTime(new Date());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Manager mgr = (Manager) request.getSession().getAttribute("manager");
        log.setManagerName(mgr.getMgrName());

        //获得方法对象  得到方法名 判断是什么操作
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        String name = method.getName();
        if(name.startsWith("add")){
            log.setAction("新增");
        }else if(name.startsWith("modify")){
            log.setAction("修改");
        }else if(name.startsWith("remove")){
            log.setAction("删除");
        }
        //获得方法参数
        Object[] args = pjp.getArgs();
        String message = "";
        for (Object object : args) {
            System.out.println(object);
            message = message + object;
        }
        log.setMessage(message);
        //获得类名
        String name1 = pjp.getTarget().getClass().getName();
        String resource=name1.replace("ServiceImpl","").replace("com.qyg.cmfz.service.impl.","");
        log.setResource(resource);
        //调用传递
        Object obj = null;
        try {
           obj = pjp.proceed();
           log.setResult("success");
        } catch (Throwable throwable) {
            log.setResult("fail");
            throwable.printStackTrace();
        }
        logService.augmentLog(log);
        return obj;
    }
}
