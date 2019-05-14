package cn.zd.bootproj.cycleTask;

/**
 * @author : Zhao Da
 * @since : 2019/5/14 10:05
 */
public class Task {

    private int cycleNum;

    private TaskInterface function;

    public int getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(int cycleNum) {
        this.cycleNum = cycleNum;
    }

    public TaskInterface getFunction() {
        return function;
    }

    public void setFunction(TaskInterface function) {
        this.function = function;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
