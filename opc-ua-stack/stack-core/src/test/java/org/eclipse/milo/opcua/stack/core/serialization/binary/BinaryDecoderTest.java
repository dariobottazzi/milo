package org.eclipse.milo.opcua.stack.core.serialization.binary;

import org.eclipse.milo.opcua.stack.core.Identifiers;
import org.eclipse.milo.opcua.stack.core.serialization.OpcUaDataTypeDictionary;
import org.eclipse.milo.opcua.stack.core.serialization.codec.OpcBinaryDataTypeCodec;
import org.eclipse.milo.opcua.stack.core.serialization.codec.SerializationContext;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class BinaryDecoderTest extends BinarySerializationFixture {

    @Test(description = "a null array, once encoded, should decode to a null array")
    public void testDecodeNullArray() {
        Argument argument = new Argument(
            "test",
            Identifiers.Int16,
            1,
            null,
            LocalizedText.NULL_VALUE
        );

        @SuppressWarnings("unchecked")
        OpcBinaryDataTypeCodec<Argument> codec = (OpcBinaryDataTypeCodec<Argument>)
            OpcUaDataTypeDictionary.getInstance().getBinaryCodec(Argument.BinaryEncodingId);

        codec.encode(SerializationContext.INTERNAL, argument, writer);
        Argument decoded = codec.decode(SerializationContext.INTERNAL, reader);

        assertEquals(decoded.getName(), argument.getName());

        assertNull(decoded.getArrayDimensions());
    }

}
