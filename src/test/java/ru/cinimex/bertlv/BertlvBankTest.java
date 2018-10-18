package ru.cinimex.bertlv;

import javacardx.framework.tlv.BERTLV;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * Created by ekandaurova on 17.10.2018.
 */
public class BertlvBankTest {
    @Test
    public void testBankExample() throws DecoderException {
        byte[] decoded = Hex.decodeHex("F020C016T408178100000000000564C902TY".toCharArray());
        short length = (short) decoded.length;
        BERTLV berTLV = BERTLV.getInstance(decoded, (short) 0,length);
        assert berTLV!=null;
    }

}
