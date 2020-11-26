package com.zhongzhi.gas.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhongzhi.location.pojo.LocalizerSaleParam;
import com.zhongzhi.location.service.SaleService;

@Controller
public class SaleController {
	@Autowired(required=true)
	private SaleService saleService;
	
//	@RequestParam(value="sourceParentsId[]")
//	private List<Integer> sourceParentsId;
//	private List<Integer> destinationParentsId;	
	@RequestMapping("localizerSale")
	@ResponseBody
	public Map<String,String> localizerSale(LocalizerSaleParam lsp){
//	public Map<String,String> localizerSale(
//			LocalizerSaleParam lsp,
//			@RequestParam(value="sourceParentsId[]") List<Integer> sourceParentsId,
//			@RequestParam(value="destinationParentsId[]") List<Integer> destinationParentsId
//			) throws Exception {
//		System.out.println(lsp);
//		System.out.println(sourceParentsId);
//		System.out.println(destinationParentsId);
//		return saleService.localizerSale(lsp,sourceParentsId,destinationParentsId);
		return saleService.localizerSale(lsp);
		//return members;
	}
}
