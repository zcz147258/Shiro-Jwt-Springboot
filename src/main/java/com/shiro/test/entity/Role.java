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
    @ApiModel(value="Role对象", description="")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.ID_WORKER_STR)
      private Integer id;

    private String description;

    private String role;


}
