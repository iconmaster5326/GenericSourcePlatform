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
		this.name = "core"; //the name of your library. The one named "core" doesn't need explicitly imported.
		
		//Add all the base data types in core:
		TypeDef.addBaseTypes(this);
		
		//define list parameter types here, becuse it's kind of complex:
		DataType ltdt = new DataType(TypeDef.LIST); //this is list[T]
		TypeDef ltt = new ParamTypeDef("T", 0); //this is T
		ltdt.params = new DataType[] {new DataType(ltt)};
		
		//add functions:
		Function fn;
		
		fn = Function.libraryFunction("print", new String[] {"item"}, new TypeDef[] {TypeDef.UNKNOWN}, null);
		this.addFunction(fn);
		
		//add iterators:
		Iterator iter;

		iter = Iterator.libraryIterator("list.pairs", new String[] {"lst"}, new Object[] {ltdt}, new Object[] {TypeDef.INT, ltt});
		iter.rawParams = new ArrayList<>();
		iter.rawParams.add(new Field("T"));
		this.addIterator(iter);
	}
}
