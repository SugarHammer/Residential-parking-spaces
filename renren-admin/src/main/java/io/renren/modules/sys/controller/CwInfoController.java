package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.CwInfo;
import io.renren.modules.sys.service.CwInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/cwInfo")
public class CwInfoController extends AbstractController {
	@Autowired
	private CwInfoService cwInfoService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = cwInfoService.queryPage(params);
		return R.ok().put("page", page);
	}
	


	@RequestMapping("/save")
	public R save(@RequestBody CwInfo cwInfo){
		cwInfoService.save(cwInfo);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R update(@RequestBody CwInfo cwInfo){
		cwInfoService.updateById(cwInfo);
		return R.ok();
	}

	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CwInfo cwInfo = cwInfoService.getById(id);
		return R.ok().put("cwInfo", cwInfo);
	}
	
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] userIds){
		cwInfoService.removeByIds(Arrays.asList(userIds));
		return R.ok();
	}
}
