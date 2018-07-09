package com.csh.cmfz.controller;

import com.csh.cmfz.entity.Article;
import com.csh.cmfz.entity.Guru;
import com.csh.cmfz.entity.RichTextResult;
import com.csh.cmfz.service.ArticleService;
import com.csh.cmfz.service.GuruService;
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
import java.util.*;

/**
 * @Description 文章管理
 * @Author 程少华
 * @Date 2018/7/8 17:44
 **/
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private GuruService guruService;
    private List<String> fileNames = new ArrayList<String >();

    /**
     * 富文本框上传照片
     * @param files 多张照片
     * @param request
     * @return 回显上传的照片
     * @throws IOException
     */
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

    /**
     * 文章创建
     * @param article
     * @return
     */
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
       /* System.out.println(article.getGuruId());
        Guru guru = guruService.queryGuruById(article.getGuruId());
        article.setGuruName(guru.getGuruName());*/
        Integer integer = articleService.addArticle(article);
        if(integer>0){
            message = "successful";
        }
        return message;
    }

    /**
     * 获取所有文章信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getallarticles")
    public @ResponseBody Map<String,Object> getAllArticles(Integer page, Integer rows){
        List<Article> articles = articleService.queryAllArticlesOnPage((page - 1) * rows, rows);
        Integer count = articleService.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",articles);
        return map;
    }

    /**
     * 时时更新选择的文章信息
     * @param id
     * @return
     */
    @RequestMapping("/getarticle")
    public @ResponseBody Article getArticleById(String id){
        Article article = articleService.queryArticleById(id);
        return article;
    }

    @RequestMapping("/updatearticle")
    public @ResponseBody String updateArticle(Article article){
        String message = "";
        return message;
    }
}
