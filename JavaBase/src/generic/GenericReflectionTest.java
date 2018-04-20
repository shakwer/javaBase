package generic;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest {
	public static void main(String[] args) {
		String name;
		if(args.length>0)name=args[0];
		else {
			Scanner in =new Scanner(System.in);
			System.out.println("Enter a class name (e.g Java.util.Collections):");
			name=in.next();
		}
		
		try {
			Class<?>c1=Class.forName(name);
			printClass(c1);
			for(Method m:c1.getDeclaredMethods()) {
				printMethod(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	
	public static void printClass(Class<?>c) {
		System.out.println(c);
		printTypes(c.getTypeParameters(), "<", ", ", ">", true);
		Type sc=c.getGenericSuperclass();
		
		if(sc!=null) {
			System.out.println(" extends ");
			printType(sc, false);
		}
		printTypes(c.getGenericInterfaces(), " implements", ", ", "", false);
		
	}
	
	public static void printMethod(Method m) {
		String name =m.getName();
		System.out.println(Modifier.toString(m.getModifiers()));
		System.out.println("");
		printTypes(m.getParameterTypes(), "<", ", ", ">", true);
		
		printType(m.getGenericReturnType(), false);
		System.out.println("");
		System.out.println(name);
		System.out.println("(");
		printTypes(m.getGenericParameterTypes(), "", ", ", "", false);
		System.out.println(")");
	}
	
	public static void printTypes(Type[]types,String pre, String sep,String suf,boolean isDefinition) {
		if(pre.equals("extends")&&Arrays.equals(types, new Type[] {Object.class}))return;
		if(types.length>0) System.out.println(pre);
		for(int i=0;i<types.length;i++) {
			if(i>0)System.out.println(sep);
			printType(types[i],isDefinition);
		}
		if(types.length>0)System.out.println(suf);
	}
	
	
	public static void printType(Type type, boolean isDefinition) {
		if(type instanceof Class) {
			Class<?> t=(Class<?>)type;
			System.out.println(t.getName());
		}else if (type instanceof TypeVariable) {
			TypeVariable<?>t=(TypeVariable<?>)type;
			System.out.println(t.getName());
			if(isDefinition) {
				printTypes(t.getBounds(), " extends ", " & ", "", false);
			}
		}else if (type instanceof WildcardType) {
			WildcardType t=(WildcardType)type;
			System.out.println("?");
			printTypes(t.getUpperBounds(), " extends ", " & ", "", false);
			printTypes(t.getLowerBounds(), " extends ", " & ", "", false);
		}else if (type instanceof ParameterizedType) {
			ParameterizedType t=(ParameterizedType)type;
			Type owner=t.getOwnerType();
			if(owner==null) {
				printType(owner, false);
				System.out.println(".");
			}
			printType(t.getRawType(), false);
			printTypes(t.getActualTypeArguments(), "<", ", ", ">", false);
		}else if (type instanceof GenericArrayType) {
			GenericArrayType t=(GenericArrayType)type;
			System.out.println("");
			printType(t.getGenericComponentType(), isDefinition);
			System.out.println("[]");
		}
	}
}
