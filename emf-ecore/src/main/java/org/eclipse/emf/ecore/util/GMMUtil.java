package org.eclipse.emf.ecore.util;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;

public class GMMUtil {

	public static final String UMLPrimitiveTypesURI = "pathmap://UML_LIBRARIES/UMLPrimitiveTypes.library.uml";
	
	public static String getRootUUID (EObject eObject)
	  {
		  return getUUID(EcoreUtil.getRootContainer(eObject));
	  }
	  
	  public static String getUUID (EObject eObject)
	  {
		  try
		  {
			  final EAnnotation eAnnotation = ((EModelElement)eObject).getEAnnotation("genmymodel");
			  
			  return eAnnotation == null ? null : eAnnotation.getDetails().get("uuid");  
		  }
		  catch(ClassCastException exception)
		  {
			  return null;
		  }
	  }
	  
	  public static void setUUID (EObject eObject)
	  {
		  setUUID (eObject, EcoreUtil.generateUUID());
	  }
	  
	  public static void setUUID (EObject eObject, String uuid)
	  {
		  // TOOO : is casting to EModelElement type safe ?
		  EModelElement modelElement = (EModelElement) eObject;

		  EAnnotation eAnnotation = modelElement.getEAnnotation("genmymodel");
		  
		  if (eAnnotation == null)
		  {
			  eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			  eAnnotation.setSource("genmymodel");
			  modelElement.getEAnnotations().add(eAnnotation);
		  }
		  
		  //TODO : check if existing uuid ?
		  /*if (eAnnotation.getDetails().contains("uuid"))
			  throw new Throwable("Trying to set UUID on modelElement with existing UUID !");*/
		  
		  eAnnotation.getDetails().put("uuid", uuid);
		  
	  }
	  
	  public static EAnnotation getGenMyModelAnnotation(EModelElement element)
	  {
		  EAnnotation eAnnotation = element.getEAnnotation("genmymodel");
		  
		  if (eAnnotation == null)
		  {
			  eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			  eAnnotation.setSource("genmymodel");
			  element.getEAnnotations().add(eAnnotation);
		  }
		  
		  return eAnnotation;
	  }
}
