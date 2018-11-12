package com.korail.openapi;

import java.io.IOException;

/**
 * 호선정보
 */
public class LineInfoByLineNm extends APICaller {
    //http://swopenAPI.seoul.go.kr/api/subway/sample/xml/subwayLine/0/5/1호선
    //http://swopenAPI.seoul.go.kr/api/subway/70644e68726b6f72323749784a7941/json/subwayLine/0/200/1호선

    private static String httpURL1 = "http://swopenAPI.seoul.go.kr/api/subway/";
    private static String httpURL2 = "/json/subwayLine/0/5/";
    private static String certyKey = "70644e68726b6f72323749784a7941";

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(httpURL1);
        buffer.append(certyKey);
        buffer.append(httpURL2);
        buffer.append("1호선");

        LineInfoByLineNm lineInfo = new LineInfoByLineNm();
        try {
            lineInfo.execute(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}