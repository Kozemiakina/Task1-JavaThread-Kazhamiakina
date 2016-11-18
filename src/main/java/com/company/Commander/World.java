package com.company.Commander;

import com.company.instance.Bus;
import com.company.instance.BusStop;
import com.company.instance.Passengers;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by alisa on 13.11.2016.
 * This class creates lists of entities
 */
public class World {
    private static final Logger log = Logger.getLogger(String.valueOf(World.class));
    private int busCount;
    private int busCapasityMin;
    private int busCapasityMax;
    private int busStopCount;
    private int manCount;
    private int interval;//interval between runs buses
    private int pause;//stay at bus stops
    List<BusStop> bus=new ArrayList<>();

    /**
     * Constructor
     * @param busStopCount
     * @param busCount
     * @param busCapasityMin
     * @param busCapasityMax
     * @param manCount
     * @param interval
     * @param pause
     */

    public World( int busStopCount,int busCount,int busCapasityMin,int busCapasityMax, int manCount,int interval,int pause) {
        this.busStopCount = busStopCount;
        this.busCount = busCount;
        this.busCapasityMin=busCapasityMin;
        this.busCapasityMax=busCapasityMax;
        this.manCount = manCount;
        this.interval=interval;
        this.pause=pause;
    }

    /**
     * Create a list of stops Method
     */

    public void GenerateBusStop(){
        int count=0;
        BusStop[] busStops=new BusStop[busStopCount];
        while (count!=busStopCount){
            busStops[count]=new BusStop(count);
            bus.add(busStops[count]);
            log.info("Bus stop № "+count+" was created");
            count++;
        }
    }

    /**
     * The method creates a list of buses
     * @return list of Bus
     */
    public List<Bus> GenerateBus(){
        List<Bus> busList=new ArrayList<>();
        int count=0;
        while (count!=busCount){
            busList.add(new Bus((int)(busCapasityMin+(Math.random()*(busCapasityMax-busCapasityMin))),bus,count,this.interval,this.pause));
            log.info("Bus № "+count+" was created");
            count++;
        }
        return busList;
    }

    /**
     * The method creates a list of passengers
     * @return list of passengers
     */
    public List<Passengers> GenerateMan(){
        List<Passengers> passengersList =new ArrayList<>();
        Random random=new Random();
        int count=0;
        while (count!=manCount){
            passengersList.add(new Passengers(bus.get(random.nextInt(busStopCount)),bus.get(random.nextInt(busStopCount)),count));
            log.info("Passengers № "+count+" was created");
            count++;
        }
        return passengersList;
    }
}
