package com.csh.cmfz.controller;

import com.alibaba.fastjson.JSON;
import com.csh.cmfz.entity.Guru;
import com.csh.cmfz.service.GuruService;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /**
     * 获取数据库中所有的上师信息
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getallgurus")
    public @ResponseBody Map<String,Object> getAllGurus(Integer page, Integer rows){
        List<Guru> gurus = gs.queryGurusOnPage((page - 1) * rows, rows);
        int size = gs.queryCount();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }

    /**
     * 选中更新的上师信息 在后台时时获取数据
     * @param guruId
     * @return
     */
    @RequestMapping(value = "/queryguru",method = RequestMethod.POST)
    public @ResponseBody Guru queryGuru(String guruId){
        Guru guru = gs.queryGuruById(guruId);
        return guru;
    }

    /**
     * 添加上师信息
     * @param myFile 头像
     * @param session
     * @param guru 上师
     * @return
     * @throws IOException
     */
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

    /**
     * 更新上师信息
     * @param guru
     * @param myFile
     * @return
     * @throws IOException
     */
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

    /**
     * 模糊查找上师信息（分页）
     * @param page dialog传过来的页数
     * @param rows dialog传过来的一页要显示的行数
     * @param trim 模糊查询的条件
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/querytrim")
    public @ResponseBody Map<String,Object> queryGurusByTrim(Integer page, Integer rows, String trim, HttpServletRequest request) throws UnsupportedEncodingException {
        Guru guru = new Guru();

        //前台get传参，汉字重新编码，后台获取参数解码
        String value = new String(request.getParameter("value").getBytes("ISO-8859-1"),"utf-8");
        if(trim.equals("guruName")){
            guru.setGuruName("%"+value+"%");
        }else if(trim.equals("guruSummary")){
            guru.setGuruSummary("%"+value+"%");
        }

        List<Guru> gurus = gs.queryGurusByTrim((page - 1) * rows, rows,guru);
        int size = gs.queryCountByTrim(guru);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",size);
        map.put("rows",gurus);
        return map;
    }

    /**
     * Excel表格的数据导入
     * @param file
     * @param request
     * @throws Exception
     */
    @RequestMapping(value="/importExcel",method = RequestMethod.POST)
    public @ResponseBody String importExcel(MultipartFile file,HttpServletRequest request) throws Exception{
        String message = "";
        if(file.isEmpty()){
            message = "field";
            return message;
        }
        ImportParams params = new ImportParams();
        //表格标题（默认为0） 但是如果设置标题，九设为一
        params.setTitleRows(0);
        //设置表头
        params.setHeadRows(1);
        //是否保存上传的Excel
        params.setNeedSave(true);
        String path1 = request.getSession().getServletContext().getRealPath("");
        int i = path1.lastIndexOf("\\");
        String path3 = path1.substring(0,i);
        String path = path3+"\\upload\\guruPic";

        File f = new File(path+"/excel"+file.getOriginalFilename());
        file.transferTo(f);
        List<Guru> gurus  = ExcelImportUtil.importExcel(f, Guru.class, params);
        /*for (Guru guru : gurus) {
            gs.addGuru(guru);
        }*/
        gs.addSomeGuru(gurus);
        message = "successful";
        return message;
    }

    /**
     * 将所有的上师信息导出成Excel文件
     * @param response
     * @throws IOException
     */
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Guru> gurus = gs.queryGurusOnPage(0, 10000);
        //设置导出表头信息
        ExportParams exportParams = new ExportParams();
        exportParams.setSheetName("上师信息表");
        exportParams.setTitle("c118");
        //导出Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,Guru.class,gurus );

        ServletOutputStream outputStream = response.getOutputStream();
        //文件下载 设置响应头 编码格式：iso-8859-1
        String fileName = new String("上师信息表.xls".getBytes(),"iso-8859-1");

        //设置下响应类型
        response.setContentType("applocation/vnd.ms-excel");
        response.setHeader("content-disposition","attachment;fileName="+fileName);

        //导出文件下载的方式
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * 为文章管理提供上师数据
     * @return
     */
    @RequestMapping("/getAllGurus")
    @ResponseBody
    public List<Guru> getAllGurus(){
        List<Guru> gurus = gs.queryGurusOnPage(0, 1000);
       /* Guru guru = new Guru();
        guru.setGuruId("0");
        guru.setGuruName("暂无");
        guru.setGuruSummary("\"selected\":true");
        gurus.add(guru);*/
        return gurus;
    }
}
