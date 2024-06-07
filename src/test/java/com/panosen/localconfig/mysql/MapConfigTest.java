package com.panosen.localconfig.mysql;

import com.panosen.localconfig.MapConfig;
import org.junit.Assert;
import org.junit.Test;

public class MapConfigTest {

    @Test
    public void test() {

        MapConfig mapConfig = new MapConfig("basic.properties");

        Assert.assertEquals("pong1", mapConfig.getStringOrDefault("ping", "1"));
        Assert.assertEquals("1", mapConfig.getStringOrDefault("2", "1"));

        Assert.assertEquals(11, (int) mapConfig.getIntOrDefault("a", 1));
        Assert.assertEquals(22L, (long) mapConfig.getLongOrDefault("b", 2L));

        Assert.assertEquals(3, (int) mapConfig.getIntOrDefault("c", 3));
        Assert.assertEquals(4L, (long) mapConfig.getLongOrDefault("d", 4L));
    }
}