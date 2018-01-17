package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[]result = new byte[4];
        for (int i = 0; i < ip.length ; i++) {
            int idtemp = (ip[i]&0xff);
            int masktemp = (mask[i]&0xff);
            result[i] = (byte) ((idtemp&masktemp& 0x80)==0?idtemp&masktemp:idtemp&masktemp-256);
        }
        return result;
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i <bytes.length ; i++) {
            String temp = Integer.toBinaryString(bytes[i]&0xff).toString();
            temp = String.format("%8s",temp).replace(" ","0");
            System.out.print(temp);
            System.out.print(" ");
        }
        System.out.println();
    }
}
