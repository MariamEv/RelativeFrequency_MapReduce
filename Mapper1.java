import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


	 public class Mapper1 extends Mapper<LongWritable, Text, Text, LongWritable>{
	        @Override
	        protected void map(LongWritable key, Text value, Context context)
	                throws IOException, InterruptedException {
	            String[] splitLine = value.toString().split("\\s+");
	            for(String val : splitLine){
	                if(val.matches("^\\w+$")){
	                    context.write(new Text(val.trim() + " " + "*"), new LongWritable(1));
	                }
	            }	            
	            StringBuilder sb = new StringBuilder();
	            int i;
	            for(i = 0; i < splitLine.length; i++ ){
	                if(i == splitLine.length - 1){
	                    break;
	                }
	                else{
	                    if(splitLine[i].matches("^\\w+$") && splitLine[i+1].matches("^\\w+$")){
	                sb.append(splitLine[i]).append(" ").append(splitLine[i+1]);
	                context.write(new Text(sb.toString()), new LongWritable(1));
	                sb.delete(0, sb.length());
	                    }
	                }
	            }
	        }
	 }