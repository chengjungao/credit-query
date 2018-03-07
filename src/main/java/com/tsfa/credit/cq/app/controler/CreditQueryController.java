package com.tsfa.credit.cq.app.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tsfa.credit.cq.app.entity.Credit;
import com.tsfa.credit.cq.app.entity.request.Option;
import com.tsfa.credit.cq.app.service.CreditService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/v1")
public class CreditQueryController {
	@Autowired
	CreditService creditService;
	 
 	@ApiOperation(value="获得个人/企业征信数据", notes="获得个人/企业征信数据")
	@RequestMapping(value="/list" , name="获得个人/企业征信数据" , method={RequestMethod.GET})
    public List<Credit> getCredits(@ApiParam(name = "name", value = "姓名", required = true) @RequestParam String name,
    		@ApiParam(name = "idCard", value = "身份证号", required = true) @RequestParam String idCard,
    		@ApiParam(name = "bizCode", value = "业务类型： 1 = 个人 ; 2 = 企业", required = true) @RequestParam int bizCode){
        return creditService.listCredit(new Option(name,idCard,bizCode));
    }
	
 	@ApiOperation(value="获得个人/企业征信数据", notes="获得个人/企业征信数据")
	@ApiImplicitParam(name = "option", value = "请求参数实体", required = true, dataType = "Option")
	@RequestMapping(value="/list", name="获得个人/企业征信数据" , method={RequestMethod.POST})
    public List<Credit>  getCredits(@RequestBody Option option){
        return creditService.listCredit(option);
    }
}
