package com.vmax.utils;

public enum TbUserStateEmum {

    //1注册通过待审核 2审核失败 3审核成功 4临时冻结',
    STATE_WAITING_AUDIT(1, "注册通过待审核", false) ,
    STATE_AUDIT_FAILURE(2, "审核失败", false) ,
    STATE_AUDIT_SUCCESS(3, "3审核成功", true) ,
    STATE_FROZEN(4, "临时冻结", false) ;

    private int nState ;
    private String strDescription ;
    private boolean isOk ;

    TbUserStateEmum(int nState, String strDescription, boolean isOk) {
        this.nState = nState;
        this.strDescription = strDescription;
        this.isOk = isOk;
    }

    public int getnState() {
        return nState;
    }

    public void setnState(int nState) {
        this.nState = nState;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }
}
