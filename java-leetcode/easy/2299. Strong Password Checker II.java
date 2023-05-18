class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }

        int countNum = 0;
        int countUp = 0;
        int countLower = 0;
        int countSpecial = 0;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isDigit(ch)) {
                countNum++;
            } else if (Character.isLowerCase(ch)) {
                countLower++;
            } else if (Character.isUpperCase(ch)) {
                countUp++;
            } else if (!Character.isLetterOrDigit(ch)) {
                countSpecial++;
            }

            if (i > 0 && password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        return (countNum > 0 && countLower > 0 && countUp > 0 && countSpecial > 0);
    }
}