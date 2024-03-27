package com.example.better.service.serviceImpl;

import com.example.better.entity.Goods;
import com.example.better.mapper.GoodsMapper;
import com.example.better.service.SearchSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchSevice {
    @Autowired GoodsMapper gm;

    @Override
    public List<Goods> SearchGoodsJ(String GNdetail) {
        return gm.SelGoodsJ(GNdetail);
    }
}
