package com.bigcorp.project.main.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Démonstration de la réflexion
 */
public class Reflection {

	private String name = "Salut !!";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		//récupération d'une instance de Class
		Class<Reflection> reflectionClass = (Class<Reflection>) Class.forName("com.bigcorp.project.main.reflection.Reflection");
		
		//Parcours des méthodes de la classe par réflexion
		for (Method method : reflectionClass.getMethods()) {
			System.out.println("Méthode : " + method.getName() + " trouvée ");
			if (method.getParameters().length == 0) {
				System.out.println("Cette méthode n'a pas d'argument");
			}
			for (Parameter parameter : method.getParameters()) {
				System.out.println("Cette méthode a l'argument : " + parameter.getName());
			}
		}
		
		//Instanciation dynamique de méthode
		Reflection reflectionInstance = reflectionClass.getConstructor(new Class<?>[0]).newInstance(new Object[0]);
		System.out.println("Appel de getName() sur une instance construite par réflexion.");
		System.out.println(reflectionInstance.getName());
		System.out.println("Appel de getName par réflexion sur une instance construite par réflexion.");
		Method getNameMethod = reflectionClass.getMethod("getName", new Class<?>[0]);
		Object returnedValue = getNameMethod.invoke(reflectionInstance, new Object[0]);
		System.out.println(returnedValue);
		
	}

}
