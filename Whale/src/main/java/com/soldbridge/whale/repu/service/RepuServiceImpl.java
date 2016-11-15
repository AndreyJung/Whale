package com.soldbridge.whale.repu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.soldbridge.whale.repu.dao.RepuDAO;

@Service("repuService")
public class RepuServiceImpl implements RepuService{
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="repuDAO")
	private RepuDAO repuDAO;
	
	@Override
	public List<Map<String, Object>> selectRepuTotItem(Map<String, Object> map) throws Exception{
		return repuDAO.selectRepuTotItem(map);
	}
	
	
	//평판항목 저장하기 
	@Override
	public Map<String,Object> saveRepu(Map<String, Object> map) throws Exception{
		
		//리턴할 결과 저장하는 MAP
		Map<String, Object> result_IOS = new HashMap<String, Object>();
		
		//평판항목 기준 정보 전체 가지고 오기 
		List<Map<String, Object>> result_whale_repu_mst = repuDAO.selectRepuTypeInfo();
		
		//평판 이력 테이블 데이터 조회 
		Map<String, Object> resultMap = repuDAO.selectRepuItemChk(map);
		int res_chk = Integer.parseInt(resultMap.get("result_cnt").toString());
		log.info(res_chk);
		
		
		//기존에 평판 정보가 저장이 되어 있는 경우, 평판 정보 update 
		if(res_chk == 5) {
			log.info("res_chk => 5");
			for(int i=1; i<=5; i++)
			{
				Map<String, Object> map1 = new HashMap<String, Object>();
				String repu_type_cd = ("0"+i).toString();
				map1.put("repu_type_cd", repu_type_cd);
				map1.put("repu_star_cnt", map.get("repu_type_cd_0"+i).toString());
				map1.put("to_user_id", map.get("to_user_id").toString());
				map1.put("from_user_id", map.get("from_user_id").toString());
				log.info(map1);
				repuDAO.updateRepuItem(map1);
			}
		}
		//기존에 평판 정보가 저장이 되어 있지 않은 경우, 평판 정보 처음 insert
		else if (res_chk == 0) {
			log.info("res_chk => 0");
		
			for(int i=1; i<=5; i++)
			{
				Map<String, Object> map2 = new HashMap<String, Object>();
				String repu_type_cd = ("0"+i).toString();
				map2.put("repu_type_cd", repu_type_cd);
				map2.put("repu_star_cnt", map.get("repu_type_cd_0"+i).toString());
				map2.put("repu_type_nm", result_whale_repu_mst.get(i-1).get("repu_type_nm").toString());
				map2.put("to_user_id", map.get("to_user_id").toString());
				map2.put("from_user_id", map.get("from_user_id").toString());
				log.info(map2);
				repuDAO.insertRepuItem(map2);
			}
		} 
		//데이터 문제 발생 
		else {
			log.info("평판 저장하기 데이터 문제 발생 확인 필요 ");
		}
		
		//평판 전체 합 테이블 데이터 조회 
		Map<String, Object> resultMap2 = repuDAO.selectRepuTotItemChk(map);
		int res_tot_chk = Integer.parseInt(resultMap2.get("result_tot_cnt").toString());
		log.info(res_tot_chk);
		
		//기존에 평판 합계 정보가 있으면 평판 합계 정보 update
		if(res_tot_chk == 5){
			log.info("res_tot_chk : "+res_tot_chk);
			
			//평가 항목 코드 수 만큼 루프문을 돌림
			for(int i=1;i<=5;i++){
				//DAO에 들어갈 파라미터 객체 생성 
				Map<String, Object> map3 = new HashMap<String, Object>();
				String repu_type_cd = ("0"+i).toString();
				String to_user_id = map.get("to_user_id").toString();
				
				map3.put("to_user_id", to_user_id);
				map3.put("repu_type_cd", repu_type_cd);
				
				Map<String, Object> result_repu_star_cnt = repuDAO.selectRepuStartCntByUserAndRepuType(map3);
				Map<String, Object> result_repu_user_cnt = repuDAO.selectRepuFromUserCntByUserAndRepuType(map3);
				
				String avr_star_cnt = result_repu_star_cnt.get("avr_star_cnt").toString();
				String from_user_cnt = result_repu_user_cnt.get("from_user_cnt").toString();
				
				map3.put("avr_star_cnt", avr_star_cnt);
				map3.put("from_user_cnt", from_user_cnt);
				
				repuDAO.updateRepuTotByUserAndRePuType(map3);
				
			}
		}
		
		//기존에 평판 합계 정보가 없으면 평판 합계 정보 insert
		else if(res_tot_chk == 0) {
			log.info("res_tot_chk : "+res_tot_chk);
			
			//평가 항목 코드 수 만큼 루프문을 돌림
			for(int i=1;i<=5;i++){
				//DAO에 들어갈 파라미터 객체 생성 
				Map<String, Object> map3 = new HashMap<String, Object>();
				String repu_type_cd = ("0"+i).toString();
				String repu_type_nm = result_whale_repu_mst.get(i-1).get("repu_type_nm").toString();
				String to_user_id = map.get("to_user_id").toString();				
				
				map3.put("to_user_id", to_user_id);
				map3.put("repu_type_cd", repu_type_cd);
				
				Map<String, Object> result_repu_star_cnt = repuDAO.selectRepuStartCntByUserAndRepuType(map3);
				Map<String, Object> result_repu_user_cnt = repuDAO.selectRepuFromUserCntByUserAndRepuType(map3);
				
				String avr_star_cnt = result_repu_star_cnt.get("avr_star_cnt").toString();
				String from_user_cnt = result_repu_user_cnt.get("from_user_cnt").toString();
				
				map3.put("repu_type_nm", repu_type_nm);
				map3.put("avr_star_cnt", avr_star_cnt);
				map3.put("from_user_cnt", from_user_cnt);
				
				repuDAO.insertRepuTotByUserAndRepuType(map3);
				
			}
		}
		
		//평판 합계 데이터 문제 발생 
		else {
			log.info("평판 저장하기 데이터 문제 발생 확인 필요 ");
		}
		
		result_IOS.put("result", "success");
		
		return result_IOS;
	}
	
}
