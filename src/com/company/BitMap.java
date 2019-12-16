package com.company;

public class BitMap {
    int[] data;
    int n;

    public BitMap(int maxOfValue) {
        this.n = maxOfValue/32+1;
        this.data = new int[n];
    }

    public void add(int num){
        int index=num>>5;//等同于index=num/32
        int local=num&31;//等同于index=num%32
        data[index]|=1<<local;
        System.out.println("BitMap中添加了"+num);
    }

    public boolean find(int num){
        int index=num>>5;
        int local=num&31;
        int i = data[index]&1<<local;
        if (i == 0) {
            return false;
        }else return true;
    }

    public void delete(int num){
        int index=num>>5;
        int local=num&31;
        data[index]&=~(1 << local);//将local位置0，其他位置1，再和原数据按位与
        System.out.println("BitMap中删除了"+num);
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(97);
        System.out.println("34是否存在："+bitMap.find(34));
        bitMap.add(34);
        System.out.println("34是否存在："+bitMap.find(34));
        bitMap.add(78);
        System.out.println("78是否存在："+bitMap.find(78));
        bitMap.delete(78);
        System.out.println("78是否存在："+bitMap.find(78));
    }
}
