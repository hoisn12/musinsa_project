package com.henry.musinsa.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.util.ObjectUtils;

public class StringCustomUtils {

    /**
     * String 으로 구성 된 문자열 date format 변경(ex. yyyyMMddHHmmss -> yyyy-MM-dd HH:mm:ss)
     *
     * <p>
     * formatter의 형태가 명확하다면 이 메서드를 사용.
     * </p>
     *
     * @param paramDate       변환 대상 텍스트
     * @param strBeforeFormat 변환 대상 텍스트의 포맷
     * @param strAfterFormat  변환 하고자 하는 LocalDate 의 포맷
     * @return String
     * @throws ParseException parse exceptions
     */
    public static String changeDateFormat(String paramDate, String strBeforeFormat, String strAfterFormat) throws ParseException {
        SimpleDateFormat beforeFormat = new SimpleDateFormat(strBeforeFormat);
        SimpleDateFormat afterFormat = new SimpleDateFormat(strAfterFormat);
        Date formatDate = beforeFormat.parse(paramDate);

        return afterFormat.format(formatDate);
    }

    /**
     * String 으로 구성 된 문자열 LocalDate 형태로 변경
     *
     * <p>
     * formatter의 형태가 명확하다면 이 메서드를 사용.
     * </p>
     *
     * @param paramDate       변환 대상 텍스트
     * @param strBeforeFormat 변환 대상 텍스트의 포맷
     * @param strAfterFormat  변환 하고자 하는 LocalDate의 포맷
     * @return LocalDate
     * @throws ParseException parse error
     */
    public static LocalDate getLocalDate(String paramDate, String strBeforeFormat, String strAfterFormat) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(strAfterFormat);

        return LocalDate.parse(changeDateFormat(paramDate, strBeforeFormat, strAfterFormat), formatter);
    }

    /**
     * String 형 날짜를 LocalDate 형으로 변경
     *
     * <p>
     * formatter 의 형태를 모를 경우 사용. yyyy-MM-dd , yyyy.MM.dd , yyyy/MM/dd , yyyyMMdd 형태의 String 날짜를 LocalDate 형으로 변경해주는 메서드
     * </p>
     *
     * @param value String 형 날짜
     * @return LocalDate
     * @throws ParseException parse error
     */
    public static LocalDate getLocalDateForgetFormatter(String value) throws ParseException {

        // 아무 값이 존재하지 않으면 null 로 반환
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }

        // 데이터 형태에 따라 포매터 설정
        String formatter;
        if (value.contains("-")) {
            formatter = "yyyy-MM-dd";
        } else if (value.contains(".")) {
            formatter = "yyyy.MM.dd";
        } else if (value.contains("/")) {
            formatter = "yyyy/MM/dd";
        } else {
            formatter = "yyyyMMdd";
        }
        return StringCustomUtils.getLocalDate(value, formatter, formatter);
    }

    /**
     * LocalDate 을 string 으로 변경
     *
     * @param localDate localDate
     * @param format        변환 형식
     * @return string
     */
    public static String localDateToString(LocalDate localDate, String format) {
        if (ObjectUtils.isEmpty(localDate)) {
            return null;
        }

        if (ObjectUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }

        return localDate.format(DateTimeFormatter.ofPattern(format));

    }

}
