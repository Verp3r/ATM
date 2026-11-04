//小肥鱼自助银行
package com.verp3r.atm;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AtmMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int yu_e = 1000;//定义初始余额
        boolean flag = true;//定义一个布尔类型的变量，用来返回到程序总循环
        String zhmima = "123456";//账户密码
        int mima2 = 666666;//存取款密码

        //程序总循环
        for (int i = 1; i <= 5; i++){
            System.out.println("登录");
            System.out.println("=================");
            System.out.println("请输入账户名");
            String name = sc.next();
            System.out.println("请输入账户密码");
            String mima1 = sc.next();

            //密码正确
            if(zhmima.equals(mima1) && "admin".equals(name)){
                System.out.println("登陆成功");
                flag = true;

                //菜单主循环
                while (flag) {
                    System.out.println("====================");
                    System.out.println("主菜单");
                    System.out.println("1.查询余额");
                    System.out.println("2.存款");
                    System.out.println("3.取款");
                    System.out.println("4.修改密码");
                    System.out.println("5.退出");
                    System.out.println("====================");

                    System.out.println("请输入选项");//选择选项，功能
                    int num = sc.nextInt();
                    switch (num) {
                        case 1:
                            System.out.println("您的余额为：" + yu_e);
                            break;
                        case 2:
                            //验证存取款密码循环
                            for (int e =1; e <= 5; e++){
                                System.out.println("请输入存取款密码");
                                int m1 = sc.nextInt();
                                //判断密码是否正确
                                if(m1 == mima2){
                                    //验证存款金额循环
                                    for (int c = 1; c <=5; c++){
                                        System.out.println("请输入你要存款的金额");
                                        int cunkuan = sc.nextInt();
                                        //if的作用是判断密码是否正确和存款金额是否恰当
                                        if (c == 5) {
                                            System.out.println("账户异常,请重新验证存取款密码");
                                            System.out.println("====================");
                                            e = 0;   //防止在e等于4时输对密码从而导致返回时e=5结束循环和确保每次验证都有5次机会
                                            break;  //结束前面一个for循环回到重新输入存取款密码环节
                                        } else if (cunkuan <= 0 && c == 1) {
                                            System.out.println("存款金额必须大于0，存款金额错误5次需重新验证存取款密码");
                                        } else if (cunkuan <= 0 && c >= 2) {
                                            System.out.println("存款金额必须大于0," + "已错误" + c + "次");
                                        } else {
                                            yu_e = yu_e + cunkuan;
                                            System.out.println("存款成功");
                                            System.out.println("余额为：" + yu_e);
                                            e += 5;  //退出验证存取款密码循环for
                                            break;  //推出验证存款金额循环
                                        }
                                    }
                                } else if (e == 5) {
                                    System.out.println("账号异常请重新登录");
                                    flag = false;  //退出菜单主循环
                                    i = 0;  //防止在i等于4时输对密码从而导致返回程序总循环时i=5结束循环和确保每次登录都有5次机会
                                } else {
                                    System.out.println("密码错误，已错误" + e + "次");
                                }
                            }
                            break;
                        case 3:
                            //这里的所有循环以及退出循环的使用与存款时同理，还有判断
                            for (int f =1; f <= 5; f++){
                                System.out.println("请输入存取款密码");
                                int m2 = sc.nextInt();
                                if(m2 == mima2){
                                    for (int d = 1; d <=5; d++){
                                        System.out.println("请输入你要取款的金额");
                                        int qukuan = sc.nextInt();
                                        if (d == 5) {
                                            System.out.println("账户异常,请重新验证存取款密码");
                                            f = 0;
                                            break;
                                        } else if ((qukuan <= 0 || qukuan > yu_e) && d == 1) {
                                            System.out.println("取款金额必须大于0且小于余额，取款金额错误5次需重新验证存取款密码");
                                        } else if ((qukuan <= 0 || qukuan > yu_e) && d >= 2) {
                                            System.out.println("取款金额必须大于0且小于余额," + "已错误" + d + "次");
                                        } else {
                                            yu_e = yu_e - qukuan;
                                            System.out.println("取款成功");
                                            System.out.println("余额为：" + yu_e);
                                            f += 5;
                                            break;
                                        }
                                    }
                                } else if (f == 5) {
                                    System.out.println("账号异常请重新登录");
                                    flag = false;
                                    i = 0;
                                } else {
                                    System.out.println("密码错误，已错误" + f + "次");
                                }
                            }
                            break;
                        case 4:
                            System.out.println("1.更改账户密码");
                            System.out.println("2.更改存取款密码");
                            System.out.println("请选择要修改密码的类型");
                            int num1 =sc.nextInt();

                            boolean flag1 = true;

                            while (flag1) {
                                switch (num1){
                                    case 1:
                                        for(int a = 1; a <= 5; a++){
                                            System.out.println("请输入账户密码");
                                            String mima1_ =sc.next();
                                            if (mima1_.equals(zhmima)) {
                                                System.out.println("请输入新的账户密码");
                                                String genggaimima1 = sc.next();
                                                boolean flag2 = true;
                                                while (flag2) {
                                                    System.out.println("请再次输入");
                                                    String genggaimima1_ = sc.next();
                                                    if (genggaimima1.equals(genggaimima1_)) {
                                                        System.out.println("更改成功");
                                                        zhmima = genggaimima1;
                                                        flag2 = false;
                                                        flag1 = false;
                                                        a += 6;
                                                    }else {
                                                        System.out.println("请重新输入");
                                                    }
                                                }
                                            }else if (a == 5) {
                                                System.out.println("账户异常，请重新登录");
                                                flag1 = false;
                                                flag = false;
                                                i = 0;
                                                break;
                                            }else {
                                                System.out.println("密码错误，已错误" + a + "次");
                                            }
                                        }
                                        break;
                                    case 2:
                                        for(int b = 1; b <= 5; b++) {
                                            System.out.println("请输入存取款密码");
                                            int mima2_ = sc.nextInt();
                                            if (mima2_ == mima2) {
                                                System.out.println("请输入新的存取款密码");
                                                int genggaimima2 = sc.nextInt();

                                                boolean flag3 = true;
                                                while (flag3) {
                                                    System.out.println("请再次输入");
                                                    int genggaimima2_ = sc.nextInt();
                                                    if (genggaimima2_ == genggaimima2) {
                                                        System.out.println("更改成功");
                                                        mima2 = genggaimima2_;
                                                        flag3 = false;
                                                        flag1 = false;
                                                        b += 6;
                                                    } else {
                                                        System.out.println("请重新输入");
                                                    }
                                                }
                                            } else if (b == 5) {
                                                System.out.println("账户异常，请重新登录");
                                                flag1 = false;
                                                flag = false;
                                                i = 0;
                                                break;
                                            } else {
                                                System.out.println("密码错误，已错误" + b + "次");
                                            }
                                        }
                                    default:
                                        flag1 = false;
                                        break;
                                }
                            }
                            break;
                        case 5:
                            i = 0;
                            flag = false;
                            break;
                        default:
                            System.out.println("请输入正确的选项");
                    }
                }
                //密码错误1次
            } else if(i == 1) {
                System.out.println("密码错误，错误5次账户将锁定");
                //密码错误第i次
            }else {
                System.out.println("密码错误，已错误" + i +"次");
            }
            //密码错误第五次，直接结束程序
            if (i == 5) {
                System.out.println("账户异常已锁定");
                break;
            }
        }
    }
}
