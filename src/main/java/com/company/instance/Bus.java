package com.company.instance;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

/**
 * This class describes the bus
 * Created by alisa on 30.10.2016.
 */
public class Bus extends Thread{
    private static final Logger log = Logger.getLogger(String.valueOf(BusStop.class));
    private int idBus;
    private int capaсity;
    private int count;//count the passengers in bus
    private BusStop stop;//bus stop
    private List<BusStop> route;
    private int interval;//interval between runs buses
    private int pause;//stay at bus stops

    /**
     * Constructor
     * @param capaсity
     * @param route
     * @param idBus
     * @param interval
     * @param pause
     */
    public Bus(int capaсity,List<BusStop> route,int idBus,int interval,int pause) {
        this.capaсity=capaсity;
        this.route=route;
        this.idBus=idBus;
        this.interval=interval;
        this.pause=pause;
        setDaemon(true);
    }

    /**
     * the method get Stop
     * @return
     */
    public BusStop getStop() {
        return stop;
    }

    /**
     * The method starts in a passenger bus
     * @param idPassengers
     * @return
     */
    public synchronized boolean inter(int idPassengers){//сел ли посажир
        if(count<capaсity){
            count++;
            log.info(idPassengers+" entered in bus");
            return true;
        }
        log.info("Passengers № "+idPassengers+" wants to enter in bus,but bus № "+this.idBus+" is full");
        return false;
    }

    /**
     * The method produces a passenger from a bus
     */
    public void leave(){
        this.count--;
    }

    /**
     * Passengers waiting for their stop
     * @param s
     * @param idPassengers
     */
    public synchronized void waitForStop(BusStop s,int idPassengers){
        while (true){
            try {
                wait();
                log.info("Passengers № "+idPassengers+" waiting for a bus stop № "+s.getIdBusStop()+" in the bus № "+this.idBus);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(s==this.getStop()){
                this.leave();
                return;
            }
        }
    }

    /**
     *It awakens bus
     */
    public synchronized void arrived(){
        this.notifyAll();
    }

    /**
     * Starts bus
     */
    @Override
    public void run() {
        try {
            this.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Iterator<BusStop> i=this.route.iterator();
        while (true){
            if(!i.hasNext()){
                i=this.route.iterator();
            }
            BusStop b=i.next();
            b.setBus(this);
            this.stop=b;
            try {
                this.sleep(pause);
                this.arrived();
                this.stop.busArrived();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

