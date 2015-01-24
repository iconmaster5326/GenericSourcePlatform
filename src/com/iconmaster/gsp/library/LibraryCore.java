package com.iconmaster.gsp.library;

import com.iconmaster.source.compile.DataType;
import com.iconmaster.source.prototype.Field;
import com.iconmaster.source.prototype.Function;
import com.iconmaster.source.prototype.Iterator;
import com.iconmaster.source.prototype.ParamTypeDef;
import com.iconmaster.source.prototype.SourcePackage;
import com.iconmaster.source.prototype.TypeDef;
import java.util.ArrayList;

/**
 *
 * @author iconmaster
 */
public class LibraryCore extends SourcePackage {
	
	public static TypeDef[] INT_TYPES = new TypeDef[] {TypeDef.INT8, TypeDef.INT16, TypeDef.INT32, TypeDef.INT64};
	public static TypeDef[] REAL_TYPES = new TypeDef[] {TypeDef.REAL32, TypeDef.REAL64};
	public static TypeDef[] MATH_TYPES = new TypeDef[] {TypeDef.INT8, TypeDef.INT16, TypeDef.INT32, TypeDef.INT64, TypeDef.REAL32, TypeDef.REAL64};
	public static TypeDef[] MATH_TYPES_EXT = new TypeDef[] {TypeDef.INT8, TypeDef.INT16, TypeDef.INT32, TypeDef.INT64, TypeDef.REAL32, TypeDef.REAL64,TypeDef.INT,TypeDef.REAL,TypeDef.CHAR};
	
	public static String[] MATH_OPS = new String[] {"_add","_sub","_mul","_div","_mod","_pow"};
	public static String[] BIT_OPS = new String[] {"_bit_and","_bit_or"};
	public static String[] BOOL_OPS = new String[] {"_eq","_neq","_lt","_gt","_le","_ge","_and","_or"};
	
	public LibraryCore() {
		this.name = "core";
		
		//Add all the base data types in core:
		TypeDef.addBaseTypes(this);
		
		//define list parameter types here, becuse it's kind of complex:
		DataType ltdt = new DataType(TypeDef.LIST); //this is list[T]
		TypeDef ltt = new ParamTypeDef("T", 0); //this is T
		ltdt.params = new DataType[] {new DataType(ltt)};
		DataType atdt = new DataType(TypeDef.ARRAY); //this is array[T]
		ltdt.params = new DataType[] {new DataType(ltt)};
		
		Function fn;
		Field f;
		Iterator iter;
		
		fn = Function.libraryFunction("print", new String[] {"item"}, new Object[] {TypeDef.UNKNOWN}, null);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("input", new String[] {}, new Object[] {}, TypeDef.STRING);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("error", new String[] {}, new Object[] {}, null);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("error", new String[] {"msg"}, new Object[] {TypeDef.UNKNOWN}, null);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("ifte", new String[] {"cond","then","else"}, new Object[] {TypeDef.BOOLEAN,ltt,ltt}, ltt);
		fn.rawParams = new ArrayList<>();
		fn.rawParams.add(new Field("T"));
		this.addFunction(fn);
		
		fn = Function.libraryFunction("typeof", new String[] {"item"}, new Object[] {TypeDef.UNKNOWN}, null);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("sizeof", new String[] {"item"}, new Object[] {TypeDef.UNKNOWN}, null);
		this.addFunction(fn);
		
		for (TypeDef type : MATH_TYPES) {
			DataType array = new DataType(TypeDef.ARRAY);
			array.params = new DataType[] {new DataType(type)};
			
			fn = Function.libraryFunction("range", new String[] {"begin","end"}, new Object[] {type,type}, array);
			this.addFunction(fn);
			
			fn = Function.libraryFunction("range", new String[] {"begin","end","step"}, new Object[] {type,type,type}, array);
			this.addFunction(fn);
			
			iter = Iterator.libraryIterator("range", new String[] {"begin","end"}, new Object[] {type,type}, new Object[] {type});
			this.addIterator(iter);
		
			iter = Iterator.libraryIterator("range", new String[] {"begin","end","step"}, new Object[] {type,type,type}, new Object[] {type});
			this.addIterator(iter);
		}
		
		for (TypeDef type : MATH_TYPES) {
			for (String op : MATH_OPS) {
				fn = Function.libraryFunction(type.name+"."+op, new String[] {"a1","a2"}, new Object[] {type,type}, type);
				this.addFunction(fn);
			}
		}
		
		for (TypeDef type : MATH_TYPES) {
			for (String op : BOOL_OPS) {
				fn = Function.libraryFunction(type.name+"."+op, new String[] {"a1","a2"}, new Object[] {type,type}, TypeDef.BOOLEAN);
				this.addFunction(fn);
			}
		}
		
		for (TypeDef type : INT_TYPES) {
			for (String op : BIT_OPS) {
				fn = Function.libraryFunction(type.name+"."+op, new String[] {"a1","a2"}, new Object[] {type,type}, type);
				this.addFunction(fn);
			}
		}
		
		fn = Function.libraryFunction("?._concat", new String[] {"a1","a2"}, new Object[] {TypeDef.UNKNOWN,TypeDef.UNKNOWN}, TypeDef.STRING);
		this.addFunction(fn);
		
		for (TypeDef type1 : MATH_TYPES_EXT) {
			for (TypeDef type2 : MATH_TYPES_EXT) {
				if (type1!=type2) {
					fn = Function.libraryFunction(type1.name+"._cast", new String[] {"from","to"}, new Object[] {type1,type2}, type2);
					this.addFunction(fn);
				}
			}
		}
	}
}
