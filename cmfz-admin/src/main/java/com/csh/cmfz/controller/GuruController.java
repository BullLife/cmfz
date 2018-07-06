package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Guru;
import com.csh.cmfz.service.GuruService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/6 16:50
 **/
@Controller
@RequestMapping("/guru")
public class GuruController {
    @Autowired
    private GuruService gs;

    @RequestMapping("/getallgurus")
    public @ResponseBody Map<String,Object> getAllGurus(Integer page, Integer rows){
        List<Guru> gurus = gs.queryGurusOnPage((page - 1) * rows, rows);
        int size = gs.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }

    @RequestMapping(value = "/queryguru",method = RequestMethod.POST)
    public @ResponseBody Guru queryGuru(String guruId){
        Guru guru = gs.queryGuruById(guruId);
        return guru;
    }

    @RequestMapping("/addguru")
    public @ResponseBody String addGuru(MultipartFile myFile, HttpSession session,Guru guru) throws IOException {
        String message = "";
        String newName = UUID.randomUUID().toString().replace("-", "");
        guru.setGuruId(newName);
        if(myFile.isEmpty()){
            message = "successful";
            return message;
        }
        ServletContext sc =  session.getServletContext();
        String path1 = sc.getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload\\guruPic";

        String fileName = myFile.getOriginalFilename();
        String suffix = fileName.substring( fileName.lastIndexOf(".") );

        guru.setGuruPic(path);
        guru.setGuruPicName(newName+suffix);

        Integer integer = gs.addGuru(guru);
        if(integer>0){
            myFile.transferTo(new File(path+"/"+newName+suffix));
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/updateguru")
    public @ResponseBody String updateGuru(Guru guru,MultipartFile myFile)throws IOException{
        String message = "";
        if(!myFile.isEmpty()){
            myFile.transferTo(new File(guru.getGuruPic()+"/"+guru.getGuruPicName()));
        }
        Integer integer = gs.modifyGuru(guru);
        if(integer>0){
            message = "successful";
        }else{
            message = "filed";
        }
        return message;
    }

    @RequestMapping("/querytrim")
    public @ResponseBody Map<String,Object> queryGurusByTrim(Integer page, Integer rows, String trim, HttpServletRequest request) throws UnsupportedEncodingException {
        Guru guru = new Guru();
        String value = new String(request.getParameter("value").getBytes("ISO-8859-1"),"utf-8");
        if(trim.equals("guruName")){
            guru.setGuruName("%"+value+"%");
        }else if(trim.equals("guruSummary")){
            guru.setGuruSummary("%"+value+"%");
        }
        System.out.println(guru);
        List<Guru> gurus = gs.queryGurusByTrim((page - 1) * rows, rows,guru);
        int size = gs.queryCountByTrim(guru);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }
}
