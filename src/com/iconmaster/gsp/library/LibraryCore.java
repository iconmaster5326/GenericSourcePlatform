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
		
		DataType arrayInt = new DataType(TypeDef.ARRAY);
		arrayInt.params = new DataType[] {new DataType(TypeDef.INT)};
		
		DataType arrayReal = new DataType(TypeDef.ARRAY);
		arrayInt.params = new DataType[] {new DataType(TypeDef.REAL)};
		
		fn = Function.libraryFunction("range", new String[] {"begin","end"}, new Object[] {TypeDef.INT,TypeDef.INT}, arrayInt);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("range", new String[] {"begin","end","step"}, new Object[] {TypeDef.INT,TypeDef.INT,TypeDef.INT}, arrayInt);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("range", new String[] {"begin","end"}, new Object[] {TypeDef.REAL,TypeDef.REAL}, arrayReal);
		this.addFunction(fn);
		
		fn = Function.libraryFunction("range", new String[] {"begin","end","step"}, new Object[] {TypeDef.REAL,TypeDef.REAL,TypeDef.REAL}, arrayReal);
		this.addFunction(fn);
		
		iter = Iterator.libraryIterator("range", new String[] {"begin","end"}, new Object[] {TypeDef.INT,TypeDef.INT}, new Object[] {TypeDef.INT});
		this.addIterator(iter);
		
		iter = Iterator.libraryIterator("range", new String[] {"begin","end","step"}, new Object[] {TypeDef.INT,TypeDef.INT,TypeDef.INT}, new Object[] {TypeDef.INT});
		this.addIterator(iter);
		
		iter = Iterator.libraryIterator("range", new String[] {"begin","end"}, new Object[] {TypeDef.REAL,TypeDef.REAL}, new Object[] {TypeDef.REAL});
		this.addIterator(iter);
		
		iter = Iterator.libraryIterator("range", new String[] {"begin","end","step"}, new Object[] {TypeDef.REAL,TypeDef.REAL,TypeDef.REAL}, new Object[] {TypeDef.REAL});
		this.addIterator(iter);
	}
}
