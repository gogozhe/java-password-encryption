package test;

public class account {
    private String userName;
    private String password;
    private String encryptionKey;
    private String encryptedPassword;

    public account() {
    }

    public account(String user, String pass, String key) {
        userName = user;
        password = pass;
        encryptionKey = key;
    }

    public void setUserName(String user) {
        userName = user;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String pass) {
        password = pass;
    }

    public void setEncryptionKey(String key) {
        encryptionKey = key;
    }

    public String getEncryptedPass() {
        return encryptedPassword;
    }

    public void scramblePassword() {
        encryptedPassword = xorEncryptDecrypt(password, encryptionKey);
        password = "";
    }

    public String unscramblePassword(String enteredPass) {
        return xorEncryptDecrypt(enteredPass, encryptionKey);
    }

    private String xorEncryptDecrypt(String input, String key) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append((char) (input.charAt(i) ^ key.charAt(i % key.length())));
        }
        return output.toString();
    }
}