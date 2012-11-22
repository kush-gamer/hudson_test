
package com.mango.games.rummy.logic.common.timers;

import java.io.Serializable;

public class Trigger implements Serializable {

    /**
     * Version Id
     */
    private static final long serialVersionUID = 1L;

    private final TriggerType type;
    private long pid = 0;
    private int seq = -1;

    public Trigger(TriggerType type) {
        this.type = type;
    }

    public Trigger(TriggerType type, long pid) {
        this.type = type;
        this.pid = pid;
    }

    public String toString() {
        return "pid[" + pid + "] type[" + type + "] seq[" + seq + "]";
    }

    public long getPid() {
        return pid;
    }

    public TriggerType getType() {
        return type;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
