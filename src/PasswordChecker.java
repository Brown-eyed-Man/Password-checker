public class PasswordChecker {
    private int minLength = -1;
    private int maxRepeats = -1;

    public int getMinLength() {
        return minLength;
    }

    public int getMaxRepeats() {
        return maxRepeats;
    }

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException();
        } else {
            this.minLength = minLength;
        }
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.maxRepeats = maxRepeats;
        }
    }

    public boolean verify(String password) {
        //============Проверка на то, введена ли настройка на макс. допустимое количество символов подряд============
        if (maxRepeats == -1) {
            throw new IllegalStateException("Error: Не было указано макс. допустимое количество символов подряд!");
        }

        //============Проверка на то, введена ли настройка на минимальную длину пароля============
        if (minLength == -1) {
            throw new IllegalStateException("Error: Не была указана мин.длина пароля!");
        }

        if (password.length() >= minLength && maxRepeats > 0) {
            int countMatches = 0;
            for (int i = 0; i <= password.length() - maxRepeats; i++) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    countMatches++;
                    if (countMatches > maxRepeats) {
                        return false;
                    }
                } else {
                    countMatches = 0;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}