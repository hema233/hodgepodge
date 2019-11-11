package com.zyt.orz.service.impl;

import com.zyt.orz.entity.Person;
import com.zyt.orz.mapper.PersonMapper;
import com.zyt.orz.service.IPersonService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 人类 服务实现类
 * </p>
 *
 * @author zyt
 * @since 2019-11-08
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

	@Autowired
	PersonMapper pMapper;
	
	@Override
	public IPage<Person> getPage(Page<Person> page, Object object) {
		return pMapper.selectPageVo(page, null);
	}

}
