package com.vmax.shiro;

import junit.framework.Assert;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.SimpleByteSource;
import org.junit.Test;

import java.security.Key;

public class EncodeDecodeTest {

    @Test
    public void Base64Test(){
        String str = "hello";
        String base64Encoded = Base64.encodeToString(str.getBytes());
        String str2 = Base64.decodeToString(base64Encoded);
        System.out.println(base64Encoded);
        System.out.println(str2);
        System.out.println(str.equals(str2));
    }

    @Test
    public void addSaleTest(){
        String str = "hello" ;
        String salt = "123" ;
        String simpleHash = new SimpleHash("md5", str, salt).toString() ;
        System.out.println(simpleHash);
    }

    @Test
    public void hashServiceTest(){
       /* DefaultHashService hashService = new DefaultHashService(); //默认算法 SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setPrivateSalt(new SimpleByteSource("123")); //私盐，默认无
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认 false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成 公盐。默认就这个
        hashService.setHashIterations(1); //生成 Hash 值的迭代次数

        HashRequest request = new HashRequest.Builder().setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))             .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build(); String hex = hashService.computeHash(request).toHex();*/

        SecureRandomNumberGenerator randomNumberGenerator =      new SecureRandomNumberGenerator();
        randomNumberGenerator.setSeed("123".getBytes());
        String hex = randomNumberGenerator.nextBytes().toHex();
        System.out.println(hex);
    }

    /**
     * 对称加密
     */
    @Test
    public void  cipherTest(){
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置 key 长度 //生成 key
        Key key = aesCipherService.generateNewKey(); String text = "hello"; //加密
        String encrptText =  aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex(); //解密
        String text2 =  new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());
        System.out.println(text2);
        System.out.println(text);

    }
}
