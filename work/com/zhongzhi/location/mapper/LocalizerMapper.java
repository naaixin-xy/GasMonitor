package com.zhongzhi.location.mapper;

import java.util.List;

import com.zhongzhi.location.pojo.Localizer;
import com.zhongzhi.location.pojo.LocalizerQueryParam;
import com.zhongzhi.location.pojo.Member;

public interface LocalizerMapper {
	public List<Localizer> localizerQuery(Localizer local);
	public int getLocalizerCount(LocalizerQueryParam queryParam);
	public List<Localizer> localizerQueryByPage(LocalizerQueryParam queryParam);
	public int localizerAdd(Localizer local);
	public int localizerUpdate(Localizer localizer);
	public int localizerDelete(int id);
	public int localizerDeleteBatch(List<Integer> ids);
}

