package com.zyt.orz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyt.orz.common.api.CommonResult;
import com.zyt.orz.entity.Person;
import com.zyt.orz.service.IPersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <p>
 * 人类 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/person")
@Api(tags = "人员信息管理")
public class PersonController {

	@Autowired
	private IPersonService personSvi;

	@ApiOperation(value = "查询用户", notes = "查询所有用户")
	@GetMapping("getPerson")
	public CommonResult getPerson() {
		List<Person> b = personSvi.list(null);
		return CommonResult.success(b);
	}

	@ApiOperation("查询用户-分页-mybatis-plus自带")
	@GetMapping("getPersonPage")
	public CommonResult getPersonPage(long current, long size) {
		Page<Person> page = new Page<Person>(current, size);
		page.addOrder(new OrderItem().setColumn("id").setAsc(false));
		QueryWrapper<Person> queryWrapper = new QueryWrapper<>();
		queryWrapper.orderByDesc("id");
		return CommonResult.success(personSvi.getPage(page, queryWrapper));
	}

	@ApiOperation(value = "添加用户")
	@PostMapping("insert")
	public CommonResult insert(Person user) {
		boolean b = personSvi.save(user);
		if (!b)
			return CommonResult.failed();
		return CommonResult.success(user);
	}

	@ApiOperation(value = "添加用户-批量")
	@PostMapping("insertList")
	public CommonResult insertList(@ApiParam(name = "用户信息集合", required = true) @RequestBody List<Person> users) {
		boolean b = personSvi.saveBatch(users);
		if (!b)
			return CommonResult.failed();
		return CommonResult.success(users);
	}

}
