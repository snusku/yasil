package io.getynge.yasil.backend.src;

import java.io.*;
import java.util.Scanner;

/**
 * Created by spark on 1/29/2017.
 */
public class Bridge extends ABridge<String, String>{
    private Scanner toRead;
    private PrintWriter toWrite;

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
               String token = toRead.next();
               if(!token.toLowerCase().equals("quit")) {
                   sendSourceToParser.send(token);
                   while(receiveOutputFromExecutor.hasNext()) toWrite.println(receiveOutputFromExecutor.next());
               }else{
                   break;
               }
           }
        }else{
            while(toRead.hasNext()){
                String token = toRead.next();
                sendSourceToParser.send(token);
            }
            while(receiveOutputFromExecutor.hasNext()) toWrite.println(receiveOutputFromExecutor.next());
        }

        toRead.close();
        toWrite.close();
    }

    Bridge(AParser<?, ?, ?, ?, String> a, AExecutor<?, ?, String, ?, ?, ?> b, ASenderReceiverPair<String> c, ASenderReceiverPair<String> d){
        parser = a;
        executor = b;
        sendSourceToParser = c.sender;
        receiveOutputFromExecutor = d.receiver;
    }
}
