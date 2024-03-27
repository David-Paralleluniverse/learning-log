package com.example.better.entity;

import lombok.Data;



/*
 *ClassName:Goods
 *Package:com.example.better.entity
 *Description:
 *@Auther:XUPT-李白
 *@TIME:2023/4/2-15:45
 *@version：v1.0
 */
@Data
public class Goods {
	private Integer gid;
	private String gimage;
	private String gsum;
	private Integer gnum;
	private Double gprize;
	private Integer gsta;

	private Integer uid;
	private String gname;
}
