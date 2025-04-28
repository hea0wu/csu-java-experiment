package experiment5;
import java.util.Scanner;
import java.util.stream.Collectors;


public class StringUtils {

    /**
     * 大小写互换
     * @param input 输入字符串
     * @return 大小写互换后的字符串
     */
    public static String swapCase(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                stringBuilder.append(Character.toLowerCase(c));
            } else {
                stringBuilder.append(Character.toUpperCase(c));
            }
        }
        return stringBuilder.toString();
    }

    /**
     * 回文检查
     * @param str 输入代检字符串
     * @return 是否为回文
     */
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 删除子串内容
     * @param source 源字符串
     * @param toRemove 待删除子串
     * @return 删除子串后的字符串
     */
    public static String removeSubstring(String source, String toRemove) {
        return source.replace(toRemove, "");
    }

    /**
     * 删除重复字符
     * @return 删除重复字符后的字符串
     */
    public static String removeDuplicates() {
        System.out.println("请输入您想要删除重复字符的字符串：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char)c))
                .collect(Collectors.joining());
    }

    /**
     * 统计一个字符串中给定字符串出现的频率
     * @param str 源字符串
     * @param sub 待查子串
     * @return 子串出现频率
     */
    public static int countSubstring(String str, String sub) {
        int count = 0, index = 0;
        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }
        return count;
    }

    /**
     * 将一个表示十进制数的字符串转换为以逗号分隔的字符串，从右边开始每三个数字标一个逗号. “1234567” => “1,234,567”
     * @param number 待转换数
     * @return 转换后的数
     */
    public static String formatWithCommas(String number) {
        StringBuilder stringBuilder = new StringBuilder(number).reverse();
        for (int i = 3; i < stringBuilder.length(); i += 4) {
            stringBuilder.insert(i, ',');
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(swapCase("HelloWorld!"));
        System.out.println(isPalindrome("abc123321cba"));
        System.out.println(removeSubstring("HelloWorld", "loW"));
        System.out.println(removeDuplicates());
        System.out.println(countSubstring("HelloWorldHello", "Hello"));
        System.out.println(formatWithCommas("1234567"));
    }
}
