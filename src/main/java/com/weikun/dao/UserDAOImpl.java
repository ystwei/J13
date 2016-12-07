package com.weikun.dao;

import com.weikun.vo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/7.
 */
public class UserDAOImpl extends JdbcDaoSupport implements IUserDAO {
    private  IUserDAO dao;



    @Test
    public void test(){
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        dao=(UserDAOImpl)ctx.getBean("dao");
        dao.queryAll();
    }
    public void update() {
        this.getJdbcTemplate().update("update user set username=? ,password=? where id=?","¹þ¶û±õ","999",1391);

    }

    public void queryAll() {
        List<Map<String, Object>> list=
        this.getJdbcTemplate().queryForList("select * from user");

        Iterator<Map<String, Object>> it=list.iterator();
        while(it.hasNext()){
            Map<String, Object> map=it.next();
            System.out.println(map.get("username").toString()+map.get("password"));

        }
    }

    public void queryById() {
        List<User> list=this.getJdbcTemplate().query("select * from user where username like ?",
                new Object[]{"%Îä%"},new RowMapper<User>(){

                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user=new User();
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        return user;
                    }
                });

        for(User user :list){
            System.out.println(user.getUsername()+"--"+user.getPassword());
        }
    }

    public void del() {
        this.getJdbcTemplate().update("delete from user where id=?", new PreparedStatementSetter() {
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1,1392);
            }
        });

    }
    @Test
    public void add() {
       System.out.println(this.getJdbcTemplate().
                update("insert into user (username,password) values(?,?)",
                        new Object[]{"¹þ¶û±õ","1207"},
                        new int[]{Types.VARCHAR,Types.VARCHAR})>0?"true":"false");


    }
}
