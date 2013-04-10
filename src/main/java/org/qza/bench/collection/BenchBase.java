package org.qza.bench.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class BenchBase {

	/*
	 * Collections
	 */
	protected List<String> arrayList = new ArrayList<String>();

	protected Set<String> hashSet = new HashSet<String>();

	protected Set<String> linkedHashSet = new LinkedHashSet<String>();

	protected Deque<String> linkedList = new LinkedList<String>();

	protected BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();

	protected List<Collection<String>> collections = new ArrayList<Collection<String>>();

	protected String dataFileName;

	public BenchBase(String dataFileName) {
		this.dataFileName = dataFileName;
		collections.add(arrayList);
		collections.add(hashSet);
		collections.add(linkedHashSet);
		collections.add(linkedList);
		collections.add(blockingQueue);
		this.loadAll(dataFileName);
	}

	protected String getName(Collection<String> collection) {
		return collection.getClass().getSimpleName();
	}

	/*
	 * Result times
	 */
	protected Map<String, Long> times = new HashMap<String, Long>();

	protected void addTime(Collection<String> col, Long time) {
		String name = getName(col);
		Long currentTime = times.get(name);
		if (currentTime == null)
			currentTime = 0L;
		times.put(name, currentTime + time);
	}

	public Map<String, Long> benchAll(int numberOfRuns, String parameter) {
		for (int i = 0; i < numberOfRuns; i++) {
			Iterator<Collection<String>> iterator = collections.iterator();
			while (iterator.hasNext()) {
				Collection<String> collection = iterator.next();
				addTime(collection, measure(collection, parameter));
			}
		}
		return times;
	}

	public void loadAll(String fileName) {
		Iterator<Collection<String>> iterator = collections.iterator();
		while (iterator.hasNext()) {
			Collection<String> collection = iterator.next();
			BenchUtil.loadData(fileName, collection);
		}
	}

	private long measure(Collection<String> collection, String parameter) {
		long start = System.nanoTime();
		executeMethod(collection, parameter);
		long end = System.nanoTime();
		collection.clear();
		return (end - start);
	}

	protected abstract void executeMethod(Collection<String> collection, String parameter);

}
