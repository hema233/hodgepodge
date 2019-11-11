package com.zyt.orz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.sql.Timestamp;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 人类
 * </p>
 *
 * @author zyt
 * @since 2019-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Person对象", description="人类")
public class Person implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年纪")
    private Integer age;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "创建时间")
    private Timestamp createTime;


}
