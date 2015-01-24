package com.iconmaster.gsp;

import com.iconmaster.source.assemble.AssembledOutput;

/**
 * This is a generic implementation of AssembledOutput that simply writes a string to a file.
 * @author iconmaster
 */
public class GenericOutput extends AssembledOutput {
	public String output;

	public GenericOutput(String output) {
		this.output = output;
	}

	@Override
	public String getOutputString() {
		return output;
	}
}
