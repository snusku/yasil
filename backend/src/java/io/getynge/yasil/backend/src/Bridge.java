package io.getynge.yasil.backend.src;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
        Thread pThread = new Thread(()->parser.start(interactive));
        Thread eThread = new Thread(()->executor.start());

        pThread.start();
        eThread.start();
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

        parser.stop();
        executor.stop();
        toRead.close();
        toWrite.close();

        try {
            pThread.join();
            eThread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
            System.err.println("ERROR JOINING PARSER AND EXECUTOR, FORCE ABORTING");
            System.err.println("PROGRAM STATE MAY BE POISONED, DO NOT CONTINUE");
            throw new IllegalStateException("Poisoned state");
        }

    }

    Bridge(AParser<?, ?, ?, ?, String> a, AExecutor<?, ?, String, ?, ?, ?> b, ASenderReceiverPair<String> c, ASenderReceiverPair<String> d){
        parser = a;
        executor = b;
        sendSourceToParser = c.sender;
        receiveOutputFromExecutor = d.receiver;
    }
}
