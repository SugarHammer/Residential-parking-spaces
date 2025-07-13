package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.CwInform;
import io.renren.modules.sys.service.CwInformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sys/cwInform")
public class CwInformController extends AbstractController {
	@Autowired
	private CwInformService cwInformService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = cwInformService.queryPage(params);
		return R.ok().put("page", page);
	}
	


	@RequestMapping("/save")
	public R save(@RequestBody CwInform cwInform){
		cwInform.setCreateTime(new Date());
        cwInform.setUsername(getUser().getUsername());
		cwInformService.save(cwInform);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R update(@RequestBody CwInform cwInform){
		cwInformService.updateById(cwInform);
		return R.ok();
	}

	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CwInform cwInform = cwInformService.getById(id);
		return R.ok().put("cwInform", cwInform);
	}
	
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] userIds){
		cwInformService.removeByIds(Arrays.asList(userIds));
		return R.ok();
	}
}
