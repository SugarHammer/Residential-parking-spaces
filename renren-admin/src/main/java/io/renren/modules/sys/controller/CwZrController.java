package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.CwJycx;
import io.renren.modules.sys.entity.CwZr;
import io.renren.modules.sys.service.CwJycxService;
import io.renren.modules.sys.service.CwZrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sys/cwZr")
public class CwZrController extends AbstractController {
	@Autowired
	private CwZrService cwZrService;
	@Autowired
	private CwJycxService cwJycxService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		PageUtils page = cwZrService.queryPage(params);
		return R.ok().put("page", page);
	}
	


	@RequestMapping("/save")
	public R save(@RequestBody CwZr cwZr){
		cwZr.setStu("未转让");
		cwZrService.save(cwZr);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R update(@RequestBody CwZr cwZr){
		if(cwZr.getStu().equals("已转让")){
			return R.error(500,"当前车位已转让 不能进行数据修改");
		}
		cwZrService.updateById(cwZr);
		return R.ok();
	}
	@RequestMapping("/updateZr")
	public R updateZr(@RequestBody CwZr cwZr){
		if(cwZr.getStu().equals("已转让")){
			return R.error(500,"当前车位已经转让，不能重复转让");
		}else{
			cwZr.setStu("已转让");
			CwJycx cwJycx=new CwJycx();
			cwJycx.setJyTime(new Date());
			cwJycx.setMoney(cwZr.getZrjg());
			Integer i = (int) ((Math.random() * 9 + 1) * 100000);
			cwJycx.setDdh(i.toString());
			cwJycx.setCwInfo(cwZr.getCwInfo());
			cwJycx.setZffs("银行卡支付");
			cwJycx.setBeizhu2("车位转让");
			cwJycxService.save(cwJycx);
			cwZrService.updateById(cwZr);
		}
		return R.ok();
	}

	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CwZr cwZr = cwZrService.getById(id);
		return R.ok().put("cwZr", cwZr);
	}
	
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] userIds){
		cwZrService.removeByIds(Arrays.asList(userIds));
		return R.ok();
	}
}
