package com.example.better.service;

import com.example.better.entity.Goods;

import java.io.Serializable;
import java.util.List;

public interface SearchSevice  {
    List<Goods> SearchGoodsJ(String GNdetail);
}
