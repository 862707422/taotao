package com.taotao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.pojo.TbItemCat;
import com.taotao.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatServiceImpl;
	
	@RequestMapping("/list")
	@ResponseBody
	public List categoryList(@RequestParam(value="id", defaultValue="0") Long parentId) throws Exception {
		List catList = new ArrayList();
		List<TbItemCat> list=itemCatServiceImpl.getItemCatList(parentId);
		for(TbItemCat tbItemCat:list){
			Map map=new HashMap<>();
			map.put("id", tbItemCat.getId());
			map.put("text", tbItemCat.getName());
			map.put("state", tbItemCat.getIsParent()?"closed":"open");
			catList.add(map);
		}
		return catList;
	}
}
