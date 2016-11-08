package com.soldbridge.whale.repu.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.soldbridge.whale.common.dao.AbstractDAO;

@Repository("repuDAO")
public class RepuDAO extends AbstractDAO{
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectRepuItem(Map<String, Object> map) {
		return (List<Map<String, Object>>)selectList("selectRepuItem", map);
	}
}
