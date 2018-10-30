package com.simpletour.entity;

import com.simpletour.collector.BigDecimalCountCollector;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: chenjunzhou
 * @date: 2018/9/12
 */


@Getter
@Setter
@ToString
@Alias("User")
public class User {

    private int id;
    private String name;

    private List<Order> orderList;

    public BigDecimal getTotalPrice() {
        return orderList.stream().map(Order::getPrice).collect(new BigDecimalCountCollector(5));
    }

}
