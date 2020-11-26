package com.zhongzhi.location.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.zhongzhi.location.mapper.LocalizerMapper;
import com.zhongzhi.location.mapper.wrapper.MemberDao;

public class MonitorService {
	@Autowired
	private LocalizerMapper localizerDao;
	@Autowired
	private MemberDao memberDao;
}
