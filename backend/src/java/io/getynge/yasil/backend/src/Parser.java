package io.getynge.yasil.backend.src;

import java.util.HashMap;
import java.util.Vector;

public class Parser extends AParser<String, Long, Integer, String, String> {
    
    private Vector tokens;
    private HashMap locationsByName;
    
    Parser(
            ASenderRecieverPair<String> argSendSourceToExecutor,
            ASenderRecieverPair<Integer> argSendLocationToExecutor,
            ASenderRecieverPair<Integer> argGetLocationFromExecutor,
            ASenderRecieverPair<String> argGetNameFromExecutor,
            ASenderRecieverPair<String> argGetSourceFromBridge
    ) {
        sendSourceToExecutor.sender = argSendSourceToExecutor;
        sendLocationToExecutor.sender = argSendLocationToExecutor;
        getLocationFromExecutor.receiver = argGetLocationFromExecutor;
        getNameFromExecutor.receiver = argGetNameFromExecutor;
        getSourceFromBridge.receiver = argGetSourceFromBridge;
    }
    
    @Override
    public void start(boolean interactive) {
        if(interactive) {
            while(interactive) {
                while(getSourceFromBridge.hasNext()) {
                    //tokens.size == the next index
                    tokens.add(tokens.size, getSourceFromBridge.next());
                    //this is where the names are identified and added to the HashMap
                }
            }
            while(getLocationFromExecutor.hasNext) {
                sendSourceToExecutor(tokens.get(getLocationFromExecutor.next()));
            }
            while(getNameFromExecutor.hasNext()) {
                sendSourceToExecutor(sendLocationToExecutor.send(locationsByName.get(getNameFromExecutor.next())));
            }
        } else {
            //non-interactive
        }
    }
}