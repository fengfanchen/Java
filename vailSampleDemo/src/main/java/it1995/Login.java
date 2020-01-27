package it1995;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login")
public class Login extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //1. 得到数据
        String inCode = request.getParameter("inCode").toString().toLowerCase();
        String valiCode = request.getSession().getAttribute("valiCode").toString().toLowerCase();

        //2. 验证是否正确
        if(inCode.equals(valiCode)){

            response.sendRedirect("success.jsp");
        }
        else{

            request.getSession().setAttribute("err", "验证码输入错误，请重新输入！");
            String url = request.getHeader("Referer");
            response.sendRedirect(url);
        }
    }
}
