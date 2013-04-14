package org.qza.bench.collection.impl;

import java.util.Collection;
import org.qza.bench.collection.BenchBase;

public class BenchContains extends BenchBase {

	public BenchContains(String fileName) {
		super(fileName);
	}

	@Override
	protected void executeMethod(Collection<String> collection, String parameter, Collection<String> collectionParameter) {
		collection.contains(parameter);
	}

}
