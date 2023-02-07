package servlet.two.page;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import database.access.DatabaseOwner;
import the.object.name.Organization;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/findOrganization")
public class findOrganization extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String num=req.getParameter("num");
        resp.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject=new JSONObject();
        Organization organizations= DatabaseOwner.findOrganization(num);
        jsonObject.put("organization",organizations);
        PrintWriter pw=resp.getWriter();
        pw.print(jsonObject);
        pw.close();
    }



}
