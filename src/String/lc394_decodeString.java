package String;

public class lc394_decodeString {
    int i = 0;

    public String decodeString(String s) {
        //coner case
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] tmp = s.toCharArray();
        while (i < tmp.length && tmp[i] != ']') {
            //如果不是数字
            if (!Character.isDigit(tmp[i])) {
                sb.append(tmp[i]);
                i++;
            } else {
                //如果是数字，或左括号
                int count = 0;
                while (i < tmp.length && Character.isDigit(tmp[i])) {
                    count = count * 10 + tmp[i] - '0';
                    i++;
                }
                i++;
                String repeat = decodeString(s);
                i++;

                while (count > 0) {
                    sb.append(repeat);
                    count--;
                }
            }

        }
        return new String(sb);
    }
}
