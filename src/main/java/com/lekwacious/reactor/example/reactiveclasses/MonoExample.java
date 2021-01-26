//package com.lekwacious.reactor.example.reactiveclasses;
//
//import com.lekwacious.reactor.example.domain.ToDo;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import reactor.core.publisher.Mono;
//import reactor.core.publisher.MonoProcessor;
//import reactor.core.scheduler.Scheduler;
//import reactor.core.scheduler.Schedulers;
//
//import java.time.Duration;
//
//@Configuration
//public class MonoExample {
//    private static Logger Log = LoggerFactory.getLogger(MonoExample.class);
//
//    @Bean
//    public CommandLineRunner runMonoExample(){
//        return args -> {
//            MonoProcessor<ToDo> promise = MonoProcessor.create();
//            Mono<ToDo> result = promise
//                    .doOnSuccess(p->Log.info("MONO >> ToDo:{}", p.getDescription()))
//                    .doOnTerminate(() -> Log.info("Mono >> Done"))
//                    .doOnError(t -> Log.error(t.getMessage(),t))
//                    .subscribeOn(Schedulers.single());
//            promise.onNext(new ToDo("Buy my ticket for Spring platform 2021"));
//           // promise.onError(new IllegalArgumentException("hi is an error proccessing the ToDO"));
//            result.block(Duration.ofMillis(1000));
//        };
//    }
//}
