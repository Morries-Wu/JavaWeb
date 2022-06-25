package Com.Servlet;

import Com.Bean.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数

        //发sql语句查询学生的信息
        //使用for循环生成查询到的数据做模拟
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int t = i + 1;
            studentList.add(new Student(t, "name" + t, 18 + t, "phone" + t));
        }
        //保存查询到的结果(学生信息)到request域中
        request.setAttribute("stuList", studentList);
        //请求转发到showStudent.jsp页面
        request.getRequestDispatcher("/JSP/showStudent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
