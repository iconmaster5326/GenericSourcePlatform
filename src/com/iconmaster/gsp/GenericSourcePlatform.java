package com.iconmaster.gsp;

import com.iconmaster.gsp.library.GenericLibrary;
import com.iconmaster.gsp.library.LibraryCore;
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
		//load all the default library packages:
		this.registerLibrary(new LibraryCore());
		
		//load your very own libraries:
		this.registerLibrary(new GenericLibrary());
		
		//load code transformers:
		
		//transforms.add(CompileUtils.iteratorReplacer); //if you want all iterators replaced with more generic for loops
		//transforms.add(CompileUtils.forEachReplacer); //if you want all SIL for-eaches replaced with for-ranges
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
	public String assemble(SourcePackage pkg) {
		return null; //return an object that represents the compiler output.
	}

	@Override
	public void run(SourcePackage pkg) {
		return; //interpret SIL here.
	}
	
}
