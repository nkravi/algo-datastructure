package leethcode.medium;

import java.util.Iterator;
import java.util.List;


public class Flatten2DVector implements Iterator<Integer> {
	
	private List<List<Integer>> vec2d;
	private int row;
	private int col;
	private Integer currVal;
	
	public Flatten2DVector(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
		this.row = 0;
		this.col = 0;
		while( row < vec2d.size()) {
			if(vec2d.get(row).size() > 0) {
				break;
			}
			row++;
		}
    }

	@Override
	public boolean hasNext() {
		if(currVal != null) {
			return true;
		}else {
			if(row < vec2d.size() && col < vec2d.get(row).size()) {
				currVal = vec2d.get(row).get(col);
				col++;
				if(col == vec2d.get(row).size()) {
					row++;
					while(row < vec2d.size()) {
						if(vec2d.get(row).size() > 0) {
							break;
						}
						row++;
					}
					col=0;
				}
			}
		}
		return currVal != null;
	}

	@Override
	public Integer next() {
		Integer retVal = null;
		if(this.hasNext()) {
			retVal = currVal;
			currVal = null;
		}
		return retVal;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
