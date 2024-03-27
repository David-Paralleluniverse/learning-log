package com.example.better.mapper;

import com.example.better.entity.Goods;
import org.apache.ibatis.annotations.*;


import java.util.List;


@Mapper
public interface GoodsMapper {
	@Insert("INSERT INTO u_goods(gsum,gprize) VALUES(#{gid},#{gsum},#{gprize},#{uid})")
	void AddGoods(String gsum,Double gprize,Integer uid);
	
	@Insert("INSERT INTO u_goods(gimage,uid) VALUES(#{gimage},#{uid})")
	//@SelectKey(statement="call identity()", keyProperty="gid", before=false, resultType=int.class)
	int AddGoodsImage(String gimage,Integer uid);
	
	
	//@Update("UPDATE u_gooods SET avator=#{avator} WHERE uid=#{uid}")
	//void ChangeGoods(String avator,Integer uid);
	@Select("SELECT * FROM u_goods")
	List<Goods> SelGoods();
	@Update("UPDATE u_goods SET gsum=#{gsum},gprize=#{gprize},gname=#{gname},gnum=#{gnum} WHERE gid=#{gid}")
	void UpdateGinfo(String gsum,Double gprize,Integer gid,String gname,Integer gnum);
	@Select("SELECT gid FROM u_goods WHERE gimage=#{gimage}")
	Integer SelectGid(String gimage);

	@Select("SELECT * FROM u_goods WHERE uid=#{uid}")
	List<Goods> SelUserGoods(Integer uid);

	//查询已经购买到的商品
	@Select("SELECT * FROM `u_goods` WHERE gid=any(SELECT gid FROM u_order WHERE buyer=#{uid} AND u_order.gsta=3)")
	List<Goods> SelMyGoods(Integer uid);

	//根据关键字查询商品
	@Select("SELECT * FROM `u_goods` WHERE gname LIKE concat('%',#{GNdetail},'%')")
	List<Goods> SelGoodsJ(String GNdetail);
}
