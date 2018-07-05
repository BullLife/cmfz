package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Picture;
import com.csh.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/5 18:02
 **/
@Controller
@RequestMapping("/pic")
public class PictureController {
    @Autowired
    private PictureService ps;

    @RequestMapping("/getpictures")
    public @ResponseBody Map<String,Object> getPictures(Integer page, Integer rows){
        List<Picture> pictures = ps.queryAllPicturesByPage((page - 1) * rows + 1, page * rows);
        Integer count = ps.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",pictures);
        return map;
    }

    @RequestMapping("/upload")
    public @ResponseBody String upload(MultipartFile myFile, HttpSession session,Picture picture) throws IOException {
        String message = "";
        ServletContext sc =  session.getServletContext();
        String path = sc.getRealPath("Pictures");

        String fileName = myFile.getOriginalFilename();
        String suffix = fileName.substring( fileName.lastIndexOf(".") );
        String newName = UUID.randomUUID().toString().replace("-", "");

        picture.setPictureId(newName);
        picture.setPicturePath(path);
        picture.setPictureName(newName);
        picture.setPictureDate(new Date());
        System.out.println("要插入的数据为："+picture);
        Integer integer = ps.addPicture(picture);
        System.out.println("受影响的行数为：  "+integer);
        if(integer>0){
            myFile.transferTo(new File(path+"/"+newName+suffix));
            message = "successful";
        }else{
            message = "filed";
        }
        // return "redirect:/pic/getpictures.do";
        return message;
    }
}
