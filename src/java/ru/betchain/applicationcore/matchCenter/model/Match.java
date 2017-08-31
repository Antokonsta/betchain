package ru.betchain.applicationcore.matchCenter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Anton on 24.08.17.
 */
@Entity
@Table(name = "matches")
public class Match {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "leftTeam")
    private String left;
    @Column(name = "rightTeam")
    private String right;
    @Column(name = "leftRes")
    private int leftRes;
    @Column(name = "rightRes")
    private int rightRes;
    @Column(name = "finished")
    private boolean finished;
    @Column(name = "date")
    private String date;
    @Column(name = "leftPic")
    private String leftPic;
    @Column(name = "rightPic")
    private String rightPic;

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

    public String getLeftPic() {
        return leftPic;
    }

    public void setLeftPic(String leftPic) {
        this.leftPic = leftPic;
    }

    public String getRightPic() {
        return rightPic;
    }

    public void setRightPic(String rightPic) {
        this.rightPic = rightPic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return date + " " + left + " " + leftRes + " : " + rightRes + " " + right + ", finished=" + finished;
    }
}
