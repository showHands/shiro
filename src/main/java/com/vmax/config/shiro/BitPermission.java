package com.vmax.config.shiro;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.Permission;

public class BitPermission implements Permission {

    private String resourceIdentify ;
    private int permissionBit ;
    private String instanceId ;

    /**
     * 解析位移方式的权限+user+10+1
     * @param permissionString
     */
    public BitPermission(String permissionString){
        String[] array = permissionString.split("\\+") ;
        if(array.length > 1){
            resourceIdentify = array[1] ;
        }
        if(StringUtils.isBlank(resourceIdentify)){
            resourceIdentify = "*" ;
        }
        if(array.length > 2){
            permissionBit = Integer.valueOf(array[2]) ;
        }
        if(array.length > 3){
            instanceId = array[3] ;
        }
        if(StringUtils.isEmpty(instanceId)){
            instanceId = "*" ;
        }
    }

    @Override
    public boolean implies(Permission permission) {
        if(!(permission instanceof BitPermission)){
            return false ;
        }
        BitPermission other = (BitPermission) permission;
        if(!"*".equals(this.resourceIdentify)){
            return false ;
        }
        if(!(this.permissionBit == 0 || (this.permissionBit & other.permissionBit)!= 0 )){
            return false ;
        }
        return true;
    }
}
