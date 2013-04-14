package org.qza.bench.collection.impl;

import java.util.Collection;

import org.qza.bench.collection.BenchBase;

public class BenchAdd extends BenchBase {

	public BenchAdd(String fileName) {
		super(fileName);
	}

	@Override
	protected void executeMethod(Collection<String> collection, String parameter, Collection<String> collectionParameter) {
		collection.add(parameter);
	}

}
