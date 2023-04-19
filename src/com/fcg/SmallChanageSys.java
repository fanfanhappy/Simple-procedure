package com.fcg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChanageSys {
    public static void main(String[] args) {

        boolean loop = true;//定义loop变量的好处，方便设计do-while循环的退出
        Scanner scanner = new Scanner(System.in);
        String key = "";

        //收益入账
        //收益入账的实现用字符串的拼接实现 定义details

        String details = "------------零钱通明细------------\n";
        //入账
        double money = 0;//入账金额
        double balance = 0;
        //消费
        String place = "";//消费地点
        double consumeMoney = 0;//消费金额
        //获得时间和更改时间形式
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");


        do {

            System.out.println("======零钱通菜单======");
            System.out.println("\t\t\t1   零钱通明细");
            System.out.println("\t\t\t2   收益入账");
            System.out.println("\t\t\t3   消费明细");
            System.out.println("\t\t\t4   退   出");
            System.out.println("---------------------");
            System.out.print("请输入（1-4） ");
            key = scanner.next();

            //判断
            switch(key)
            {
                case "1" :
                {
                    System.out.println(details);
                    break;
                }
                case "2" :
                {
                    System.out.print("收益入账金额： ");
                    money = scanner.nextDouble();
                    //输入金额的校验,校验先使用不符合条件的方式检验更好

                    if(money <= 0)
                    {
                        System.out.println("输入的金额应该大于零。。。");
                        break;
                    }
                        balance += money;
                        //零钱通明细更新
                        date = new Date();//获取当前时间
                        details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
                        break;
                }
                case "3" :
                {
                    System.out.print("消费地点： ");
                    place = scanner.next();
                    System.out.print("消费金额： ");
                    consumeMoney = scanner.nextDouble();
                    //检验消费金额是否超过余额
                   if(consumeMoney > balance)
                   {
                       System.out.println("你输入的消费金额超出余额，错误。。。。");
                       break;
                   }
                        //更新余额
                        balance -= consumeMoney;
                        //更新零钱通明细
                        date = new Date();
                        details += "\n" + place + "\t-" + consumeMoney + "\t" + sdf.format(date) + "\t" + "余额：" + balance;
                        break;
                }
                case "4" :
                {
                    String choies = "";
                    //循环判断输入的是否为 y/n  一个小模块完成一个小功能
                    while(true)
                    {
                        System.out.print("你确定要退出吗？ y/n : ");
                        choies = scanner.next();
                        if("y".equals(choies) || "n".equals(choies))
                        {
                            break;
                        }
                            System.out.println("请输入正确的 y/n");
                    }

                    if(choies.equals("y"))
                    {
                        loop = false;
                    }
                    break;
                }
                default :
                {
                    System.out.println("输入选项有误   请重新输入");
                }
            }

        }while(loop);
        System.out.println("------退出了零钱通项目------");
    }
}
