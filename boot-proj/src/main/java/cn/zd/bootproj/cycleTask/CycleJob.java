package cn.zd.bootproj.cycleTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author : Zhao Da
 * @since : 2019/5/14 10:01
 */
@Component
public class CycleJob {

    @Scheduled(cron = "* * * * * ?")
    public void execute(){
        if (RealTAction.currentIndex == RealTAction.cycleArray.length - 1) {
            RealTAction.currentIndex = 0;
        }
        RealTAction.currentIndex ++;
        Set<Task> currentSet = RealTAction.cycleArray[RealTAction.currentIndex];
        for (Task task : currentSet) {
            if (task.getCycleNum() > 0) {
                task.setFunction(() -> {System.out.println("飞吧");});
                task.setCycleNum(task.getCycleNum() - 1);
            } else {
                task.getFunction().call();
                currentSet.remove(task);
            }
        }
    }
}
