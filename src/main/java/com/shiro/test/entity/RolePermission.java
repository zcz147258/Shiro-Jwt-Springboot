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
    @ApiModel(value="RolePermission对象", description="")
public class RolePermission implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "permission_id", type = IdType.ID_WORKER_STR)
      private Integer permissionId;

    private Integer roleId;


}
