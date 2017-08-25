package ru.betchain.applicationcore.matchCenter.vo;

/**
 * Created by Anton on 24.08.17.
 */
public class Match {
    private String left;
    private String right;
    private int leftRes;
    private int rightRes;
    private boolean finished;
    private String date;

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    public int getLeftRes() {
        return leftRes;
    }

    public void setLeftRes(int leftRes) {
        this.leftRes = leftRes;
    }

    public int getRightRes() {
        return rightRes;
    }

    public void setRightRes(int rightRes) {
        this.rightRes = rightRes;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return date + " " + left + " " + leftRes + " : " + rightRes + " " + right + ", finished=" + finished;
    }
}
