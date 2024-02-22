package com.yunheng.Service;

import com.yunheng.Entity.vo.MessageModel;
import com.yunheng.Mapper.AdminMapper;
import com.yunheng.Util.GetSqlSession;
import com.yunheng.Util.StringUtil;
import com.yunheng.Entity.Admin;
import org.apache.ibatis.session.SqlSession;

public class AdminService {
    public MessageModel adminlogin(String adid, String adpwd) {
        MessageModel messageModel=new MessageModel();


        //回显数据
        Admin a=new Admin();
        a.setId(adid);
        a.setPassword(adpwd);
        messageModel.setObject(a);

        //2.调用dao层查询方法，通过用管理员id查询管理员对象
        SqlSession session= GetSqlSession.createSqlSession();
        AdminMapper adminMapper=session.getMapper(AdminMapper.class);
        Admin admin=adminMapper.queryAdminById(adid);

        if(StringUtil.isEmpty(adid)||StringUtil.isEmpty(adpwd)){
            //将状态码，提示信息，回显数据设置到消息模型对象，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户名和密码不能为空");
            return messageModel;
        }


        //3.判断管理员对象是否为空
        if(admin==null){
            messageModel.setCode(0);
            messageModel.setMsg("用户名不存在");
            return messageModel;
        }



        //4，比较密码
        if(!adpwd.equals(admin.getPassword())){
            messageModel.setCode(0);
            messageModel.setMsg("密码错误");
            return messageModel;
        }

       messageModel.setObject(admin);
        return messageModel;
    }
}
