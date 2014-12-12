package com.iconmaster.gsp.library;

import com.iconmaster.source.compile.DataType;
import com.iconmaster.source.compile.Operation;
import static com.iconmaster.source.link.platform.hppl.LibraryCore.listIndexFn;
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
		this.addType(TypeDef.UNKNOWN);
		this.addType(TypeDef.REAL);
		this.addType(TypeDef.STRING);
		this.addType(TypeDef.LIST);
		this.addType(TypeDef.INT);
		this.addType(TypeDef.BOOLEAN);
		
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
		
		//here's list.pairs in full SIL, just for you:
		iter = Iterator.libraryIterator("list.pairs", new String[] {"lst"}, new Object[] {ltdt}, new Object[] {TypeDef.INT, ltt});
		iter.rawParams = new ArrayList<>();
		iter.rawParams.add(new Field("T"));
		ArrayList<Operation> pairsOps = new ArrayList<>();
		pairsOps.add(new Operation(Operation.OpType.BEGIN));
		pairsOps.add(new Operation(Operation.OpType.DEF, TypeDef.INT, null, "R1"));
		pairsOps.add(new Operation(Operation.OpType.DEF, TypeDef.INT, null, "R2"));
		pairsOps.add(new Operation(Operation.OpType.DEF, ltt, null, "R3"));
		pairsOps.add(new Operation(Operation.OpType.DO));
		pairsOps.add(new Operation(Operation.OpType.CALL, TypeDef.INT, null, "R2","list.size","lst"));
		pairsOps.add(new Operation(Operation.OpType.MOVN, TypeDef.INT, null, "R1", "1"));
		pairsOps.add(new Operation(Operation.OpType.FORR, TypeDef.INT, null, "R0", "1", "R1", "R2"));
		pairsOps.add(new Operation(Operation.OpType.CALL, ltt, null, "R0", listIndexFn.getFullName(), "R1", "R2")); //TODO: Make this not use a direct name
		pairsOps.add(new Operation(Operation.OpType.RET, ltt, null, "R0", "R3"));
		pairsOps.add(new Operation(Operation.OpType.ENDB));
		pairsOps.add(new Operation(Operation.OpType.END));
		iter.setCompiled(pairsOps);
		this.addIterator(iter);
	}
}
