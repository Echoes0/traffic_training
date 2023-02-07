package servlet.one.page;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import database.access.Database_connect;
import the.object.name.Request;
import the.object.name.TrainPlan;
import the.object.name.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/FindTrainPlan")
public class FindTrainPlan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String content=req.getParameter("content");
        String institution=req.getParameter("institution");
        resp.setContentType("text/html;charset=utf-8");
        JSONObject jsonObject=new JSONObject();
        List<TrainPlan> trainPlans=Database_connect.findTrainPlan(content,institution);
        jsonObject.put("trainPlan",trainPlans);
        PrintWriter pw=resp.getWriter();
        pw.print(jsonObject);
        pw.close();
    }



}
