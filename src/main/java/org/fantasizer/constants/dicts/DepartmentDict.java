package org.fantasizer.constants.dicts;


/**
 * 部门的映射
 *
 * @author fengshuonan
 * @date 2017-05-06 15:01
 */
public class DepartmentDict extends AbstractDictMap {

    @Override
    public void init() {
        put("deptId", "部门名称");
        put("orderNo", "部门排序");
        put("parentId", "上级名称");
        put("simpleName", "部门简称");
        put("fullName", "部门全称");
        put("tips", "备注");
    }

    @Override
    protected void initBeWrapped() {
        putFieldWrapperMethodName("deptId", "getDepartmentName");
        putFieldWrapperMethodName("parentId", "getDepartmentName");
    }
}
