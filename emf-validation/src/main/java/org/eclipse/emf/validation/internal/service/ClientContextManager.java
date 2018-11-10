/******************************************************************************
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc., and others. All
 * rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation -
 * initial API and implementation Zeligsoft - Bugs 137213, 249496, 252302
 * Borland Software - Bug 137213 SAP AG - Bug 240352
 ****************************************************************************/

package org.eclipse.emf.validation.internal.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IModelConstraint;

/**
 * The context manager loads contexts from the <code>constraintBindings</code>
 * extension point and makes them available to the validation framework.
 * @author Christian W. Damus
 */
public class ClientContextManager
{
    private static final String E_CLIENT_CONTEXT = "clientContext"; //$NON-NLS-1$

    private static final String E_BINDING = "binding"; //$NON-NLS-1$
    private static final String A_CONTEXT = "context"; //$NON-NLS-1$

    private static final String E_CONSTRAINT            = "constraint"; //$NON-NLS-1$
    private static final String E_CATEGORY              = "category"; //$NON-NLS-1$
    private static final String E_EXTEND_CLIENT_CONTEXT = "extendClientContext"; //$NON-NLS-1$
    private static final String E_EXCLUDE_CONSTRAINT    = "excludeConstraint"; //$NON-NLS-1$
    private static final String E_EXCLUDE_CATEGORY      = "excludeCategory"; //$NON-NLS-1$
    private static final String A_REF                   = "ref"; //$NON-NLS-1$

    private static final ClientContextManager INSTANCE = new ClientContextManager();

    private volatile Set<IClientContext>         clientContexts   =
            new java.util.HashSet<IClientContext>();
    private volatile Map<String, IClientContext> clientContextMap =
            new java.util.HashMap<String, IClientContext>();

    private volatile Set<ClientContext> defaultContexts = new java.util.HashSet<ClientContext>();

    private final Object clientContextLock = new Object();

    // private final IExtensionChangeHandler extensionHandler = new
    // IExtensionChangeHandler() {
    //
    // public void addExtension(IExtensionTracker tracker, IExtension extension)
    // {
    // // must create all of the contexts before we process the bindings.
    // // Hence, this will loop over the elements twice
    // IConfigurationElement[] configs = extension
    // .getConfigurationElements();
    //
    // synchronized (clientContextLock) {
    // configureClientContexts(configs);
    // configureBindings(configs);
    // }
    // }
    //
    // public void removeExtension(IExtension extension, Object[] objects) {
    // // client-contexts cannot be undefined
    // }
    // };

    /**
     * Not instantiable by clients.
     */
    private ClientContextManager()
    {
        super();

        // configureConstraintBindings();
    }

    /**
     * Configures constraint bindings based on the <tt>constraintBindings</tt>
     * extension configurations.
     */
    // private void configureConstraintBindings()
    // {
    // if (EMFPlugin.IS_ECLIPSE_RUNNING) {
    // IExtensionPoint extPoint =
    // Platform.getExtensionRegistry()
    // .getExtensionPoint(EMFModelValidationPlugin.getPluginId(),
    // EMFModelValidationPlugin.CONSTRAINT_BINDINGS_EXT_P_NAME);
    //
    // IExtensionTracker extTracker =
    // EMFModelValidationPlugin.getExtensionTracker();
    //
    // if (extTracker != null) {
    // extTracker.registerHandler(extensionHandler,
    // ExtensionTracker.createExtensionPointFilter(extPoint));
    //
    // for (IExtension extension : extPoint.getExtensions()) {
    // extensionHandler.addExtension(extTracker, extension);
    // }
    // }
    // }
    // }

    /**
     * Obtains the singleton instance of this class.
     * @return the singleton context manager
     */
    public static final ClientContextManager getInstance()
    {
        return INSTANCE;
    }

    /**
     * Obtains a client context by its unique identifier.
     * @param contextId the client context ID to look for
     * @return the matching context, or <code>null</code> if none is registered
     *         under this ID
     */
    public IClientContext getClientContext(String contextId)
    {
        return clientContextMap.get(contextId);
    }

    /**
     * Obtains all of the client contexts registered in the system.
     * @return the available {@link IClientContext}s
     */
    public Set<IClientContext> getClientContexts()
    {
        return clientContexts;
    }

    /**
     * Obtains the client contexts to which the specified object belongs.
     * @param eObject a model element
     * @return the collection of client contexts to which the
     *         <code>eObject</code> belongs. This may be empty if no context
     *         selector matches this element
     */
    public Collection<IClientContext> getClientContextsFor(EObject eObject)
    {
        return new java.util.HashSet<>();
        // Set<IClientContext> result = new java.util.HashSet<IClientContext>();
        //
        // EvaluationContext ctx = new EvaluationContext(null, eObject);
        //
        // Collection<IClientContext> contextsCopy;
        // synchronized (clientContextLock) {
        // contextsCopy = getClientContexts();
        // }
        // for (Iterator<IClientContext> iter = contextsCopy.iterator();
        // iter.hasNext();) {
        //
        // IClientContext next = iter.next();
        // IClientSelector selector = next.getSelector();
        //
        // final Object toTest =
        // (selector instanceof XmlExpressionSelector) ? (Object) ctx : (Object)
        // eObject;
        //
        // try {
        // if (selector.selects(toTest)) {
        // result.add(next);
        // }
        // }
        // catch (RuntimeException e) {
        // // client context selectors must not throw exceptions. This one
        // // will not be trusted in future validation operations. This
        // // is effected by removing it from the context manager
        // synchronized (clientContextLock) {
        // clientContexts.remove(next);
        // clientContextMap.remove(next.getId());
        // defaultContexts.remove(next); // in case it is a default
        // // context
        // }
        //
        // Trace.catching(getClass(), "getClientContextsFor", e); //$NON-NLS-1$
        // Log.log(IStatus.ERROR,
        // EMFModelValidationStatusCodes.CLIENT_SELECTOR_FAILURE,
        // EMFModelValidationPlugin.getMessage(ValidationMessages.client_selectorFailure_ERROR_,
        // new Object[]{next.getId()}),
        // e);
        // }
        // }
        //
        // if (result.size() > 1) {
        // ClientContext.pruneExtensions(result);
        // }
        //
        // return result;
    }

