package Com.Servlet;

import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1、获取要下载的文件名
        String downloadFileName = "oo.jpg";
        //2、读取要下载的文件内容(通过ServletContext对象可以读取)
        ServletContext servletContext = getServletContext();
        //获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/文件传输/file/" + downloadFileName);
        System.out.println(mimeType);
        //3、在回传前,通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        //4、还要告诉客户端收到的数据是用于下载使用(还是使用响应头)
        //Content-Disposiotion响应头,表示收到的数据怎么处理
        //attachment表示附件
        //filename=表示指定下载的文件名 URL编码是把汉字转换成为%xxx%xx的格式
        if (request.getHeader("User-Agent").contains("Firefox")) {
            response.setHeader("Content-Disposition", "attachment;filename==?UTF-8?B" + new BASE64Encoder().encode(downloadFileName.getBytes(StandardCharsets.UTF_8)));
        } else {
            //如果不是火狐,是IE或谷歌,使用URL编码
            response.setHeader("Content-Disposition", "attachment;filename==?UTF-8?B" + URLEncoder.encode(downloadFileName, "UTF-8"));
        }


        InputStream resourceAsStream = servletContext.getResourceAsStream("/文件传输/file/" + downloadFileName);

        //获取响应的输出流
        OutputStream outputStream = response.getOutputStream();
        //5、把下载的文件内容回传给客户端
        //读取输入流中全部的数据,复制给输出流,输出给客户端
        IOUtils.copy(resourceAsStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
