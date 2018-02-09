package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Service
public class ConnectionServiceImpl implements ConnectionService {
	@Autowired
	private ConnectionDAO cdao;
	@Override
	public ConnectionInfoVO getConnectionInfo(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConnectionInfoVO> getConnectionInfoList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertConnectionInfo(Map<String, Object> rMap, ConnectionInfoVO ci) {
		int result = cdao.insertConnectionInfo(ci);
		rMap.put("msg", "저장이 실패하였습니다.");
		if(result==1) {
			rMap.put("msg", "저장이 성공하였습니다.");
		}
	}
	
	public List<Map<String,Object>> getDatabaseList(){
		List<Map<String,Object>> dbList = cdao.selectDatabaseList();
		int idx = 0;
		for(Map<String,Object> mDb : dbList) {
			mDb.put("id", ++idx);
			mDb.put("text", mDb.get("Database"));
			mDb.put("items", new Object[] {});
		}
		return dbList;
	}

	@Override
	public List<TableVO> getTableList(String dbName) {
		return cdao.selectTableList(dbName);
	}

}
