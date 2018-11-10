/**
 * <copyright> Copyright (c) 2008 Zeligsoft Inc. and others. All rights
 * reserved. This program and the accompanying materials are made available
 * under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors: Zeligsoft - Initial API and implementation </copyright> $Id:
 * ResourceStatus.java,v 1.1 2008/09/22 06:11:29 cdamus Exp $
 */

package org.eclipse.emf.validation.internal.service;

import java.util.Collections;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.internal.EMFModelValidationPlugin;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;

/**
 * A marker status indicating a {@link Resource} covered by a validation
 * operation.
 * @author Christian W. Damus (cdamus)
 * @since 1.3
 */
public final class ResourceStatus extends ConstraintStatus
{

    private static IModelConstraint dummy = new IModelConstraint()
    {

        private final IConstraintDescriptor descriptor = new AbstractConstraintDescriptor()
        {

            @Override
            public boolean targetsTypeOf(EObject object)
            {
                return false;
            }

            @Override
            public boolean targetsEvent(Notification notification)
            {
                return false;
            }

            @Override
            public int getStatusCode()
            {
                return 0;
            }

            @Override
            public ConstraintSeverity getSeverity()
            {
                return ConstraintSeverity.INFO;
            }

            @Override
            public String getPluginId()
            {
                return EMFModelValidationPlugin.getPluginId();
            }

            @Override
            public String getName()
            {
                return ""; //$NON-NLS-1$
            }

            @Override
            public String getMessagePattern()
            {
                return ""; //$NON-NLS-1$
            }

            @Override
            public String getId()
            {
                return getPluginId() + ".resourceMarker"; //$NON-NLS-1$
            }

            @Override
            public EvaluationMode<?> getEvaluationMode()
            {
                return EvaluationMode.BATCH;
            }

            @Override
            public String getDescription()
            {
                return null;
            }

            @Override
            public String getBody()
            {
                return null;
            }
        };

        @Override
        public IStatus validate(IValidationContext ctx)
        {
            return ctx.createSuccessStatus();
        }

        @Override
        public IConstraintDescriptor getDescriptor()
        {
            return descriptor;
        }
    };

    /**
     * Initializes me with my resource.
     * @param resource a resource covered by the validation operation
     */
    public ResourceStatus(EObject root)
    {
        super(dummy, root, IStatus.OK, 0, "ValidationMessages.eval_all_pass_INFO_",
              Collections.singleton(root));
    }

}
