package com.qkainan;


import com.qkainan.dao.userDao;
import com.qkainan.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Demo {
    public static void main( String[] args ) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //传入对应配置文件的输入流，读取配置文件获取SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过SqlSessionFactory获取SqlSession对象(理解为一个数据库连接)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取userDao实现类对象(Mapper)
        userDao userDao = sqlSession.getMapper(userDao.class);

        //提交事务
        sqlSession.commit();
        //释放资源
        sqlSession.close();
    }
}

