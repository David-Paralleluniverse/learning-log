package com.example.better;

//import org.mybatis.spring.annotation.MapperScan;
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

