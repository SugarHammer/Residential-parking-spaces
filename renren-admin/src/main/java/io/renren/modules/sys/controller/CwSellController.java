package io.renren.modules.sys.controller;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.CwJycx;
import io.renren.modules.sys.entity.CwSell;
import io.renren.modules.sys.service.CwJycxService;
import io.renren.modules.sys.service.CwSellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/sys/cwSell")
public class CwSellController extends AbstractController {
	@Autowired
	private CwSellService cwSellService;

	@Autowired
	private CwJycxService cwJycxService;
	
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		params.put("cwType","车位出售");
		PageUtils page = cwSellService.queryPage(params);
		return R.ok().put("page", page);
	}
	@RequestMapping("/list2")
	public R list2(@RequestParam Map<String, Object> params){
		params.put("cwType","车位租赁");
		PageUtils page = cwSellService.queryPage(params);
		return R.ok().put("page", page);
	}
	@RequestMapping("/list3")
	public R list3(@RequestParam Map<String, Object> params){
		params.put("cwType","车位时租");
		PageUtils page = cwSellService.queryPage(params);
		return R.ok().put("page", page);
	}

	@RequestMapping("/saveBuy")
	public R saveBuy(@RequestBody CwSell CwSell){
		CwSell.setStu("未出售");
		CwSell.setCwType("车位出售");
		CwSell.setCwLx("地下单车位");
		cwSellService.save(CwSell);
		return R.ok();
	}


	@RequestMapping("/saveLease")
	public R saveLease(@RequestBody CwSell CwSell){
		CwSell.setStu("未租赁");
		CwSell.setCwType("车位租赁");
		CwSell.setCwLx("地下单车位");
		cwSellService.save(CwSell);
		return R.ok();
	}

	@RequestMapping("/saveSzLease")
	public R saveSzLease(@RequestBody CwSell CwSell){
		CwSell.setStu("车位空闲");
		CwSell.setCwType("车位时租");
		CwSell.setCwLx("地下单车位");
//		System.out.println();
		cwSellService.save(CwSell);
		return R.ok();
	}


	@RequestMapping("/save")
	public R save(@RequestBody CwSell CwSell){
        CwSell.setStu("空闲");
		CwSell.setCwLx("地下单车位");
		CwSell.setZlPrice("每小时100元");
		cwSellService.save(CwSell);
		return R.ok();
	}
	
	@RequestMapping("/update")
	public R update(@RequestBody CwSell cwSell){
		cwSellService.updateById(cwSell);
        return R.ok();

    }

	@RequestMapping("/cwBySz")
	public R cwBySz(@RequestBody CwSell cwSell){
		String stu = cwSell.getStu();
		if(stu.equals("已出租")){
			return R.error(500,"当前车位已出租,请选择其他车位");
		}else{
			cwSell.setStu("已出租");
			cwSellService.updateById(cwSell);
			CwJycx cwJycx=new CwJycx();
			cwJycx.setJyTime(new Date());
			cwJycx.setMoney(cwSell.getPrice());
			Integer i = (int) ((Math.random() * 9 + 1) * 100000);
			cwJycx.setDdh(i.toString());
			cwJycx.setCwInfo(cwSell.getWeizhi());
			cwJycx.setZffs("银行卡支付");
			cwJycx.setBeizhu(cwSell.getBz());
			cwJycx.setBeizhu2("车位时租");
			cwJycxService.save(cwJycx);
		}

		return R.ok();
	}

	@RequestMapping("/cwBuy")
	public R cwBuy(@RequestBody CwSell cwSell){
		cwSell.setStu("已出售");
		cwSellService.updateById(cwSell);
		CwJycx cwJycx=new CwJycx();
		cwJycx.setJyTime(new Date());
		cwJycx.setMoney(cwSell.getPrice());
        Integer i = (int) ((Math.random() * 9 + 1) * 100000);
        cwJycx.setDdh(i.toString());
        cwJycx.setCwInfo(cwSell.getWeizhi());
        cwJycx.setZffs("银行卡支付");
        cwJycx.setBeizhu(cwSell.getBz());
		cwJycx.setBeizhu2("车位出售");
		cwJycxService.save(cwJycx);
		return R.ok();
	}
	@RequestMapping("/update2")
	public R update2(@RequestBody CwSell cwSell){
		String stu = cwSell.getStu();
		if(stu.equals("已出售")){
			return R.error(500,"当前车位已出售,请选择其他车位");
		}else{
			cwSell.setStu("已出售");
			cwSellService.updateById(cwSell);

            CwJycx cwJycx=new CwJycx();
            cwJycx.setJyTime(new Date());
            cwJycx.setMoney(cwSell.getPrice());
            Integer i = (int) ((Math.random() * 9 + 1) * 100000);
            cwJycx.setDdh(i.toString());
            cwJycx.setCwInfo(cwSell.getWeizhi());
            cwJycx.setZffs("银行卡支付");
            cwJycx.setBeizhu(cwSell.getBz());
			cwJycx.setBeizhu2("车位出售");
			cwJycxService.save(cwJycx);
		}
		return R.ok();

	}

	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id){
		CwSell cwSell = cwSellService.getById(id);
		return R.ok().put("cwSell", cwSell);
	}
	
	@RequestMapping("/delete")
	public R delete(@RequestBody Long[] userIds){
		cwSellService.removeByIds(Arrays.asList(userIds));
		return R.ok();
	}
}
