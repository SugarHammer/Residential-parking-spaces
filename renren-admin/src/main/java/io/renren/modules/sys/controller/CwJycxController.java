package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.CwJycx;
import io.renren.modules.sys.service.CwJycxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping("/sys/cwJycx")
public class CwJycxController extends AbstractController {
	@Autowired
	private CwJycxService cwJycxService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = cwJycxService.queryPage(params);
		return R.ok().put("page", page);
	}
	


	@RequestMapping("/save")
	public R save(@RequestBody CwJycx cwJycx){
		cwJycxService.save(cwJycx);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R update(@RequestBody CwJycx cwJycx){
		cwJycxService.updateById(cwJycx);
		return R.ok();
	}

	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CwJycx cwJycx = cwJycxService.getById(id);
		return R.ok().put("cwJycx", cwJycx);
	}
	
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] userIds){
		cwJycxService.removeByIds(Arrays.asList(userIds));
		return R.ok();
	}
}
