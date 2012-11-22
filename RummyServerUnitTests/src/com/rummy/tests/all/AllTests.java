package com.rummy.tests.all;

import org.junit.runners.Suite;
import org.junit.runner.RunWith;

import com.rummy.tests.SinglePlayer;
import com.rummy.tests.actions.TestEventHandlerMap;


@RunWith(Suite.class)
@Suite.SuiteClasses({
    TestEventHandlerMap.class,
    SinglePlayer.class,
})

public class AllTests {}