    /**
     * Computes the constraints bound to contexts that include the specified
     * <code>eObject</code> from amongst the specified collection.
     * @param eObject a model element
     * @param constraints a collection of {@link IModelConstraint}s
     * @return the {@link IModelConstraint}s from amongst the specified
     *         <code>constraints</code> that are bound to the
     *         <code>context</code>
     */
    public <T extends IModelConstraint> Collection<T> getBindings(EObject eObject,
                                                                  Collection<? extends T> constraints)
    {

        Collection<T> result;

        Collection<IClientContext> contexts = getClientContextsFor(eObject);

        if (contexts.isEmpty()) {
            // no context recognizes this object? Oh, well, then there are
            // no constraints
            result = Collections.emptyList();
        } else if (contexts.size() == 1) {
            // easy when there's just one context
            result = getBindings(contexts.iterator().next(), constraints);
        } else {
            // multiple contexts require more looping
            result = getBindings(contexts, constraints);
        }

        return result;
    }

    /**
     * Computes the constraints bound to the specified <code>context</code> from
     * amongst the specified collection.
     * @param context a client context
     * @param constraints a collection of {@link IModelConstraint}s
     * @return the {@link IModelConstraint}s from amongst the specified
     *         <code>constraints</code> that are bound to the
     *         <code>context</code>
     */
    public <T extends IModelConstraint> Collection<T> getBindings(IClientContext context,
                                                                  Collection<? extends T> constraints)
    {

        Collection<T> result = new java.util.ArrayList<T>(constraints.size());

        for (T constraint : constraints) {
            if (context.includes(constraint)) {
                result.add(constraint);
            } else if (context.isDefault()) {
                // maybe this constraint is implictly bound to the default
                // context, because it is not explicitly bound to any?
                if (isDefaultBinding(constraint)) {
                    result.add(constraint);
                }
            }
        }

        return result;
    }

    /**
     * Computes the constraints bound any of the specified <code>contexts</code>
     * from amongst the specified collection.
     * @param contexts a collection of {@link IClientContext}s
     * @param constraints a collection of {@link IModelConstraint}s
     * @return the {@link IModelConstraint}s from amongst the specified
     *         <code>constraints</code> that are bound to the
     *         <code>context</code>
     */
    public <T extends IModelConstraint> Collection<T> getBindings(Collection<? extends IClientContext> contexts,
                                                                  Collection<? extends T> constraints)
    {

        Collection<T> result = new java.util.ArrayList<T>(constraints.size());

        // use an array for performance (to avoid creating so many iterators)
        IClientContext[] ctxArray = contexts.toArray(new IClientContext[contexts.size()]);

        // in case we don't find an explicit binding, we need to know whether
        // we need to look for default bindings. This will only be the case
        // if any of the current contexts is default
        boolean anyContextIsDefault = false;

        for (T constraint : constraints) {
            boolean bound = false;

            for (IClientContext element : ctxArray) {
                bound = element.includes(constraint);

                if (bound) {
                    result.add(constraint);
                    break;  // needn't look at any more contexts
                } else if (element.isDefault()) {
                    // no need to check for default contexts as long as we
                    // find explicit bindings
                    anyContextIsDefault = true;
                }
            }

            if (!bound && anyContextIsDefault) {
                // maybe this constraint is implictly bound to the default
                // context, because it is not explicitly bound to any?
                if (isDefaultBinding(constraint)) {
                    result.add(constraint);
                }
            }
        }

        return result;
    }

    /**
     * Computes whether the specified <code>constraint</code> is implicitly
     * bound to the default client contexts, by virtue of not being explicitly
     * bound to any context (even to a default context).
     * <p>
     * <em>Side Effect:</em> This method adds the <code>constraint</code>, if it
     * is indeed a default constraint, to all default client contexts, so that
     * the computation can be averted in future.
     * </p>
     * @param constraint a constraint
     * @return whether the constraint is bound implicitly to default client
     *         contexts
     * @see IClientContext#isDefault()
     */
    private boolean isDefaultBinding(IModelConstraint constraint)
    {
        boolean result = true;
        String id = constraint.getDescriptor().getId();

        for (Iterator<IClientContext> iter = clientContexts.iterator(); result && iter.hasNext();) {

            result = !iter.next().includes(constraint);
        }

        if (result) {
            // add the constraint to all default contexts so that we don't do
            // this computation again
            for (ClientContext next : defaultContexts) {
                next.includeConstraint(id);
            }
        }

        return result;
    }

    /**
     * Adds the specified implicit client context binding (forward reference).
     * The client-context lock must be held when calling this method.
     * @param context the implicit context to add
     */
    public void addClientContext(ClientContext context)
    {
        synchronized (clientContextLock) {
            // copy on write
            clientContexts = new java.util.HashSet<IClientContext>(clientContexts);
            clientContextMap = new java.util.HashMap<String, IClientContext>(clientContextMap);

            if (clientContexts.add(context)) {
                clientContextMap.put(context.getId(), context);
            }
        }
    }
}
