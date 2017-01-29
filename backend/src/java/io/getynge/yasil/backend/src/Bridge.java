package io.getynge.yasil.backend.src;

import java.io.*;
import java.util.Scanner;

/**
 * Created by spark on 1/29/2017.
 */
public class Bridge extends ABridge<String, String>{
    Scanner toRead;
    PrintWriter toWrite;

    @Override
    public void connect(InputStream in, OutputStream out) throws IOException {
        toRead = new Scanner(in);
        toWrite = new PrintWriter(out);
    }

    @Override
    public void start(boolean interactive) throws IllegalStateException {
        parser.start(interactive);
        executor.start();
        if(interactive){
           while(toRead.hasNext()){
               for(String i : receiveOutputFromExecutor) toWrite.println(i);
               String token = toRead.next();

               if(!token.toLowerCase().equals("quit")) {
                   sendSourceToParser.send(token);
               }else{
                   break;
               }
           }
        }else{
            while(toRead.hasNext()){
                String token = toRead.next();
                sendSourceToParser.send(token);
            }

        }
    }

    Bridge(AParser<?, ?, ?, ?, String> a, AExecutor<?, ?, String, ?, ?, ?> b, ASenderReceiverPair<String> c, ASenderReceiverPair<String> d){
        parser = a;
        executor = b;
        sendSourceToParser = c.sender;
        receiveOutputFromExecutor = d.receiver;
    }
}
