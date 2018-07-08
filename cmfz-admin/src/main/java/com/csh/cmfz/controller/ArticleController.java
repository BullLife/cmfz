package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Article;
import com.csh.cmfz.entity.RichTextResult;
import com.csh.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description TODO
 * @Author 程少华
 * @Date 2018/7/8 17:44
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    private List<String> fileNames = new ArrayList<String >();

    @RequestMapping("/upload")
    @ResponseBody
    public RichTextResult uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request) throws IOException { // MultipartFile[] 代表多文件上传
        RichTextResult result = new RichTextResult();
        List<String> data = new ArrayList<String>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath = realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload\\article";
            if(files != null && files.length != 0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString().replace("-","")+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    // 将上传的文件转存到服务器中存储
                    file.transferTo(new File(uploadPath+"\\"+fileName));

                    // 将上传的图片在服务器的url响应给客户端  图片回显
                    data.add(request.getContextPath()+"/upload/article/"+fileName);
                    fileNames.add(fileName);
                }
            }
            result.setErrno(0);
            result.setData(data);
        } catch (Exception e) {
            result.setErrno(1);
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/addarticle")
    public @ResponseBody String addArticle(Article article){
        String message = "";
        if(article.getArticleStatus() == null){
            article.setArticleStatus("未上架");
        }else if(article.getArticleStatus().equals("on")){
            article.setArticleStatus("上架");
        }
        String id = UUID.randomUUID().toString().replace("-","");
        article.setArticleId(id);
        article.setPublishDate(new Date());
        String articlePic = "";
        for (String datum : fileNames) {
            articlePic = articlePic + datum + ",";
        }
        article.setArticlePic(articlePic);
        Integer integer = articleService.addArticle(article);
        if(integer>0){
            message = "successful";
        }
        return message;
    }
}
