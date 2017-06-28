/**
 * Copyright (c) 2006-2010 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 */
package org.eclipse.emf.ecore.impl;

import java.util.Collection;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.InvocationTargetException;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.google.gwt.user.client.rpc.GwtTransient;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>EGeneric Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getEUpperBound <em>EUpper Bound</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getETypeArguments <em>EType Arguments</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getERawType <em>ERaw Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getELowerBound <em>ELower Bound</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getETypeParameter <em>EType Parameter</em>}</li>
 *   <li>{@link org.eclipse.emf.ecore.impl.EGenericTypeImpl#getEClassifier <em>EClassifier</em>}</li>
 * </ul>
 * </p>
 *
 * @generated not
 */
public class EGenericTypeImpl extends MinimalEObjectImpl.Container implements EGenericType
{
  /**
   * The cached value of the '{@link #getEUpperBound() <em>EUpper Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEUpperBound()
   * @generated
   * @ordered
   */
  @GwtTransient
  protected EGenericType eUpperBound;

  /**
   * The cached value of the '{@link #getETypeArguments() <em>EType Arguments</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getETypeArguments()
   * @generated
   * @ordered
   */
  @GwtTransient
  protected EList<EGenericType> eTypeArguments;

  /**
   * The cached default value for the {@link #eRawType eRawType} field.
   * It needs to be set to {@link org.eclipse.emf.ecore.EcorePackage.Literals#EJAVA_OBJECT}
   * but due to bootstrap delays initializing that field, 
   * it needs to be set after the Ecore package has been initialized.
   * @see org.eclipse.emf.ecore.impl.EcorePackageImpl#internalBootstrap()
   * @see #eRawType
   */
  static EDataType eJavaObject;

  /**
   * The cached value of the '{@link #getERawType() <em>ERaw Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getERawType()
   * @generated NOT
   * @ordered
   */
  @GwtTransient
  protected EClassifier eRawType = eJavaObject;

  /**
   * The cached value of the '{@link #getELowerBound() <em>ELower Bound</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getELowerBound()
   * @generated
   * @ordered
   */
  @GwtTransient
  protected EGenericType eLowerBound;

  /**
   * The cached value of the '{@link #getETypeParameter() <em>EType Parameter</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getETypeParameter()
   * @generated
   * @ordered
   */
  @GwtTransient
  protected ETypeParameter eTypeParameter;

  /**
   * The cached value of the '{@link #getEClassifier() <em>EClassifier</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEClassifier()
   * @generated
   * @ordered
   */
  @GwtTransient
  protected EClassifier eClassifier;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EGenericTypeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return EcorePackage.Literals.EGENERIC_TYPE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public EGenericType getEUpperBound()
  {
    return eUpperBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetEUpperBound(EGenericType newEUpperBound, NotificationChain msgs)
  {
    EGenericType oldEUpperBound = eUpperBound;
    eUpperBound = newEUpperBound;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__EUPPER_BOUND, oldEUpperBound, newEUpperBound);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public void setEUpperBound(EGenericType newEUpperBound)
  {
    if (newEUpperBound != eUpperBound)
    {
      NotificationChain msgs = null;
      if (eUpperBound != null)
        msgs = ((InternalEObject)eUpperBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcorePackage.EGENERIC_TYPE__EUPPER_BOUND, null, msgs);
      if (newEUpperBound != null)
        msgs = ((InternalEObject)newEUpperBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcorePackage.EGENERIC_TYPE__EUPPER_BOUND, null, msgs);
      msgs = basicSetEUpperBound(newEUpperBound, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__EUPPER_BOUND, newEUpperBound, newEUpperBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public EList<EGenericType> getETypeArguments()
  {
    if (eTypeArguments == null)
    {
      eTypeArguments = new EObjectContainmentEList<EGenericType>(EGenericType.class, this, EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS);
    }
    return eTypeArguments;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
public EClassifier getERawType()
  {
    if (eRawType != null && eRawType.eIsProxy())
    {
      InternalEObject oldERawType = (InternalEObject)eRawType;
      eRawType = (EClassifier)eResolveProxy(oldERawType);
      if (eRawType != oldERawType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePackage.EGENERIC_TYPE__ERAW_TYPE, oldERawType, eRawType));

        if (eContainer instanceof EOperation)
        {
          if (eContainerFeatureID() == (EOPPOSITE_FEATURE_BASE - EcorePackage.EOPERATION__EGENERIC_EXCEPTIONS) && eContainer.eNotificationRequired())
          {
            new ENotificationImpl
              (eContainer, 
               Notification.RESOLVE, 
               EcorePackage.EOPERATION__EEXCEPTIONS, 
               oldERawType,
               eRawType,
               ((EOperation)eContainer).getEGenericExceptions().indexOf(this)).dispatch();
          }
        }
        else if (eContainer instanceof EClass)
        {
          if (eContainerFeatureID() == (EOPPOSITE_FEATURE_BASE - EcorePackage.ECLASS__EGENERIC_SUPER_TYPES) && eContainer.eNotificationRequired())
          {
            EClassifier newERawType = eRawType;
            if (!(newERawType instanceof EClass))
            {
              newERawType = EcorePackage.Literals.EOBJECT;
            }
            if (!(oldERawType instanceof EClass))
            {
              oldERawType = (InternalEObject)EcorePackage.Literals.EOBJECT;
            }

            new ENotificationImpl
              (eContainer, 
               Notification.RESOLVE, 
               EcorePackage.ECLASS__ESUPER_TYPES, 
               oldERawType,
               newERawType,
               ((EClass)eContainer).getEGenericSuperTypes().indexOf(this)).dispatch();
          }
        }
      }
    }
    return eRawType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetERawType()
  {
    return eRawType;
  }

  public NotificationChain setERawType(EClassifier newERawType, NotificationChain msgs)
  {
    EClassifier oldERawType = eRawType;
    if (newERawType == null)
    {
      newERawType = eJavaObject; 
    }
    eRawType = newERawType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ERAW_TYPE, oldERawType, eRawType);
      if (msgs == null)
      {
        msgs = notification;
      }
      else
      {
        msgs.add(notification);
      }
    }
    
    if (oldERawType != newERawType)
    {
      if (eContainer instanceof ETypedElementImpl)
      {
        if (eContainerFeatureID() == (EOPPOSITE_FEATURE_BASE - EcorePackage.ETYPED_ELEMENT__EGENERIC_TYPE))
        {
          msgs = ((ETypedElementImpl)eContainer).setEType(newERawType, msgs);
        }
        else if (eContainerFeatureID() == (EOPPOSITE_FEATURE_BASE - EcorePackage.EOPERATION__EGENERIC_EXCEPTIONS))
        {
          if (newERawType == null)
          {
            newERawType = EcorePackage.Literals.EJAVA_OBJECT;
          }
          if (oldERawType == null)
          {
            oldERawType = EcorePackage.Literals.EJAVA_OBJECT;
          }
  
          if (eContainer.eNotificationRequired())
          {
            ENotificationImpl notification =
              new ENotificationImpl
                (eContainer, 
                 Notification.SET, 
                 EcorePackage.EOPERATION__EEXCEPTIONS, 
                 oldERawType,
                 newERawType,
                 ((EOperation)eContainer).getEGenericExceptions().indexOf(this), 
                 false);
            
            if (msgs == null)
            {
              msgs = notification;
            }
            else
            {
              msgs.add(notification);
            }
          }
        }
      }
      else if (eContainer instanceof EClass)
      {
        if (eContainerFeatureID() == (EOPPOSITE_FEATURE_BASE - EcorePackage.ECLASS__EGENERIC_SUPER_TYPES))
        {
          if (!(newERawType instanceof EClass))
          {
            newERawType = EcorePackage.Literals.EOBJECT;
          }
          if (!(oldERawType instanceof EClass))
          {
            oldERawType = EcorePackage.Literals.EOBJECT;
          }
  
          if (eContainer.eNotificationRequired())
          {
            ENotificationImpl notification =
              new ENotificationImpl
                (eContainer, 
                 Notification.SET, 
                 EcorePackage.ECLASS__ESUPER_TYPES, 
                 oldERawType,
                 newERawType,
                 ((EClass)eContainer).getEGenericSuperTypes().indexOf(this), 
                 false);
            
            if (msgs == null)
            {
              msgs = notification;
            }
            else
            {
              msgs.add(notification);
            }
          }
        }
      }
      else if (eContainer instanceof ETypeParameter)
      {
        ETypeParameter eTypeParameter = (ETypeParameter)eContainer;
        synchronized (eTypeParameter)
        {
          @SuppressWarnings("unchecked") 
          Set<EGenericTypeImpl> eGenericTypes = (Set<EGenericTypeImpl>)(Set<?>)((ETypeParameterImpl)eTypeParameter).getEGenericTypes();
          for (EGenericTypeImpl eGenericType : eGenericTypes)
          {
            msgs = eGenericType.setERawType(eGenericType.getErasure(eTypeParameter), msgs);
          }
        }
      }
    }
    return msgs;
  }
  

  @Override
  public NotificationChain eBasicSetContainer(InternalEObject newContainer, int newContainerFeatureID, NotificationChain msgs)
  {
    msgs = super.eBasicSetContainer(newContainer, newContainerFeatureID, msgs);
    if (eTypeParameter != null && newContainer instanceof EStructuralFeature)
    {
      // When we attached we have to recompute the erasure of the type parameter.
      //
      EClassifier newERawType = getErasure(eTypeParameter);
      if (newERawType != eRawType)
      {
        msgs = setERawType(newERawType, msgs);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public EGenericType getELowerBound()
  {
    return eLowerBound;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetELowerBound(EGenericType newELowerBound, NotificationChain msgs)
  {
    EGenericType oldELowerBound = eLowerBound;
    eLowerBound = newELowerBound;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ELOWER_BOUND, oldELowerBound, newELowerBound);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public void setELowerBound(EGenericType newELowerBound)
  {
    if (newELowerBound != eLowerBound)
    {
      NotificationChain msgs = null;
      if (eLowerBound != null)
        msgs = ((InternalEObject)eLowerBound).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EcorePackage.EGENERIC_TYPE__ELOWER_BOUND, null, msgs);
      if (newELowerBound != null)
        msgs = ((InternalEObject)newELowerBound).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EcorePackage.EGENERIC_TYPE__ELOWER_BOUND, null, msgs);
      msgs = basicSetELowerBound(newELowerBound, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ELOWER_BOUND, newELowerBound, newELowerBound));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public ETypeParameter getETypeParameter()
  {
    return eTypeParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public NotificationChain basicSetETypeParameter(ETypeParameter newETypeParameter, NotificationChain msgs)
  {
    ETypeParameter oldETypeParameter = eTypeParameter;
    eTypeParameter = newETypeParameter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER, oldETypeParameter, newETypeParameter);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    if (oldETypeParameter != newETypeParameter)
    {
      if (newETypeParameter != null)
      {
        msgs = setERawType(getErasure(newETypeParameter), msgs);
      }
      else 
      {
        msgs = setERawType(eClassifier, msgs);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
public void setETypeParameter(ETypeParameter newETypeParameter)
  {
    if (newETypeParameter != eTypeParameter)
    {
      // Maintain a (weak hash) set on the type parameter of all referencing generic types.
      //
      if (eTypeParameter != null)
      {
        synchronized (eTypeParameter)
        {
          ((ETypeParameterImpl)eTypeParameter).getEGenericTypes().remove(this);
        }
      }
      if (newETypeParameter != null)
      {
        synchronized (newETypeParameter)
        {
          ((ETypeParameterImpl)newETypeParameter).getEGenericTypes().add(this);
        }
      }
      NotificationChain msgs = basicSetETypeParameter(newETypeParameter, null);
      if (msgs != null) 
      {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER, newETypeParameter, newETypeParameter));
    }
  }

  protected EClassifier getErasure(ETypeParameter eTypeParameter)
  {
    if (eTypeParameter == null)
    {
      return null;
    }
    else
    {
      boolean needEClass = eContainer instanceof EClass || eContainer instanceof EReference;
      boolean needEDataType = !needEClass && eContainer instanceof EAttribute;
      for (EGenericType eBound : eTypeParameter.getEBounds())
      {
        EClassifier eRawType = eBound.getERawType();
        if (needEClass ? eRawType instanceof EClass : needEDataType ? eRawType instanceof EDataType : eRawType!= null)
        {
          return eRawType;
        }
      }
      return needEClass ? EcorePackage.Literals.EOBJECT : EcorePackage.Literals.EJAVA_OBJECT;
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
public EClassifier getEClassifier()
  {
    if (eClassifier != null && eClassifier.eIsProxy())
    {
      InternalEObject oldEClassifier = (InternalEObject)eClassifier;
      eClassifier = (EClassifier)eResolveProxy(oldEClassifier);
      if (eClassifier != oldEClassifier)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, EcorePackage.EGENERIC_TYPE__ECLASSIFIER, oldEClassifier, eClassifier));
      }
    }
    return eClassifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClassifier basicGetEClassifier()
  {
    return eClassifier;
  }

  public NotificationChain setEClassifier(EClassifier newEClassifier, NotificationChain msgs)
  {
    EClassifier oldEClassifier = eClassifier;
    eClassifier = newEClassifier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = 
        new ENotificationImpl(this, Notification.SET, EcorePackage.EGENERIC_TYPE__ECLASSIFIER, oldEClassifier, eClassifier);
      if (msgs == null)
      {
        msgs = notification;
      }
      else
      {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
public void setEClassifier(EClassifier newEClassifier)
  {
    EClassifier oldEClassifier = eClassifier;
    NotificationChain msgs = setEClassifier(newEClassifier, null);
    if (oldEClassifier != newEClassifier && eTypeParameter == null)
    {
      msgs = setERawType(newEClassifier, msgs);
    }
    if (msgs != null)
    {
      msgs.dispatch();
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
public boolean isInstance(Object object)
  {
    // If there is type parameter...
    //
    ETypeParameter eTypeParameter = getETypeParameter();
    if (eTypeParameter != null)
    {
      // If the object isn't an instance of all of the bounds, then it's not an instance of this generic type.
      //
      EList<EGenericType> eBounds = eTypeParameter.getEBounds();
      for (EGenericType eBound : eBounds)
      {
        if (!eBound.isInstance(object))
        {
          return false;
        }
      }

      // No contradiction is found, so it must be an instance.
      //
      return true;
    }
    else
    {
      // If there is no classifier, or the object isn't an instance of that classifier, then it's not an instance of this generic type.
      //
      EClassifier eClassifier = getEClassifier();
      if (eClassifier == null || !eClassifier.isInstance(object))
      {
        return false;
      }
      else if (eClassifier instanceof EDataType)
      {
        // If we're dealing with a data type instance, we don't have more Ecore information about the instance so we must assume it's a proper instance.
        // We could consider using reified Java reflection for further checking.
        //
        return true;
      }
      else
      {
        // Otherwise we're dealing with an instance of an EClass.
        //
        EClass eClass = (EClass)eClassifier;

        // If the class has no type parameters, we're done.
        //
        EList<ETypeParameter> eTypeParameters = eClass.getETypeParameters();
        if (eTypeParameters.isEmpty())
        {
          return true;
        }
        else
        {
          // If the generic type has no corresponding arguments, we're done.
          //
          EList<EGenericType> eTypeArguments = getETypeArguments();
          int size = eTypeArguments.size();
          if (size == 0)
          {
            return true;
          }
          else
          {
            // The object is an instance of the eClass, so it must be an EObject.
            //
            EObject eObject = (EObject)object;
            EClass instanceEClass = eObject.eClass();

            // If the classes are the same, we're done.
            //
            if (eClass == instanceEClass)
            {
              return true;
            }
            else
            {
              // We must necessarily find the class among all the generic super types.
              //
              for (EGenericType eGenericSuperType : instanceEClass.getEAllGenericSuperTypes())
              {
                if (eGenericSuperType.getEClassifier() == eClass)
                {
                  // If it's specified as a raw type, we're done.
                  //
                  EList<EGenericType> instanceETypeArguments = eGenericSuperType.getETypeArguments();
                  if (instanceETypeArguments.isEmpty())
                  {
                    return true;
                  }
                  else
                  {
                    // Look for a contradiction between the type arguments of this generic type and the type arguments specified for the instance.
                    //
                    for (int i = 0; i < size; ++i)
                    {
                      EGenericType instanceETypeArgument = instanceETypeArguments.get(i);
                      EGenericType eTypeArgument = eTypeArguments.get(i);
                      EGenericType reifiedType = EcoreUtil.getReifiedType(instanceEClass, instanceETypeArgument);
                      if (eTypeArgument.getETypeParameter() == null ? !isCompatibleArgument(reifiedType, eTypeArgument) : !isSuperType(reifiedType, eTypeArgument))
                      {
                        return false;
                      }
                    }

                    return true;
                  }
                }
              }

              // We should not get here.
              //
              return false;
            }
          }
        }
      }
    }
  }

  private static boolean isSuperType(EGenericType eGenericType, EGenericType superEGenericType)
  {
    // If there is type parameter...
    //
    ETypeParameter eTypeParameter = superEGenericType.getETypeParameter();
    if (eTypeParameter != null)
    {
      // If the type is not a subtype of of all of the bounds, then it's not an subtype.
      //
      EList<EGenericType> eBounds = eTypeParameter.getEBounds();
      for (EGenericType eBound : eBounds)
      {
        if (!isSuperType(eGenericType, eBound))
        {
          return false;
        }
      }

      // No contradiction is found, so it subtype.
      //
      return true;
    }
    else
    {
      // If there is no classifier, we treat it as a type argument and check for compatibility.
      //
      EClassifier eClassifier = superEGenericType.getEClassifier();
      if (eClassifier == null)
      {
        return isCompatibleArgument(eGenericType, superEGenericType);
      }
      else
      {
        // If the type doesn't have a classifier, then it's not a subtype.
        //
        EClassifier eGenericTypeEClassifier = eGenericType.getEClassifier();
        if (eGenericTypeEClassifier == null)
        {
          return false;
        }
        else
        {
           // If both the instance classes are non-null, check Java assignability for them.
           //
           Class<?> instanceClass = eClassifier.getInstanceClass();
           Class<?> instanceTypeArgumentInstanceClass = eGenericTypeEClassifier.getInstanceClass();
           if (instanceClass != null && instanceTypeArgumentInstanceClass != null)
           {
//             if (!instanceClass.isAssignableFrom(instanceTypeArgumentInstanceClass))
               if (!EcoreUtil.isAssignableFrom(instanceTypeArgumentInstanceClass, instanceClass))
             {
               return false;
             }
           }
           // If their both EClasses, check Ecore super types.
           //
           else if (eClassifier instanceof EClass && eGenericTypeEClassifier instanceof EClass)
           {
             if (!((EClass)eClassifier).isSuperTypeOf((EClass)eGenericTypeEClassifier))
             {
               return false;
             }
           }
           else if (eClassifier != eGenericTypeEClassifier)
           {
             // Otherwise they're not compatible.
             //
             return false;
           }

          // If the class has no type parameters, we're done.
          //
          EList<ETypeParameter> eTypeParameters = eClassifier.getETypeParameters();
          if (eTypeParameters.isEmpty())
          {
            return true;
          }
          else
          {
            // If the generic type has no corresponding arguments, we're done.
            //
            EList<EGenericType> eTypeArguments = superEGenericType.getETypeArguments();
            int size = eTypeArguments.size();
            if (size == 0)
            {
              return true;
            }
            else if (eClassifier instanceof EDataType)
            {
              // If it's an EDataType, check that the arguments, if any, are compatible.
              //
              return isCompatibleArguments(eGenericType.getETypeArguments(), eTypeArguments);
            }
            else
            {
              // They are both EClasses...
              //
              EClass eClass = (EClass)eClassifier;
              EClass eGenericTypeEClass = (EClass)eGenericTypeEClassifier;

              // If the classes are the same, check that the type arguments, if any, are compatible.
              //
              if (eClass == eGenericTypeEClass)
              {
                return isCompatibleArguments(eGenericType.getETypeArguments(), eTypeArguments);
              }
              else
              {
                // We generally expect to find the class among all the generic super types.
                //
                for (EGenericType eGenericSuperType : eGenericTypeEClass.getEAllGenericSuperTypes())
                {
                  if (eGenericSuperType.getEClassifier() == eClass)
                  {
                    // If it's specified as a raw type, we're done.
                    //
                    EList<EGenericType> instanceETypeArguments = eGenericSuperType.getETypeArguments();
                    if (instanceETypeArguments.isEmpty())
                    {
                      return true;
                    }
                    else
                    {
                      // Look for a contradiction between the type arguments of this generic type and the type arguments specified for the instance.
                      //
                      for (int i = 0; i < size; ++i)
                      {
                        EGenericType instanceETypeArgument = instanceETypeArguments.get(i);
                        EGenericType eTypeArgument = eTypeArguments.get(i);
                        EGenericType reifiedType = EcoreUtil.getReifiedType(eGenericTypeEClass, instanceETypeArgument);
                        if (!isCompatibleArgument(reifiedType, eTypeArgument))
                        {
                          return false;
                        }
                      }

                      return true;
                    }
                  }
                }

                // We should not get here.
                //
                return true;
              }
            }
          }
        }
      }
    }
  }

  private static boolean isCompatibleArguments(EList<EGenericType> instanceETypeArguments, EList<EGenericType> eTypeArguments)
  {
    // Check any argument, if present, for compatibility.
    //
    int size = Math.min(instanceETypeArguments.size(), eTypeArguments.size());
    if (size > 0)
    {
      for (int i = 0; i < size; ++i)
      {
        if (!isCompatibleArgument(instanceETypeArguments.get(i), eTypeArguments.get(i)))
        {
          return false;
        }
      }
    }
    return true;
  }

  protected static boolean isCompatibleArgument(EGenericType instanceETypeArgument, EGenericType eTypeArgument)
  {
    // If the type argument specifies a type parameter...
    //
    ETypeParameter eTypeParameter = eTypeArgument.getETypeParameter();
    if (eTypeParameter != null)
    {
      // The instance type argument must not be incompatible with any of the type argument's bounds.
      //
      for (EGenericType eBound : eTypeParameter.getEBounds())
      {
        if (!isCompatibleArgument(instanceETypeArgument, eBound))
        {
          return false;
        }
      }
      return true;
    }
    else
    {
      // If the type argument specifies a classifier...
      //
      EClassifier eClassifier = eTypeArgument.getEClassifier();
      if (eClassifier != null)
      {
        // If the instance type argument specifies a classifier...
        //
        EClassifier instanceTypeArgumentEClassifier = instanceETypeArgument.getEClassifier();
        if (instanceTypeArgumentEClassifier != null)
        {
          // If they're the same classifier they're compatible...
          //
          if (eClassifier == instanceTypeArgumentEClassifier)
          {
            return isEqualArguments(instanceETypeArgument.getETypeArguments(), eTypeArgument.getETypeArguments());
          }
          else
          {
            // If both the instance classes are non-null, check Java assignability for them.
            //
            Class<?> instanceClass = eClassifier.getInstanceClass();
            Class<?> instanceTypeArgumentInstanceClass = instanceTypeArgumentEClassifier.getInstanceClass();
            if (instanceClass != null && instanceTypeArgumentInstanceClass != null)
            {
              // The arguments must be equal.
              //
              //return instanceClass.isAssignableFrom(instanceTypeArgumentInstanceClass) && isEqualArguments(instanceETypeArgument.getETypeArguments(), eTypeArgument.getETypeArguments());
              return EcoreUtil.isAssignableFrom(instanceTypeArgumentInstanceClass, instanceClass) && isEqualArguments(instanceETypeArgument.getETypeArguments(), eTypeArgument.getETypeArguments());
            }
            // If their both EClasses, check Ecore super types.
            //
            else if (eClassifier instanceof EClass && instanceTypeArgumentEClassifier instanceof EClass)
            {
              // The arguments must be equal.
              //
              return ((EClass)eClassifier).isSuperTypeOf((EClass)instanceTypeArgumentEClassifier) && isEqualArguments(instanceETypeArgument.getETypeArguments(), eTypeArgument.getETypeArguments());
            }
            else
            {
              // Otherwise they're not compatible.
              //
              return false;
            }
          }
        }
        else
        {
          // If the type argument specifies a type parameter...
          //
          ETypeParameter instanceTypeArgumentETypeParameter = instanceETypeArgument.getETypeParameter();
          if (instanceTypeArgumentETypeParameter != null)
          {
            // One of the bounds must be compatible...
            //
            for (EGenericType eBound : instanceTypeArgumentETypeParameter.getEBounds())
            {
              if (isCompatibleArgument(eBound, eTypeArgument))
              {
                return true;
              }
            }
            return false;
          }
          else
          {
            // It must be wildcard of some sort, but that's not valid.
            //
            return false;
          }
        }
      }
      else
      {
        EGenericType eLowerBound = eTypeArgument.getELowerBound();
        if (eLowerBound != null)
        {
          return isCompatibleArgument(eLowerBound, instanceETypeArgument);
        }
        else
        {
          EGenericType eUpperBound = eTypeArgument.getEUpperBound();
          if (eUpperBound != null)
          {
            return isCompatibleArgument(instanceETypeArgument, eUpperBound);
          }
          else
          {
            // An unbounded wildcard is compatible with anything.
            //
            return true;
          }
        }
      }
    }
  }

  protected static boolean isEqualArguments(EList<EGenericType> instanceETypeArguments, EList<EGenericType> eTypeArguments)
  {
    // Check all the arguments, if any, for equality.
    //
    int size = Math.min(instanceETypeArguments.size(), eTypeArguments.size());
    if (size != 0)
    {
      for (int i = 0; i < size; ++i)
      {
        if (!isEqualArgument(instanceETypeArguments.get(i), eTypeArguments.get(i)))
        {
          return false;
        }
      }
    }
    return true;
  }

  protected static boolean isEqualArgument(EGenericType eGenericType1, EGenericType eGenericType2)
  {
    // If they are the same instance they are equal.
    //
    if (eGenericType1 == eGenericType2)
    {
      return true;
    }
    // If one is null (but the other is not) then they are not equal.
    //
    else if (eGenericType1 == null || eGenericType2 == null)
    {
      return false;
    }
    else
    {
      // Consider the classifiers in a special way
      // to take into account the fact they they often acts as wrappers for instance type names
      // and that two classifiers that wrap the same instance type name should be considered equal.
      //
      EClassifier eClassifier1 = eGenericType1.getEClassifier();
      EClassifier eClassifier2 = eGenericType2.getEClassifier();

      // If they are the same classifier, they are of course equal.
      //
      if (eClassifier1 != eClassifier2)
      {
        // If they both aren't null...
        //
        if (eClassifier1 != null && eClassifier2 != null)
        {
          // Consider the instance type names they wrap
          // to see if they are non-null and equal.
          //
          String instanceTypeName1 = eClassifier1.getInstanceTypeName();
          String instanceTypeName2 = eClassifier2.getInstanceTypeName();

          // I.e., the classifiers are considered equal if they wrap the same non-null type.
          //
          if (instanceTypeName1 == null || !instanceTypeName1.equals(instanceTypeName2))
          {
            return false;
          }
        }
        // If one is null (but the other is not) then they can't be equal.
        //
        else if (eClassifier1 != null || eClassifier2 != null)
        {
          return false;
        }
      }

      // Type parameters are assumed to be equal.
      //
      ETypeParameter eTypeParameter1 = eGenericType1.getETypeParameter();
      ETypeParameter eTypeParameter2 = eGenericType2.getETypeParameter();
      if (eTypeParameter1 != null && eTypeParameter2 != null)
      {
        return true;
      }

      // The arguments, type parameters, lower bounds and upper bounds must be equal type arguments.
      //
      return
        isEqualArguments(eGenericType1.getETypeArguments(), eGenericType2.getETypeArguments()) &&
          isEqualArgument(eGenericType1.getELowerBound(), eGenericType2.getELowerBound()) &&
          isEqualArgument(eGenericType1.getEUpperBound(), eGenericType2.getEUpperBound());
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case EcorePackage.EGENERIC_TYPE__EUPPER_BOUND:
        return basicSetEUpperBound(null, msgs);
      case EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS:
        return ((InternalEList<?>)getETypeArguments()).basicRemove(otherEnd, msgs);
      case EcorePackage.EGENERIC_TYPE__ELOWER_BOUND:
        return basicSetELowerBound(null, msgs);
    }
    return eDynamicInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case EcorePackage.EGENERIC_TYPE__EUPPER_BOUND:
        return getEUpperBound();
      case EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS:
        return getETypeArguments();
      case EcorePackage.EGENERIC_TYPE__ERAW_TYPE:
        if (resolve) return getERawType();
        return basicGetERawType();
      case EcorePackage.EGENERIC_TYPE__ELOWER_BOUND:
        return getELowerBound();
      case EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER:
        return getETypeParameter();
      case EcorePackage.EGENERIC_TYPE__ECLASSIFIER:
        if (resolve) return getEClassifier();
        return basicGetEClassifier();
    }
    return eDynamicGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case EcorePackage.EGENERIC_TYPE__EUPPER_BOUND:
        setEUpperBound((EGenericType)newValue);
        return;
      case EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS:
        getETypeArguments().clear();
        getETypeArguments().addAll((Collection<? extends EGenericType>)newValue);
        return;
      case EcorePackage.EGENERIC_TYPE__ELOWER_BOUND:
        setELowerBound((EGenericType)newValue);
        return;
      case EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER:
        setETypeParameter((ETypeParameter)newValue);
        return;
      case EcorePackage.EGENERIC_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)newValue);
        return;
    }
    eDynamicSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case EcorePackage.EGENERIC_TYPE__EUPPER_BOUND:
        setEUpperBound((EGenericType)null);
        return;
      case EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS:
        getETypeArguments().clear();
        return;
      case EcorePackage.EGENERIC_TYPE__ELOWER_BOUND:
        setELowerBound((EGenericType)null);
        return;
      case EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER:
        setETypeParameter((ETypeParameter)null);
        return;
      case EcorePackage.EGENERIC_TYPE__ECLASSIFIER:
        setEClassifier((EClassifier)null);
        return;
    }
    eDynamicUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case EcorePackage.EGENERIC_TYPE__EUPPER_BOUND:
        return eUpperBound != null;
      case EcorePackage.EGENERIC_TYPE__ETYPE_ARGUMENTS:
        return eTypeArguments != null && !eTypeArguments.isEmpty();
      case EcorePackage.EGENERIC_TYPE__ERAW_TYPE:
        return eRawType != null;
      case EcorePackage.EGENERIC_TYPE__ELOWER_BOUND:
        return eLowerBound != null;
      case EcorePackage.EGENERIC_TYPE__ETYPE_PARAMETER:
        return eTypeParameter != null;
      case EcorePackage.EGENERIC_TYPE__ECLASSIFIER:
        return eClassifier != null;
    }
    return eDynamicIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException
  {
    switch (operationID)
    {
      case EcorePackage.EGENERIC_TYPE___IS_INSTANCE__OBJECT:
        return isInstance(arguments.get(0));
    }
    return eDynamicInvoke(operationID, arguments);
  }

  @Override
  public String toString()
  {
    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (expression: ");
    toString(result);
    result.append(')');
    return result.toString();
  }
  
  protected void toString(StringBuilder result)
  {
    if (eClassifier != null)
    {
      String label = eClassifier.getName();
      String tail = null;
      if (label != null)
      {
        result.append(label);
      }
      else
      {
        String instanceTypeName = eClassifier.getInstanceTypeName();
        if (instanceTypeName != null)
        {
          int index = instanceTypeName.indexOf('[');
          if (index != -1)
          {
            tail = instanceTypeName.substring(index);
            result.append(instanceTypeName, 0, index);
          }
          else
          {
            result.append(instanceTypeName);
          }
        }
      }
      
      if (eTypeArguments != null && !eTypeArguments.isEmpty())
      {
        boolean first = true;
        result.append('<');
        for (EGenericType eTypeArgument : eTypeArguments)
        {
          if (first)
          {
            first = false;
          }
          else
          {
            result.append(", ");
          }
          ((EGenericTypeImpl)eTypeArgument).toString(result);
        }
        result.append('>');
      }
      
      if (tail != null)
      {
        result.append(tail);
      }
    }
    else if (eTypeParameter != null)
    {
      String label = eTypeParameter.getName();
      if (label != null)
      {
        result.append(label);
      }
    }
    else
    {
      result.append('?');
      if (eLowerBound != null)
      {
        result.append(" super ");
        ((EGenericTypeImpl)eLowerBound).toString(result);
      }
      else
      {
        if (eUpperBound != null)
        {
          result.append(" extends ");
          ((EGenericTypeImpl)eUpperBound).toString(result);
        }
      }
    }
  }

} //EGenericTypeImpl
