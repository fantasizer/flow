package org.fantasizer.controller;

import org.fantasizer.annotations.BussinessLog;
import org.fantasizer.annotations.Permission;
import org.fantasizer.constants.RequestMappingConstants;
import org.fantasizer.constants.dicts.DepartmentDict;
import org.fantasizer.constants.factorys.ConstantFactory;
import org.fantasizer.domain.Department;
import org.fantasizer.exceptions.BizExceptionEnum;
import org.fantasizer.exceptions.SystemException;
import org.fantasizer.log.LogObjectHolder;
import org.fantasizer.service.DepartmentService;
import org.fantasizer.utils.ToolUtil;
import org.fantasizer.wrapper.DepartmentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author quxiaoyong 2018/6/25 16:24
 */
@Controller
@RequestMapping(RequestMappingConstants.RMC_DEPARTMENT_ROOT)
public class DepartmentController extends BaseController {

    @Autowired
    private DepartmentService departmentService;


    /**
     * 新增部门
     */
    @BussinessLog(value = "添加部门", key = "simpleName", dict = DepartmentDict.class)
    @RequestMapping(value = RequestMappingConstants.RMC_DEPARTMENT_METHOD_ADD)
    @Permission
    @ResponseBody
    public Object add(Department dept) {
        if (ToolUtil.isOneEmpty(dept, dept.getSimpleName())) {
            throw new SystemException(BizExceptionEnum.REQUEST_NULL);
        }
        //完善pids,根据pid拿到pid的pids
        deptSetPids(dept);
        return this.departmentService.insert(dept);
    }

    /**
     * 获取所有部门列表
     */
    @RequestMapping(value = RequestMappingConstants.RMC_DEPARTMENT_METHOD_LIST)
    @Permission
    @ResponseBody
    public Object list(String condition) {
        List<Map<String, Object>> list = this.departmentService.list(condition);
        return super.warpObject(new DepartmentWrapper(list));
    }

    /**
     * 部门详情
     */
    @RequestMapping(value = RequestMappingConstants.RMC_DEPARTMENT_METHOD_DETAIL)
    @Permission
    @ResponseBody
    public Object detail(@PathVariable("deptId") Integer deptId) {
        return this.departmentService.selectById(deptId);
    }

    /**
     * 修改部门
     */
    @BussinessLog(value = "修改部门", key = "simpleName", dict = DepartmentDict.class)
    @RequestMapping(value = RequestMappingConstants.RMC_DEPARTMENT_METHOD_UPDATE)
    @Permission
    @ResponseBody
    public Object update(Department dept) {
        if (ToolUtil.isEmpty(dept) || dept.getId() == null) {
            throw new SystemException(BizExceptionEnum.REQUEST_NULL);
        }
        deptSetPids(dept);
        this.departmentService.updateById(dept);
        return SUCCESS_TIP;
    }

    /**
     * 删除部门
     */
    @BussinessLog(value = "删除部门", key = "deptId", dict = DepartmentDict.class)
    @RequestMapping(value = RequestMappingConstants.RMC_DEPARTMENT_METHOD_DELETE)
    @Permission
    @ResponseBody
    public Object delete(@RequestParam Integer deptId) {

        //缓存被删除的部门名称
        LogObjectHolder.me().set(ConstantFactory.me().getDeptName(deptId));

        this.departmentService.deleteDepartment(deptId);

        return SUCCESS_TIP;
    }

    private void deptSetPids(Department dept) {
        if (ToolUtil.isEmpty(dept.getParentId()) || dept.getParentId().equals(0)) {
            dept.setParentId(0);
            dept.setParentIds("[0],");
        } else {
            int pid = dept.getParentId();
            Department temp = this.departmentService.selectById(pid);
            String pids = temp.getParentIds();
            dept.setParentId(pid);
            dept.setParentIds(pids + "[" + pid + "],");
        }
    }
}
