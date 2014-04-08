package hello.web.editor;

import hello.domain.Department;
import hello.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

/**
 * Created by xiaohu on 14-4-6.
 */
public class DepartmentEditor extends PropertyEditorSupport {

    private SystemService systemService;

    public DepartmentEditor(SystemService systemService) {
        this.systemService = systemService;
    }

    public void setAsText(String text) {
        int id = Integer.parseInt(text);
        Department department = systemService.findDepartment(id);
        setValue(department);
    }
}
