package jdk8.encodingDecoding;

import java.util.Random;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Encoder;

/**
 * here’s a standard way to do Base64 encoding. For too long we have been relying on Apache Commons Codec (which is great anyway).
 * Memory-conscious coders will desperately use sun.misc.BASE64Encoder and sun.misc.BASE64Decoder just to avoid adding extra JAR files in
 * their programs, provided they are super sure of using only Sun/Oracle JDK.
 * https://www.javacodegeeks.com/2014/04/base64-in-java-8-its-not-too-late-to-join-in-the-fun.html?utm_content=buffer48d1f&utm_medium=social&utm_source=facebook.com&utm_campaign=buffer
 * 
 * @author darekar
 */
@SuppressWarnings("restriction")
public class Base64EncodingDecoding {

    private final byte[] randomBinaryData = new byte[10000000];

    public Base64EncodingDecoding() {
        new Random().nextBytes(randomBinaryData);
    }
    public static void main(String[] args) {
        Base64EncodingDecoding encodingDecoding = new Base64EncodingDecoding();
        encodingDecoding.testSunBase64Encode();
        encodingDecoding.testCommonsBase64Encode();
        encodingDecoding.testJdk8Base64Encode();
    }

    /**
     * Encode using sun.MISC.Base64encoder
     */
    @SuppressWarnings("restriction")
    private void testSunBase64Encode() {
        long duration = 0;
        long before = System.currentTimeMillis();
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encodedSuns = base64Encoder.encode(randomBinaryData);
        long after = System.currentTimeMillis();
        duration = after - before;
        System.out.println("Sun: " + duration);
    }

    /**
     * Encode using apache commons encode.
     */
    private void testCommonsBase64Encode() {
        long duration = 0;
        long before = System.currentTimeMillis();
        byte[] encodedCommons = Base64.encodeBase64(randomBinaryData);
        long after = System.currentTimeMillis();
        duration = after - before;
        System.out.println("Commons: " + duration);
    }

    /**
     * Encode using Jdk8
     */
    private void testJdk8Base64Encode() {

        long duration = 0;
        long before = System.currentTimeMillis();
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        byte[] encodedJdk8 = encoder.encode(randomBinaryData);
        long after = System.currentTimeMillis();
        duration = after - before;
        System.out.println("Jdk8: " + duration);
    }
}
