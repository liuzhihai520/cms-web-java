package com.trunk.util.xutil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ��������ʱ��Ĺ����ࡣ
 *
 * @author xuan
 * @version $Revision: 1.0 $, $Date: 2012-11-22 ����9:46:12 $
 */
public abstract class DateUtils {

    private static final int[] DAY_OF_MONTH = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    /**
     * ȡ��ָ���������ʱ��
     *
     * @param date
     *            ��׼ʱ��
     * @param dayAmount
     *            ָ������������Ϊ����
     * @return ָ���������ʱ��
     */
    public static Date addDay(Date date, int dayAmount) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, dayAmount);
        return calendar.getTime();
    }

    /**
     * ȡ��ָ��Сʱ�����ʱ��
     *
     * @param date
     *            ��׼ʱ��
     * @param hourAmount
     *            ָ��Сʱ��������Ϊ����
     * @return ָ��Сʱ�����ʱ��
     */
    public static Date addHour(Date date, int hourAmount) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR, hourAmount);
        return calendar.getTime();
    }

    /**
     * ȡ��ָ�����������ʱ��
     *
     * @param date
     *            ��׼ʱ��
     * @param minuteAmount
     *            ָ��������������Ϊ����
     * @return ָ�����������ʱ��
     */
    public static Date addMinute(Date date, int minuteAmount) {
        if (date == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minuteAmount);
        return calendar.getTime();
    }

    /**
     * �Ƚ������ڶ����е�Сʱ�ͷ��Ӳ��ֵĴ�С.
     *
     * @param date
     *            ���ڶ���1, ���Ϊ <code>null</code> ���Ե�ǰʱ������ڶ������
     * @param anotherDate
     *            ���ڶ���2, ���Ϊ <code>null</code> ���Ե�ǰʱ������ڶ������
     * @return ������ڶ���1�������ڶ���2, �򷵻ش���0����; ��֮����С��0����; ��������ڶ������, �򷵻�0.
     */
    public static int compareHourAndMinute(Date date, Date anotherDate) {
        if (date == null) {
            date = new Date();
        }

        if (anotherDate == null) {
            anotherDate = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hourOfDay1 = cal.get(Calendar.HOUR_OF_DAY);
        int minute1 = cal.get(Calendar.MINUTE);

        cal.setTime(anotherDate);
        int hourOfDay2 = cal.get(Calendar.HOUR_OF_DAY);
        int minute2 = cal.get(Calendar.MINUTE);

        if (hourOfDay1 > hourOfDay2) {
            return 1;
        }
        else if (hourOfDay1 == hourOfDay2) {
            // Сʱ��ȾͱȽϷ���
            return minute1 > minute2 ? 1 : (minute1 == minute2 ? 0 : -1);
        }
        else {
            return -1;
        }
    }

    /**
     * �Ƚ������ڶ���Ĵ�С, ������, ֻ��ȷ������.
     *
     * @param date
     *            ���ڶ���1, ���Ϊ <code>null</code> ���Ե�ǰʱ������ڶ������
     * @param anotherDate
     *            ���ڶ���2, ���Ϊ <code>null</code> ���Ե�ǰʱ������ڶ������
     * @return ������ڶ���1�������ڶ���2, �򷵻ش���0����; ��֮����С��0����; ��������ڶ������, �򷵻�0.
     */
    public static int compareIgnoreSecond(Date date, Date anotherDate) {
        if (date == null) {
            date = new Date();
        }

        if (anotherDate == null) {
            anotherDate = new Date();
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        date = cal.getTime();

        cal.setTime(anotherDate);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        anotherDate = cal.getTime();

        return date.compareTo(anotherDate);
    }

    /**
     * ȡ�õ�ǰʱ����ַ�����ʾ����ʽΪ2006-01-10 20:56:30.756
     *
     * @return ��ǰʱ����ַ�����ʾ
     */
    public static String currentDate2String() {
        return date2String(new Date());
    }

    /**
     * ȡ�õ�ǰʱ����ַ�����ʾ����ʽΪ2006-01-10
     *
     * @return ��ǰʱ����ַ�����ʾ
     */
    public static String currentDate2StringByDay() {
        return date2StringByDay(new Date());
    }

    /**
     * ȡ�ý�������һ��ʱ��
     *
     * @return ��������һ��ʱ��
     */
    public static Date currentEndDate() {
        return getEndDate(new Date());
    }

    /**
     * ȡ�ý���ĵ�һ��ʱ��
     *
     * @return ����ĵ�һ��ʱ��
     */
    public static Date currentStartDate() {
        return getStartDate(new Date());
    }

    /**
     * ��ʱ��ת�����ַ�������ʽΪ2006-01-10 20:56:30.756
     *
     * @param date
     *            ʱ��
     * @return ʱ���ַ���
     */
    public static String date2String(Date date) {
        return date2String(date, "yyyy-MM-dd HH:mm:ss.SSS");
    }

    /**
     * ����ָ����ʽ��ʱ��ת�����ַ�������ʽ��д������yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param date
     *            ʱ��
     * @param pattern
     *            ��ʽ
     * @return ʱ���ַ���
     */
    public static String date2String(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        return (new SimpleDateFormat(pattern)).format(date);
    }

    /**
     * ��ʱ��ת�����ַ�������ʽΪ2006-01-10
     *
     * @param date
     *            ʱ��
     * @return ʱ���ַ���
     */
    public static String date2StringByDay(Date date) {
        return date2String(date, "yyyy-MM-dd");
    }

    /**
     * ��ʱ��ת�����ַ�������ʽΪ2006-01-10 20:56
     *
     * @param date
     *            ʱ��
     * @return ʱ���ַ���
     */
    public static String date2StringByMinute(Date date) {
        return date2String(date, "yyyy-MM-dd HH:mm");
    }

    /**
     * ��ʱ��ת�����ַ�������ʽΪ2006-01-10 20:56:30
     *
     * @param date
     *            ʱ��
     * @return ʱ���ַ���
     */
    public static String date2StringBySecond(Date date) {
        return date2String(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * ����ĳ���ڼ���Ӣ����������ȡ�����ڼ���������. <br>
     * e.g. <li>monday -> һ</li> <li>sunday -> ��</li>
     *
     * @param englishWeekName
     *            ���ڵ�Ӣ������
     * @return ���ڵ�������
     */
    public static String getChineseWeekNumber(String englishWeekName) {
        if ("monday".equalsIgnoreCase(englishWeekName)) {
            return "һ";
        }

        if ("tuesday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        if ("wednesday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        if ("thursday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        if ("friday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        if ("saturday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        if ("sunday".equalsIgnoreCase(englishWeekName)) {
            return "��";
        }

        return null;
    }

    /**
     * ����ָ������, ��, �յȲ�����ȡ���ڶ���.
     *
     * @param year
     *            ��
     * @param month
     *            ��
     * @param date
     *            ��
     * @return ��Ӧ�����ڶ���
     */
    public static Date getDate(int year, int month, int date) {
        return getDate(year, month, date, 0, 0);
    }

    /**
     * ����ָ������, ��, ��, ʱ, �ֵȲ�����ȡ���ڶ���.
     *
     * @param year
     *            ��
     * @param month
     *            ��
     * @param date
     *            ��
     * @param hourOfDay
     *            ʱ(24Сʱ��)
     * @param minute
     *            ��
     * @return ��Ӧ�����ڶ���
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute) {
        return getDate(year, month, date, hourOfDay, minute, 0);
    }

    /**
     * ����ָ������, ��, ��, ʱ, ��, ��Ȳ�����ȡ���ڶ���.
     *
     * @param year
     *            ��
     * @param month
     *            ��
     * @param date
     *            ��
     * @param hourOfDay
     *            ʱ(24Сʱ��)
     * @param minute
     *            ��
     * @param second
     *            ��
     * @return ��Ӧ�����ڶ���
     */
    public static Date getDate(int year, int month, int date, int hourOfDay, int minute, int second) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, date, hourOfDay, minute, second);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * ȡ��ĳ�����������ڼ�����������1����������
     *
     * @param date
     *            ����
     * @return ���ڼ�
     */
    public static int getDayOfWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * ��ȡĳ��Ľ���ʱ��, e.g. 2005-10-01 23:59:59.999
     *
     * @param date
     *            ���ڶ���
     * @return ����Ľ���ʱ��
     */
    public static Date getEndDate(Date date) {

        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    /**
     * ȡ��һ������������
     *
     * @param year
     *            ���
     * @param month
     *            �·ݣ�0��ʾ1�£���������
     * @return ��������
     */
    public static int getMaxDayOfMonth(int year, int month) {
        if (month == 1 && isLeapYear(year)) {
            return 29;
        }
        return DAY_OF_MONTH[month];
    }

    /**
     * �õ�ָ�����ڵ���һ��
     *
     * @param date
     *            ���ڶ���
     * @return ͬһʱ�����һ������ڶ���
     */
    public static Date getNextDay(Date date) {
        return addDay(date, 1);
    }

    /**
     * ��ȡĳ�����ʼʱ��, e.g. 2005-10-01 00:00:00.000
     *
     * @param date
     *            ���ڶ���
     * @return �������ʼʱ��
     */
    public static Date getStartDate(Date date) {
        if (date == null) {
            return null;
        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * �������ڶ�������ȡ�����е�ʱ��(HH:mm:ss).
     *
     * @param date
     *            ���ڶ���
     * @return ʱ���ַ���, ��ʽΪ: HH:mm:ss
     */
    public static String getTime(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(date);
    }

    /**
     * �������ڶ�������ȡ�����е�ʱ��(HH:mm).
     *
     * @param date
     *            ���ڶ���
     * @return ʱ���ַ���, ��ʽΪ: HH:mm
     */
    public static String getTimeIgnoreSecond(Date date) {
        if (date == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(date);
    }

    /**
     * �ж��Ƿ�������
     *
     * @param year
     *            ���
     * @return ��true������false
     */
    public static boolean isLeapYear(int year) {
        Calendar calendar = Calendar.getInstance();
        return ((GregorianCalendar) calendar).isLeapYear(year);
    }

    /**
     * ���ַ���ת�������ڣ���ʽΪ2006-01-10
     *
     * @param str
     *            �ַ���
     * @return ����
     */
    public static Date string2Date(String str) {
        return string2Date(str, "yyyy-MM-dd");
    }

    /**
     * ����ָ���ĸ�ʽ���ַ���ת����ʱ�䣬��ʽ��д������yyyy-MM-dd HH:mm:ss.SSS
     *
     * @param str
     *            �ַ���
     * @param pattern
     *            ��ʽ
     * @return ʱ��
     */
    public static Date string2Date(String str, String pattern) {
        if (Validators.isEmpty(str)) {
            return null;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        Date date = null;
        try {
            date = dateFormat.parse(str);
        }
        catch (ParseException e) {
            // ignore
        }
        return date;
    }

    /**
     * ���ַ���ת�������ڣ���ʽΪ2006-01-10 20:56:30
     *
     * @param str
     *            �ַ���
     * @return ����
     */
    public static Date string2DateTime(String str) {
        return string2Date(str, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * ȡ��һ���еĵڼ��ܡ�
     *
     * @param date
     * @return
     */
    public static int getWeekOfYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * ��ȡ���ܵ�ָ�����ڵ����ڡ�
     *
     * @param dayOfWeek
     *            ���ڼ���ȡֵ��Χ�� {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     */
    public static Date getDateOfPreviousWeek(int dayOfWeek) {
        if (dayOfWeek > 7 || dayOfWeek < 1) {
            throw new IllegalArgumentException("����������1-7֮�������");
        }

        return getDateOfRange(dayOfWeek, -7);
    }

    /**
     * ��ȡ���ܵ�ָ�����ڵ����ڡ�
     *
     * @param dayOfWeek
     *            ���ڼ���ȡֵ��Χ�� {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     */
    public static Date getDateOfCurrentWeek(int dayOfWeek) {
        if (dayOfWeek > 7 || dayOfWeek < 1) {
            throw new IllegalArgumentException("����������1-7֮�������");
        }

        return getDateOfRange(dayOfWeek, 0);
    }

    /**
     * ��ȡ���ܵ�ָ�����ڵ����ڡ�
     *
     * @param dayOfWeek
     *            ���ڼ���ȡֵ��Χ�� {@link Calendar#MONDAY} - {@link Calendar#SUNDAY}
     */
    public static Date getDateOfNextWeek(int dayOfWeek) {
        if (dayOfWeek > 7 || dayOfWeek < 1) {
            throw new IllegalArgumentException("����������1-7֮�������");
        }

        return getDateOfRange(dayOfWeek, 7);
    }

    private static Date getDateOfRange(int dayOfWeek, int dayOfRange) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + dayOfRange);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
