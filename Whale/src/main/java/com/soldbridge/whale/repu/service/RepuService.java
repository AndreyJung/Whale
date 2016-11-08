package com.soldbridge.whale.repu.service;

import java.util.List;
import java.util.Map;

public interface RepuService {
	List<Map<String, Object>> selectRepuItem(Map<String, Object> commandMap) throws Exception;
}
