package com.simpletour.entity;

import com.simpletour.collector.BigDecimalCountCollector;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: chenjunzhou
 * @date: 2018/10/29
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
@Alias("Order")
public class Order {

    private long id;

    private String name;

    private User user;

    private List<Item> itemList;

    public BigDecimal getPrice() {
        return itemList.stream().map(Item::getPrice).collect(new BigDecimalCountCollector(5));
    }

}
