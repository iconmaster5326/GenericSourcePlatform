package com.iconmaster.gsp.library;

import com.iconmaster.source.prototype.Field;
import com.iconmaster.source.prototype.Function;
import com.iconmaster.source.prototype.Iterator;
import com.iconmaster.source.prototype.SourcePackage;
import com.iconmaster.source.prototype.TypeDef;

/**
 *
 * @author iconmaster
 */
public class LibraryMath extends SourcePackage {
	
	public LibraryMath() {
		this.name = "math";
		
		Function fn;
		Field f;
		Iterator iter;
		
		for (TypeDef type : LibraryCore.MATH_TYPES) {
			fn = Function.libraryFunction("abs", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type.name+".abs", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("min", new String[] {"n1","n2"}, new Object[] {type,type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("max", new String[] {"n1","n2"}, new Object[] {type,type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
		}
		
		for (TypeDef type : LibraryCore.REAL_TYPES) {
			fn = Function.libraryFunction("exp", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("ln", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("log", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("logb", new String[] {"n","b"}, new Object[] {type,type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("sin", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("cos", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("tan", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("asin", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("acos", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("atan", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("sinh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("cosh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("tanh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("asinh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("acosh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("atanh", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("ceil", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("floor", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("round", new String[] {"n","d"}, new Object[] {type,TypeDef.INT}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type+".ceil", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type+".floor", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type+".round", new String[] {"n","d"}, new Object[] {type,TypeDef.INT}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("rad", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction("deg", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type+".rad", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
			
			fn = Function.libraryFunction(type+".deg", new String[] {"n"}, new Object[] {type}, type);
			fn.getDirectives().add("pure");
			this.addFunction(fn);
		}
		
		f = Field.libraryField("pi", TypeDef.REAL);
		this.addField(f);
		
		f = Field.libraryField("e", TypeDef.REAL);
		this.addField(f);
	}
}
