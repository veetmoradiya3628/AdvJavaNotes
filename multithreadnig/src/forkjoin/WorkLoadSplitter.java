package forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class WorkLoadSplitter extends RecursiveAction {
    private final long workload;

    public WorkLoadSplitter(long workload) {
        this.workload = workload;
    }

    @Override
    protected void compute() {
        if(workload > 16){
            System.out.println("Work load too big, thus spitting, workload : " + workload);
            long fistWorkload = workload / 2;
            long secondWorkload = workload - fistWorkload;

            WorkLoadSplitter firstSplit = new WorkLoadSplitter(fistWorkload);
            WorkLoadSplitter secondSplit = new WorkLoadSplitter(secondWorkload);

            firstSplit.fork();
            secondSplit.fork();

        }else{
            System.out.println("Work load within the limits!, Tasks being executed for workload : " + workload);
        }
    }
}
class WorkLoadSplitDemo {
    public static void main(String[] args) {
        try(ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors())){
            WorkLoadSplitter splitter = new WorkLoadSplitter(128);
            pool.invoke(splitter);
        }
    }
}