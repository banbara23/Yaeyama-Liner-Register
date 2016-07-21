package com.ikmr.banbara23.yaeyama_liner_register.entity;

public class LinerRecordInfo {
    LinerRecord linerRecordLef;
    LinerRecord linerRecordRight;

    public LinerRecord getLinerRecordLef() {
        return linerRecordLef;
    }

    public void setLinerRecordLef(LinerRecord linerRecordLef) {
        this.linerRecordLef = linerRecordLef;
    }

    public LinerRecord getLinerRecordRight() {
        return linerRecordRight;
    }

    public void setLinerRecordRight(LinerRecord linerRecordRight) {
        this.linerRecordRight = linerRecordRight;
    }

    @Override
    public String toString() {
        return "LinerRecordInfo{" +
                "linerRecordLef=" + linerRecordLef +
                ", linerRecordRight=" + linerRecordRight +
                '}';
    }
}
