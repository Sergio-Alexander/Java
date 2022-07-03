public class NegativeFilter implements Filter {

	@Override
	public void filter(PixelImage pi) {
		Pixel[][] data = pi.getData();
		for (int i = 0;i<pi.getHeight();i++){
			for(int j = 0; j<pi.getWidth();j++){
				// Change the colour to negative
				int negR = 255-data[i][j].red;
				int negG = 255-data[i][j].green;
				int negB = 255-data[i][j].blue;
				// Setting the colour to negative
				data[i][j].red = negR;
				data[i][j].green = negG;
				data[i][j].blue = negB;
			}
		}
		pi.setData(data);
	}

}