package com.simpletour.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;

/**
 * @author: chenjunzhou
 * @date: 2018/10/29
 */

@Setter
@Getter
@NoArgsConstructor
@ToString
@Alias("Item")
public class Item {

    private long id;

    private String name;

    private BigDecimal price;
}
