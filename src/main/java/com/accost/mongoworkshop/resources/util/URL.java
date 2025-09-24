package com.accost.mongoworkshop.resources.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class URL {
    public static String decodeParam(String text) {
        return java.net.URLDecoder.decode(text, StandardCharsets.UTF_8);
    }
}
