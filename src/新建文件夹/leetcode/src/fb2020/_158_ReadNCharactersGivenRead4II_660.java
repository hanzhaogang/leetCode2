package fb2020;

/*
 * Description

The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

The read function may be called multiple times.
Example

Example 1

Input:
"filetestbuffer"
read(6)
read(5)
read(4)
read(3)
read(2)
read(1)
read(10)
Output:
6, buf = "filete"
5, buf = "stbuf"
3, buf = "fer"
0, buf = ""
0, buf = ""
0, buf = ""
0, buf = ""

Example 2

Input:
"abcdef"
read(1)
read(5)
Output:
1, buf = "a"
5, buf = "bcdef"


 */
public class _158_ReadNCharactersGivenRead4II_660 {
	
   	int charLeft=0;

    public int read(char[] buf, int n) {
    	int readCount=0;
    	char[] buf4=new char[4];
    	
    	if(n<=charLeft) {
    		copy(buf,buf4,readCount,);
    	}
    	while(readCount<n) {
    		
    		
    		int curCount=read4(buf4);
    		
    		if(n==curCount+readCount||curCount+readCount<n&&curCount<4) {
    			copy(buf,buf4,readCount,curCount);
    			readCount+=curCount;
    			break;
    		}else if(n<curCount+readCount){
    			copy(buf,buf4,readCount,n-readCount);
    			readCount+=n-readCount;
    			break;
    		}

    		copy(buf,buf4,readCount,curCount);
    		readCount+=curCount;
    	}
    	return readCount;
    }
    private void copy(char[] buf,char[] buf4,int readCount,int curCount) {
    	for(int i=0;i<curCount;i++) {
    		buf[readCount+i]=buf4[i];
    	}
    }

}






/*
Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.



Method read4:

The API read4 reads 4 consecutive characters from the file, then writes those characters into the buffer array buf.

The return value is the number of actual characters read.

Note that read4() has its own file pointer, much like FILE *fp in C.

Definition of read4:

    Parameter:  char[] buf
    Returns:    int

Note: buf[] is destination not source, the results from read4 will be copied to buf[]

Below is a high level example of how read4 works:

File file("abcdefghijk"); // File is "abcdefghijk", initially file pointer (fp) points to 'a'
char[] buf = new char[4]; // Create buffer with enough space to store characters
read4(buf); // read4 returns 4. Now buf = "abcd", fp points to 'e'
read4(buf); // read4 returns 4. Now buf = "efgh", fp points to 'i'
read4(buf); // read4 returns 3. Now buf = "ijk", fp points to end of file

 

Method read:

By using the read4 method, implement the method read that reads n characters from the file and store it in the buffer array buf. Consider that you cannot manipulate the file directly.

The return value is the number of actual characters read.

Definition of read:

    Parameters:	char[] buf, int n
    Returns:	int

Note: buf[] is destination not source, you will need to write the results to buf[]

 

Example 1:

Input: file = "abc", n = 4
Output: 3
Explanation: After calling your read method, buf should contain "abc". We read a total of 3 characters from the file, so return 3. Note that "abc" is the file's content, not buf. buf is the destination buffer that you will have to write the results to.

Example 2:

Input: file = "abcde", n = 5
Output: 5
Explanation: After calling your read method, buf should contain "abcde". We read a total of 5 characters from the file, so return 5.

Example 3:

Input: file = "abcdABCD1234", n = 12
Output: 12
Explanation: After calling your read method, buf should contain "abcdABCD1234". We read a total of 12 characters from the file, so return 12.

Example 4:

Input: file = "leetcode", n = 5
Output: 5
Explanation: After calling your read method, buf should contain "leetc". We read a total of 5 characters from the file, so return 5.

 

Note:

    Consider that you cannot manipulate the file directly, the file is only accesible for read4 but not for read.
    The read function will only be called once for each test case.
    You may assume the destination buffer array, buf, is guaranteed to have enough space for storing n characters.
*/


/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */








class Solution extends Reader4 {
/**
* @param buf Destination buffer
* @param n   Maximum number of characters to read
* @return    The number of characters read
*/
public int read(char[] buf, int n) {
  int offset = 0;
  char[] buf4 = new char[4];
  while(true) {
      int count = read4(buf4);
      if (count == 0) {
          break;
      }
      for (int i = 0; i < count && offset < n; i ++) {
          buf[offset] = buf4[i];
          offset ++;
      }
  }
  return offset;
}
}


public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int count = 0;  //count the length of data retrieved by read4()
    int index = 0;  //record the position of data consumed by read()
    char[] data = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while (i < n) {
            //get new data with read4 api
            if (index == 0) count = read4(data);
            //if no new data, break
            if (count == 0) break;
            //consume data
            while (i < n && index < count) {
                buf[i++] = data[index++];
            }
            //all existing data consumed, restart with index = 0
            if (index >= count) index = 0; 
        }
        //return the length of data read
        return i;
    }
}


需要多次调用，用queue来保存前一次调用read4没用完的数据.

read时先用queue中的数据添加到buf中，若是不够再call read4. 

在读够n个char后若是read4Buff中还有可用数据，加到queue中. 

Note: declear rest first, but not use i < n - readSum in the while condidtion since readSum is changing.

Time Complexity: read, O(n).

Space: O(1). queue的大小不会超过4.


/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    LinkedList<Character> que = new LinkedList<>();

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int readSum = 0;
        // 先用queue中剩余的上次结果加到buf中
        while(readSum < n && !que.isEmpty()){
            buf[readSum++] = que.poll();
        }

        // 若是不够再调用read4 API
        boolean eof = false;
        char [] temp = new char[4];
        while(!eof && readSum < n){
            int count = read4(temp);
            eof = count < 4;
            int rest = n-readSum;

            int i = 0;
            while(i < count && i < rest){
                buf[readSum++] = temp[i++];
            }

            // 把当前read4Buff中没有读的有用char加到queue中
            if(i == rest){
                while(i < count){
                    que.add(temp[i++]);
                }
            }
        }

        return readSum;
    }
}
