package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemDescService;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemServiceImpl;
	@Autowired
	private ItemDescService itemDescServiceImpl;
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult  getTbItemList(Integer page, Integer rows){
		return itemServiceImpl.getItemList(page, rows);
	}
	@RequestMapping("/save")
	@ResponseBody
		public TaotaoResult saveItem(TbItem item, String desc) throws Exception {
			//添加商品信息
		itemServiceImpl.saveItem(item, desc, null);
			return TaotaoResult.ok();
		}
	@RequestMapping("/desc/query/{item_id}")
	@ResponseBody
	public TaotaoResult queryDescById(@PathVariable long item_id) throws Exception {
		TaotaoResult result=new TaotaoResult();
		TbItemDesc desc=itemDescServiceImpl.queryById(item_id);
		if(desc!=null){
			result.setStatus(200);
			result.setMsg("OK");
			result.setData(desc);
		}
		return result;
	}
	@RequestMapping("/update")
	@ResponseBody
	public TaotaoResult update(TbItem item, String desc) throws Exception {
		itemServiceImpl.updateItem(item, desc, null);
		return TaotaoResult.ok();
	}


}
