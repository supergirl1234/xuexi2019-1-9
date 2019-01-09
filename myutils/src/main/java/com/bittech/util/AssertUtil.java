package com.bittech.util;

import java.util.Collection;
import java.util.Map;


/**
 * 断言<br>
 * 断言某些对象或值是否符合规定，否则抛出异常。经常用于做变量检查
 * Author: secondriver
 * Created: 2018/10/16
 */
public final class AssertUtil {
    
    private AssertUtil() {
    }
    
    /**
     * 断言是否为真，如果为 {@code false} 抛出 {@code IllegalArgumentException} 异常<br>
     *
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, "The value must be greater than zero");
     * </pre>
     *
     * @param expression       波尔值
     * @param errorMsgTemplate 错误抛出异常附带的消息模板，变量用{}代替
     * @param params           参数列表
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言是否为真，如果为 {@code false} 抛出 {@code IllegalArgumentException} 异常<br>
     *
     * <pre class="code">
     * Assert.isTrue(i &gt; 0, "The value must be greater than zero");
     * </pre>
     *
     * @param expression 波尔值
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isTrue(boolean expression) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言是否为假，如果为 {@code true} 抛出 {@code IllegalArgumentException} 异常<br>
     *
     * <pre class="code">
     * Assert.isFalse(i &lt; 0, "The value must be greater than zero");
     * </pre>
     *
     * @param expression       波尔值
     * @param errorMsgTemplate 错误抛出异常附带的消息模板，变量用{}代替
     * @param params           参数列表
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isFalse(boolean expression, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言是否为假，如果为 {@code true} 抛出 {@code IllegalArgumentException} 异常<br>
     *
     * <pre class="code">
     * Assert.isFalse(i &lt; 0);
     * </pre>
     *
     * @param expression 波尔值
     * @throws IllegalArgumentException if expression is {@code false}
     */
    public static void isFalse(boolean expression) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言对象是否为{@code null} ，如果不为{@code null} 抛出{@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     * Assert.isNull(value, "The value must be null");
     * </pre>
     *
     * @param object           被检查的对象
     * @param errorMsgTemplate 消息模板，变量使用{}表示
     * @param params           参数列表
     * @throws IllegalArgumentException if the object is not {@code null}
     */
    public static void isNull(Object object, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言对象是否为{@code null} ，如果不为{@code null} 抛出{@link IllegalArgumentException} 异常
     *
     * <pre class="code">
     * Assert.isNull(value);
     * </pre>
     *
     * @param object 被检查对象
     * @throws NullPointerException if the object is not {@code null}
     */
    public static void isNull(Object object) throws NullPointerException {
        //TODO
    }
    
    // ----------------------------------------------------------------------------------------------------------- Check not null
    
    /**
     * 断言对象是否不为{@code null} ，如果为{@code null} 抛出{@link NullPointerException} 异常 Assert that an object is not {@code null} .
     *
     * <pre class="code">
     * Assert.notNull(clazz, "The class must not be null");
     * </pre>
     *
     * @param <T>              被检查对象泛型类型
     * @param object           被检查对象
     * @param errorMsgTemplate 错误消息模板，变量使用{}表示
     * @param params           参数
     * @return 被检查后的对象
     * @throws NullPointerException if the object is {@code null}
     */
    public static <T> T notNull(T object, String errorMsgTemplate, Object... params) throws NullPointerException {
        //TODO
        return null;
    }
    
    /**
     * 断言对象是否不为{@code null} ，如果为{@code null} 抛出{@link NullPointerException} 异常
     *
     * <pre class="code">
     * Assert.notNull(clazz);
     * </pre>
     *
     * @param <T>    被检查对象类型
     * @param object 被检查对象
     * @return 非空对象
     * @throws NullPointerException if the object is {@code null}
     */
    public static <T> T notNull(T object) throws NullPointerException {
        //TODO
        return null;
    }
    
    // ----------------------------------------------------------------------------------------------------------- Check empty
    
    /**
     * 检查给定字符串是否为空，为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     * Assert.notEmpty(name, "Name must not be empty");
     * </pre>
     *
     * @param text             被检查字符串
     * @param errorMsgTemplate 错误消息模板，变量使用{}表示
     * @param params           参数
     * @return 非空字符串
     * @throws IllegalArgumentException 被检查字符串为空
     * @see StringUtil#isNotEmpty(CharSequence)
     */
    public static String notEmpty(String text, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 检查给定字符串是否为空，为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     * Assert.notEmpty(name);
     * </pre>
     *
     * @param text 被检查字符串
     * @return 被检查的字符串
     * @throws IllegalArgumentException 被检查字符串为空
     * @see StringUtil#isNotEmpty(CharSequence)
     */
    public static String notEmpty(String text) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 检查给定字符串是否为空白（null、空串或只包含空白符），为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     * Assert.notBlank(name, "Name must not be blank");
     * </pre>
     *
     * @param text             被检查字符串
     * @param errorMsgTemplate 错误消息模板，变量使用{}表示
     * @param params           参数
     * @return 非空字符串
     * @throws IllegalArgumentException 被检查字符串为空白
     * @see StringUtil#isNotBlank(CharSequence)
     */
    public static String notBlank(String text, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 检查给定字符串是否为空白（null、空串或只包含空白符），为空抛出 {@link IllegalArgumentException}
     *
     * <pre class="code">
     * Assert.notBlank(name, "Name must not be blank");
     * </pre>
     *
     * @param text 被检查字符串
     * @return 非空字符串
     * @throws IllegalArgumentException 被检查字符串为空白
     * @see StringUtil#isNotBlank(CharSequence)
     */
    public static String notBlank(String text) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定字符串是否不被另一个字符串包含（既是否为子串）
     *
     * <pre class="code">
     * Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");
     * </pre>
     *
     * @param textToSearch     被搜索的字符串
     * @param substring        被检查的子串
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 被检查的子串
     * @throws IllegalArgumentException 非子串抛出异常
     */
    public static String notContain(String textToSearch, String substring, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定字符串是否不被另一个字符串包含（既是否为子串）
     *
     * <pre class="code">
     * Assert.doesNotContain(name, "rod", "Name must not contain 'rod'");
     * </pre>
     *
     * @param textToSearch 被搜索的字符串
     * @param substring    被检查的子串
     * @return 被检查的子串
     * @throws IllegalArgumentException 非子串抛出异常
     */
    public static String notContain(String textToSearch, String substring) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定数组是否包含元素，数组必须不为 {@code null} 且至少包含一个元素
     *
     * <pre class="code">
     * Assert.notEmpty(array, "The array must have elements");
     * </pre>
     *
     * @param array            被检查的数组
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 被检查的数组
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements
     */
    public static Object[] notEmpty(Object[] array, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定数组是否包含元素，数组必须不为 {@code null} 且至少包含一个元素
     *
     * <pre class="code">
     * Assert.notEmpty(array, "The array must have elements");
     * </pre>
     *
     * @param array 被检查的数组
     * @return 被检查的数组
     * @throws IllegalArgumentException if the object array is {@code null} or has no elements
     */
    public static Object[] notEmpty(Object[] array) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定数组是否不包含{@code null}元素，如果数组为空或 {@code null}将被认为不包含
     *
     * <pre class="code">
     * Assert.noNullElements(array, "The array must have non-null elements");
     * </pre>
     *
     * @param <T>              数组元素类型
     * @param array            被检查的数组
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 被检查的数组
     * @throws IllegalArgumentException if the object array contains a {@code null} element
     */
    public static <T> T[] noNullElements(T[] array, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定数组是否不包含{@code null}元素，如果数组为空或 {@code null}将被认为不包含
     *
     * <pre class="code">
     * Assert.noNullElements(array);
     * </pre>
     *
     * @param <T>   数组元素类型
     * @param array 被检查的数组
     * @return 被检查的数组
     * @throws IllegalArgumentException if the object array contains a {@code null} element
     */
    public static <T> T[] noNullElements(T[] array) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定集合非空
     *
     * <pre class="code">
     * Assert.notEmpty(collection, "Collection must have elements");
     * </pre>
     *
     * @param <T>              集合元素类型
     * @param collection       被检查的集合
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 非空集合
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements
     */
    public static <T> Collection<T> notEmpty(Collection<T> collection, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定集合非空
     *
     * <pre class="code">
     * Assert.notEmpty(collection);
     * </pre>
     *
     * @param <T>        集合元素类型
     * @param collection 被检查的集合
     * @return 被检查集合
     * @throws IllegalArgumentException if the collection is {@code null} or has no elements
     */
    public static <T> Collection<T> notEmpty(Collection<T> collection) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定Map非空
     *
     * <pre class="code">
     * Assert.notEmpty(map, "Map must have entries");
     * </pre>
     *
     * @param <K>              Key类型
     * @param <V>              Value类型
     * @param map              被检查的Map
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 被检查的Map
     * @throws IllegalArgumentException if the map is {@code null} or has no entries
     */
    public static <K, V> Map<K, V> notEmpty(Map<K, V> map, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定Map非空
     *
     * <pre class="code">
     * Assert.notEmpty(map, "Map must have entries");
     * </pre>
     *
     * @param <K> Key类型
     * @param <V> Value类型
     * @param map 被检查的Map
     * @return 被检查的Map
     * @throws IllegalArgumentException if the map is {@code null} or has no entries
     */
    public static <K, V> Map<K, V> notEmpty(Map<K, V> map) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言给定对象是否是给定类的实例
     *
     * <pre class="code">
     * Assert.instanceOf(Foo.class, foo);
     * </pre>
     *
     * @param <T>  被检查对象泛型类型
     * @param type 被检查对象匹配的类型
     * @param obj  被检查对象
     * @return 被检查的对象
     * @throws IllegalArgumentException if the object is not an instance of clazz
     * @see Class#isInstance(Object)
     */
    public static <T> T isInstanceOf(Class<?> type, T obj) {
        //TODO
        return null;
    }
    
    /**
     * 断言给定对象是否是给定类的实例
     *
     * <pre class="code">
     * Assert.instanceOf(Foo.class, foo);
     * </pre>
     *
     * @param <T>              被检查对象泛型类型
     * @param type             被检查对象匹配的类型
     * @param obj              被检查对象
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 被检查对象
     * @throws IllegalArgumentException if the object is not an instance of clazz
     * @see Class#isInstance(Object)
     */
    public static <T> T isInstanceOf(Class<?> type, T obj, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
        return null;
    }
    
    /**
     * 断言 {@code superType.isAssignableFrom(subType)} 是否为 {@code true}.
     *
     * <pre class="code">
     * Assert.isAssignable(Number.class, myClass);
     * </pre>
     *
     * @param superType 需要检查的父类或接口
     * @param subType   需要检查的子类
     * @throws IllegalArgumentException 如果子类非继承父类，抛出此异常
     */
    public static void isAssignable(Class<?> superType, Class<?> subType) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 断言 {@code superType.isAssignableFrom(subType)} 是否为 {@code true}.
     *
     * <pre class="code">
     * Assert.isAssignable(Number.class, myClass);
     * </pre>
     *
     * @param superType        需要检查的父类或接口
     * @param subType          需要检查的子类
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @throws IllegalArgumentException 如果子类非继承父类，抛出此异常
     */
    public static void isAssignable(Class<?> superType, Class<?> subType, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        //TODO
    }
    
    /**
     * 检查boolean表达式，当检查结果为false时抛出 {@code IllegalStateException}。
     *
     * <pre class="code">
     * Assert.state(id == null, "The id property must not already be initialized");
     * </pre>
     *
     * @param expression       boolean 表达式
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @throws IllegalStateException 表达式为 {@code false} 抛出此异常
     */
    public static void state(boolean expression, String errorMsgTemplate, Object... params) throws IllegalStateException {
        //TODO
    }
    
    /**
     * 检查boolean表达式，当检查结果为false时抛出 {@code IllegalStateException}。
     *
     * <pre class="code">
     * Assert.state(id == null);
     * </pre>
     *
     * @param expression boolean 表达式
     * @throws IllegalStateException 表达式为 {@code false} 抛出此异常
     */
    public static void state(boolean expression) throws IllegalStateException {
        //TODO
    }
    
    /**
     * 检查下标（数组、集合、字符串）是否符合要求，下标必须满足：
     *
     * <code>
     * 0 <= index < size
     * </code>
     *
     * @param index 下标
     * @param size  长度
     * @return 检查后的下标
     * @throws IllegalArgumentException  如果size < 0 抛出此异常
     * @throws IndexOutOfBoundsException 如果index < 0或者 index >= size 抛出此异常
     */
    public static int checkIndex(int index, int size) throws IllegalArgumentException, IndexOutOfBoundsException {
        //TODO
        return -1;
    }
    
    /**
     * 检查下标（数组、集合、字符串）是否符合要求，下标必须满足：
     *
     * <pre>
     * 0 <= index < size
     * </pre>
     *
     * @param index            下标
     * @param size             长度
     * @param errorMsgTemplate 异常时的消息模板
     * @param params           参数列表
     * @return 检查后的下标
     * @throws IllegalArgumentException  如果size < 0 抛出此异常
     * @throws IndexOutOfBoundsException 如果index < 0或者 index >= size 抛出此异常
     */
    public static int checkIndex(int index, int size, String errorMsgTemplate, Object... params) throws IllegalArgumentException, IndexOutOfBoundsException {
        //TODO
        return -1;
    }
    
    /**
     * 检查值是否在指定范围内
     *
     * @param value 值
     * @param min   最小值（包含）
     * @param max   最大值（包含）
     * @return 检查后的长度值
     */
    public static int checkBetween(int value, int min, int max) {
        //TODO
        return -1;
    }
    
    /**
     * 检查值是否在指定范围内
     *
     * @param value 值
     * @param min   最小值（包含）
     * @param max   最大值（包含）
     * @return 检查后的长度值
     */
    public static long checkBetween(long value, long min, long max) {
        //TODO
        return -1;
    }
    
    /**
     * 检查值是否在指定范围内
     *
     * @param value 值
     * @param min   最小值（包含）
     * @param max   最大值（包含）
     * @return 检查后的长度值
     */
    public static double checkBetween(double value, double min, double max) {
        //TODO
        return -1;
    }
    
    /**
     * 检查值是否在指定范围内
     *
     * @param value 值
     * @param min   最小值（包含）
     * @param max   最大值（包含）
     * @return 检查后的长度值
     */
    public static Number checkBetween(Number value, Number min, Number max) {
        //TODO
        return -1;
    }
    
    /**
     * 错误的下标时显示的消息
     *
     * @param index  下标
     * @param size   长度
     * @param desc   异常时的消息模板
     * @param params 参数列表
     * @return 消息
     */
    public static String badIndexMsg(int index, int size, String desc, Object... params) {
        //TODO
        return null;
    }
}

