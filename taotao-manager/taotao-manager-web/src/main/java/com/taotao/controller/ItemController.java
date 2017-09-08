package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taoato.commom.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemServiceImpl;
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult  getTbItemList(Integer page, Integer rows){
		return itemServiceImpl.getItemList(page, rows);
	}

}
