package com.qingzu.applet.test4;

import lombok.Data;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@Data
public class Num {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            System.out.println("Hello");
        });
      /*  try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
        System.out.println("CompletableFuture");
    }
}
