package com.example.jsp5.servlet;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import jakarta.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    private static final String SAVE_DIR="\"C:\\Users\\seto\\IdeaProjects\\jsp5\\upload\"";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (ServletFileUpload.isMultipartContent((RequestContext) req)) {//如果是文件上传的请求
            DiskFileItemFactory factory=new DiskFileItemFactory();//创建一个磁盘文件项工程
            factory.setDefaultCharset("UTF-8");
            factory.setRepository(new File("java.io.tmpdir"));//设置临时文件存储位置
            factory.setSizeThreshold(4096*1024);//设置每个文件项最大为4096，超过这个就使用临时文件存储内容
            ServletFileUpload upload=new ServletFileUpload(factory);//创建文件上传的对象
            upload.setFileSizeMax(5*1024*1024);//设置每一个上传文件的大小为5m
            upload.setSizeMax(50*1024*1024);//设置总大小为50m
            upload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> fileItems=upload.parseRequest((RequestContext) req);//开始解析请求得到文件项
                for(FileItem fileItem:fileItems){//判断是否是普通的表单字段
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getName()+"=>"+fileItem.toString());
                    }else {//走这里说明是上传的文件
                        File dir=new File(SAVE_DIR);
                        if(!dir.exists())
                            dir.mkdirs();
                        //创建保存的文件
                        File saveFile=new File(dir,fileItem.getName());
                        InputStream is=fileItem.getInputStream();//获取上传文件的输入流
                        OutputStream os=new FileOutputStream(saveFile);
                        IOUtils.copy(is,os);//将输入流的拷贝到输出流流中1这个就是文件保存
                        IOUtils.closeQuietly(is);//关闭流
                        IOUtils.closeQuietly(os);
                    }
                }

                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().print("上传成功");


            } catch (FileUploadException e) {
                e.  printStackTrace();
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().print("上传失败");
            }

        }else {
            throw new RuntimeException("请求头中为发现multipart/form-data");
        }
    }
}
