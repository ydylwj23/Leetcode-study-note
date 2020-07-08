class Solution {
    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length;) {
            int cur = checkCode(data, i);
            if (cur == -1) {
                return false;
            }
            i += cur;
        }
        return true;
    }

    private int checkCode(int[] data, int index) {
        int head = data[index];
        int checkBit = 1 << 7;
        int codeLength = 0;
        // find code byte length
        if ((head & checkBit) == 0) {
            return 1;
        } else if ((head & (checkBit >> 1)) == 0) {
            return -1;
        } else if ((head & (checkBit >> 2)) == 0) {
            codeLength = 2;
        } else if ((head & (checkBit >> 3)) == 0) {
            codeLength = 3;
        } else if ((head & (checkBit >> 4)) == 0) {
            codeLength = 4;
        } else {
            return -1;
        }
        // check trailing bytes
        for (int i = index + 1; i < index + codeLength; ++i) {
            // if out of bound
            if (i >= data.length) {
                return -1;
            }
            int curByte = data[i];
            if ((checkBit & curByte) == 0 || ((checkBit >> 1) & curByte) != 0) {
                return -1;
            }
        }
        return codeLength;
    }
}