package com.company;

import com.company.Commander.Command;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("inter");
        int busStopCount,busCount,busCapasityMin,busCapasityMax,manCount,interval,pause;
        busStopCount= Integer.parseInt(resourceBundle.getString("busStopCount"));
        busCount=Integer.parseInt(resourceBundle.getString("busCount"));
        busCapasityMin=Integer.parseInt(resourceBundle.getString("busCapasityMin"));
        busCapasityMax=Integer.parseInt(resourceBundle.getString("busCapasityMax"));
        manCount=Integer.parseInt(resourceBundle.getString("manCount"));
        interval=Integer.parseInt(resourceBundle.getString("interval"));
        pause=Integer.parseInt(resourceBundle.getString("pause"));
        /*Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of stops");
        busStopCount=scanner.nextInt();
        System.out.println("Enter the number of buses");
        busCount=scanner.nextInt();
        System.out.println("Enter the minimum bus capacitance");
        busCapasityMin=scanner.nextInt();
        System.out.println("Enter the maximum bus capacitance");
        busCapasityMax=scanner.nextInt();
        System.out.println("Enter the number of passengers");
        manCount=scanner.nextInt();
        System.out.println("Enter the interval between runs buses");
        interval=scanner.nextInt();
        System.out.println("Enter stay at bus stops");
        pause=scanner.nextInt();*/
        Command command=new Command(busStopCount,busCount,busCapasityMin,busCapasityMax,manCount,interval,pause);

    }

}
