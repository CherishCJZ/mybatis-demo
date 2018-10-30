package com.simpletour;

import com.simpletour.entity.User;
import com.simpletour.mapper.UserMapper;
import com.simpletour.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

public class MyBatisDemo {

    public static void main(String[] args) {

        SqlSession session = DBUtils.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.findById(1);
        System.out.println(user.getOrderList().get(0).getPrice());


    }
}
