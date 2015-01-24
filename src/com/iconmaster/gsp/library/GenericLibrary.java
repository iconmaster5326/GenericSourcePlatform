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
public class GenericLibrary extends SourcePackage {
	
	public static TypeDef myType = new TypeDef("myType",TypeDef.UNKNOWN); //your custom data type

	public GenericLibrary() {
		this.name = "myLib"; //the name of your library. The one named "core" doesn't need explicitly imported.
		
		//add new data types:
		this.addType(myType);
		
		Function fn;
		Field f;
		Iterator iter;
		
		//add functions:
		fn = Function.libraryFunction("myFunc", new String[] {"arg1","arg2","arg3"}, new Object[] {TypeDef.UNKNOWN,TypeDef.UNKNOWN,TypeDef.UNKNOWN}, TypeDef.UNKNOWN);
		this.addFunction(fn);
		
		//add fields:
		f = Field.libraryField("myField", TypeDef.INT);
		this.addField(f);
		
		//add iterators:
		iter = Iterator.libraryIterator("myIter", new String[] {"lst"}, new Object[] {TypeDef.UNKNOWN}, new Object[] {TypeDef.UNKNOWN});
		this.addIterator(iter);
	}
}
