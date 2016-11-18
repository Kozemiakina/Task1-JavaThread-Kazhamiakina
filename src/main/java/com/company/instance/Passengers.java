package com.company.instance;

import org.apache.log4j.Logger;


/**
 * This class describes the passenger
 * Created by alisa on 30.10.2016.
 */
public class Passengers extends Thread{
    private static final Logger log = Logger.getLogger(String.valueOf(BusStop.class));
    private int idPassengers;
    private BusStop startBussStop;
    private BusStop finishBussStop;

    /**
     * Constructor
     * @param startBussStop
     * @param finishBussStop
     * @param idPassengers
     */
    public Passengers(BusStop startBussStop, BusStop finishBussStop, int idPassengers){
        this.startBussStop=startBussStop;
        this.finishBussStop=finishBussStop;
        this.idPassengers = idPassengers;
    }

    /**
     * Start the passengers
     */
    @Override
    public void run() {
        this.startBussStop.waitForBus(this.idPassengers).waitForStop(this.finishBussStop,this.idPassengers);
        log.info("Passengers № "+ idPassengers +" arrived at № "+this.finishBussStop.getIdBusStop());
    }
}

