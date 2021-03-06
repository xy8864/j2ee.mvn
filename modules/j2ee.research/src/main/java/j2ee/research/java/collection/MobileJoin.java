package j2ee.research.java.collection;


import com.google.common.base.Stopwatch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**  
 * @author yuanwei  
 * @version ctreateTime:2012-7-26 下午2:54:41
 *   
 */
public class MobileJoin {
	final static String baseDir="D:/Server/java/sql/";
	final static String ENCODING="UTF-8";
	public static void readFileLine(String path, String charset,BitSetNotInMap all,boolean left){
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		//Set<Integer> header=new HashSet<Integer>(99);
		//int count=0;
		try{
			File fl = new File(path);
			fileReader = new FileReader(fl);
			bufferedReader = new BufferedReader(fileReader);
			String currentLine;
			while((currentLine = bufferedReader.readLine())!=null && currentLine.trim().length()>0){
				//System.out.println(currentLine);
				//rs.add(currentLine);
				//set(set,currentLine);//count++;
				//set.set(convertMobile2Int(pauseLong(currentLine,0)));
				if(left)all.addLeft(currentLine);
				else all.addRight(currentLine);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bufferedReader!=null){
				try{bufferedReader.close();}catch(IOException e){e.printStackTrace();}
			}
			if(fileReader!=null){
				try{fileReader.close();}catch(IOException e){e.printStackTrace();}
			}
		}
		//System.out.println(count);
	}


	public static int convertMobile2Int(long mobile){
		int result=0;
		if(mobile>0){
			long t=mobile/100000000-100;
			if(t>29&&t<99)result=(int)t;
			//if(t==11)throw new RuntimeException(String.valueOf(mobile));
			//if(mobile>100)System.out.println(mobile);
		}
		return result;
	}
	public static void notIn(String fromAll,String notIn) throws IOException{
		final String suffix=".txt";
		//2,147,483,647 Integer.MAX_VALUE
		BitSetNotInMap all=new BitSetNotInMap();

		readFileLine(baseDir+fromAll+suffix,ENCODING,all,true);
		readFileLine(baseDir+notIn+suffix,ENCODING,all,false);
		all.writeStringToFile(baseDir+"result_"+fromAll+"_notin_"+notIn+suffix,ENCODING);
		//System.out.println(all.length());
		///readFileLine4Header(baseDir+notIn+suffix,ENCODING,notin);
		///System.out.println(notin.length());

		//FileUtils.write(new File("D:/Server/java/sql/andNot.txt"),data,encoding)
		//FileUtils.writeStringToFile(new File("D:/Server/java/sql/andNot.txt"),ByteUtil.toBinaryString(all.toLongArray()),ENCODING);
		//all.andNot(notin);
		//all.and(notin);
		//System.out.println(all.toString());

		//FileUtils.writeStringToFile(new File(baseDir+"result_"+fromAll+"_notin_"+notIn+suffix),all.toString(),ENCODING);
		//ClassUtil.sleep(1000000);
		//System.out.println(all);
	}
	public static void main(String[] args) throws IOException {
		Stopwatch watch=Stopwatch.createStarted();

		//ClassUtil.sleep(30000L);
		/**/
		notIn("2012.1.1before","2012.1.1after");//17933 notIn 29134 =14058
		System.out.println(watch.stop().toString());
		//ClassUtil.sleep(60000L);

		//long num=15868020959L;
		//System.out.println(num/100000000);
		//System.out.println(num/100000000-100);
		//System.out.println(convertMobile2Int(num));
		//System.out.println(convertMobile2Int(18666000998L));
	}
	
}
