package org.fantasizer.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.fantasizer.dao.mapper.DepartmentMapper;
import org.fantasizer.domain.Department;
import org.fantasizer.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author quxiaoyong 2018/6/25 16:30
 */
@Service
@Transactional
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public void deleteDepartment(Integer deptId) {
        Department dept = departmentMapper.selectById(deptId);

        Wrapper<Department> wrapper = new EntityWrapper<>();
        wrapper = wrapper.like("pids", "%[" + dept.getId() + "]%");
        List<Department> subDepts = this.departmentMapper.selectList(wrapper);
        for (Department temp : subDepts) {
            temp.deleteById();
        }

        dept.deleteById();
    }


    @Override
    public List<Map<String, Object>> list(String condition) {
        return this.baseMapper.list(condition);
    }
}
