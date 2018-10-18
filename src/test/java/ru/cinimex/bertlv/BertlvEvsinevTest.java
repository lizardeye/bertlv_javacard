package ru.cinimex.bertlv;

import javacardx.framework.tlv.BERTLV;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * This test is taken from library https://github.com/evsinev/ber-tlv
 * It's supposed, that they work identical with plain javacard parser
 * Created by ekandaurova on 17.10.2018.
 */
public class BertlvEvsinevTest {
    @Test
    public void testParseLen2() throws DecoderException {
        String hex =
        /*            0  1  2  3   4  5  6  7     8  9  a  b   c  d  e  f      0123 4567  89ab  cdef */
        /*    0 */   "e0 81 91 71  7f 9f 18 04    12 34 56 78  86 0d 84 24" // ...q ....  .4Vx  ...$
        /*   10 */ + "00 00 08 5a  e9 57 e8 81    8d 95 a8 86  0d 84 24 00" // ...Z .W..  ....  ..$.
        /*   20 */ + "00 08 36 d2  44 95 47 47    ec 1e 86 0d  84 24 00 00" // ..6. D.GG  ....  .$..
        /*   30 */ + "08 38 63 b1  c1 79 be 38    ac 86 0d 84  24 00 00 08" // .8c. .y.8  ....  $...
        /*   40 */ + "25 4d b4 b4  ec db 21 74    86 0d 84 24  00 00 08 67" // %M.. ..!t  ...$  ...g
        /*   50 */ + "8d f9 12 84  78 e2 8f 86    0d 84 24 00  00 08 51 4c" // .... x...  ..$.  ..QL
        /*   60 */ + "8f d9 5a 21  6c 0b 86 0d    84 24 00 00  08 1f 62 34" // ..Z! l...  .$..  ..b4
        /*   70 */ + "65 db 0c 95  59 86 0d 84    24 00 00 08  2a 5a 0a 9a" // e... Y...  $...  *Z..
        /*   80 */ + "82 8a ba 0a  91 0a 42 50    0e 43 81 a4  67 7a 30 30" // .... ..BP  .C..  gz00
        /*   90 */ + "8a 02 30 30                                         " // ..00
                ;
        char[] src = hex.replace("\n", "").replace(" ", "").toUpperCase().toCharArray();
        byte[] decoded = Hex.decodeHex(src);
        short length = (short) decoded.length;
        BERTLV berTLV = BERTLV.getInstance(decoded, (short) 0,length);
    }

}
