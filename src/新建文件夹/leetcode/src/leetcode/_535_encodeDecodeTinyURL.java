package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 *     Note: This is a companion problem to the System Design problem: 
 *     Design TinyURL.

TinyURL is a URL shortening service 
where you enter a URL such as https://leetcode.com/problems/design-tinyurl 
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service. 
There is no restriction on how your encode/decode algorithm should work. 
You just need to ensure that a URL can be encoded to a tiny URL 
and the tiny URL can be decoded to the original URL.

1. global 
 */
public class _535_encodeDecodeTinyURL {
	Random r=new Random();
	int shortUrlLen=9;
	String str="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	Map<String,String> long2short=new HashMap<>();
	Map<String,String> short2long=new HashMap<>();
	String prefix="http://shortUrl/";
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	if(!long2short.containsKey(longUrl)) {
    		String shortUrl= genHash();
    	   	while(short2long.containsKey(shortUrl)) {
    	   		shortUrl=genHash();
    	   	}
    	   	long2short.put(longUrl,shortUrl);
    	   	short2long.put(shortUrl, longUrl);
    	}
    	
    	return long2short.get(longUrl);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return short2long.getOrDefault(shortUrl, "not found");
    }
    
    private String genHash() {
    	StringBuilder sb=new StringBuilder();
    	for(int i=0;i<shortUrlLen;i++) {
    		sb.append(str.charAt(r.nextInt(str.length())));
    	}
    	return sb.toString();
    }
}
