package com.example.better;

//import org.mybatis.spring.annotation.MapperScan;
import com.example.better.utils.JwtUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;
//import com.example.better.service.Poster;



@SpringBootApplication
public class BetterApplication {
	public static void main(String[] args) {

		SpringApplication.run(BetterApplication.class, args);
		//System.out.println(DigestUtils.md5Hex("12312"));
		//Poster p=new Poster();
		//p.CreateIssueBalanceDetail();
		/*

		BCryptPasswordEncoder bcpe=new BCryptPasswordEncoder();
		System.out.println(bcpe.encode("123456"));
		123456密码：$2a$10$hnZ2s75LhaP8zad3FCS.B.sFIULq689ji2YoWdsdxcdE4IHBy9QJe

		*/
		/*
		System.out.println(JwtUtil.genAccessToken("Wongy"));
		System.out.println(JwtUtil.parsePayload("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyaWQiOiJXb25neSIsImp0aSI6IjAyNTM0MGIwLTZhNzItNGQ2ZS1hYmRlLWRlNWY4MGEwOWJkNCIsImV4cCI6MTcxMTk3MDk4NywiaWF0IjoxNzExNjEwOTg3LCJzdWIiOiJQZXJpcGhlcmFscyIsImlzcyI6IlRpYW0ifQ.IVZL8V_gKIiFU5rRwAPLPDiyhULrsJt3S1i3ylMW0E8").get("userid"));
		这里解决了Jwt的问题，生成了工具类并正常解析
		 */


	}
	//定义全局变量URL
	@Component
	public class GlobalV {
		//写入数据库的访问地址
		public static final String APP_URL = "https://www.xrcdx.com/uet/";
		//文件实际存储地址
		public static final String APP_FILE_URL = "/var/www/xrcdx/uet/";
	}
	
}

