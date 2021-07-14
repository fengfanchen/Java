package cn.it1995;

import cn.it1995.http.HttpCallback;
import cn.it1995.http.HttpServer;
import cn.it1995.tool.AES;
import cn.it1995.tool.DH;
import cn.it1995.tool.DataSecret;
import cn.it1995.tool.RSA;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class Main {

    private static final String PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCjuN97tkBc0QcKGU9oXydaQN7q" +
            "wZnThxTOmdIc8O1yuA9FrDZpZ3Sz908vTqM/YPZkOUaYrGwsBO7FeQovoX7nQPKu" +
            "YQpRDqt7OKzhwPavyynH0Jz38PDyCBw45zwl4Ux8BtsggTrGVxAqNjO4KkuyL1QS" +
            "8amn4Fzl1CBre8Y0gQIDAQAB";

    private static final String PRI_KEY = "MIICdAIBADANBgkqhkiG9w0BAQEFAASCAl4wggJaAgEAAoGBAKO433u2QFzRBwoZ" +
            "T2hfJ1pA3urBmdOHFM6Z0hzw7XK4D0WsNmlndLP3Ty9Ooz9g9mQ5RpisbCwE7sV5" +
            "Ci+hfudA8q5hClEOq3s4rOHA9q/LKcfQnPfw8PIIHDjnPCXhTHwG2yCBOsZXECo2" +
            "M7gqS7IvVBLxqafgXOXUIGt7xjSBAgMBAAECgYAgp0uzcdsOaAY+ZmPnDitcHdoX" +
            "+jsC7EsjFZzJduf03G73V2yWwzKMfkPFzKpUhrM9tAq3gpQkh2tT6Vs1usEDbrDd" +
            "e08Cc3D5YWK7HuTfO3kkJTSNOK0JfuT1UQaTjCmDQWWjPmYbu6UN0UDv4Mo26dgl" +
            "cp9h0wlaPsSFN3O97QJBANgj+4i7ABAdbTuUfq6Tcr38E7wYSFTUeL5jTd4sO636" +
            "+KJ6zx4uTXAmxnt9OdIY1ihLRqDh8VbiorqOelGf6iMCQQDB6jZver3mTMe6ntSY" +
            "hx3JWOCDM3ULkPvOWGrAcRsNKjyIuo37taXa7fuqmVQQq9MJYikJfilMhkgwkV/X" +
            "ihcLAkBsOvBskj9A0ottJzmcT4dIbR6wtHQbzl078NwAIaQsxZyVN+vY0BTE0RXY" +
            "pmc6tmcevDr8uscv28Liqg/EKdCDAkAjL9C44djblUsYvgFtu/bXtlzm8ctnUeOf" +
            "ScP1L5DtDqD1XoStDAUQeOaVykTK0aL1rO4tXss3q5Yl2fs+LTyJAj8f7N5kzw08" +
            "9S5OWCHoEm5UOeAvjFh//cjXi6lyqetBW3w17muZ2OumUAbKJXksyzmT6/QRpkX3" +
            "S0w/tqdJXLs=";

    private static final String HANDHAKE = "handshake";

    public static void main(String[] args) throws UnsupportedEncodingException {

//        String content = "123456";
//        String encrypted = RSA.encrypt(content, PUB_KEY);
//        System.out.println(encrypted);
//        System.out.println(RSA.decrypt(encrypted, PRI_KEY));

        //查密钥
//        DH dhC = new DH();
//        DH dhS = new DH();
//
//        int publicKeyC = dhC.getPublicKey();
//        int publicKeyS = dhS.getPublicKey();
//
//        byte[] secretC = dhC.getSecretKey(publicKeyS);
//        byte[] secretS = dhS.getSecretKey(publicKeyC);
//
//        System.out.println("client's secrete is : ");
//        for(byte i : secretC){
//
//            System.out.print(i + " ");
//        }
//        System.out.println("\nserver's secrete is : ");
//        for(byte i : secretS){
//
//            System.out.print(i + " ");
//        }


//        AES aes = new AES();
//        byte[] encrypted = aes.encrypt(content);
//        System.out.println(new String(encrypted));
//        byte[] decrypt = aes.decrypt(encrypted);
//        System.out.println(new String(decrypt));
//
        System.out.println("start http server");
        HttpServer server = new HttpServer(new HttpCallback() {

            private DH mDh = new DH();
            private AES mAes = new AES();

            @Override
            public byte[] onResponse(String request) {

                if(isHandshake(request)){

                    //握手
                    Map<String, String> header = HttpServer.getHeader(request);
                    String handshake = header.get(HANDHAKE);
                    System.out.println("Handshake为:" + handshake);
                    int dhPubKey = Integer.valueOf(RSA.decrypt(handshake, PRI_KEY));

                    //设置为AES密钥
                    mAes.setKey(mDh.getSecretKey(dhPubKey));
                    System.out.println("解密后，客户端dhPubKey："  + dhPubKey);

                    return DataSecret.int2Byte(mDh.getPublicKey());
                }

                byte[] result = mAes.encrypt("Hello World");
                return result;
            }
        });

        server.startHttpServer();
    }

    private static boolean isHandshake(String request){

        return (request != null && request.contains(HANDHAKE));
    }


}
