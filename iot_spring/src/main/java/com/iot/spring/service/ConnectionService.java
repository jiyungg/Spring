package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.ConnectionInfoVO;

public interface ConnectionService {
	ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci);
	List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci);
	void insertConnectionInfo(Map<String,Object> rMap,ConnectionInfoVO ci);
}
