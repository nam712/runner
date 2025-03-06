package com.sCore.modules.mngOrganization.bo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrgTreNode {
    private Long key;
    private String label;
    private List<OrgTreNode> children;
    private Long numChild;
    private boolean leaf;
    private boolean expanded;

    public OrgTreNode(Organization org) {
        if (org == null) {
            return;
        }
        this.key = org.getId();
        this.label = org.getName();
        this.numChild = org.getNumChild();
        this.leaf = this.numChild == 0;
        this.expanded = org.isExpanded();
        if (org.getChildOrg() != null) {
            children = new ArrayList<>();
            for (Organization child : org.getChildOrg()) {
                children.add(new OrgTreNode(child));
            }
        }
    }
}
