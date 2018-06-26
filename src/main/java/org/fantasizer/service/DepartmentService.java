package org.fantasizer.service;

import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Param;
import org.fantasizer.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * @author quxiaoyong 2018/6/25 16:29
 */
public interface DepartmentService extends IService<Department> {

    /**
     * 删除部门
     */
    void deleteDepartment(Integer deptId);


    /**
     * 获取所有部门列表
     */
    List<Map<String, Object>> list(@Param("condition") String condition);
}
