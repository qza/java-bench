package org.qza.bench.collection.impl;

import java.util.Collection;

import org.qza.bench.collection.BenchBase;

public class BenchSize extends BenchBase {

	public BenchSize(String fileName) {
		super(fileName);
	}

	@Override
	protected void executeMethod(Collection<String> collection, String parameter, Collection<String> collectionParameter) {
		collection.size();
	}

}
