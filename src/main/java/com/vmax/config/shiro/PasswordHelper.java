package com.vmax.config.shiro;

import com.vmax.entity.Tbuser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator() ;
    private String algorithmName = "md5" ;
    private final int hashIterations = 2 ;

    public void encrypPassword(Tbuser tbuser) {
        tbuser.setStrsalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, tbuser.getStrpassword(), ByteSource.Util.bytes(tbuser.getCredentialsSalt()), hashIterations).toHex() ;
        tbuser.setStrpassword(newPassword);
    }
}
