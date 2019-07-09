package fileManager;

abstract class CharacterHider {
    private static final byte MUL = -1;
    private static final byte PLUS = 51;

    static byte[] hide(String text) {
        final int size = text.length();
        byte[] bytes = text.getBytes();
        byte[] buf = new byte[size];
        for (int i = 0; i < size; i++) {
            buf[i] = (byte) ((bytes[i] * MUL) + PLUS);
        }
        return buf;
    }

    static byte[] show(byte[] bytes) {
        final int size = bytes.length;
        byte[] buf = new byte[size];
        for (int i = 0; i < size; i++) {
            buf[i] = (byte) ((bytes[i] * MUL) + PLUS);
        }
        return buf;
    }
}
