
import org.apache.hadoop.io.Text;

public class Results implements Comparable<Results>  {
	

	double relFreq;
	String key;
	String value;

	Results(double relFreq, String key, String value) {
		this.relFreq = relFreq;
		this.key = key;
		this.value = value;
	}

	@Override
	public int compareTo(Results results) {
		if (this.relFreq <= results.relFreq) {
			return 1;
		} else {
			return -1;
		}
	}
}