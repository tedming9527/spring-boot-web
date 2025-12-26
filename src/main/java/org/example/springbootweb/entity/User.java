package org.example.springbootweb.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ted
 * @since 2025-12-26
 */
@Getter
@Setter
@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String gender;

    /**
     * 姓名
     */
    private String name;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT)
    private String creator;

    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    private String updater;
}
