package imageProcessing;

import java.io.File;

import io.scif.img.ImgIOException;
import io.scif.img.ImgOpener;
import io.scif.img.ImgSaver;
import net.imglib2.Cursor;
import net.imglib2.Dimensions;
import net.imglib2.Interval;
import net.imglib2.IterableInterval;
import net.imglib2.RandomAccess;
import net.imglib2.RandomAccessibleInterval;
import net.imglib2.algorithm.neighborhood.Neighborhood;
import net.imglib2.algorithm.neighborhood.RectangleShape;
import net.imglib2.algorithm.region.localneighborhood.old.LocalNeighborhood;
import net.imglib2.exception.IncompatibleTypeException;
import net.imglib2.img.Img;
import net.imglib2.img.array.ArrayImgFactory;
import net.imglib2.type.numeric.integer.UnsignedByteType;
import net.imglib2.util.Intervals;
import net.imglib2.view.IntervalView;
import net.imglib2.view.Views;

public class Convolution {
	/**
	 * Question 1.1
	 */
	public static void meanFilterSimple(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output) {
		final int iw = (int) input.max(0);
		final int ih = (int) input.max(1);
		int tab[][] = new int[iw][ih];

		// Transform pic into a tab, time economy in the future
		final RandomAccess<UnsignedByteType> r = input.randomAccess();
		for (int x = 0; x < iw; ++x) {
			for (int y = 0; y < ih; ++y) {
				r.setPosition(x, 0);
				r.setPosition(y, 1);
				final UnsignedByteType px = r.get();
				tab[x][y] = px.get();
			}
		}
		// compute into pic
		final RandomAccess<UnsignedByteType> w = output.randomAccess();
		for (int x = 1; x < iw - 1; ++x) {
			for (int y = 1; y < ih - 1; ++y) {
				w.setPosition(x, 0);
				w.setPosition(y, 1);
				final UnsignedByteType pxo = w.get();
				int val = 0;
				for (int i = -1; i <= +1; i++) {
					for (int j = -1; j <= +1; j++) {
						val += tab[x + i][y + j];
					}
				}
				val /= 9;
				pxo.set(val);

			}
		}
	}

	/**
	 * Question 1.2
	 */
	public static void meanFilterWithBorders(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output,
			int size) {
		final int iw = (int) input.max(0);
		final int ih = (int) input.max(1);
		//étendre par mirroire
		final IntervalView<UnsignedByteType> r = Views.expandMirrorDouble(input,size,size);
		final RandomAccess<UnsignedByteType> w = output.randomAccess();
		
		for (int x = 0; x < iw; ++x) {
			for (int y = 0; y < ih; ++y) {
				//choisi le pixel à écrire
				w.setPosition(x, 0);
				w.setPosition(y, 1);
				final UnsignedByteType pxo = w.get();
				//Définit la bordure de la zone à traiter pour le caclul de mmoyenne
				final long[] min = new long[] {x-((size-1)/2),y-((size-1)/2)};
				final long[] max = new long[] {x+((size-1)/2),y+((size-1)/2)};
				//Sélectionne la zone
				final IterableInterval<UnsignedByteType> it = Views.interval(r,min,max);
				final Cursor< UnsignedByteType > cursor = it.cursor();
				//Calcul la moyenne
				int val = 0;
				while(cursor.hasNext()){
					final UnsignedByteType px = cursor.next();
					val += px.get();
				}
				val /= (size * size);
				//met la valeur dans le pixel
				pxo.set(val);
				
			}
		}
	}

	/**
	 * Question 1.3
	 */
	public static void meanFilterWithNeighborhood(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output,int size) {
		//Create and limit the reading of tge input image
		IntervalView<UnsignedByteType> r = Views.expandMirrorDouble(input,size,size);
		final Interval limit = Intervals.expand(input,0);
		r = Views.interval(r,limit);
		final RectangleShape shape = new RectangleShape( (size-1)/2, false );
		
		final Cursor< UnsignedByteType > center = output.cursor();
		//Compute with Neighborhood
		for ( final Neighborhood< UnsignedByteType> localNeighborhood : shape.neighborhoods(r) )
		{
			UnsignedByteType pxo = center.next();
			int val = 0;
			for(final UnsignedByteType lvl : localNeighborhood){
				val += lvl.get();
			}
			val /= (size * size);
			//met la valeur dans le pixel
			pxo.set(val);
			
		}
		

	}

	//Permet de récupérer la taille d'un tableau, gourmand en calcul mais sur et évite d'avoir des paramètres en plus.
	public static  int getTabSize(Object[] tab) {
		int size = 0;
		while(true){
			try{
				Object val = tab[size];
				size ++;
			}
			catch (IndexOutOfBoundsException ex){
				return size;
			}
		}
		
	}

	/**
	 * Question 2.1
	 */
	public static void convolution(final Img<UnsignedByteType> input, final Img<UnsignedByteType> output,int[][] kernel) {
		final int size = getTabSize(kernel);//matrice carée
		IntervalView<UnsignedByteType> r = Views.expandMirrorDouble(input,size,size);
		final Interval limit = Intervals.expand(input,0);
		r = Views.interval(r,limit);
		final RectangleShape shape = new RectangleShape( (size-1)/2, false );
		
		final Cursor< UnsignedByteType > center = output.cursor();
		//Compute with Neighborhood
		for ( final Neighborhood< UnsignedByteType> localNeighborhood : shape.neighborhoods(r) )
		{
			UnsignedByteType pxo = center.next();
			int val = 0;
			int count = 0;
			int covtot = 0;
			for(final UnsignedByteType lvl : localNeighborhood){
				int cov = kernel[count/size][count%size];
				covtot += cov;
				val += (lvl.get())*(cov);
				count ++;
			}
			val /= covtot;
			//met la valeur dans le pixel
			pxo.set(val);
			
		}
	
	}

	public static void main(final String[] args) throws ImgIOException, IncompatibleTypeException {

		// load image
		if (args.length < 2) {
			System.out.println("missing input or output image filename");
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

		// output image of same dimensions
		final Dimensions dim = input;
		final Img<UnsignedByteType> output = factory.create(dim);

		// mean filter
		int[][] tab = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
		int[][] gaus = new int[][] {{1,2,3,2,1},{2,6,8,6,2},{3,8,10,8,3},{2,6,8,6,2},{1,2,3,2,1}};
		
		long begcur = System.nanoTime(); 
		convolution(input, output,gaus);
		long endcur = System.nanoTime();

		final String outPath = args[1];
		File path = new File(outPath);
		if (path.exists()) {
			path.delete();
		}
		ImgSaver imgSaver = new ImgSaver();
		imgSaver.saveImg(outPath, output);
		imgSaver.context().dispose();
		System.out.println("Image saved in: " + outPath + " time : " + (endcur - begcur));
	}

}
