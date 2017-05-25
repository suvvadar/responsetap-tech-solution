package com.rao.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

    @Component
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public class CounterEvents {

 /*       private IAtomicLong numberOfEvents;

        @Autowired
        HazelcastInstance hazelcastInstance;

        @PostConstruct
        public void init(){
            numberOfEvents = hazelcastInstance.getAtomicLong("CounterEvents");
        }

        public long counting(){
            return numberOfEvents.incrementAndGet();
        }

        public long getNumberOfEvents(){
            return numberOfEvents.get();
        }

        public void resetCounter(){
            numberOfEvents.set(0);
        }*/

    }

