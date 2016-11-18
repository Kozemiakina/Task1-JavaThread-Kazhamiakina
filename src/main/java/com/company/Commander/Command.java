package com.company.Commander;

import com.company.instance.Passengers;
import com.company.instance.Bus;

import java.util.List;

/**
 * This class starts a thread for execution
 * Created by alisa on 16.11.2016.
 */
public class Command {
    /**
     * Constructor
     * @param busStopCount
     * @param busCount
     * @param busCapasityMin
     * @param busCapasityMax
     * @param manCount
     * @param interval
     * @param pause
     * @throws InterruptedException
     */
    public Command(int busStopCount, int busCount, int busCapasityMin, int busCapasityMax, int manCount,int interval,int pause) throws InterruptedException {
        StartTheWorld(busStopCount,busCount,busCapasityMin,busCapasityMax,manCount,interval,pause);
    }

    /**
     * The method starts a thread for execution
     * @param busStopCount
     * @param busCount
     * @param busCapasityMin
     * @param busCapasityMax
     * @param manCount
     * @param interval
     * @param pause
     * @throws InterruptedException
     */

    private void StartTheWorld(int busStopCount,int busCount,int busCapasityMin,int busCapasityMax,int manCount,int interval,int pause) throws InterruptedException {
        World world=new World(busStopCount,busCount,busCapasityMin,busCapasityMax,manCount,interval,pause);
        world.GenerateBusStop();
        List<Bus> busList=world.GenerateBus();
        List<Passengers> passengersList = world.GenerateMan();

        for (Passengers m: passengersList){
            m.start();
        }

        for (Bus b:busList){
            b.start();
        }
        for (Passengers m: passengersList){
            m.join();
        }

    }
}
