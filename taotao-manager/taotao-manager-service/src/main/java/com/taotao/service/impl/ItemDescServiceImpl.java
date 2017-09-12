package com.taotao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemDescMapper;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemDescExample;
import com.taotao.pojo.TbItemDescExample.Criteria;
import com.taotao.service.ItemDescService;

@Service
public class ItemDescServiceImpl implements ItemDescService{

	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	
	public TbItemDesc queryById(long item_id){
		TbItemDesc desc=tbItemDescMapper.selectByPrimaryKey(item_id);
		return desc;
	}
}
