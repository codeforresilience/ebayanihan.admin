/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.ebayanihan.admin.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.ebayanihan.admin.entity.ProjectNgoMapping;

/**
 *
 * @author John Eris
 */
@Stateless
public class ProjectNgoMappingFacade extends AbstractFacade<ProjectNgoMapping> {
    @PersistenceContext(unitName = "org_ebayanihan.admin_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProjectNgoMappingFacade() {
        super(ProjectNgoMapping.class);
    }
    
}
