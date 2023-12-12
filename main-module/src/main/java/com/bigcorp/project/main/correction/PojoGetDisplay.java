package com.bigcorp.project.main.correction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PojoGetDisplay {

	private static final String GETTER_PREFIX = "get";

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Child valentin = new Child("Valentin", 12);
		
		invokeGetters(valentin);
		
		invokeGetters(new AutrePojo(3, "jacquot", Boolean.TRUE));
		
	}

	/**
	 * Invoque tous les getters de Object
	 * @param object
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private static void invokeGetters(Object object) throws IllegalAccessException
		, IllegalArgumentException, InvocationTargetException {
		Class<? extends Object> clazz = object.getClass();
		//Itération sur toutes les méthodes déclarées de la classe
		for(Method method : clazz.getDeclaredMethods()) {
			//Filtre pour récupérer les getters
			String methodName = method.getName();
			if(methodName.startsWith(GETTER_PREFIX)) {
				String attributeName = methodName.toLowerCase();
				attributeName = attributeName.substring(3);
				Object invokeResult = method.invoke(object, new Object[0]);
				System.out.println("Le résultat de l'invocation de : "
						+ methodName + " sur l'objet vaut : " + invokeResult);
				
			}
		}
	}

}
