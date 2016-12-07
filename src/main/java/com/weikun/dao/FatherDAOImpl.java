package com.weikun.dao;

import com.weikun.po.Father2;
import com.weikun.po.Son2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2016/12/7.
 */
public class FatherDAOImpl {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContextHibernate.xml");


        FatherDAOImpl dao=(FatherDAOImpl)ctx.getBean("fdao");

        dao.add();


    }
    public void add(){
        Session session=this.sessionFactory.openSession();
        Father2 father=new Father2();
        father.setFname("¹þ¶û±õ");
        father.setFid(2);

        Son2 s1=new Son2();
        s1.setSid(10);
        s1.setSname("ºÚ");
        s1.setFather(father);
        Son2 s2=new Son2();
        s2.setSid(11);
        s2.setSname("Áú");
        s2.setFather(father);
        Son2 s3=new Son2();
        s3.setSid(12);
        s3.setSname("½­");
        s3.setFather(father);

        father.getSons().add(s1);
        father.getSons().add(s2);
        father.getSons().add(s3);

        session.save(father);

        session.flush();
        session.clear();
        session.close();

    }

}
