package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getTbItemById(Long id);
	EUDataGridResult getItemList(int page, int rows);
	void saveItem(TbItem item, String desc, String itemParams) throws Exception;
	void updateItem(TbItem item, String desc, String itemParams) throws Exception;
}
