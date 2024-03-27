package com.example.better.controller;

import com.example.better.BetterApplication;
import com.example.better.entity.Goods;
import com.example.better.mapper.GoodsMapper;
import com.example.better.service.SearchSevice;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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


	//private String filePath="D:\\phpstudy_pro\\WWW\\uet\\goodsimage";//图片本地地址
	private String filePath=BetterApplication.GlobalV.APP_FILE_URL+"goodsimage/";//图片本地地址linux

	@PostMapping(value = "/goodsimage")//插入商品图片
	public Integer upGoodsimage(@RequestParam("file") MultipartFile upload, @RequestParam("uid") Integer uid,@RequestParam("uskey") String uskey) {
		//用于测试是否能正常接收参数System.out.println(uskey+"iii"+uid);
		//判断Post行为是否合法
			//判断文件夹是否存在,不存在则创建
			File file = new File(filePath);

			if (!file.exists()) {
				file.mkdirs();
			}

			String originalFileName = upload.getOriginalFilename();//获取原始图片的扩展名
			String newFileName = UUID.randomUUID() + originalFileName;
			//String newFilePath = filePath + "\\" + newFileName; //新文件的路径
			String newFilePath = filePath  + newFileName; //新文件的路径linux

			try {
				//String goodsimageUrl = "http://192.168.0.169/uet/goodsimage/" + newFileName;//图片数据库网络地址
				String goodsimageUrl = BetterApplication.GlobalV.APP_URL+"goodsimage/" + newFileName;//图片数据库网络地址
				goodsMapper1.AddGoodsImage(goodsimageUrl,uid);
				System.out.println("插入成功");
				upload.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
				System.out.println("上传商品图片成功");
				return goodsMapper1.SelectGid(goodsimageUrl);
				//return newFileName;
			}catch (IllegalStateException e ) {
				//处理异常
			}catch (IOException e1){
				//处理异常
			}
			return 1;

	}




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
}
