package com.example.better.controller;

import com.example.better.BetterApplication;
import com.example.better.entity.Goods;
import com.example.better.mapper.GoodsMapper;
import com.example.better.service.SearchSevice;
import com.example.better.utils.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;



@CrossOrigin
@RestController
@RequestMapping("/uet")
public class GoodsController {
	
	//1.商品信息录入
	
	//1.1商品照片录入

	@Autowired
	SearchSevice ss;

	@Resource
	@Autowired
	private GoodsMapper goodsMapper1;

	//2.用户商品浏览
	@GetMapping("/goods")
	public List<Goods> SelGoods()
	{
     return goodsMapper1.SelGoods();
	}


	//用户个人商品查询 用户发布了啥

	//查询已经购买到的商品

	/*
	@PostMapping("/mygoods")
	public List<Goods> MyGoods(@RequestBody Receive gods)
	{
		if(bm.UserGrant(gods.getUid(),gods.getUskey())){
			return goodsMapper1.SelMyGoods(gods.getUid());
		}else{
			return null;
		}
	}
	*/


	@GetMapping("sergj")
	public List<Goods> SGj(@RequestParam("gmname") String name){
		return ss.SearchGoodsJ(name);
	}

	//Security测试类
	@GetMapping("hello")
	public String HelloSec(@RequestParam("username") String uname,@RequestParam("password") String upass){
		if(Objects.isNull(goodsMapper1.SelUserName(upass,uname))){
			return "没有";
		}else {
			return "有";
		}
	}


	@GetMapping("jwt")
	public String Rtl(@RequestParam("token") String name){
		return (String) JwtUtil.parsePayload(name).get("userid");
	}



}
