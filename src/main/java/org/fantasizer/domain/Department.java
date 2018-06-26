package org.fantasizer.domain;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author quxiaoyong 2018/6/25 15:57
 */
@TableName("sys_department")
@Getter
@Setter
public class Department extends Model<Department> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 排序
     */
    private Integer orderNo;
    /**
     * 父部门id
     */
    private Integer parentId;
    /**
     * 父级ids
     */
    private String parentIds;
    /**
     * 简称
     */
    private String simpleName;
    /**
     * 全称
     */
    private String fullName;
    /**
     * 提示
     */
    private String tips;
    /**
     * 版本（乐观锁保留字段）
     */
    private Integer version;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }


}
