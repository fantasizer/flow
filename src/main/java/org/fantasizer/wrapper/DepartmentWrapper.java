package org.fantasizer.wrapper;

import org.fantasizer.constants.factorys.ConstantFactory;
import org.fantasizer.core.wrapper.BaseControllerWarpper;
import org.fantasizer.utils.ToolUtil;

import java.util.Map;

/**
 * @author quxiaoyong 2018/6/25 16:54
 */
public class DepartmentWrapper extends BaseControllerWarpper {

    public DepartmentWrapper(Object list) {
        super(list);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

        Integer pid = (Integer) map.get("parentId");

        if (ToolUtil.isEmpty(pid) || pid.equals(0)) {
            map.put("pName", "--");
        } else {
            map.put("pName", ConstantFactory.me().getDeptName(pid));
        }
    }
}
