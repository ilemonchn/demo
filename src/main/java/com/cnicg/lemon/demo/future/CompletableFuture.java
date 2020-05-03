package com.cnicg.lemon.demo.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

class CompletableFutureTest {
    public static void main(String[] args) throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {

            return "hello";
        }).thenApply(s -> s + "apply");
        CompletableFuture<String> future1 = future.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + "end"));
//        future.complete("success");
//        future.complete("aaa");
//        future.cancel(false);
//        future.cancel(true);
        String result = null;
        try {
            result = future1.get(1, TimeUnit.SECONDS);
        }catch (Exception ex) {

        }

        future.completeExceptionally(new RuntimeException());
        System.out.println(result);

        TimeUnit.SECONDS.sleep(3);



    }
}
