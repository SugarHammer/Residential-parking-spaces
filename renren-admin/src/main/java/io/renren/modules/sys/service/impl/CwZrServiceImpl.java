package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.CwJycxDao;
import io.renren.modules.sys.dao.CwZrDao;
import io.renren.modules.sys.entity.CwJycx;
import io.renren.modules.sys.entity.CwZr;
import io.renren.modules.sys.service.CwJycxService;
import io.renren.modules.sys.service.CwZrService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cwZrService")
public class CwZrServiceImpl extends ServiceImpl<CwZrDao, CwZr> implements CwZrService {


	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		String cwInfo = (String)params.get("cwInfo");
		IPage<CwZr> page = this.page(
				new Query<CwZr>().getPage(params),
				new QueryWrapper<CwZr>()
						.like(StringUtils.isNotBlank(cwInfo),"cw_info", cwInfo)
		);
		return new PageUtils(page);
	}



}
