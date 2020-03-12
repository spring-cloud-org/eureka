package cn.zd.bootproj.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tool {
    public static void main(String[] args) {
        MySource();
    }

    private static void MySource() {
        /** 利用localdatetime获取7天后的数据 */
        int validityDuration = 7;
        ZoneId zoneId = ZoneId.systemDefault();
        Date createTime = new Date();
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusDays(Long.valueOf(validityDuration));
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date voucherOutDate = Date.from(zdt.toInstant());


        /** calendar获取昨天 */
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, -1);// 昨天
        cal.set(Calendar.HOUR_OF_DAY, 16);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        List<Integer> valueList = new ArrayList<>();
        String valueStr = "1,2,3,4,5,6";
        valueList = Arrays.asList(valueStr.split(",")).stream().
                map(str -> Integer.valueOf(str)).
                sorted(((o1, o2) -> o2.compareTo(o1))).
                collect(Collectors.toList());

        for (Integer integer : valueList) {
            System.out.println(integer);
        }


        valueList = Arrays.stream(valueStr.split(","))
                .map(str -> Integer.valueOf(str))
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .collect(Collectors.toList());
        for (Integer integer : valueList) {
            System.out.println(integer);
        }



        valueList = Stream.of(valueStr.split(","))
                .map(Integer :: new)
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .collect(Collectors.toList());
        for (Integer integer : valueList) {
            System.out.println(integer);
        }


        valueList = Stream.of(valueStr.split(","))
                .map(Integer :: new)
                .sorted(Comparator.comparing(Integer :: intValue).reversed())
                .collect(Collectors.toList());
        for (Integer integer : valueList) {
            System.out.println(integer);
        }

    }

}
