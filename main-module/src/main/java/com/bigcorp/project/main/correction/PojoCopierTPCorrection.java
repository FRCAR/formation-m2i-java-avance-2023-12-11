package com.bigcorp.project.main.correction;

import java.lang.reflect.Method;

/**
 * Démonstration de la réflexion
 */
public class PojoCopierTPCorrection {

	public static void main(String[] args) throws Exception {

		System.out.println("Récupération des infos de child via getters");
		Child child = new Child("José", 10);
		readChild(child);

		Child otherChild = new Child();
		System.out.println("Copie des informations de child vers otherChild");
		copyChild(child, otherChild);

		System.out.println("Récupération des infos de otherChild via getters");
		readChild(otherChild);

	}

	/**
	 * Copy par réflexion (en utilisant les getters et setters) les informations de
	 * childFrom vers childTo
	 * 
	 * @param childFrom
	 * @param childTo
	 * @throws Exception
	 */
	private static void copyChild(Child childFrom, Child childTo) throws Exception {
		Class<Child> reflectionClass = Child.class;
		for (Method method : reflectionClass.getMethods()) {
			if (method.getParameters().length == 0
					&& method.getName().startsWith("get")) {

				String setterName = method.getName().replaceFirst("get", "set");
				Class<?> getterReturnType = method.getReturnType();

				Method setterMethod = null;
				try {
					setterMethod = reflectionClass.getMethod(setterName, getterReturnType);
				} catch (Exception e) {
				}
				if (setterMethod == null) {
					continue;
				}

				setterMethod.invoke(childTo, method.invoke(childFrom));

			}
		}

	}

	/**
	 * Affiche via les getters les informations de child
	 * 
	 * @param child
	 * @throws Exception
	 */
	private static void readChild(Child child) throws Exception {
		Class<Child> reflectionClass = Child.class;

		// Appel des getters
		for (Method method : reflectionClass.getMethods()) {
			if (method.getParameters().length == 0
					&& method.getName().startsWith("get")) {
				System.out.println("Appel du getter: "
						+ method.getName()
						+ "() , valeur : "
						+ method.invoke(child));
			}
		}

	}

}
