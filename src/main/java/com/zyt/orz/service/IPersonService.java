package com.zyt.orz.service;

import com.zyt.orz.entity.Person;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 人类 服务类
 * </p>
 *
 * @author zyt
 * @since 2019-11-08
 */
public interface IPersonService extends IService<Person> {

	IPage<Person> getPage(Page<Person> page, Object object);

}
