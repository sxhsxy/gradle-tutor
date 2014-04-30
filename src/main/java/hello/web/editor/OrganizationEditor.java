package hello.web.editor;

import hello.domain.Organization;
import hello.service.SystemService;

import java.beans.PropertyEditorSupport;

/**
 * Created by Xiaohu on 14-4-18.
 */
public class OrganizationEditor extends PropertyEditorSupport {
    private SystemService systemService;

    public OrganizationEditor(SystemService systemService) {
        this.systemService = systemService;
    }

    public void setAsText(String text) {
        Long id = Long.parseLong(text);
        Organization organization = systemService.findOrganization(id);
        setValue(organization);
    }
}
