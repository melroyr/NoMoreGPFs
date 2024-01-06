package com.myco.stockcenter.simple.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class ScheduledExecutorServiceDemo {

	private Task runnableTask;
	private CallableTask callableTask;
	private void execute() {
		System.out.println("In execute");
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		getTasksToRun().apply(executorService);
		executorService.shutdown();
		System.out.println("Out execute");
	}

	private void executeWithMultiThread() {
		System.out.println("In executeWithMultiThread");
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
		getTasksToRun().apply(executorService);
		executorService.shutdown();
		System.out.println("Out executeWithMultiThread");
	}

	private Function<ScheduledExecutorService, Void> getTasksToRun() {
		System.out.println("In getTasksToRun");
		runnableTask = new Task();
		callableTask = new CallableTask();

		return (executorService -> {
			Future<String> resultFuture = executorService.schedule(callableTask, 1, TimeUnit.SECONDS);
			executorService.scheduleAtFixedRate( runnableTask, 100, 450, TimeUnit.SECONDS);
			executorService.scheduleWithFixedDelay( runnableTask, 100, 150, TimeUnit.SECONDS);
			return null;
		});
	}

//	public static void main(String... args) {
//		ScheduledExecutorServiceDemo demo = new ScheduledExecutorServiceDemo();
//		//demo.execute();
//		demo.executeWithMultiThread();
//	}

}
