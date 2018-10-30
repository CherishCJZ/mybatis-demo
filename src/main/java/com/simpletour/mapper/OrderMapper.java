package com.simpletour.mapper;

import com.simpletour.entity.Order;

public interface OrderMapper {

    Order findByUid(long uid);
}
