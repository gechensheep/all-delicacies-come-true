package com.yunheng.Util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;



//getsqlsession工具类
public class GetSqlSession {
    public static SqlSession createSqlSession(){
        SqlSessionFactory sqlSessionFactory =null;
        InputStream input =null;
        SqlSession session=null;

        try{
            //获取mybatis环境配置文件
            String resource = "mybatis-config.xml";
            //再以流的方式获取resource
             input= Resources.getResourceAsStream(resource);

            sqlSessionFactory=new SqlSessionFactoryBuilder().build(input);

            session=sqlSessionFactory.openSession();

            return session;
        } catch (IOException e) {
           e.printStackTrace();
            return null;
        }
    }
}
