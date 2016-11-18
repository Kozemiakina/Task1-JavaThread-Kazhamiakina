package com.company.instance;

import org.apache.log4j.Logger;


/**
 * This class describes the Bus Stop
 * Created by alisa on 02.11.2016.
 */
public class BusStop {
    private static final Logger log = Logger.getLogger(String.valueOf(BusStop.class));
    private int idBusStop;
    private Bus bus;

    /**
     * Constructor
     * @param idBusStop
     */
    public BusStop(int idBusStop) {
        this.idBusStop = idBusStop;
    }

    /**
     * Method set Bus
     * @param bus
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

    /**
     * Method get  id Bus Stop
     * @return
     */
    public int getIdBusStop() {
        return idBusStop;
    }

    /**
     * Checks if bus came and launches passengers
     * @param idMan
     * @return
     */
    public synchronized Bus waitForBus(int idMan) {
        Bus b=null;
        while (b==null){
            try {
                this.wait();
                log.info("Passengers № "+idMan+" waiting for a bus at the bus stop № "+this.idBusStop);
                b=bus;
                if(!b.inter(idMan)){
                    b=null;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return b;
    }
    /**
     *It awakens bus
     */
    public synchronized void busArrived(){
        notifyAll();
    }
}
