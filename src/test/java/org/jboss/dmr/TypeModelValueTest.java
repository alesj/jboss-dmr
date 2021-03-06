package org.jboss.dmr;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;

public class TypeModelValueTest {

    @Test
    public void testHashCode() {
        assertEquals(true, TypeModelValue.of(ModelType.BIG_DECIMAL).hashCode() == TypeModelValue.of(ModelType.BIG_DECIMAL)
                .hashCode());
        assertEquals(false, TypeModelValue.of(ModelType.BIG_DECIMAL).hashCode() == TypeModelValue.of(ModelType.BIG_INTEGER)
                .hashCode());
    }

    @Test
    public void testAsBoolean() {
        assertEquals(true, TypeModelValue.of(ModelType.BIG_DECIMAL).asBoolean());
        assertEquals(false, TypeModelValue.of(ModelType.UNDEFINED).asBoolean());
    }

    @Test
    public void testAsBooleanBoolean() {
        assertEquals(true, TypeModelValue.of(ModelType.BIG_DECIMAL).asBoolean(false));
        assertEquals(false, TypeModelValue.of(ModelType.UNDEFINED).asBoolean(true));
    }

    @Test
    public void testAsString() {
        assertEquals("BIG_DECIMAL", TypeModelValue.of(ModelType.BIG_DECIMAL).asString());
    }

    @Test
    public void testAsType() {
        assertEquals(ModelType.BIG_DECIMAL, TypeModelValue.of(ModelType.BIG_DECIMAL).asType());
    }

    @Test
    public void testEqualsObject() {
        final TypeModelValue value1 = TypeModelValue.of(ModelType.BIG_DECIMAL);
        final TypeModelValue value2 = TypeModelValue.of(ModelType.BIG_DECIMAL);
        final TypeModelValue value3 = TypeModelValue.of(ModelType.BIG_INTEGER);
        assertEquals(true, value1.equals((Object) value1));
        assertEquals(true, value1.equals((Object) value2));
        assertEquals(true, value2.equals((Object) value1));
        assertEquals(false, value1.equals((Object) value3));
        assertEquals(false, value1.equals((Object) null));
        assertEquals(false, value1.equals("some string"));
    }

    @Test
    public void testFormatAsJSON() {
        final TypeModelValue value = TypeModelValue.of(ModelType.BIG_DECIMAL);
        final StringWriter stringWriter1 = new StringWriter();
        final PrintWriter writer1 = new PrintWriter(stringWriter1, true);
        value.formatAsJSON(writer1, 0, false);
        assertEquals("{ \"TYPE_MODEL_VALUE\" : \"BIG_DECIMAL\" }", stringWriter1.toString());

        final StringWriter stringWriter2 = new StringWriter();
        final PrintWriter writer2 = new PrintWriter(stringWriter2, true);
        value.formatAsJSON(writer2, 0, true);
        assertEquals("{\n    \"TYPE_MODEL_VALUE\" : \"BIG_DECIMAL\"\n}", stringWriter2.toString());
    }

    @Test
    public void testWriteExternal() {
        // TODO implement
    }

    @Test
    public void testOf() {
        assertEquals(ModelType.LONG, TypeModelValue.of(ModelType.LONG).asType());
        assertEquals(ModelType.INT, TypeModelValue.of(ModelType.INT).asType());
        assertEquals(ModelType.BOOLEAN, TypeModelValue.of(ModelType.BOOLEAN).asType());
        assertEquals(ModelType.STRING, TypeModelValue.of(ModelType.STRING).asType());
        assertEquals(ModelType.DOUBLE, TypeModelValue.of(ModelType.DOUBLE).asType());
        assertEquals(ModelType.BIG_DECIMAL, TypeModelValue.of(ModelType.BIG_DECIMAL).asType());
        assertEquals(ModelType.BYTES, TypeModelValue.of(ModelType.BYTES).asType());
        assertEquals(ModelType.LIST, TypeModelValue.of(ModelType.LIST).asType());
        assertEquals(ModelType.TYPE, TypeModelValue.of(ModelType.TYPE).asType());
        assertEquals(ModelType.OBJECT, TypeModelValue.of(ModelType.OBJECT).asType());
        assertEquals(ModelType.UNDEFINED, TypeModelValue.of(ModelType.UNDEFINED).asType());
    }

    @Test
    public void testEqualsTypeModelValue() {
        final TypeModelValue value1 = TypeModelValue.of(ModelType.BIG_DECIMAL);
        final TypeModelValue value2 = TypeModelValue.of(ModelType.BIG_DECIMAL);
        final TypeModelValue value3 = TypeModelValue.of(ModelType.BIG_INTEGER);
        assertEquals(true, value1.equals(value1));
        assertEquals(true, value1.equals(value2));
        assertEquals(true, value2.equals(value1));
        assertEquals(false, value1.equals(value3));
        assertEquals(false, value1.equals((TypeModelValue) null));
    }
}
