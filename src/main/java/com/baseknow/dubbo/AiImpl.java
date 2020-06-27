package com.baseknow.dubbo;

import com.alibaba.dubbo.common.URL;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

public abstract  class AiImpl implements Ai {

    public AiImpl(Class type, URL url) {
        this(type, url, (Map<String, String>) null);
    }

    public AiImpl(String type, String url, String keys) {
    }

    public AiImpl(Class type, URL url, Map<String, String> attachment) {
    }

}
