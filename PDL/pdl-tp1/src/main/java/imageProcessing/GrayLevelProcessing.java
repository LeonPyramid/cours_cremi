package imageProcessing;

import net.imglib2.RandomAccess;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import io.scif.SCIFIO;
import io.scif.img.ImgIOException;
import io.scif.img.ImgOpener;
import io.scif.img.ImgSaver;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.exception.IncompatibleTypeException;
import java.io.File;
import net.imglib2.Cursor;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import net.imglib2.type.numeric.integer.UnsignedByteType;

public class GrayLevelProcessing{

	public static void threshold(Img<UnsignedByteType> img, int t) {
		final RandomAccess<UnsignedByteType> r = img.randomAccess();

		final int iw = (int) img.max(0);
		final int ih = (int) img.max(1);

		for (int x = 0; x <= iw; ++x) {
			for (int y = 0; y <= ih; ++y) {
				r.setPosition(x, 0);
				r.setPosition(y, 1);
				final UnsignedByteType val = r.get();
				if (val.get() < t)
				    val.set(0);
				else
				    val.set(255);
			}
		}

	}

	public static void augmentLight(Img<UnsignedByteType> img, int t) {
		final RandomAccess<UnsignedByteType> r = img.randomAccess();

		final int iw = (int) img.max(0);
		final int ih = (int) img.max(1);
		int p = 0;
		for (int x = 0; x <= iw; ++x) {
			for (int y = 0; y <= ih; ++y) {
				r.setPosition(x, 0);
				r.setPosition(y, 1);
				final UnsignedByteType val = r.get();
				p = val.get() + t;
				if (p > 255)
					 p = 255;
				else if (p< 0)
					p = 0;
				val.set(p);
			}
		}

	}
	

	

	public static void augmentLightCur(Img<UnsignedByteType> img, int t) {
		final Cursor< UnsignedByteType > cursor = img.cursor();
		int p = 0;
		while(cursor.hasNext()){
			final UnsignedByteType val = cursor.next();
			p = val.get() + t;
			if (p > 255)
				 p = 255;
			else if (p< 0)
				p = 0;
			val.set(p);
		}
	}

	public static void dinamicContr(Img<UnsignedByteType> img, int minct, int maxct){
		int max = 0;
		int min = 255;
		for( UnsignedByteType t : img ){
			max = Math.max( t.get(), max );
			min = Math.min( t.get(), min );
		}
		final Cursor< UnsignedByteType > cursor = img.cursor();
		int p = 0;
		while(cursor.hasNext()){
			final UnsignedByteType val = cursor.next();
			p = (255*(val.get()-min)/(max-min)) ;
			if (p > maxct)
				 p = maxct;
			else if (p< minct)
				p = minct;
			val.set(p);
		}
	}

	public static void dinamicContrLUT(Img<UnsignedByteType> img, int minct, int maxct){
		int max = 0;
		int min = 255;
		for( UnsignedByteType t : img ){
			max = Math.max( t.get(), max );
			min = Math.min( t.get(), min );
		}
		final Cursor< UnsignedByteType > cursor = img.cursor();
		int p = 0;
		int lut[] = new int[256];
		for(int i = 0; i < 256; i ++){
			lut[i] = (255*(i-min)/(max-min)) ;
		}
		while(cursor.hasNext()){
			final UnsignedByteType val = cursor.next();
			p = lut[val.get()] ;
			if (p > maxct)
				 p = maxct;
			else if (p< minct)
				p = minct;
			val.set(p);
		}
	}

	public static void hystoContr(Img<UnsignedByteType> img){
		final Cursor< UnsignedByteType > cursor = img.cursor();
		int hyst[] = new int[256];
		for( UnsignedByteType t : img ){
			hyst[t.get()] ++;
		}

		int lut[] = new int[256];
		lut[0]=hyst[0];
		for(int i = 1; i < 256; i ++){
			lut[i] = lut[i-1] + hyst[i];
		}
		int p;
		int n = lut[255];
		while(cursor.hasNext()){
			final UnsignedByteType val = cursor.next();
			p = lut[val.get()]*255/n ;
			val.set(p);
		}
	}
	
	public static void main(final String[] args) throws ImgIOException, IncompatibleTypeException {
		// load image
		if (args.length < 2) {
			System.out.println("missing input and/or output image filenames");
			System.exit(-1);
		} 
		final String filename = args[0];
		if (!new File(filename).exists()) {
			System.err.println("File '" + filename + "' does not exist");
			System.exit(-1);
		}

		final ArrayImgFactory<UnsignedByteType> factory = new ArrayImgFactory<>(new UnsignedByteType());
		final ImgOpener imgOpener = new ImgOpener();
		final Img<UnsignedByteType> input = (Img<UnsignedByteType>) imgOpener.openImgs(filename, factory).get(0);
		imgOpener.context().dispose();
		
		// process image
		long begcur = System.nanoTime(); 
		hystoContr(input);
		long endcur = System.nanoTime();
		// save output image
		final String outPath = args[1];
		File path = new File(outPath);
		// clear the file if it already exists.
		if (path.exists()) {
			path.delete();
		}
		ImgSaver imgSaver = new ImgSaver();
		imgSaver.saveImg(outPath, input);
		imgSaver.context().dispose();
		System.out.println("Image saved in: " + outPath + " time : " + (endcur - begcur));		
	}

}
