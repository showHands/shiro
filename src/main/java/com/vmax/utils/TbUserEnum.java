package com.vmax.utils;

public enum TbUserEnum {

    IDENTIFIER_ADMINSTRATOR(1, "超级管理员", true) ,
    IDENTIFIER_COMMENUSER(2, "普通用户", false) ;

    private int nIdentifier ;
    private String strDescription ;
    private boolean isAdminstrotor ;


    TbUserEnum(int nIdentifier, String strDescription, boolean isAdminstrotor) {
        this.nIdentifier = nIdentifier;
        this.strDescription = strDescription;
        this.isAdminstrotor = isAdminstrotor;
    }

    public int getnIdentifier() {
        return nIdentifier;
    }

    public void setnIdentifier(int nIdentifier) {
        this.nIdentifier = nIdentifier;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public boolean isAdminstrotor() {
        return isAdminstrotor;
    }

    public void setAdminstrotor(boolean adminstrotor) {
        isAdminstrotor = adminstrotor;
    }
}
