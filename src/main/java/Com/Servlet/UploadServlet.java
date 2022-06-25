package Com.Servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、先判断上传的数据是否是多段数据(只要是多端的数据,才是文件上传的)
        if (ServletFileUpload.isMultipartContent(request)) {
            //创建FileItemFactory工厂实现类
            FileItemFactory fileInteFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类 ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileInteFactory);
            try {
                //解析上传数据,得到每一个表单项FileItem
                List<FileItem> list = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : list) {

                    if (fileItem.isFormField()) {
                        //普通表单项
                        System.out.println("表单项的name属性值:" + fileItem.getFieldName());
                        //参数UTF-8解决乱码问题
                        System.out.println("表单项的value属性值:" + fileItem.getString("UTF-8"));
                    } else {
                        //上传文件
                        System.out.println("表单项的name属性值:" + fileItem.getFieldName());
                        System.out.println("上传的文件名:" + fileItem.getName());
                        fileItem.write(new File("D:\\" + fileItem.getName()));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }
}
