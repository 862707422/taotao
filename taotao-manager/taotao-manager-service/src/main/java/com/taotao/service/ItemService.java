package com.taotao.service;

import com.taoato.commom.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getTbItemById(Long id);
	EUDataGridResult getItemList(int page, int rows);
}
