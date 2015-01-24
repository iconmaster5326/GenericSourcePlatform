package com.iconmaster.gsp;

import com.iconmaster.gsp.library.GenericLibrary;
import com.iconmaster.gsp.library.LibraryCore;
import com.iconmaster.source.assemble.AssembledOutput;
import com.iconmaster.source.link.Platform;
import com.iconmaster.source.link.platform.PlatformLoader.LoadedPlatform;
import com.iconmaster.source.prototype.SourcePackage;

/**
 *
 * @author iconmaster
 */
@LoadedPlatform
public class GenericSourcePlatform extends Platform {
	
	public GenericSourcePlatform() {
		this.name = "GenericSourcePlatform"; //Your name is important!
		
		//load all the default library packages:
		this.registerLibrary(new LibraryCore());
		
		//load your very own libraries:
		this.registerLibrary(new GenericLibrary());
		
		//load code transformers:
		
		//transforms.add(CompileUtils.iteratorReplacer); //if you want all non-system iterators inlined
		//transforms.add(CompileUtils.gotoReplacer); //if you want ALL SIL branches/loops replaced with SIL GOTOs
	}

	@Override
	public boolean canAssemble() {
		return false; //switch to true if your platform compiles (Example: LLVM).
	}

	@Override
	public boolean canRun() {
		return false; //switch to true if your platform interprets (Example: SourceBox).
	}

	@Override
	public AssembledOutput assemble(SourcePackage pkg) {
		return null; //return a new GenericOutput that represents the compiler output.
	}

	@Override
	public Object run(SourcePackage pkg) {
		return null; //interpret SIL here.
	}
	
}
