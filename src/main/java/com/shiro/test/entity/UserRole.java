package com.shiro.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    @ApiModel(value="UserRole对象", description="")
public class UserRole implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "uid", type = IdType.ID_WORKER_STR)
      private Integer uid;

    private Integer roleId;


}
