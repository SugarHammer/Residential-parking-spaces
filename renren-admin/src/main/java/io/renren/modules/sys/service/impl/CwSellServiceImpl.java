package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.CwSellDao;
import io.renren.modules.sys.entity.CwSell;
import io.renren.modules.sys.entity.CwZr;
import io.renren.modules.sys.service.CwSellService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cwSellService")
public class CwSellServiceImpl extends ServiceImpl<CwSellDao, CwSell> implements CwSellService {


	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CwSell> page = this.page(
			new Query<CwSell>().getPage(params),
			new QueryWrapper<CwSell>().eq("cw_type",params.get("cwType").toString())
		);
		return new PageUtils(page);
	}

	}


