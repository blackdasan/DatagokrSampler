package com.korail.openapi;

import java.io.IOException;

public class SectionInfoByStnNm extends APICaller {

    private static String httpURL1 = "http://swopenAPI.seoul.go.kr/api/subway/";
    private static String httpURL2 = "/json/stationSection/0/5/";
    private static String certyKey = "70644e68726b6f72323749784a7941";

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(httpURL1);
        buffer.append(certyKey);
        buffer.append(httpURL2);
        buffer.append("운길산");

        SectionInfoByStnNm sectionInfo = new SectionInfoByStnNm();
        try {
            sectionInfo.execute(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
