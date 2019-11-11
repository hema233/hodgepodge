package com.zyt.orz.mapper;

import com.zyt.orz.entity.Person;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 * 人类 Mapper 接口
 * </p>
 *
 * @author zyt
 * @since 2019-11-08
 */
public interface PersonMapper extends BaseMapper<Person> {
	 /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param state 状态
     * @return 分页对象
     */
    IPage<Person> selectPageVo(IPage<Person> page, @Param("state") Integer state);
}
