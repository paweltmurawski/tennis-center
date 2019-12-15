package com.tennis.scheduler;

import com.tennis.repository.UsersOrdersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class OrdersNumberScheduler {
    @Autowired
    private UsersOrdersRepository usersOrdersRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersNumberScheduler.class);

    @Scheduled(fixedRate = 1000000)
    public void numberOfOrders() {
        long ordersNumber = usersOrdersRepository.count();
        LOGGER.info("Current number of orders is: " + ordersNumber);
    }
}
