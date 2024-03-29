package com.example.better.mapper;

import com.example.better.entity.Goods;
import com.example.better.entity.User;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface GoodsMapper {
	//@Update("UPDATE u_gooods SET avator=#{avator} WHERE uid=#{uid}")
	//void ChangeGoods(String avator,Integer uid);
	@Select("SELECT * FROM u_goods")
	List<Goods> SelGoods();


	//根据关键字查询商品
	@Select("SELECT * FROM `u_goods` WHERE gname LIKE concat('%',#{GNdetail},'%')")
	List<Goods> SelGoodsJ(String GNdetail);

	//登陆
	@Select("SELECT username FROM u_user WHERE password = #{password} AND username=#{username}")
	String SelUserName(String password,String username);


    //查用户名
	@Select("SELECT uid,username,password,tel,major,uskey FROM u_user WHERE username=#{username}")
	User SelUser(String username);

	//用id查用户名
	@Select("SELECT uid,username,password,tel,major,uskey FROM u_user WHERE uid=#{id}")
	User SelUserById(Integer id);


	@Select("SELECT username FROM u_user WHERE  username=#{username}")
	User SelUser1(String username);

}
