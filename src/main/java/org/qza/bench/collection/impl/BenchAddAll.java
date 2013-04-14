package org.qza.bench.collection.impl;

import java.util.Collection;

import org.qza.bench.collection.BenchBase;

public class BenchAddAll extends BenchBase {

	public BenchAddAll(String fileName) {
		super(fileName);
	}

	@Override
	protected void executeMethod(Collection<String> collection,
			String parameter, Collection<String> collectionParameter) {
		collection.addAll(collectionParameter);
	}

}
