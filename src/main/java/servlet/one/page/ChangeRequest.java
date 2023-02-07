package servlet.one.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import database.access.Database_connect;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/ChangeParameter")
public class ChangRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        JSONObject jsonObject=new JSONObject();
        String name=req.getParameter("name");
        String or_name=req.getParameter("or_name");
        String answer=req.getParameter("answer");
        resp.setContentType("text/html;charset=utf-8");
        try {
            jsonObject.put("reason", Database_connect.changeParameter(name, or_name,answer));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter pw=resp.getWriter();
        pw.print(jsonObject);
        pw.close();
    }



}
