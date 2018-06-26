package org.fantasizer.dao.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.fantasizer.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * @author quxiaoyong 2018/6/25 16:07
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {


    /**
     *  获取所有部门列表
     *
     * @param condition
     * @return
     */
    List<Map<String, Object>> list(@Param("condition") String condition);

}
