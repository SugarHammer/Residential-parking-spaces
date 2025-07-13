/**
 * .
 *
 *
 *
 *
 */

package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.CwInfo;
import io.renren.modules.sys.entity.CwSell;

import java.util.Map;


public interface CwSellService extends IService<CwSell> {

	PageUtils queryPage(Map<String, Object> params);
	
}
