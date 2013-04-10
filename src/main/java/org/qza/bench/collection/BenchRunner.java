package org.qza.bench.collection;

import java.util.Iterator;
import java.util.Map;

import org.qza.bench.collection.impl.BenchAdd;
import org.qza.bench.collection.impl.BenchContains;
import org.qza.bench.collection.impl.BenchSize;

public class BenchRunner {

	static String fileName = "src/main/resources/report-200000-200-segmentation-maxbytes-visited.txt";

	static String[] targets = {
			"http://www.amazon.com/LEGO-Ninjago-Venomari-Shrine-9440/dp/B005QUQ9BS",
			"http://www.amazon.com/Standards-Based-Physical-Education-Curriculum-Development/dp/0763771597",
			"http://www.amazon.com/Tulle-Spool-Yards-Packaging-Wedding-Favors/dp/B001NAUOR0" };

	public void runBenchContains(int runs) {
		System.out.println("\n\nBENCH CONTAINS\n\n");
		runBench(new BenchContains(fileName), runs);
	}

	public void runBenchAdd(int runs) {
		System.out.println("\n\nBENCH ADD\n\n");
		runBench(new BenchAdd(fileName), runs);
	}

	public void runBenchSize(int runs) {
		System.out.println("\n\nBENCH SIZE\n\n");
		runBench(new BenchSize(fileName), runs);
	}

	public void runBench(BenchBase bench, int runs) {
		for (int i = 0; i < targets.length; i++) {
			Map<String, Long> times = bench.benchAll(runs, targets[i]);
			for (Iterator<String> iterator = times.keySet().iterator(); iterator
					.hasNext();) {
				String collectionType = iterator.next();
				System.out.println(String.format("%25s \t~\t %d ns",
						collectionType, times.get(collectionType) / runs));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int runs = 10;
		System.out.println("NUMBER OF RUNS : " + runs);
		BenchRunner runner = new BenchRunner();
		runner.runBenchSize(runs);
		runner.runBenchContains(runs);
		runner.runBenchAdd(runs);
	}

}
