package com.yunheng.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunheng.Entity.vo.MessageModel;
import com.yunheng.Service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//要有索引
@WebServlet("/admin_login")
public class AdminServlet extends HttpServlet {
    //实例化AdminServ对象
    private AdminService adminService=new AdminService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        //String adid = req.getParameter("adid");
       // String adpwd = req.getParameter("adpwd");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(req.getInputStream());

        String adid = jsonNode.get("adid").asText();
        String adpwd = jsonNode.get("adpwd").asText();


        MessageModel messageModel = adminService.adminlogin(adid, adpwd);

        if (messageModel.getCode() == 1) {
            //成功
            ObjectMapper mapper1 = new ObjectMapper();
            String jsonMessage = mapper1.writeValueAsString(messageModel);

            resp.getWriter().write(jsonMessage);
        } else {
            ObjectMapper mapper1 = new ObjectMapper();
            String jsonMessage = mapper1.writeValueAsString(messageModel);

            resp.getWriter().write(jsonMessage);
        }
    }
}
