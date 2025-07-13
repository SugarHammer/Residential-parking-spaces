package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.CwJycxDao;
import io.renren.modules.sys.dao.CwSellDao;
import io.renren.modules.sys.entity.CwJycx;
import io.renren.modules.sys.entity.CwSell;
import io.renren.modules.sys.service.CwJycxService;
import io.renren.modules.sys.service.CwSellService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cwJycxService")
public class CwJycxServiceImpl extends ServiceImpl<CwJycxDao, CwJycx> implements CwJycxService {


	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CwJycx> page = this.page(
			new Query<CwJycx>().getPage(params),
			new QueryWrapper<>()
		);
		return new PageUtils(page);
	}



}
