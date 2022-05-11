package com.niu.controller;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class ShowHashCode {

    public static void main(String[] args) {
        try {
            Thread.sleep(4100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ShowHashCode a = new ShowHashCode();
        //jvm的信息
        System.out.println(VM.current().details());
        System.out.println("-------------------------");
        //调用之前打印a对象的头信息
        //以表格的形式打印对象布局
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        System.out.println("-------------------------");
        //调用后再打印a对象的hashcode值
//        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        System.out.println("-------------------------");
        //有线程A变轻量级锁
        new Thread(() -> {
            try {
                synchronized (a) {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        try {
            Thread.sleep(5200);
        } catch (InterruptedException e) {
        }
        System.out.println("-------------------------");
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        System.out.println("-------------------------");
        //在线程A的sleep中再创建一个线程B来竞争a的锁，在sleep执行过程中会自旋，超过10次获取不到锁的话升级为重量级锁
        new Thread(() -> {
            try {
                synchronized (a) {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
//        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        //在线程A的sleep中再创建一个线程B来竞争a的锁，在sleep执行过程中会自旋，超过10次获取不到锁的话升级为重量级锁
        new Thread(() -> {
            try {
                synchronized (a) {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
//        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
        }
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        new Thread(() -> {
            try {
                synchronized (a) {
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
//        System.out.println(Integer.toHexString(a.hashCode()));
        System.out.println(ClassLayout.parseInstance(a).toPrintable());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}