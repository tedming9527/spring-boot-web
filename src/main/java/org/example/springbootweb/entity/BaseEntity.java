package org.example.springbootweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseEntity<T extends Model<T>> extends Model<T> {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;
  @TableField(fill = FieldFill.INSERT)
  private String creator;
  @TableField(fill = FieldFill.INSERT)
  private String createTime;
  @TableField(fill = FieldFill.UPDATE)
  private String modifier;
  @TableField(fill = FieldFill.UPDATE)
  private String updateTime;
}
