/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.annotation.DataFilter;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.sys.dao.CwInfoDao;
import io.renren.modules.sys.dao.CwInformDao;
import io.renren.modules.sys.entity.CwInfo;
import io.renren.modules.sys.entity.CwInform;
import io.renren.modules.sys.service.CwInfoService;
import io.renren.modules.sys.service.CwInformService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cwInformService")
public class CwInformServiceImpl extends ServiceImpl<CwInformDao, CwInform> implements CwInformService {


	@Override
	@DataFilter(subDept = true, user = false)
	public PageUtils queryPage(Map<String, Object> params) {
		IPage<CwInform> page = this.page(
			new Query<CwInform>().getPage(params),
			new QueryWrapper<>()
		);
		return new PageUtils(page);
	}



}
